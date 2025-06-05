package model;

import java.time.LocalDate;

public class Student {
    // Contatore statico per assegnare ID univoci agli studenti
    private static int counter = 1;

    // Attributi dello studente
    private final int id;
    private final String name;
    private final LocalDate BirthDate;
    private final LocalDate RegistrationDate;
    private final String ClassAttended;

    // Costruttore che inizializza uno studente con i dati forniti
    public Student(String name, LocalDate BirthDate, LocalDate RegistrationDate, String ClassAttended) {
        this.id = counter++; // Assegna un ID univoco e incrementa il contatore
        this.name = name;
        this.BirthDate = BirthDate;
        this.RegistrationDate = RegistrationDate;
        this.ClassAttended = ClassAttended;
    }

    // Metodo per ottenere l'ID dello studente
    public int getId() {
        return id;
    }

    // Metodo per ottenere il nome dello studente
    public String getName() {
        return name;
    }

    // Metodo per ottenere la data di nascita
    public LocalDate getBirthDate() {
        return BirthDate;
    }

    // Metodo per ottenere la data di iscrizione
    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }

    // Metodo per ottenere la classe frequentata
    public String getClassAttended() {
        return ClassAttended;
    }

    // Metodo che restituisce una rappresentazione testuale dello studente
    @Override
    public String toString() {
        return "[" + id + "] " + name + " | Nascita: " + BirthDate +
               " | Iscrizione: " + RegistrationDate + " | Classe: " + ClassAttended;
    }
}