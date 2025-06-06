package model;

import java.util.*;

// Classe base per tutti gli utenti dell'app (Chef, Critic, ecc.)
public class User {
    protected String name;
    protected String email;
    protected String password;
    protected float balance; // Bilancio fittizio (generato casualmente)

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        randomizeBalance();
    }

    // Genera un bilancio casuale compreso fra 0 e 100
    public void randomizeBalance() {
        this.balance = new Random().nextFloat() * 100;
    }

    // Getter
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public float getBalance() { return balance; }
}