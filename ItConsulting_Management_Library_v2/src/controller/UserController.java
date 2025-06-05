package controller;

import java.util.ArrayList;

import model.Resource;
import view.UserView;

// Controller che gestisce le operazioni dell'utente
public class UserController {
    
    // Lista delle risorse disponibili
    private ArrayList<Resource> resources;
    
    // View associata all'utente
    private UserView view;

    // Costruttore che riceve le risorse e la view da collegare
    public UserController(ArrayList<Resource> risorse, UserView view) {
        this.resources = risorse;
        this.view = view;
    }

    // Avvia il menu principale dell'utente
    public void startMenu() {
        boolean loop = true;
        while (loop) {
            int choice = view.showMenuUser();
            switch (choice) {
                case 1 -> findResource();         // Cerca una risorsa
                case 2 -> viewAll();              // Mostra tutte le risorse
                case 3 -> takeOnBorrowing();      // Prende una risorsa in prestito
                case 4 -> giveBack();             // Restituisce una risorsa
                case 0 -> loop = false;           // Esce dal menu
                default -> view.print("\nScelta non valida.");
            }
        }
    }

    // Permette all'utente di cercare una risorsa per titolo o codice
    private void findResource() {
        String criterion = view.askInput("\nCerca per (titolo/codice):");
        String value = view.askInput("Valore da cercare:");
        for (Resource r : resources) {
            if ((criterion.equalsIgnoreCase("titolo") && r.getTitle().equalsIgnoreCase(value)) ||
                (criterion.equalsIgnoreCase("codice") && r.getCode().equalsIgnoreCase(value))) {
                r.viewDetails();
                return;
            }
        }
        view.print("\nNessuna risorsa trovata.");
    }

    // Mostra tutte le risorse disponibili nel sistema
    private void viewAll() {
        if (resources.isEmpty()) {
            view.print("\nNessuna risorsa disponibile.");
            return;
        }
        for (Resource r : resources) {
            r.viewDetails();
            System.out.println("-----------------");
        }
    }

    // Cerca una risorsa tramite il codice
    private Resource findByCode(String codice) {
        for (Resource r : resources) {
            if (r.getCode().equalsIgnoreCase(codice)) {
                return r;
            }
        }
        return null;
    }

    // Gestisce il prestito di una risorsa da parte dell'utente
    private void takeOnBorrowing() {
        String codice = view.askInput("\nInserisci il codice della risorsa da prendere in prestito:");
        Resource risorsa = findByCode(codice);
        
        if (risorsa == null) {
            view.print("\nRisorsa non trovata.");
        } else if (!risorsa.getIsAvailable()) {
            view.print("\nLa risorsa non è disponibile.");
        } else {
            risorsa.setIsAvailable(false);
            view.print("\nRisorsa '" + risorsa.getTitle() + "' presa in prestito con successo.");
        }
    }

    // Gestisce la restituzione di una risorsa da parte dell'utente
    private void giveBack() {
        String codice = view.askInput("\nInserisci il codice della risorsa da restituire:");
        Resource risorsa = findByCode(codice);
        
        if (risorsa == null) {
            view.print("\nRisorsa non trovata.");
        } else if (risorsa.getIsAvailable()) {
            view.print("\nLa risorsa non è attualmente in prestito.");
        } else {
            risorsa.setIsAvailable(true);
            view.print("\nRisorsa '" + risorsa.getTitle() + "' restituita con successo.");
        }
    }
}
