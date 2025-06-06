package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

// Classe View (input/output da console)
public class View {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato per le date

    // Mostra il menu principale
    public String showMainMenu() {
        System.out.println("\n==== MENU PRINCIPALE ====");
        System.out.println("1. Gestione Case Discografiche");
        System.out.println("0. Esci");
        System.out.println("=========================");
        System.out.print("Scelta: ");
        return scanner.nextLine();
    }

    // Menu per la gestione delle case discografiche
    public String showRecordHouseMenu() {
        System.out.println("\n== Menu Casa Discografica ==");
        System.out.println("1. Aggiungi Casa");
        System.out.println("2. Visualizza Tutte");
        System.out.println("3. Modifica Casa");
        System.out.println("4. Rimuovi Casa");
        System.out.println("5. Rimuovi Tutte");
        System.out.println("6. Gestisci Artisti");
        System.out.println("7. Gestisci Album");
        System.out.println("0. Indietro");
        System.out.println("============================");
        System.out.print("Scelta: ");
        return scanner.nextLine();
    }

    // Menu per la gestione degl'artisti
    public String showArtistMenu() {
        System.out.println("\n==== Menu Artisti ====");
        System.out.println("1. Aggiungi");
        System.out.println("2. Visualizza Tutti");
        System.out.println("3. Modifica");
        System.out.println("4. Rimuovi");
        System.out.println("5. Rimuovi Tutti");
        System.out.println("0. Indietro");
        System.out.println("======================");
        System.out.print("Scelta: ");
        return scanner.nextLine();
    }

    // Menu per la gestione degl'album
    public String showAlbumMenu() {
        System.out.println("\n==== Menu Album ====");
        System.out.println("1. Aggiungi");
        System.out.println("2. Visualizza Tutti");
        System.out.println("3. Modifica");
        System.out.println("4. Rimuovi");
        System.out.println("5. Rimuovi Tutti");
        System.out.println("0. Indietro");
        System.out.println("====================");
        System.out.print("Scelta: ");
        return scanner.nextLine();
    }

    // Metodo generico per mostrare una lista di oggetti
    public void showList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("Nessun elemento trovato.");
        } else {
            System.out.println("\n--- Lista Elementi ---");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
            System.out.println("---------------------");
        }
    }

    // Richiesta di input testuale
    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Richiesta di input numerico intero, con validazione
    public int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Errore: inserisci un numero valido.");
            }
        }
    }

    // Richiesta di una data nel formato dd/MM/yyyy, con validazione
    public LocalDate getDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Errore: inserisci una data valida nel formato dd/MM/yyyy.");
            }
        }
    }

    // Metodo per chiudere lo scanner
    public void close() {
        scanner.close();
    }
}
