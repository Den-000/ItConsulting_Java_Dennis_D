package view;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n**** MENU ****");
        System.out.println("1. Somma due numeri interi");
        System.out.println("2. Moltiplica due numeri interi");
        System.out.println("3. Moltiplica tre float");
        System.out.println("4. Somma ricorsiva dei primi N numeri");
        System.out.println("5. Modifica variabile primitiva (boolean)");
        System.out.println("6. Modifica array di nomi");
        System.out.println("0. Esci");
        System.out.println("**************");
        System.out.print("Scelta: ");
    }

    public int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Input non valido. Inserisci un numero intero.");
                scanner.nextLine(); // pulisce il buffer
            }
        }
    }

    public float getFloat(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextFloat();
            } catch (Exception e) {
                System.out.println("Input non valido. Inserisci un numero decimale (float).");
                scanner.nextLine(); // pulisce il buffer
            }
        }
    }

    public boolean getBoolean(String message) {
        while (true) {
            try {
                System.out.print(message + " (true/false): ");
                return scanner.nextBoolean();
            } catch (Exception e) {
                System.out.println("Input non valido. Inserisci 'true' o 'false'.");
                scanner.nextLine(); // pulisce il buffer
            }
        }
    }

    public String getString(String message) {
        System.out.print(message);
        scanner.nextLine(); // pulisce il buffer
        return scanner.nextLine();
    }

    public void printResult(String message, Object result) {
        System.out.println(message + result);
    }

    public void close() {
        scanner.close();
    }
}