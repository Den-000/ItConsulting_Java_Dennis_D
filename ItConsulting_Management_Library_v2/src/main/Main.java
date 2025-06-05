package main;

import controller.AuthController;
import view.AuthView;

public class Main {
    public static void main(String[] args) {
    	
        // Crea la view dell'applicazione
        AuthView view = new AuthView();
        
        // Crea il controller e collega la vista
        AuthController controller = new AuthController(view);
        
        // Avvia l'applicazione
        controller.start();
    }
}