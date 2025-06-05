package model;

public class Book extends Resource {
    private String author;

    // Costruttore
    public Book(String titolo, int anno, String codice, String autore) {
        super(titolo, anno, codice);
        this.author = autore;
    }

    // Metodi getter e setter
    public String getAuthor() { return author; }
    public void setAuthor(String autore) { this.author = autore; }

    // Mostra i dettagli del libro
    @Override
    public void viewDetails() {
        super.viewDetails();
        System.out.println("Autore: " + author);
    }
}