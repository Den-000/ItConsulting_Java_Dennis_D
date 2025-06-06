package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe che rappresenta un artista musicale
public class Artist {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String genre;
    private LocalDate birthDate;

    // Costruttore completo
    public Artist(String firstName, String lastName, String genre, LocalDate birthDate) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.birthDate = birthDate;
    }

    // Getter ID
    public int getId() {return id;}

    // Getter e setter nome
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    // Getter e setter cognome
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    // Getter e setter genere musicale
    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

    // Getter e setter data di nascita
    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    // Rappresentazione testuale dell’artista
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
            "Artist {\n" +
            "  ID: %d\n" +
            "  Name: '%s %s'\n" +
            "  Genre: '%s'\n" +
            "  Birth Date: %s\n" +
            "}",
            id,
            firstName,
            lastName,
            genre,
            birthDate.format(formatter)
        );
    }
}