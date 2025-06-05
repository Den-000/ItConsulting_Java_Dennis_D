package controller;

import model.*;
import view.AuthView;
import view.LibrarianView;
import view.UserView;

import java.util.ArrayList;

// Controller che gestisce la registrazione, login e instrada verso il menu utente o bibliotecario
public class AuthController {
    private ArrayList<User> users = new ArrayList<>();             // Lista degli utenti registrati
    private ArrayList<Resource> resourcesArchive = new ArrayList<>(); // Archivio condiviso delle risorse
    private AuthView view;                                         // View per l'autenticazione
    private int userCounter = 1;                                   // Contatore per ID utente
    private int librarianCounter = 1;                              // Contatore per ID bibliotecario

    // Costruttore
    public AuthController(AuthView view) {
        this.view = view;
    }

    // Metodo principale per gestire il ciclo di login/registrazione
    public void start() {
        boolean running = true;
        while (running) {
            int choice = view.showStartMenu();
            switch (choice) {
                case 1 -> register();   // Registrazione nuovo utente
                case 2 -> login();      // Accesso utente esistente
                case 0 -> {
                    view.print("\nArrivederci!");
                    running = false;    // Termina il ciclo
                }
                default -> view.print("\nScelta non valida.");
            }
        }
    }

    // Gestisce la registrazione
    private void register() {
        String name = view.askInput("Inserisci il tuo username:");
        String adminCode = view.askInput("Inserisci codice (lascia vuoto se sei utente normale):");

        User newUser;
        String generatedId;

        if (adminCode.equalsIgnoreCase("ADMIN")) { // Codice amministratore per diventare bibliotecario (da upgradare a lista di codici)
            generatedId = "L" + librarianCounter++;
            newUser = new Librarian(name, generatedId);
            view.print("Registrazione completata come bibliotecario. ID assegnato: " + generatedId);
        } else {
            generatedId = "U" + userCounter++;
            newUser = new User(name, generatedId);
            view.print("Registrazione completata come utente. ID assegnato: " + generatedId);
        }

        users.add(newUser);
    }

    // Gestisce il login e reindirizza all'interfaccia utente o bibliotecario
    private void login() {
        String id = view.askInput("\nInserisci il tuo ID:");
        for (User u : users) {
            if (u.getId().equals(id)) {
                if (u.isLibrarian()) {
                    view.print("Benvenuto, bibliotecario " + u.getName());
                    menuLibrarian(u);
                } else {
                    view.print("Benvenuto, utente " + u.getName());
                    menuUser(u);
                }
                return;
            }
        }
        view.print("\nID non trovato. Effettua prima la registrazione.");
    }

    // Avvia il menu per l’utente semplice
    private void menuUser(User u) {
        UserController uc = new UserController(resourcesArchive, new UserView());
        uc.startMenu();
    }

    // Avvia il menu per il bibliotecario
    private void menuLibrarian(User u) {
        LibrarianController lc = new LibrarianController(resourcesArchive, new LibrarianView());
        lc.startMenu();
    }
}