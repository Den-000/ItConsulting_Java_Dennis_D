package controller;

public class Main {
    public static void main(String[] args) {
        new AppController().run();
    }
}

/*Togliere la possibilità di mettere recensioni vuote
 * Upgradare tutto il sistema di recensioni (es. like e dislike, risposta alle recensioni, segnalazioni, ecc.)
 * Inserire Output per segnalare l'upgradea Grand Chef e/o Grand Critic
 * Modificare la registrazione con username al posto del nome
 * Richiedere dati anagrafici per upgrade a Grand Chef e/o Grand Critic
 * Inserire controller e view (più in generale sezioni) dedicate a Grand Chef e/o Grand Critic (renderli entità)
 * Ampliare le funzionalità CRUD e rendere l'app fruibile anche da parte degl'admin
 * Da valutare la ripartizione dei metodi contenuti in Restaurant
 * Da valutare una migliore suddivisione delle varie view e dei vari CRUD
 */