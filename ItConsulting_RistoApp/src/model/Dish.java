package model;

// Rappresenta un piatto pubblicato da uno chef
public class Dish {
    private final String name;
    private final String chefName;

    public Dish(String name, String chefName) {
        this.name = name;
        this.chefName = chefName;
    }

    // Getter
    public String getName() { return name; }
    public String getChefName() { return chefName; }
}