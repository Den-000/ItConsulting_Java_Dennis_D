package model;

//Estende User, rappresenta uno chef
public class Chef extends User {
    private int dishCount = 0;

    public Chef(String name, String email, String password) {
        super(name, email, password);
    }

    // Incrementa il contatore di piatti aggiunti
    public void incrementDishCount() {
        dishCount++;
    }

    // Uno Chef è Head Chef se ha aggiunto almeno 3 piatti
    public boolean isHeadChef() {
        return dishCount >= 3;
    }

    // Getter
    public int getDishCount() {
        return dishCount;
    }
}