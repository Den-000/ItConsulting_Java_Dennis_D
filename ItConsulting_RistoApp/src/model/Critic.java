package model;

// Estende User, rappresenta un critico
public class Critic extends User {
    private int reviewCount = 0;

    public Critic(String name, String email, String password) {
        super(name, email, password);
    }

    // Incrementa il contatore di recensioni scritte
    public void incrementReviewCount() {
        reviewCount++;
    }

    // Un critico è Top Critic se ha scritto almeno 3 recensioni
    public boolean isTopCritic() {
        return reviewCount >= 3;
    }

    // Getter
    public int getReviewCount() {
        return reviewCount;
    }
}