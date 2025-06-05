package view;

import java.util.List;
import java.util.Scanner;
import model.Book;

public class BookView {
	
    private final Scanner scanner = new Scanner(System.in);

    // Mostra il menu principale e legge la scelta dell'utente, gestendo input non validi
    public int viewMenu() {
        while (true) {
            System.out.println("\n**** MENU LIBRI ****");
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Mostra libri");
            System.out.println("3. Rimuovi libro per codice");
            System.out.println("4. Torna al menù principale");
            System.out.println("********************");
            System.out.print("Scelta (1-4): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) return choice;
            } catch (NumberFormatException ignored) {}
            System.out.println("Scelta non valida.");
        }
    }

    // Chiede all'utente il titolo del libro
    public String askTitle() {
        System.out.print("Inserisci il titolo del libro: ");
        return scanner.nextLine().trim();
    }

    // Chiede all'utente il prezzo del libro, gestendo input non validi
    public double askPrice() {
        while (true) {
            try {
                System.out.print("Inserisci il prezzo: ");
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Prezzo non valido.");
            }
        }
    }

    // Chiede all'utente il codice del libro da rimuovere, gestendo input non validi
    public int askCodeToRemove() {
        while (true) {
            try {
                System.out.print("Inserisci il codice del libro da rimuovere: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Codice non valido.");
            }
        }
    }

    // Mostra la lista dei libri
    public void viewBookList(List<Book> books) {
        System.out.println("\n--- Elenco libri ---");
        if (books.isEmpty()) {
            System.out.println("Nessun libro presente.");
        } else {
            books.forEach(System.out::println);
        }
    }

    // Mostra un messaggio di conferma dopo l'aggiunta di un libro
    public void viewAddMessage(String title) {
        System.out.println("Libro '" + title + "' aggiunto.");
    }

    // Mostra un messaggio dopo il tentativo di rimozione di un libro
    public void viewRemovedMessage(int code, boolean removed) {
        if (removed) {
            System.out.println("Libro con codice " + code + " rimosso.");
        } else {
            System.out.println("Libro con codice " + code + " non trovato.");
        }
    }

    // Mostra un messaggio di uscita dal sotto-menu
    public void viewExitMessage() {
        System.out.println("Tornando al menù principale...");
    }
}