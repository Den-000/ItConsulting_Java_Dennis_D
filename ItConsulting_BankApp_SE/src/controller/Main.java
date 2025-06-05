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