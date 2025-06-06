package model;

// Rappresenta una recensione su un piatto
public class Rating {
    private final String dishName;
    private final String criticName;
    private final String review;

    public Rating(String dishName, String criticName, String review) {
        this.dishName = dishName;
        this.criticName = criticName;
        this.review = review;
    }

    // Getter
    public String getDishName() { return dishName; }
    public String getCriticName() { return criticName; }
    public String getReview() { return review; }
}