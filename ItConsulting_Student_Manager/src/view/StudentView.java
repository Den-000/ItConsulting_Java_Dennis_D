package view;

import model.Student;

import java.util.List;

public class StudentView {

    // Mostra tutti gli studenti nella lista
    public void showAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Nessuno studente presente.");
            return;
        }
        System.out.println("Lista studenti:");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Mostra i dettagli di un singolo studente
    public void showStudent(Student student) {
        System.out.println(student);
    }

    // Mostra messaggi generici
    public void showMessage(String message) {
        System.out.println(message);
    }
}