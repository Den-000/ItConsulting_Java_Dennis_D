package view;

import java.util.Scanner;

public class UserView {
    // Scanner per la lettura dell'input da tastiera
    private Scanner scanner = new Scanner(System.in);

    // Mostra il menu per l'utente e restituisce la scelta effettuata
    public int showMenuUser() {
        System.out.println("\n== Menu Utente ==");
        System.out.println("1. Cerca Risorsa");
        System.out.println("2. Visualizza Tutte le Risorse");
        System.out.println("3. Prendi in Prestito");
        System.out.println("4. Restituisci");
        System.out.println("0. Logout");
        System.out.println("=================");
        System.out.print("\nScelta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Chiede un input generico all'utente
    public String askInput(String msg) {
        System.out.print(msg + " ");
        return scanner.nextLine();
    }

    // Mostra un messaggio a schermo
    public void print(String msg) {
        System.out.println(msg);
    }
}