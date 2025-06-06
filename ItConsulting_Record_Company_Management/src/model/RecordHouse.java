package model;

import java.util.*;

// Classe che rappresenta una Casa Discografica
public class RecordHouse {
    private static int counter = 0; // Contatore statico per ID univoci
    private int id;
    private String name;
    private List<Artist> artists = new ArrayList<>(); // Lista di artisti associati
    private List<Album> albums = new ArrayList<>();   // Lista di album associati

    // Costruttore che assegna ID e nome
    public RecordHouse(String name) {
        this.id = counter++;
        this.name = name;
    }

    // Getter
    public int getId() {return id;}
    public String getName() {return name;}
    public List<Artist> getArtists() {return artists;}
    public List<Album> getAlbums() {return albums;}

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Aggiunge un artista alla lista
    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    // Rimuove un artista dalla lista
    public void removeArtist(Artist artist) {
        artists.remove(artist);
    }

    // Aggiunge un album alla lista
    public void addAlbum(Album album) {
        albums.add(album);
    }

    // Rimuove un album dalla lista
    public void removeAlbum(Album album) {
        albums.remove(album);
    }

    // Rappresentazione testuale della casa discografica
    @Override
    public String toString() {
        return String.format(
            "RecordHouse {\n" +
            "  ID: %d\n" +
            "  Name: '%s'\n" +
            "  Artists count: %d\n" +
            "  Albums count: %d\n" +
            "}",
            id,
            name,
            artists.size(),
            albums.size()
        );
    }
}