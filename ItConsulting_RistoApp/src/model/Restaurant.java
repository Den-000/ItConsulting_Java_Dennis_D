package model;

import java.util.*;
import java.util.stream.Collectors;

// Contiene la logica per la gestione dei piatti e delle recensioni
public class Restaurant {
    private final List<Dish> dishes = new ArrayList<>();
    private final List<Rating> ratings = new ArrayList<>();

    // Aggiunge un piatto
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    
    // Aggiunge una recensione
    public void addRating(Rating rating) {
        ratings.add(rating);
    }

    // Restituisce tutti i piatti
    public List<Dish> getDishes() {
        return new ArrayList<>(dishes);
    }
    
    // Restituisce tutte le recensioni
    public List<Rating> getRatings() {
        return new ArrayList<>(ratings);
    }

    // Verifica se un piatto esiste già (ignorando maiuscole)
    public boolean dishExists(String name) {
        return dishes.stream().anyMatch(d -> d.getName().equalsIgnoreCase(name));
    }

    // Restituisce tutte le recensioni relative a un piatto
    public List<Rating> getRatingsForDish(String dishName) {
        return ratings.stream()
                .filter(r -> r.getDishName().equalsIgnoreCase(dishName))
                .collect(Collectors.toList());
    }

    // Conta quante recensioni ha ogni piatto
    public Map<String, Long> getDishReviewCounts() {
        return ratings.stream().collect(
            Collectors.groupingBy(Rating::getDishName, Collectors.counting())
        );
    }

    // Restituisce i nomi degli Head Chef (coloro che hanno pubblicato 3 più piatti)
    public List<String> getHeadChefs() {
        Map<String, Long> dishCounts = dishes.stream()
            .collect(Collectors.groupingBy(Dish::getChefName, Collectors.counting()));
        return dishCounts.entrySet().stream()
            .filter(e -> e.getValue() >= 3)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}