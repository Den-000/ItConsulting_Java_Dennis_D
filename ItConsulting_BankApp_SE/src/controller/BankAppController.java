package controller;

import model.BankAccount;
import model.User;
import view.BankAppView;

import java.util.*;

public class BankAppController {
    // Riferimento alla view
    private final BankAppView view;

    // Mappa che associa un'email a un oggetto User (utenti registrati)
    private final Map<String, User> users = new HashMap<>();

    // Mappa che associa un'email a un oggetto BankAccount (conti bancari)
    private final Map<String, BankAccount> accounts = new HashMap<>();

    // Costruttore che riceve la view
    public BankAppController(BankAppView view) {
        this.view = view;
    }

    // Metodo principale per avviare l'applicazione
    public void start() {
        boolean running = true;
        while (running) {
        	
            // Mostra il menu principale e legge la scelta dell'utente
            int choice = view.mainMenu();
            switch (choice) {
                case 1: register(); break;          // Registra nuovo utente
                case 2: login(); break;             // Accesso utente
                case 3: running = false; break;     // Uscita dall'applicazione
                default: view.printMessage("\nScelta non valida."); break;
            }
        }
    }

    // Metodo per registrare un nuovo utente
    private void register() {
        String[] creds = view.registerUser();  // Richiede email e password

        // Controlla se l'email è già registrata
        if (users.containsKey(creds[0])) {
            view.printMessage("\nEmail già registrata.");
            return;
        }

        // Registra il nuovo utente nella mappa
        users.put(creds[0], new User(creds[0], creds[1]));
        view.printMessage("\nRegistrazione completata.");
    }

    // Metodo per effettuare il login
    private void login() {
        String[] creds = view.loginUser(); // Richiede email e password
        User user = users.get(creds[0]);   // Recupera l'utente dalla mappa

        // Verifica che l'utente esista e che la password sia corretta
        if (user == null || !user.checkPassword(creds[1])) {
            view.printMessage("\nCredenziali non valide.");
            return;
        }

        view.printMessage("\nLogin effettuato.");
        String email = creds[0];

        // Se l'utente non ha ancora un conto bancario, lo si crea
        if (!accounts.containsKey(email)) {
            view.printMessage("\nNon hai ancora un conto. Creiamone uno.");

            // Richiede i dati per il nuovo conto: intestatario e numero di telefono
            String[] accInfo = view.openBankAccount();

            // Verifica che il numero di telefono non sia già usato in un altro conto
            if (accounts.values().stream().anyMatch(a -> a.getCellphoneNumber().equals(accInfo[1]))) {
                view.printMessage("\nNumero di telefono già associato ad un altro conto.");
                return;
            }

            // Crea e associa il conto all'email dell'utente
            accounts.put(email, new BankAccount(accInfo[0], accInfo[1]));
        }

        // Gestisce il conto
        handleAccount(accounts.get(email));
    }

    // Metodo per gestire le operazioni sul conto bancario dell'utente autenticato
    private void handleAccount(BankAccount account) {
        boolean session = true;
        while (session) {
            // Mostra il menu del conto e legge la scelta
            int choice = view.accountMenu();
            double amt;
            switch (choice) {
                case 1:
                    // Deposito
                    amt = view.askAmount("depositare");
                    if (account.deposit(amt))
                        view.printMessage("\nDeposito effettuato.");
                    else
                        view.printMessage("\nImporto non valido.");
                    break;
                case 2:
                    // Prelievo
                    amt = view.askAmount("prelevare");
                    if (account.withdraw(amt))
                        view.printMessage("\nPrelievo effettuato.");
                    else
                        view.printMessage("\nFondi insufficienti o importo non valido.");
                    break;
                case 3:
                    // Visualizzazione saldo
                    account.displayBalance();
                    break;
                case 4:
                    // Uscita dalla sessione
                    session = false;
                    break;
                default:
                    view.printMessage("\nScelta non valida.");
                    break;
            }
        }
    }
}