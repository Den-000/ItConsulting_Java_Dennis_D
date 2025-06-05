package model;

public class Student {
    private static int nextId = 1;

    private int id;
    private String name;
    private String lastName;
    private String classe;
    private String birthDate;       // Data d nascita in formato gg/MM/yyyy
    private String enrollmentDate;  // Data d'iscrizione in formato gg/MM/yyyy
    private int grade;

    // Costruttore con parametri
    public Student(String name, String lastName, String classe, String birthDate, String enrollmentDate, int grade) {
        this.id = nextId++;
        this.name = name;
        this.lastName = lastName;
        this.classe = classe;
        this.birthDate = birthDate;
        this.enrollmentDate = enrollmentDate;
        setGrade(grade);
    }

    // getter e setter
    public int getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getClasse() { return classe; }
    public String getBirthDate() { return birthDate; }
    public String getEnrollmentDate() { return enrollmentDate; }
    public int getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setClasse(String classe) { this.classe = classe; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setEnrollmentDate(String enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    // Imposta il voto controllando che sia tra 0 e 10
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 10) {
            this.grade = grade;
        } else {
            System.out.println("Errore: il voto deve essere compreso tra 0 e 10.");
        }
    }

    // Rappresentazione testuale dello studente
    @Override
    public String toString() {
        return "Studente #" + id 
             + " - Nome: " + name + " " + lastName 
             + ", Classe: " + classe 
             + ", Nascita: " + birthDate 
             + ", Iscrizione: " + enrollmentDate
             + ", Voto: " + grade;
    }
}