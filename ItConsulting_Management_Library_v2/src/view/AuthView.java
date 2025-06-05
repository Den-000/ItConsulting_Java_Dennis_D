package view;

import java.util.Scanner;

public class AuthView {
    // Scanner per l'input dell'utente
    private Scanner scanner = new Scanner(System.in);

    // Mostra il menu iniziale per l'autenticazione
    public int showStartMenu() {
        System.out.println("\n=== Biblioteca Digitale ===");
        System.out.println("1. Registrati");
        System.out.println("2. Login");
        System.out.println("0. Esci");
        System.out.println("===========================");
        System.out.print("\nScelta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    // Richiede un input generico all'utente
    public String askInput(String messaggio) {
        System.out.print(messaggio + " ");
        return scanner.nextLine();
    }

    // Mostra un messaggio all'utente
    public void print(String messaggio) {
        System.out.println(messaggio);
    }
}