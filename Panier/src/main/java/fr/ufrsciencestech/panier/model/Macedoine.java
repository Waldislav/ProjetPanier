package fr.ufrsciencestech.panier.model;

import java.util.ArrayList;

public class Macedoine implements Fruit {
    
    // Liste de fruits
    private ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    // Boolean pour savoir si la macédoine ne contient que des fruits sans pépins
    private boolean seedless;
    
    /**
     * Constructeur de la macédoine
     * @param fruit le fruit à ajouter à la macédoine
     */
    public Macedoine() {
        super();
    }
    
    /**
     * Ajoute un fruit à la macédoine
     * @param fruit le fruit à ajouter
     */
    public void ajouteFruit(Fruit fruit) {
        fruits.add(fruit);
        if (!fruit.isSeedless())
            seedless = false;
    }
    
    /**
     * @return true si la macédoine ne contient que des fruits sans pépins, false sinon
     */
    @Override
    public boolean isSeedless() {
        return seedless;
    }
    
    /**
     * @return le prix total de la macédoine
     */
     
    @Override
    public double getPrix() {
        double prix = 0;
        for (Fruit fruit : fruits) {
            prix += fruit.getPrix();
        }
        return prix;
    }
    
    /**
     * @return une chaîne de caractères contenant les informations affichées par la méthode toString() de chaque fruit
     */
    @Override
    public String getOrigine() {
        String s = "Origine des fruits : ";
        for (Fruit fruit : fruits) {
            s += fruit.getOrigine() + ", ";
        }
        return s;
    }
    
    /**
     * @return une chaîne de caractères contenant les informations affichées par la méthode toString() de chaque fruit
     */
    @Override
    public String toString() {
        String s = "Macedoine de fruits : ";
        for (Fruit fruit : fruits) {
            s += fruit.toString() + ", ";
        }
        return s;
    }
}
