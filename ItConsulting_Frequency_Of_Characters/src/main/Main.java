package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continues = true;

        // Messaggio di benvenuto
        System.out.println("**** PROGRAMMA DI FREQUENZA CARATTERI ****"); //NON FA DISTINZIONE FRA MAIUSCOLO E MINUSCOLO

        // Ciclo principale del programma
        while (continues) {
            // Stampa il menu
            System.out.println("\n**** MENU ****");
            System.out.println("1. Analizza una parola/frase");
            System.out.println("2. Esci");
            System.out.println("**************");
            System.out.print("\nInserisci la tua scelta (1-2): ");

            String choice = scanner.nextLine(); // Lettura input

            // Switch per gestire le opzioni
            switch (choice) {
                case "1": // Analisi di una parola o frase
                    System.out.println("\n**************");
                    System.out.print("Inserisci una parola/frase da analizzare: ");
                    String pharse = scanner.nextLine(); // Lettura della frase da analizzare

                    // Verifica se l'input è vuoto o solo spazi
                    if (pharse.trim().isEmpty()) {
                        System.out.println("Errore: Devi scrivere qualcosa.");
                        break; // Torna al menu
                    }

                    HashMap<Character, Integer> frequency = new HashMap<>(); // Mappa per contare la frequenza

                    // Ciclo per ogni carattere della parola/frase
                    for (char ch : pharse.toCharArray()) {
                        if (Character.isLetter(ch)) { // Considera solo lettere (ignora numeri, spazi, punteggiatura)
                            ch = Character.toLowerCase(ch); // Converte in minuscolo per uniformare
                            // Aggiorna la frequenza del carattere
                            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
                        }
                    }

                    // Se non sono state trovate lettere valide
                    if (frequency.isEmpty()) {
                        System.out.println("\nNessun carattere valido trovato.");
                    } else {
                        // Stampa la frequenza dei caratteri
                        System.out.println("\nFrequenza dei caratteri:");
                        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
                            System.out.println("'" + entry.getKey() + "' = " + entry.getValue());
                        }
                    }
                    break;

                case "2": //Exit
                    System.out.println("Stai uscendo dal programma. Arrivederci!");
                    continues = false; //Termina il ciclo
                    break;

                default: // Errore
                    System.out.println("Scelta non valida. Inserisci 1 o 2.");
            }
        }

        scanner.close(); // Chiude lo scanner
    }
}