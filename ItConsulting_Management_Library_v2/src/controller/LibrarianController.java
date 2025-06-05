package controller;

import model.*;
import view.LibrarianView;

import java.util.ArrayList;
import java.util.UUID;

// Controller dedicato alle operazioni dal bibliotecario
public class LibrarianController {
    private ArrayList<Resource> resources;
    private LibrarianView view;

    // Costruttore
    public LibrarianController(ArrayList<Resource> risorse, LibrarianView view) {
        this.resources = risorse;
        this.view = view;
    }

    // Avvia il menu principale del bibliotecario
    public void startMenu() {
        boolean loop = true;
        while (loop) {
            int choice = view.showMenuLibrarian();
            switch (choice) {
                case 1 -> addResource();       // Aggiunge una nuova risorsa
                case 2 -> modifyResource();    // Modifica una risorsa esistente
                case 3 -> removeResource();    // Rimuove una risorsa
                case 4 -> findResource();      // Cerca una risorsa
                case 5 -> viewAll();           // Visualizza tutte le risorse
                case 0 -> loop = false;        // Esce dal menu
                default -> view.print("Scelta non valida.");
            }
        }
    }

    // Aggiunge una nuova risorsa alla lista
    private void addResource() {
        String type = view.askInput("Tipo (libro/rivista/ebook):").toLowerCase();
        String title = view.askInput("Titolo:");
        int year = Integer.parseInt(view.askInput("Anno di pubblicazione:"));
        String code = UUID.randomUUID().toString(); // Genera un codice univoco

        Resource New = null;
        switch (type) {
            case "libro" -> {
                String autore = view.askInput("Autore:");
                New = new Book(title, year, code, autore);
            }
            case "rivista" -> {
                int numero = Integer.parseInt(view.askInput("Numero della rivista:"));
                New = new Magazine(title, year, code, numero);
            }
            case "ebook" -> {
                String formato = view.askInput("Formato (PDF, EPUB...):");
                New = new Ebook(title, year, code, formato);
            }
            default -> {
                view.print("\nTipo non valido.");
                return;
            }
        }

        resources.add(New);
        view.print("Risorsa aggiunta con codice: " + code);
    }

    // Modifica i dettagli di una risorsa esistente
    private void modifyResource() {
        String code = view.askInput("Inserisci il codice della risorsa da modificare:");
        Resource r = findByCode(code);
        if (r == null) {
            view.print("\nRisorsa non trovata.");
            return;
        }

        String newTitle = view.askInput("Nuovo titolo:");
        int newYear = Integer.parseInt(view.askInput("Nuovo anno di pubblicazione:"));
        r.setTitle(newTitle);
        r.setYearPublication(newYear);

        // Modifica campi specifici in base al tipo della risorsa
        if (r instanceof Book book) {
            book.setAuthor(view.askInput("Nuovo autore:"));
        } else if (r instanceof Magazine rivista) {
            rivista.setNumber(Integer.parseInt(view.askInput("Nuovo numero rivista:")));
        } else if (r instanceof Ebook ebook) {
            ebook.setProductFormat(view.askInput("Nuovo formato:"));
        }

        view.print("\nRisorsa modificata.");
    }

    // Rimuove una risorsa dalla lista
    private void removeResource() {
        String code = view.askInput("\nCodice della risorsa da rimuovere:");
        Resource r = findByCode(code);
        if (r != null) {
            resources.remove(r);
            view.print("\nRisorsa rimossa.");
        } else {
            view.print("\nRisorsa non trovata.");
        }
    }

    // Cerca una risorsa per titolo o codice
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

    // Visualizza tutte le risorse presenti nel sistema
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

    // Cerca una risorsa specifica in base al codice
    private Resource findByCode(String codice) {
        for (Resource r : resources) {
            if (r.getCode().equalsIgnoreCase(codice)) {
                return r;
            }
        }
        return null;
    }
}
