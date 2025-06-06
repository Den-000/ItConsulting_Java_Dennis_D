package service;

import model.*;
import java.util.*;
import java.util.regex.Pattern;

// Classe che gestisce la logica principale
public class AppService {
    private final Restaurant restaurant;
    private final Map<String, User> users = new HashMap<>();
    private User currentUser;

    // Costruttore che riceve l'istanza del ristorante
    public AppService(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Metodo per registrare un nuovo utente
    public boolean registerUser(String name, String email, String password) {
        if (!isValidEmail(email) || password.isEmpty()) return false; // Controlla formato email e password
        if (users.containsKey(email)) return false; // Email già registrata

        User user = new User(name, email, password); // Crea nuovo utente
        users.put(email, user);                      // Aggiunge alla mappa
        currentUser = user;                          // Imposta come utente loggato
        return true;
    }

    // Metodo per effettuare il login
    public boolean login(String email, String password) {
        if (currentUser != null) return false; // Già loggato
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false; // Credenziali errate
    }

    // Verifica se c'è un utente attualmente loggato
    public boolean isLoggedIn() {
        return currentUser != null;
    }

    // Restituisce l'utente attualmente loggato
    public User getCurrentUser() {
        return currentUser;
    }

    // Aggiunge un nuovo piatto al ristorante, se non esiste già
    public boolean addDish(String name) {
        if (restaurant.dishExists(name)) 
            return false; // Piatto già presente
        restaurant.addDish(new Dish(name, currentUser.getName())); // Aggiunge piatto con il nome dello chef corrente
        return true;
    }

    // Aggiunge una recensione a un piatto
    public void addRating(String dishName, String review) {
        restaurant.addRating(new Rating(dishName, currentUser.getName(), review));
    }

    // Restituisce la lista dei piatti
    public List<Dish> getDishes() {
        return restaurant.getDishes();
    }

    // Restituisce le recensioni associate a un determinato piatto
    public List<Rating> getRatingsForDish(String dishName) {
        return restaurant.getRatingsForDish(dishName);
    }

    // Restituisce la lista dei nomi degli Head Chef
    public List<String> getHeadChefs() {
        return restaurant.getHeadChefs();
    }

    // Verifica se l'email inserita ha un formato valido, tramite regex
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }
}