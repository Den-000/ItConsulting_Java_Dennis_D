package model;

public class BankAccount {
	
    // Contatore statico per ID univoco
    private static int idCounter = 1;

    // Attributi del conto bancario
    private final int id;
    private final String accountHolderName;
    private final String cellphoneNumber;
    private double balance;

    // Costruttore: inizializza un nuovo conto con nome e numero di telefono
    public BankAccount(String accountHolderName, String cellphoneNumber) {
        this.id = idCounter++;
        this.accountHolderName = accountHolderName;
        this.cellphoneNumber = cellphoneNumber;
        this.balance = 0.0;
    }

    // Restituisce l'ID
    public int getId() {
        return id;
    }

    // Restituisce il nome dell'intestatario del conto
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Restituisce il contatore ID (statico)
    public static int getIdCounter() {
        return idCounter;
    }

    // Imposta il valore del contatore ID
    public static void setIdCounter(int idCounter) {
        BankAccount.idCounter = idCounter;
    }

    // Imposta direttamente il saldo
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Restituisce il numero di telefono associato
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    // Restituisce il saldo corrente
    public double getBalance() {
        return balance;
    }

    // Effettua un deposito
    public boolean deposit(double amount) {
        if (amount <= 0) return false;     // Importo non valido
        balance += amount;                 // Aggiunge l'importo al saldo
        return true;
    }

    // Effettua un prelievo
    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false; // Importo non valido o fondi insufficienti
        balance -= amount;                 // Sottrae l'importo dal saldo
        return true;
    }

    // Mostra il saldo disponibile a console
    public void displayBalance() {
        System.out.println("Saldo disponibile: €" + balance);
    }
}