package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n1 = 0, n2 = 0, n3 = 0;
            boolean validInput = false;

            // Ciclo fino a ottenere input valido
            while (!validInput) {
                try {
                    System.out.print("Inserisci il primo numero: ");
                    n1 = scanner.nextInt();

                    System.out.print("Inserisci il secondo numero: ");
                    n2 = scanner.nextInt();

                    System.out.print("Inserisci il terzo numero: ");
                    n3 = scanner.nextInt();

                    validInput = true; // Input valido, esco dal ciclo
                    scanner.nextLine(); // Consuma il new line
                } catch (InputMismatchException e) {
                    System.out.println("\nErrore: devi inserire dei numeri interi.");
                    scanner.nextLine(); // Pulisce l'input errato
                }
            }
            
            boolean allEquals = (n1 == n2) && (n2 == n3);
            boolean twoEquals = (n1 == n2) || (n1 == n3) || (n2 == n3);

            // Verifica uguaglianze
            if (allEquals) {
                System.out.println("Tutti e tre i numeri sono uguali: " + n1);
            } else if (twoEquals) {
                System.out.print("Ci sono due numeri uguali: ");
                if (n1 == n2) {
                    System.out.println(n1 + " e " + n2);
                } else if (n1 == n3) {
                    System.out.println(n1 + " e " + n3);
                } else {
                    System.out.println(n2 + " e " + n3);
                }
            } else {
                System.out.println("Tutti e tre i numeri sono diversi.");
            }
            

//            int codeEquality = 0;
//            if (n1 == n2 && n2 == n3) {
//                codeEquality = 1; // Tutti uguali
//            } else if (n1 == n2 || n1 == n3 || n2 == n3) {
//                codeEquality = 2; // Due uguali
//            } else {
//                codeEquality = 3; // Tutti diversi
//            }
//
//            switch (codeEquality) {
//                case 1:
//                    System.out.println("Tutti e tre i numeri sono uguali: " + n1);
//                    break;
//                case 2:
//                    System.out.print("Ci sono due numeri uguali: ");
//                    if (n1 == n2) {
//                        System.out.println(n1 + " e " + n2);
//                    } else if (n1 == n3) {
//                        System.out.println(n1 + " e " + n3);
//                    } else {
//                        System.out.println(n2 + " e " + n3);
//                    }
//                    break;
//                case 3:
//                    System.out.println("Tutti e tre i numeri sono diversi.");
//                    break;
//                default:
//                    System.out.println("Errore nel confronto.");
//            }

            // Calcolo manuale del massimo
            int max;
            if (n1 >= n2 && n1 >= n3) {
                max = n1;
            } else if (n2 >= n1 && n2 >= n3) {
                max = n2;
            } else {
                max = n3;
            }

            System.out.println("Il numero più grande è: " + max);

            // Ripeti o termina
            System.out.print("Vuoi riprovare? (si/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("si")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            System.out.println(); // Riga vuota tra i cicli
        }

        scanner.close();
    }
}