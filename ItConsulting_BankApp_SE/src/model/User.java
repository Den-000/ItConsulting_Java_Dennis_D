package model;

public class User {
	
    // Attributi dell'utente: email e password
    private String email;
    private String password;

    // Costruttore: inizializza con email e password
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Restituisce l'email
    public String getEmail() {
        return email;
    }

    // Verifica se la password fornita corrisponde a quella memorizzata
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Restituisce la password
    public String getPassword() {
        return password;
    }

    // Imposta una nuova password
    public void setPassword(String password) {
        this.password = password;
    }

    // Imposta una nuova email
    public void setEmail(String email) {
        this.email = email;
    }
}