package controller;

import model.Student;
import view.StudentView;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final List<Student> students;
    private final StudentView view = new StudentView();
    private final Scanner scanner = new Scanner(System.in);

    public StudentController(List<Student> students) {
        this.students = students;
    }

    // Metodo principale per mostrare il menu e gestire le azioni
    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                ===== MENU STUDENTI =====
                1. Aggiungi Studente
                2. Mostra tutti gli studenti
                3. Aggiorna Studente
                4. Rimuovi Studente
                5. Cerca Studente per ID
                0. Torna al menu principale
                """);
            System.out.print("Scelta: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addStudent();
                case "2" -> view.showAllStudents(students);
                case "3" -> updateStudent();
                case "4" -> removeStudent();
                case "5" -> searchStudentById();
                case "0" -> running = false;
                default -> view.showMessage("Scelta non valida.");
            }
        }
    }

    // Aggiunge un nuovo studente, gestendo eventuali errori
    private void addStudent() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Cognome: ");
        String lastName = scanner.nextLine();
        System.out.print("Classe: ");
        String classe = scanner.nextLine();
        System.out.print("Data di nascita (gg/MM/yyyy): ");
        String birthDate = scanner.nextLine();
        System.out.print("Data di iscrizione (gg/MM/yyyy): ");
        String enrollmentDate = scanner.nextLine();
        System.out.print("Voto (0-10): ");
        int grade;
        try {
            grade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("Voto non valido.");
            return;
        }
        Student student = new Student(name, lastName, classe, birthDate, enrollmentDate, grade);
        students.add(student);
        view.showMessage("\nStudente aggiunto.");
    }

    // Aggiorna uno studente esistente, gestendo eventuali errori
    private void updateStudent() {
        System.out.print("\nInserisci l'ID dello studente da aggiornare: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID non valido.");
            return;
        }
        Student student = findStudentById(id);
        if (student == null) {
            view.showMessage("\nStudente non trovato.");
            return;
        }
        System.out.println("Premi invio per saltare un campo.");
        System.out.print("Nuovo nome (" + student.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) student.setName(name);

        System.out.print("Nuovo cognome (" + student.getLastName() + "): ");
        String lastName = scanner.nextLine();
        if (!lastName.isEmpty()) student.setLastName(lastName);

        System.out.print("Nuova classe (" + student.getClasse() + "): ");
        String classe = scanner.nextLine();
        if (!classe.isEmpty()) student.setClasse(classe);

        System.out.print("Nuova data di nascita (" + student.getBirthDate() + "): ");
        String birthDate = scanner.nextLine();
        if (!birthDate.isEmpty()) student.setBirthDate(birthDate);

        System.out.print("Nuova data di iscrizione (" + student.getEnrollmentDate() + "): ");
        String enrollmentDate = scanner.nextLine();
        if (!enrollmentDate.isEmpty()) student.setEnrollmentDate(enrollmentDate);

        System.out.print("Nuovo voto (" + student.getGrade() + "): ");
        String gradeStr = scanner.nextLine();
        if (!gradeStr.isEmpty()) {
            try {
                int grade = Integer.parseInt(gradeStr);
                student.setGrade(grade);
            } catch (NumberFormatException e) {
                view.showMessage("Voto non valido, non aggiornato.");
            }
        }
        view.showMessage("\nStudente aggiornato.");
    }

    // Rimuove uno studente, gestendo eventuali errori
    private void removeStudent() {
        System.out.print("Inserisci l'ID dello studente da rimuovere: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("ID non valido.");
            return;
        }
        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            view.showMessage("\nStudente rimosso.");
        } else {
            view.showMessage("\nStudente non trovato.");
        }
    }

    // Cerca uno studente tramite ID, gestendo eventuali errori
    private void searchStudentById() {
        System.out.print("Inserisci l'ID dello studente da cercare: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            view.showMessage("\nID non valido.");
            return;
        }
        Student student = findStudentById(id);
        if (student != null) {
            view.showStudent(student);
        } else {
            view.showMessage("\nStudente non trovato.");
        }
    }

    // Metodo ausiliario per trovare uno studente tramite ID
    private Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }
}