package controller;

import java.time.LocalDate;
import java.util.*;
import model.Student;

// Classe che gestisce le operazioni logiche sugli studenti
public class StudentMethods {
	
    // Lista degli studenti gestiti
    private List<Student> students = new ArrayList<>();

    // Aggiunge un nuovo studente alla lista
    public void addStudent(String name, LocalDate BirthDate, LocalDate RegistrationDate, String ClassAttended) {
        students.add(new Student(name, BirthDate, RegistrationDate, ClassAttended));
    }

    // Restituisce una lista ordinata alfabeticamente per nome
    public List<Student> getSortedStudents() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(Student::getName)); // Riordina la lista comparando i nomi, method reference a getName
        return sorted;
    }

    // Restituisce il numero totale di studenti presenti
    public int getStudentCount() {
        return students.size();
    }

    // Rimuove uno studente dalla lista cercandolo per nome (ignorando maiuscole/minuscole)
    public boolean removeStudent(String name) {
        return students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }
}