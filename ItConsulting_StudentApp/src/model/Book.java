package model;

public class Book {
    // Contatore statico per assegnare codici univoci ai libri
    private static int counter = 1;

    // Attributi del libro
    private final int code;
    private final String title;
    private final double price;

    // Costruttore che inizializza un libro con titolo e prezzo
    public Book(String title, double price) {
        this.code = counter++; // Codice assegnato automaticamente
        this.title = title;
        this.price = price;
    }

    // Metodo per ottenere il codice del libro
    public int getCode() {
        return code;
    }

    // Metodo per ottenere il titolo del libro
    public String getTitle() {
        return title;
    }

    // Metodo per ottenere il prezzo del libro
    public double getPrice() {
        return price;
    }

    // Metodo che restituisce una descrizione testuale del libro
    @Override
    public String toString() {
        return "[" + code + "] " + title + " - €" + price;
    }
}