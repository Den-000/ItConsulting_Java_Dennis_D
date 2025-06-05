package model;

public class User {
    protected String name;
    protected String id;

    // Costruttore
    public User(String nome, String id) {
        this.name = nome;
        this.id = id;
    }

    // Restituisce il nome
    public String getName() { return name; }

    // Restituisce l'ID
    public String getId() { return id; }

    // Verifica se l'utente è un bibliotecario
    public boolean isLibrarian() {
        return this instanceof Librarian;
    }
}