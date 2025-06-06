package view;

import model.*;
import java.util.*;

// Classe che estisce tutta l'interazione con l'utente tramite console
public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    // Mostra il menu all'utente
    public void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Registrati");
        System.out.println("2. Login");
        System.out.println("3. Profilo");
        System.out.println("4. Pubblica piatto");
        System.out.println("5. Pubblica recensione");
        System.out.println("6. Visualizza piatti e recensioni");
        System.out.println("7. Visualizza Head Chef");
        System.out.println("0. Esci");
        System.out.println("-------------\n");
        System.out.print("Scelta: ");
    }

    // Richiede un input stringa all’utente con messaggio personalizzato
    public String prompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    // Richiede un input intero all’utente con gestione dell’errore di conversione
    public int promptInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nValore non valido.");
            }
        }
    }

    // Stampa un messaggio generico a console
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    // Visualizza una lista di piatti con il nome e lo chef associato
    public void displayDishes(List<Dish> dishes) {
        for (Dish dish : dishes) {
            System.out.println("- " + dish.getName() + " (Chef: " + dish.getChefName() + ")");
        }
    }

    // Visualizza i piatti con numero di recensioni e dettaglio di ciascuna recensione
    public void displayDishesWithReviews(Restaurant restaurant) {
        Map<String, Long> counts = restaurant.getDishReviewCounts();
        for (Dish dish : restaurant.getDishes()) {
            long reviewCount = counts.getOrDefault(dish.getName(), 0L);
            System.out.println(dish.getName() + " (Chef: " + dish.getChefName() + ", Recensioni: " + reviewCount + ")");
            for (Rating r : restaurant.getRatingsForDish(dish.getName())) {
                System.out.println("    - " + r.getCriticName() + ": " + r.getReview());
            }
        }
    }

    // Visualizza l’elenco degli Head Chef
    public void displayHeadChefs(List<String> chefs) {
        if (chefs.isEmpty()) System.out.println("\nNessun Head Chef.");
        else {
            System.out.println("\nHead Chefs:");
            for (String name : chefs) {
                System.out.println("- " + name);
            }
        }
    }
}