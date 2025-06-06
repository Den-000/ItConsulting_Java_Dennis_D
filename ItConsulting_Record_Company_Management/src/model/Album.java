package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe che rappresenta un album musicale
public class Album {
    private static int counter = 0;
    private int id;
    private String title;
    private LocalDate releaseDate;
    private Artist artist;

    // Costruttore completo
    public Album(String title, LocalDate releaseDate, Artist artist) {
        this.id = counter++;
        this.title = title;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }

    // Getter ID
    public int getId() {return id;}

    // Getter e setter titolo
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    // Getter e setter data uscita
    public LocalDate getReleaseDate() {return releaseDate;}
    public void setReleaseDate(LocalDate releaseDate) {this.releaseDate = releaseDate;}

    // Getter e setter artista associato
    public Artist getArtist() {return artist;}
    public void setArtist(Artist artist) {this.artist = artist;}

    // Rappresentazione testuale dell’album
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
            "Album {\n" +
            "  ID: %d\n" +
            "  Title: '%s'\n" +
            "  Release Date: %s\n" +
            "  Artist: %s %s\n" +
            "}",
            id,
            title,
            releaseDate.format(formatter),
            artist.getFirstName(),
            artist.getLastName()
        );
    }
}