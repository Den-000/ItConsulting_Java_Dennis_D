package model;

public class Ebook extends Resource {
    private String productFormat;

    // Costruttore
    public Ebook(String titolo, int anno, String codice, String formato) {
        super(titolo, anno, codice);
        this.productFormat = formato;
    }

    // Metodi getter e setter
    public String getProductFormat() { return productFormat; }
    public void setProductFormat(String formato) { this.productFormat = formato; }

    // Mostra i dettagli dell'ebook
    @Override
    public void viewDetails() {
        super.viewDetails();
        System.out.println("Formato: " + productFormat);
    }
}