package model;

// Sottoclasse di User per rappresentare un bibliotecario
public class Librarian extends User {
    // Costruttore che utilizza il costruttore della superclasse
    public Librarian(String nome, String id) {
        super(nome, id);
    }
}