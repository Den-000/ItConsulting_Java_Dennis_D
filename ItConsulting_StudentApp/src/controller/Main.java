package controller;

import java.time.LocalDate;

import view.BookView;
import view.StudentView;

public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
    	
        // Creazione delle istanze per la gestione di studenti e libri
        StudentMethods studentMethods = new StudentMethods();
        StudentView studentView = new StudentView();
        BookMethods bookMethods = new BookMethods();
        BookView bookView = new BookView();

        // Variabile per controllare il ciclo principale
        boolean running = true;

        // Ciclo principale del programma
        while (running) {
            // Menu principale, gestendo eventuali input errati
            System.out.println("\n**** MENU PRINCIPALE ****");
            System.out.println("1. Gestione studenti");
            System.out.println("2. Gestione libri");
            System.out.println("3. Esci");
            System.out.println("*************************");
            System.out.print("Scelta (1-3): ");

            int mainChoice;
            try {
                mainChoice = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Scelta non valida.");
                continue;
            }

            // Gestione delle scelte del menu principale
            switch (mainChoice) {
                case 1 -> {
                    // Gestione menu studenti
                    boolean back = false;
                    while (!back) {
                        int choice = studentView.viewMenu();
                        switch (choice) {
                            case 1 -> {
                                // Aggiunta di uno studente
                                String name = studentView.askName();
                                LocalDate bithDate = studentView.askDate("Data di nascita");
                                LocalDate registrationDate = studentView.askDate("Data di iscrizione");
                                String classAttended = studentView.askClass();
                                studentMethods.addStudent(name, bithDate, registrationDate, classAttended);
                                studentView.viewAddMessage(name);
                            }
                            case 2 -> {
                                // Visualizzazione lista studenti
                                studentView.viewStudentList(studentMethods.getSortedStudents());
                                studentView.viewCount(studentMethods.getStudentCount());
                            }
                            case 3 -> {
                                // Rimozione studente
                                String name = studentView.askNameToRemove();
                                boolean removed = studentMethods.removeStudent(name);
                                studentView.viewRemovedMessage(name, removed);
                            }
                            case 4 -> {
                                // Uscita dal menu studenti
                                studentView.viewExitMessage();
                                back = true;
                            }
                        }
                    }
                }

                case 2 -> {
                    // Gestione menu libri
                    boolean back = false;
                    while (!back) {
                        int choice = bookView.viewMenu();
                        switch (choice) {
                            case 1 -> {
                                // Aggiunta di un libro
                                String title = bookView.askTitle();
                                double price = bookView.askPrice();
                                bookMethods.addBook(title, price);
                                bookView.viewAddMessage(title);
                            }
                            case 2 -> 
                                // Visualizzazione lista libri
                                bookView.viewBookList(bookMethods.getBooks());
                            case 3 -> {
                                // Rimozione libro
                                int code = bookView.askCodeToRemove();
                                boolean removed = bookMethods.removeBookByCode(code);
                                bookView.viewRemovedMessage(code, removed);
                            }
                            case 4 -> {
                                // Uscita dal menu libri
                                bookView.viewExitMessage();
                                back = true;
                            }
                        }
                    }
                }

                case 3 -> {
                    // Uscita dal programma
                    System.out.println("Arrivederci!");
                    running = false;
                }

                default -> 
                    // Scelta non valida
                    System.out.println("Scelta non valida.");
            }
        }
    }
}