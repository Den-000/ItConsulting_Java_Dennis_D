package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import model.Album;
import model.Artist;
import model.RecordHouse;
import view.View;

public class Controller {
    private final View view; // Interfaccia utente per input/output
    private final List<RecordHouse> recordHouses; // Lista delle case discografiche
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato data

    public Controller() {
        this.view = new View();
        this.recordHouses = new ArrayList<>();
    }

    // Avvia il ciclo principale dell'applicazione
    public void run() { 
        while (true) {
            String choice = view.showMainMenu(); // Mostra menu principale e riceve scelta
            switch (choice) {
                case "1": manageRecordHouses(); break; 	// Entra nella gestione case discografiche
                case "0": view.close(); 				// Esci dall'applicazione
                System.out.println("Arrivederci!");
                return; 
                default: 
                	System.out.println("Scelta non valida. Riprova."); 
                	break; 
            }
        }
    }

    // Menu per gestire case discografiche
    private void manageRecordHouses() { 
        while (true) {
            String choice = view.showRecordHouseMenu(); 		// Mostra opzioni case discografiche
            switch (choice) {
                case "1": addRecordHouse(); break;			    // Aggiungi nuova casa discografica
                case "2": view.showList(recordHouses); break;   // Visualizza tutte le case
                case "3": editRecordHouse(); break; 			// Modifica nome casa selezionata
                case "4": removeRecordHouse(); break; 			// Rimuovi casa selezionata
                case "5": recordHouses.clear(); 				// Rimuovi tutte le case
                System.out.println("Tutte le case discografiche sono state rimosse."); 
                break; 
                case "6": manageArtists(); break; 				// Gestisci artisti di una casa
                case "7": manageAlbums(); break; 				// Gestisci album di una casa
                case "0": return; 								// Torna al menu principale
                default: 
                	System.out.println("Scelta non valida. Riprova."); 
                	break;
            }
        }
    }

    // Crea e aggiunge una nuova casa discografica
    private void addRecordHouse() { 
        String name = view.getString("Inserisci il nome della casa discografica: ");
        recordHouses.add(new RecordHouse(name));
        System.out.println("Casa discografica aggiunta con successo!");
    }

    // Modifica il nome di una casa selezionata
    private void editRecordHouse() { 
        RecordHouse rh = chooseRecordHouse();
        if (rh != null) {
            String newName = view.getString("Inserisci il nuovo nome della casa discografica: ");
            rh.setName(newName);
            System.out.println("Nome aggiornato con successo.");
        }
    }

    // Rimuove la casa discografica selezionata
    private void removeRecordHouse() { 
        RecordHouse rh = chooseRecordHouse();
        if (rh != null) {
            recordHouses.remove(rh);
            System.out.println("Casa discografica rimossa.");
        }
    }

    // Gestione menu artisti per una casa specifica
    private void manageArtists() { 
        RecordHouse rh = chooseRecordHouse();
        if (rh == null) return;

        while (true) {
            String choice = view.showArtistMenu();
            switch (choice) {
                case "1": addArtist(rh); break; 				 // Aggiungi artista
                case "2": view.showList(rh.getArtists()); break; // Visualizza artisti
                case "3": editArtist(rh); break; 			     // Modifica artista
                case "4": removeArtist(rh); break; 				 // Rimuovi artista
                case "5": rh.getArtists().clear();				 // Rimuovi tutti gli artisti
                System.out.println("Tutti gli artisti sono stati rimossi."); 
                break; 
                case "0": return; 								 // Torna al menu precedente
                default: 
                	System.out.println("Scelta non valida. Riprova."); 
                	break;
            }
        }
    }
    
    // Crea e aggiunge un artista alla casa selezionata
    private void addArtist(RecordHouse rh) { 
        String firstName = view.getString("Nome artista: ");
        String lastName = view.getString("Cognome artista: ");
        String genre = view.getString("Genere musicale: ");
        LocalDate birthDate = null;
        while (birthDate == null) {
            String inputDate = view.getString("Data di nascita (dd/MM/yyyy): ");
            try {
                birthDate = LocalDate.parse(inputDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido, riprova.");
            }
        }
        Artist artist = new Artist(firstName, lastName, genre, birthDate);
        rh.addArtist(artist);
        System.out.println("Artista aggiunto con successo!");
    }

    // Modifica dati di un artista selezionato
    private void editArtist(RecordHouse rh) { 
        Artist a = chooseArtist(rh);
        if (a != null) {
            a.setFirstName(view.getString("Nuovo nome: "));
            a.setLastName(view.getString("Nuovo cognome: "));
            a.setGenre(view.getString("Nuovo genere: "));
            LocalDate birthDate = null;
            while (birthDate == null) {
                String inputDate = view.getString("Nuova data di nascita (dd/MM/yyyy): ");
                try {
                    birthDate = LocalDate.parse(inputDate, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato data non valido, riprova.");
                }
            }
            a.setBirthDate(birthDate);
            System.out.println("Artista aggiornato con successo.");
        }
    }

    // Rimuove l'artista selezionato (da una determinata casa)
    private void removeArtist(RecordHouse rh) { 
        Artist a = chooseArtist(rh);
        if (a != null) {
            rh.removeArtist(a);
            System.out.println("Artista rimosso.");
        }
    }

    // Gestione menu album per una casa specifica
    private void manageAlbums() { 
        RecordHouse rh = chooseRecordHouse();
        if (rh == null) return;

        while (true) {
            String choice = view.showAlbumMenu();
            switch (choice) {
                case "1": addAlbum(rh); break; 					// Aggiungi album
                case "2": view.showList(rh.getAlbums()); break; // Visualizza album
                case "3": editAlbum(rh); break; 				// Modifica album
                case "4": removeAlbum(rh); break; 				// Rimuovi album
                case "5": rh.getAlbums().clear(); 				// Rimuovi tutti gli album
                System.out.println("Tutti gli album sono stati rimossi."); 
                break;
                case "0": return; 								// Torna al menu precedente
                default: 
                	System.out.println("Scelta non valida. Riprova."); 
                	break;
            }
        }
    }

    // Crea e aggiunge un album, collegato ad un artista
    private void addAlbum(RecordHouse rh) { 
        Artist artist = chooseArtist(rh);
        if (artist == null) return;

        String title = view.getString("Titolo album: ");
        LocalDate releaseDate = null;
        while (releaseDate == null) {
            String inputDate = view.getString("Data di uscita (dd/MM/yyyy): ");
            try {
                releaseDate = LocalDate.parse(inputDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido, riprova.");
            }
        }

        Album album = new Album(title, releaseDate, artist);
        rh.addAlbum(album);
        System.out.println("Album aggiunto con successo!");
    }

    // Modifica i dati di un album selezionato
    private void editAlbum(RecordHouse rh) { 
        Album a = chooseAlbum(rh);
        if (a != null) {
            a.setTitle(view.getString("Nuovo titolo: "));
            LocalDate releaseDate = null;
            while (releaseDate == null) {
                String inputDate = view.getString("Nuova data di uscita (dd/MM/yyyy): ");
                try {
                    releaseDate = LocalDate.parse(inputDate, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato data non valido, riprova.");
                }
            }
            a.setReleaseDate(releaseDate);

            Artist newArtist = chooseArtist(rh);
            if (newArtist != null) a.setArtist(newArtist);

            System.out.println("Album aggiornato con successo.");
        }
    }

    // Rimuove un album selezionato dalla casa
    private void removeAlbum(RecordHouse rh) { 
        Album a = chooseAlbum(rh);
        if (a != null) {
            rh.removeAlbum(a);
            System.out.println("Album rimosso.");
        }
    }

    // Permette di selezionare una casa discografica dalla lista
    private RecordHouse chooseRecordHouse() { 
        view.showList(recordHouses);
        if (recordHouses.isEmpty()) {
            System.out.println("Nessuna casa discografica disponibile.");
            return null;
        }
        int index = view.getInt("Scegli indice casa discografica: ");
        if (index >= 0 && index < recordHouses.size()) return recordHouses.get(index);
        System.out.println("Indice non valido.");
        return null;
    }

    // Permette di selezionare un artista da una casa
    private Artist chooseArtist(RecordHouse rh) { 
        view.showList(rh.getArtists());
        if (rh.getArtists().isEmpty()) {
            System.out.println("Nessun artista disponibile.");
            return null;
        }
        int index = view.getInt("Scegli indice artista: ");
        if (index >= 0 && index < rh.getArtists().size()) return rh.getArtists().get(index);
        System.out.println("Indice non valido.");
        return null;
    }

    // Permette di selezionare un album da una casa
    private Album chooseAlbum(RecordHouse rh) { 
        view.showList(rh.getAlbums());
        if (rh.getAlbums().isEmpty()) {
            System.out.println("Nessun album disponibile.");
            return null;
        }
        int index = view.getInt("Scegli indice album: ");
        if (index >= 0 && index < rh.getAlbums().size()) return rh.getAlbums().get(index);
        System.out.println("Indice non valido.");
        return null;
    }
}