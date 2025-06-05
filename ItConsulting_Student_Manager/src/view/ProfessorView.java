package view;

import model.Professor;
import model.Student;

import java.util.List;

public class ProfessorView {

    // Mostra la lista di tutti i professori
    public void showAllProfessors(List<Professor> professors) {
        if (professors.isEmpty()) {
            System.out.println("Nessun professore presente.");
            return;
        }
        System.out.println("Lista professori:");
        for (Professor p : professors) {
            System.out.println(p);
        }
    }

    // Mostra i dettagli di un singolo professore con i suoi studenti
    public void showProfessor(Professor professor) {
        System.out.println(professor);
        showStudents(professor.getStudents());
    }

    // Mostra la lista degli studenti di un professore
    public void showStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Nessuno studente associato.");
        } else {
            System.out.println("Studenti associati:");
            for (Student s : students) {
                System.out.println(" * " + s);
            }
        }
    }

    // Mostra messaggi generici
    public void showMessage(String message) {
        System.out.println(message);
    }
}