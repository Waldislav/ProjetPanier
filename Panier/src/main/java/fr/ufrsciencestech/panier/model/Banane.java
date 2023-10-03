package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.Fruit;

/**
 *

 * @author roudet

 */
public class Banane extends FruitSimple {


    public Banane() {
        this.prix = 0.5; // prix en euros
        this.origine = "Espagne";
    }

    public Banane(double prix, String origine) {
        if (prix < 0)
            this.prix = -prix; // une solution possible pour interdire les prix negatifs
        else
            this.prix = prix;

        if (origine.equals(""))
            this.origine = "Espagne"; // Espagne par défaut
        else
            this.origine = origine;
    }

    @Override
    public String toString() {
        return "Banane de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return true;
    }


}

 