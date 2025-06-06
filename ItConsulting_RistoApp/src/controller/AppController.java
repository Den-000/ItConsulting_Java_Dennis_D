package controller;

import model.*;
import service.AppService;
import view.ConsoleView;

// Classe principale
public class AppController {
    // Vista (input/output console)
    private final ConsoleView view = new ConsoleView();

    // Modello (ristorante con piatti e recensioni)
    private final Restaurant restaurant = new Restaurant();

    // Servizio che contiene la logica dell'app (registrazione, login, gestione piatti e recensioni)
    private final AppService service = new AppService(restaurant);

    // Metodo principale per avviare l'app
    public void run() {
        boolean running = true;
        while (running) {
            view.displayMenu();                    // Mostra il menu
            int choice = view.promptInt("");       // Legge la scelta dell’utente

            switch (choice) {
                case 1 -> registerUser();                                    // Registrazione
                case 2 -> loginUser();                                       // Login
                case 3 -> printUserProfile();                                // Profilo utente
                case 4 -> publishDish();                                     // Pubblica piatto
                case 5 -> publishReview();                                   // Pubblica recensione
                case 6 -> view.displayDishesWithReviews(restaurant);        // Mostra piatti e recensioni
                case 7 -> view.displayHeadChefs(service.getHeadChefs());    // Mostra Head Chefs
                case 0 -> running = false;                                   // Esci
                default -> view.displayMessage("\nScelta non valida.");     // Scelta errata
            }
        }
    }

    // Metodo per registrare un nuovo utente
    private void registerUser() {
        String name = view.prompt("Nome: ");
        String email = view.prompt("Email: ");
        String password = view.prompt("Password: ");
        if (service.registerUser(name, email, password)) {
            view.displayMessage("\nRegistrazione e login riusciti.");
        } else {
            view.displayMessage("\nRegistrazione fallita.");
        }
    }

    // Metodo per effettuare il login
    private void loginUser() {
        if (service.isLoggedIn()) {
            view.displayMessage("\nUtente già loggato.");
            return;
        }
        String email = view.prompt("\nEmail: ");
        String password = view.prompt("Password: ");
        if (service.login(email, password)) {
            view.displayMessage("\nLogin riuscito.");
        } else {
            view.displayMessage("\nCredenziali errate o utente già loggato.");
        }
    }

    // Mostra il profilo dell’utente attualmente loggato
    private void printUserProfile() {
        if (!service.isLoggedIn()) {
            view.displayMessage("\nNessun utente loggato.");
            return;
        }
        User user = service.getCurrentUser();
        view.displayMessage("\nNome: " + user.getName());
        view.displayMessage("Email: " + user.getEmail());
        view.displayMessage("Credito: €" + String.format("%.2f", user.getBalance()));
    }

    // Permette all’utente, se loggato, di pubblicare un nuovo piatto
    private void publishDish() {
        if (!service.isLoggedIn()) {
            view.displayMessage("\nEffettua il login prima.");
            return;
        }
        String dish = view.prompt("\nNome del piatto: ");
        if (service.addDish(dish)) {
            view.displayMessage("\nPiatto aggiunto con successo.");
        } else {
            view.displayMessage("\nPiatto già esistente.");
        }
    }

    // Permette all’utente, se loggato, di scrivere una recensione per un piatto
    private void publishReview() {
        if (!service.isLoggedIn()) {
            view.displayMessage("\nEffettua il login prima.");
            return;
        }
        view.displayDishes(service.getDishes()); // Mostra piatti disponibili
        String dish = view.prompt("\nNome del piatto da recensire: ");
        String review = view.prompt("\nRecensione: ");
        service.addRating(dish, review);
        view.displayMessage("\nRecensione aggiunta con successo.");
    }
}