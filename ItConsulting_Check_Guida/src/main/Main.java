package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Richiesta età
            System.out.print("Quanti anni hai? ");
            int eta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            // Se troppo giovane per qualsiasi tipo di patente
            if (eta < 14) {
                System.out.println("Sei troppo giovane per avere la patente. Non puoi guidare.");
            } else {
                // Richiesta patente
                System.out.print("Hai la patente? (si/no): ");
                String haPatente = scanner.nextLine().trim().toLowerCase();

                if (!haPatente.equals("si")) {
                    System.out.println("Non puoi guidare.");
                } else {
                    String tipoPatente = "";
                    boolean patenteValida = false;

                    System.out.print("Di che tipo di patente disponi? (AM, A1, A2, A, B): ");
                    tipoPatente = scanner.nextLine().trim().toUpperCase();

                    // Verifica compatibilità età con tipo patente
                    switch (tipoPatente) {
                        case "AM":
                            patenteValida = eta >= 14;
                            break;
                        case "A1":
                            patenteValida = eta >= 16;
                            break;
                        case "A2":
                            patenteValida = eta >= 18;
                            break;
                        case "A":
                            patenteValida = eta >= 20; // con A2 da almeno 2 anni (semplificato)
                            break;
                        case "B":
                            patenteValida = eta >= 18;
                            break;
                        default:
                            System.out.println("Tipo di patente non riconosciuto.");
                            patenteValida = false;
                    }

                    // Richiesta se ha bevuto
                    System.out.print("Hai bevuto alcolici? (si/no): ");
                    String haBevuto = scanner.nextLine().trim().toLowerCase();

                    // Verifica condizioni per guidare
                    if (patenteValida && haBevuto.equals("no")) {
                        System.out.println("Puoi guidare.");
                    } else {
                        System.out.println("Non puoi guidare.");
                    }
                }
            }

            // Ripeti o termina
            System.out.print("Vuoi riprovare? (si/no): ");
            String risposta = scanner.nextLine().trim().toLowerCase();
            if (!risposta.equals("si")) {
                System.out.println("Uscita dal programma.");
                break;
            }

            System.out.println(); // Riga vuota per separare i cicli
        }

        scanner.close();
    }
}