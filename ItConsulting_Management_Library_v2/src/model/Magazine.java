package model;

public class Magazine extends Resource {
    private int number;

    // Costruttore
    public Magazine(String titolo, int anno, String codice, int numero) {
        super(titolo, anno, codice);
        this.number = numero;
    }

    // Metodi getter e setter
    public int getNumber() { return number; }
    public void setNumber(int numero) { this.number = numero; }

    // Mostra i dettagli della rivista
    @Override
    public void viewDetails() {
        super.viewDetails();
        System.out.println("Numero Rivista: " + number);
    }
}