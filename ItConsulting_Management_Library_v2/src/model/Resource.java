package model;

public class Resource {
    private String title;
    private int yearPublication;
    private boolean isAvailable;
    private String code;

    // Costruttore
    public Resource(String titolo, int annoPubblicazione, String codice) {
        this.title = titolo;
        this.yearPublication = annoPubblicazione;
        this.isAvailable = true;
        this.code = codice;
    }

    // Metodi getter
    public String getTitle() { return title; }
    public int getYearPublication() { return yearPublication; }
    public String getCode() { return code; }
    public boolean getIsAvailable() { return isAvailable; }

    // Metodi setter
    public void setTitle(String titolo) { this.title = titolo; }
    public void setYearPublication(int anno) { this.yearPublication = anno; }
    public void setIsAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    // Mostra i dettagli della risorsa
    public void viewDetails() {
        System.out.println("Titolo: " + title + ", Anno: " + yearPublication + ", Codice: " + code);
    }
}