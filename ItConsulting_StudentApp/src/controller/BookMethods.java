package controller;

import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookMethods {
	
    // Lista di libri
    private List<Book> books = new ArrayList<>();

    // Aggiunge un libro alla lista
    public void addBook(String title, double price) {
        books.add(new Book(title, price));
    }

    // Restituisce la lista dei libri
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    // Rimuove un libro in base ad un codice
    public boolean removeBookByCode(int code) {
        return books.removeIf(b -> b.getCode() == code); //lambda per cercare per codice
    }
}