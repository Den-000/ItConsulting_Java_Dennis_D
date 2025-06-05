package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double credit = 10.00;
        boolean continues = true;

        // Messaggio di benvenuto e visualizzazione del credito iniziale
        System.out.println("*** Benvenuto al Distributore Automatico! ***");
        System.out.printf("Credito iniziale: %.2f€%n", credit);

        // Ciclo principale: continua finché l'utente non esce o finisce il credito
        while (continues && credit > 0) {
            // Menu
            System.out.println("\nSeleziona una bevanda:");
            System.out.println("1. Caffè - 1.50€");
            System.out.println("2. Cappuccino - 2.00€");
            System.out.println("3. Tè - 1.00€");
            System.out.println("4. Acqua - 0.50€");
            System.out.println("5. ❌ Uscire ❌");

            // Lettura della scelta
            System.out.print("Scelta (1-5): ");
            String input = scanner.nextLine();
            int choice;

            // Try di conversione dell’input in int
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Inserisci un numero valido tra 1 e 5. ⚠️");
                continue; // Torna all'inizio del ciclo se input non valido
            }

            double price = 0;
            String drink = "";

            // Scelta della bevanda in base all'input
            switch (choice) {
                case 1:
                    price = 1.50;
                    drink = "Caffè";
                    break;
                case 2:
                    price = 2.00;
                    drink = "Cappuccino";
                    break;
                case 3:
                    price = 1.00;
                    drink = "Tè";
                    break;
                case 4:
                    price = 0.50;
                    drink = "Acqua";
                    break;
                case 5:
                    continues = false;
                    System.out.println("Hai scelto di uscire.");
                    break;
                default:
                    System.out.println("⚠️ Scelta non valida. Inserisci un numero da 1 a 5. ⚠️");
            }

            // Se è stata selezionata una bevanda valida (price > 0), procedi all'acquisto
            if (price > 0) {
                if (credit >= price) {
                    credit -= price; // Scala il prezzo dal credito disponibile
                    System.out.printf("Hai acquistato: %s (%.2f€)%n", drink, price);
                    System.out.printf("Credito rimanente: %.2f€%n", credit);
                } else {
                    System.out.printf("❌ Credito insufficiente per %s. Ti restano %.2f€%n ❌", drink, credit);
                }
            }
        }

        // Fine del programma: mostra credito residuo e saluto finale
        System.out.printf("%n Credito finale: %.2f€%n", credit);
        System.out.println("Grazie per aver utilizzato il distributore. A presto!");
        scanner.close();
    }
}