package controller;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Inizializzazione dei controller
        StudentController studentController = new StudentController(students);
        ProfessorController professorController = new ProfessorController(students);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Ciclo del menu principale
        while (running) {
            // Visualizzazione del menu
            System.out.println("""
                ===== MENU PRINCIPALE =====
                1. Gestione Studenti
                2. Gestione Professori
                0. Esci
                """);
            System.out.print("Scelta: ");
            String choice = scanner.nextLine();

            // Gestione delle scelte dell'utente
            switch (choice) {
                case "1" -> studentController.start(); // Avvia gestione studenti
                case "2" -> professorController.start(); // Avvia gestione professori
                case "0" -> {
                    running = false; // Uscita dal programma
                    System.out.println("\nArrivederci!");
                }
                default -> System.out.println("\nScelta non valida."); // Opzione non riconosciuta
            }
        }

        scanner.close(); // Chiusura dello scanner
    } 
}