package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.Fruit;

/**
 * Classe Ananas
 * @author gbeldilmi
 */
public class Ananas extends FruitSimple {

  public Ananas() {
    this(0.5, "");
}

public Ananas(double prix, String origine) {
    setPrix(prix);
    setOrigine(origine);
}

    @Override
    public String toString() {
        return "Ananas de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return true;
    }
}
