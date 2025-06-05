package main;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continues = true;

        while (continues) { // Finché l'utente non sceglie di uscire
            // Menu
            System.out.println("\n*** MENU ***");
            System.out.println("1. Inserisci una parola/frase");
            System.out.println("2. Esci");
            System.out.println("************");
            System.out.print("Scegli un'opzione (1-2): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // Inserisci parola/frase
                    System.out.print("\n Inserisci una parola/frase: ");
                    String phrase = scanner.nextLine();

                    int vowelCount = 0;
                    char c = 0;
                    boolean atLeastOneVowel = false;

                    System.out.println("\n Risultati (solo vocali, ignorando numeri e simboli):");

                    // Cicla ogni carattere della frase
                    for (int i = 0; i < phrase.length(); i++) {
                        c = phrase.charAt(i);
                        
                        if (Character.isLetter(c)) {
                            char lowercase = Character.toLowerCase(c);
                            
                            // Verifica se è una vocale
                            if ("aeiou".indexOf(lowercase) != -1) {
                                System.out.println("• Vocale '" + c + "' all'indice " + i);
                                vowelCount++;
                                atLeastOneVowel = true;
                            }
                        }
                    }

                    // Se non è stata trovata nessuna vocale
                    if (!atLeastOneVowel) {
                        System.out.println("⚠️ Nessuna vocale trovata. ⚠️");
                    } else {
                        System.out.println("\n Totale vocali trovate: " + vowelCount);
                    }
                    break;

                case "2": // Exit
                    System.out.println("\n Uscita dal programma. A presto!");
                    continues = false; // Ferma il ciclo
                    break;

                default: // Opzione non valida
                    System.out.println("❌ Scelta non valida. Inserisci 1 o 2. ❌");
            }
        }

        scanner.close(); // Chiude lo scanner
    }
}

//Array di vocali (in minuscolo)
//char[] vowels = {'a', 'e', 'i', 'o', 'u'};

//Stampa della vocale
//if (Character.isLetter(c)) {
// char lowercase = Character.toLowerCase(c);
//     // Controllo se è una vocale
// if (isVowel(lowercase, vowels)) {
//     System.out.println("• Vocale '" + c + "' all'indice " + i);
//     vowelCount++;
//     atLeastOneVowel = true;
// 	}
//	}
//}

//Metodo per controllare se un carattere è una vocale usando un array
//public static boolean isVowel(char c, char[] vowels) {
// for (char v : vowels) {
//     if (c == v) {
//         return true;
//     }
// }
// return false;
//}