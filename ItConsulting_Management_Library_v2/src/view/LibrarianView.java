package view;

import java.util.Scanner;

public class LibrarianView {
    // Scanner per leggere l'input da tastiera
    private Scanner scanner = new Scanner(System.in);

    // Mostra il menu per il bibliotecario e restituisce la scelta
    public int showMenuLibrarian() {
        System.out.println("\n== Menu Bibliotecario ==");
        System.out.println("1. Aggiungi Risorsa");
        System.out.println("2. Modifica Risorsa");
        System.out.println("3. Rimuovi Risorsa");
        System.out.println("4. Cerca Risorsa");
        System.out.println("5. Visualizza Tutte le Risorse");
        System.out.println("0. Logout");
        System.out.println("========================");
        System.out.print("\nScelta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Chiede un input generico all'utente
    public String askInput(String msg) {
        System.out.print(msg + " ");
        return scanner.nextLine();
    }

    // Visualizza un messaggio
    public void print(String msg) {
        System.out.println(msg);
    }
}