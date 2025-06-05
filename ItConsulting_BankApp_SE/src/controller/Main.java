package controller;

import view.BankAppView;

public class Main {
    public static void main(String[] args) {
        // Crea un'istanza della view
        BankAppView view = new BankAppView();
        
        // Crea un'istanza del controller e gli passa la view come parametro
        BankAppController controller = new BankAppController(view);
        
        // Avvia l'applicazione attraverso il controller
        controller.start();
    }
}


/*MODIFICHE/MIGLIORIE DA APPORTARE
 * 1. Capire se limitare i numeri di telefono ad italiani (da 6 a 10 cifre, mim e max)
 * 2. Aggiungere nazioni
 * 3. Aggiungere prefisso
 * 4. Aggiungere crittografia
 */