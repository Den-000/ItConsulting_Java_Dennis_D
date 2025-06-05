package controller;

import model.Professor;
import model.Student;
import view.ProfessorView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorController {
    private final List<Professor> professors = new ArrayList<>();
    private final List<Student> students;
    private final ProfessorView view = new ProfessorView();
    private final Scanner scanner = new Scanner(System.in);

    // Costruttore che riceve la lista studenti per l'associazione
    public ProfessorController(List<Student> students) {
        this.students = students;
    }

    // Menu e gestione input per professori
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                ===== MENU PROFESSORI =====
                1. Aggiungi Professore
                2. Mostra tutti i professori
                3. Aggiorna Professore
                4. Rimuovi Professore
                5. Cerca Professore per ID
                6. Aggiungi Studente a Professore
                7. Rimuovi Studente da Professore
                0. Torna al menu principale
                """);
            System.out.print("\nScelta: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addProfessor();
                case "2" -> view.showAllProfessors(professors);
                case "3" -> updateProfessor();
                case "4" -> removeProfessor();
                case "5" -> searchProfessorById();
                case "6" -> addStudentToProfessor();
                case "7" -> removeStudentFromProfessor();
                case "0" -> running = false;
                default -> view.showMessage("\nScelta non valida.");
            }
        }
    }

    // Aggiunge un nuovo professore
    private void addProfessor() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Cognome: ");
        String lastName = scanner.nextLine();
        System.out.print("Materia: ");
        String subject = scanner.nextLine();
        Professor professor = new Professor(name, lastName, subject);
        professors.add(professor);
        view.showMessage("\nProfessore aggiunto con successo.");
    }

    // Aggiorna dati di un professore esistente, gestendo eventuali errori
    private void updateProfessor() {
        System.out.print("Inserisci l'ID del professore da aggiornare: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID non valido.");
            return;
        }
        Professor professor = findProfessorById(id);
        if (professor == null) {
            view.showMessage("\nProfessore non trovato.");
            return;
        }
        System.out.println("Premi invio per saltare un campo.");
        System.out.print("Nuovo nome (" + professor.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            professor.setName(name);
        }
        System.out.print("Nuovo cognome (" + professor.getLastName() + "): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) {
            professor.setLastName(lastName);
        }
        System.out.print("Nuova materia (" + professor.getSubject() + "): ");
        String subject = scanner.nextLine();
        if (!subject.isEmpty()) {
            professor.setSubject(subject);
        }
        view.showMessage("\nProfessore aggiornato.");
    }

    // Rimuove un professore, gestendo eventuali errori
    private void removeProfessor() {
        System.out.print("Inserisci l'ID del professore da rimuovere: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID non valido.");
            return;
        }
        Professor professor = findProfessorById(id);
        if (professor != null) {
            professors.remove(professor);
            view.showMessage("\nProfessore rimosso.");
        } else {
            view.showMessage("\nProfessore non trovato.");
        }
    }

    // Cerca un professore tramite ID, gestendo eventuali errori
    private void searchProfessorById() {
        System.out.print("Inserisci l'ID del professore da cercare: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID non valido.");
            return;
        }
        Professor professor = findProfessorById(id);
        if (professor != null) {
            view.showProfessor(professor);
        } else {
            view.showMessage("\nProfessore non trovato.");
        }
    }

    // Associa uno studente a un professore, gestendo eventuali errori
    private void addStudentToProfessor() {
        System.out.print("Inserisci l'ID del professore: ");
        int profId;
        try {
            profId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID professore non valido.");
            return;
        }
        Professor professor = findProfessorById(profId);
        if (professor == null) {
            view.showMessage("\nProfessore non trovato.");
            return;
        }
        System.out.print("Inserisci l'ID dello studente da aggiungere: ");
        int studId;
        try {
            studId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID studente non valido.");
            return;
        }
        Student student = findStudentById(studId);
        if (student == null) {
            view.showMessage("\nStudente non trovato.");
            return;
        }
        professor.addStudent(student);
        view.showMessage("\nStudente aggiunto al professore.");
    }

    // Rimuove uno studente da un professore, gestendo eventuali errori
    private void removeStudentFromProfessor() {
        System.out.print("\nInserisci l'ID del professore: ");
        int profId;
        try {
            profId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID professore non valido.");
            return;
        }
        Professor professor = findProfessorById(profId);
        if (professor == null) {
            view.showMessage("\nProfessore non trovato.");
            return;
        }
        System.out.print("Inserisci l'ID dello studente da rimuovere: ");
        int studId;
        try {
            studId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID studente non valido.");
            return;
        }
        Student student = findStudentById(studId);
        if (student == null) {
            view.showMessage("\nStudente non trovato.");
            return;
        }
        professor.removeStudent(student);
        view.showMessage("\nStudente rimosso dal professore.");
    }

    // Metodo ausiliario per trovare un professore tramite ID
    private Professor findProfessorById(int id) {
        for (Professor p : professors) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // Metodo ausiliario per trovare uno studente tramite ID
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}