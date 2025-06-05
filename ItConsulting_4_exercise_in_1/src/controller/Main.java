package controller;

import model.Functions;
import view.View;

public class Main {
    public static void main(String[] args) {
        Functions model = new Functions();
        View view = new View();
        boolean running = true;

        // Inizializza array
        String[] names = new String[5];
        for (int i = 0; i < names.length; i++) {
            names[i] = "(vuoto)";
        }

        while (running) {
            view.showMenu();
            int choice = view.getInt("");

            switch (choice) {
            	//Somma due numeri interi
                case 1:
                    int n1 = view.getInt("Inserisci il primo numero: ");
                    int n2 = view.getInt("Inserisci il secondo numero: ");
                    int sum = model.sum(n1, n2);
                    view.printResult("Somma: ", sum);
                    break;

                    //Moltiplica due numeri interi
                case 2:
                    int m1 = view.getInt("Inserisci il primo numero: ");
                    int m2 = view.getInt("Inserisci il secondo numero: ");
                    int productInt = model.multiply(m1, m2);
                    view.printResult("Prodotto: ", productInt);
                    break;

                    //Moltiplica tre float
                case 3:
                    float f1 = view.getFloat("Inserisci il primo numero: ");
                    float f2 = view.getFloat("Inserisci il secondo numero: ");
                    float f3 = view.getFloat("Inserisci il terzo numero: ");
                    float productFloat = model.multiply(f1, f2, f3);
                    view.printResult("Prodotto: ", productFloat);
                    break;

                    //Somma ricorsiva dei primi N numeri
                case 4:
                    int n = view.getInt("Inserisci N: ");
                    if (n < 0) {
                        view.printResult("Errore: N deve essere >= 0", "");
                    } else {
                        int total = model.recursiveSum(n);
                        view.printResult("Somma ricorsiva: ", total);
                    }
                    break;

                    //Modifica variabile primitiva (boolean)
                case 5:
                    boolean value = view.getBoolean("Inserisci valore booleano");
                    model.toggleBoolean(value);
                    break;

                    //Modifica array di nomi
                case 6:
                    String newName = view.getString("Inserisci nuovo nome: ");
                    int pos = view.getInt("Inserisci posizione (0 - " + (names.length - 1) + "): ");
                    if (pos >= 0 && pos < names.length) {
                        model.modifyArray(names, pos, newName);
                    } else {
                        view.printResult("Indice fuori dai limiti dell'array.", "");
                    }
                    break;

                    //Exit
                case 0:
                    running = false;
                    view.printResult("Uscita in corso...", "");
                    break;

                default:
                    view.printResult("Scelta non valida.", "");
            }
        }

        view.close();
    }
}