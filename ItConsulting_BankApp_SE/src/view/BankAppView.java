package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BankAppView {
    private final Scanner scanner = new Scanner(System.in);

    // Pattern regex per validare input:
    // Email: formato base username@domain.ext
    private static final Pattern EMAIL_PATTERN = 
        Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    // Nome: solo lettere (anche accentate), spazi e apostrofi
    private static final Pattern NAME_PATTERN =
        Pattern.compile("^[a-zA-Zàèéìòù' ]+$");
    // Telefono: solo cifre, almeno 6 caratteri
    private static final Pattern PHONE_PATTERN =
        Pattern.compile("^\\d{6,}$");

    /**
     * Metodo generico per mostrare un menu e acquisire scelta numerica valida.
     * @param title Titolo del menu
     * @param options Opzioni da mostrare
     * @param min Valore minimo accettato
     * @param max Valore massimo accettato
     * @return scelta numerica valida
     */
    private int showMenu(String title, String[] options, int min, int max) {
        while (true) {
            try {
                System.out.println("\n**** " + title + " ****");
                for (int i = 0; i < options.length; i++) {
                    System.out.printf("%d. %s%n", i + 1, options[i]);
                }
                System.out.println("************************");
                System.out.print("\nScelta: ");
                
                
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.printf("\nScelta non valida. Inserire un numero tra %d e %d.%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput non valido. Inserire un numero.");
            }
        }
    }

    //Menu principale dell'applicazione.
    public int mainMenu() {
        return showMenu("MENU PRINCIPALE", new String[]{"Registrazione", "Login", "Esci"}, 1, 3);
    }

    // Menu delle operazioni bancarie.
    public int accountMenu() {
        return showMenu("OPERAZIONI BANCARIE", new String[]{"Deposito", "Prelievo", "Mostra Saldo", "Esci"}, 1, 4);
    }

    // Richiede un input stringa non vuoto.
    private String promptNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("\nIl campo non può essere vuoto.");
        }
    }

    //Richiede e valida un indirizzo email.
    private String promptEmail() {
        while (true) {
            System.out.print("Email: ");
            String email = scanner.nextLine().trim();
            if (EMAIL_PATTERN.matcher(email).matches()) {
                return email;
            } else {
                System.out.println("\nEmail non valida. Inserire un indirizzo email corretto.");
            }
        }
    }

    //Richiede e valida una password (minimo 6 caratteri).
    private String promptPassword() {
        while (true) {
            System.out.print("Password (min 6 caratteri): ");
            String pwd = scanner.nextLine();
            if (pwd.length() >= 6) {
                return pwd;
            } else {
                System.out.println("\nPassword troppo corta. Inserire almeno 6 caratteri.");
            }
        }
    }

    //Richiede e valida il nome e cognome (solo lettere, spazi e apostrofi).
    private String promptName() {
        while (true) {
            System.out.print("Nome e Cognome: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty() && NAME_PATTERN.matcher(name).matches()) {
                return name;
            } else {
                System.out.println("\nNome non valido. Usa solo lettere, spazi e apostrofi.");
            }
        }
    }

    // Richiede e valida un numero di telefono (solo cifre, almeno 6 cifre).
    private String promptPhone() {
        while (true) {
            System.out.print("Numero di telefono: ");
            String phone = scanner.nextLine().trim();
            if (PHONE_PATTERN.matcher(phone).matches()) {
                return phone;
            } else {
                System.out.println("\nNumero di telefono non valido. Inserire almeno 6 cifre numeriche.");
            }
        }
    }

    // Acquisisce dati per la registrazione utente con controlli validità.
    public String[] registerUser() {
        String email = promptEmail();
        String password = promptPassword();
        return new String[]{email, password};
    }

    // Acquisisce dati per il login utente.
    public String[] loginUser() {
        String email = promptEmail();
        String password = promptNonEmpty("Password: ");
        return new String[]{email, password};
    }

    // Acquisisce dati per apertura conto (nome e telefono validati).
    public String[] openBankAccount() {
        String name = promptName();
        String phone = promptPhone();
        return new String[]{name, phone};
    }

    // Richiede un importo numerico non negativo.
    public double askAmount(String action) {
        while (true) {
            try {
                System.out.print("Importo da " + action + ": ");
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount >= 0) {
                    return amount;
                } else {
                    System.out.println("\nL'importo non può essere negativo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput non valido. Inserire un numero decimale.");
            }
        }
    }

    //Stampa un messaggio sulla console.
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}