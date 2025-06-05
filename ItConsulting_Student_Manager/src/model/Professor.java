package model;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private static int nextId = 1;

    private int id;
    private String name;
    private String lastName;
    private String subject;
    private final List<Student> students = new ArrayList<>();

    // Costruttore
    public Professor(String name, String lastName, String subject) {
        this.id = nextId++;
        this.name = name;
        this.lastName = lastName;
        this.subject = subject;
    }

    // Getter e setter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getSubject() { return subject; }
    public List<Student> getStudents() { return students; }

    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setSubject(String subject) { this.subject = subject; }

    // Aggiunge uno studente alla lista, se non è già presente
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Rimuove uno studente dalla lista
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Rappresentazione testuale del professore
    @Override
    public String toString() {
        return "Professore #" + id 
             + " - Nome: " + name + " " + lastName 
             + ", Materia: " + subject
             + ", Numero studenti: " + students.size();
    }
}