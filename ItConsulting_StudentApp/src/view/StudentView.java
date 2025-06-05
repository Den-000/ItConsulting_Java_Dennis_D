package view;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import model.Student;

public class StudentView {
	
    private final Scanner scanner = new Scanner(System.in);

    // Mostra il menu principale per la gestione degli studenti e restituisce la scelta dell'utente, gestendo eventuali input non validi
    public int viewMenu() {
        while (true) {
            System.out.println("\n**** MENU STUDENTI ****");
            System.out.println("1. Aggiungi studente");
            System.out.println("2. Mostra studenti");
            System.out.println("3. Rimuovi studente");
            System.out.println("4. Torna al menù principale");
            System.out.print("Scelta (1-4): ");
            System.out.println("**********************");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) return choice;
            } catch (NumberFormatException ignored) {}
            System.out.println("Scelta non valida.");
        }
    }

    // Chiede all'utente il nome dello studente
    public String askName() {
        System.out.print("Inserisci il nome dello studente: ");
        return scanner.nextLine().trim();
    }

    // Chiede una data (nascita o iscrizione) e la valida
    public LocalDate askDate(String prompt) {
        while (true) {
            System.out.print(prompt + " (AAAA-MM-GG): ");
            try {
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido.");
            }
        }
    }

    // Chiede la classe frequentata dallo studente
    public String askClass() {
        System.out.print("Inserisci la classe frequentata (es. 4A): ");
        return scanner.nextLine().trim();
    }

    // Chiede il nome dello studente da rimuovere
    public String askNameToRemove() {
        System.out.print("Inserisci il nome dello studente da rimuovere: ");
        return scanner.nextLine().trim();
    }

    // Mostra la lista degli studenti
    public void viewStudentList(List<Student> students) {
        System.out.println("\n--- Elenco studenti ---");
        if (students.isEmpty()) {
            System.out.println("Nessuno studente presente.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Mostra il numero totale di studenti
    public void viewCount(int total) {
        System.out.println("Totale studenti: " + total);
    }

    // Mostra un messaggio dopo il tentativo di rimozione di uno studente
    public void viewRemovedMessage(String name, boolean removed) {
        if (removed) {
            System.out.println("Studente '" + name + "' rimosso.");
        } else {
            System.out.println("Studente '" + name + "' non trovato.");
        }
    }

    // Mostra un messaggio dopo l'aggiunta di uno studente
    public void viewAddMessage(String name) {
        System.out.println("Studente '" + name + "' aggiunto.");
    }

    // Mostra un messaggio di uscita dal sotto-menu
    public void viewExitMessage() {
        System.out.println("Tornando al menù principale...");
    }
}