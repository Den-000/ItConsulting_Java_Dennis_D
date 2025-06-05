package main;

import java.util.Scanner;

public class Main {

    // Metodo per calcolare il fattoriale di un intero
    public static long calculateFactorial(int n) {
        if (n < 0) {
            System.out.println("Il fattoriale non è definito per numeri negativi.");
            return -1;
        }

        long result = 1;
        for (int i = 1; i <= n; i++) {
        	result *= i;
        }
        return result;
    }

    // Metodo overload per gestire input come stringa
    public static void calculateFactorial(String input) {
        try {
            int number = Integer.parseInt(input);
            long factorial = calculateFactorial(number);
            if (factorial != -1) {
                System.out.println("Il fattoriale di " + number + " è: " + factorial);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nErrore: Inserisci un numero valido.\n");
        }
    }

    // Metodo main con menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continues = true;

        while (continues) {
            System.out.println("\n**** MENU ****");
            System.out.println("1. Calcolo fattoriale");
            System.out.println("2. Esci");
            System.out.println("**************");
            System.out.print("\nScegli un'opzione: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                	System.out.println("\n**************");
                    System.out.print("Inserisci un numero intero: ");
                    String input = scanner.nextLine();
                    calculateFactorial(input);
                    break;

                case "2":
                    System.out.println("\nStai uscendo dal programma. A presto!\n");
                    continues = false;
                    break;

                default:
                    System.out.println("\nErrore: Scelta non valida, riprova.\n");
            }
        }

        scanner.close();
    }
}