package fr.ufrsciencestech.panier.model;

/**
 * Fabrique de fruits
 */
public class FruitFactory {
    
    /**
     * Crée un fruit en fonction du type rentré
     * @param fruit le nom du fruit à créer
     * @return le fruit créé
     */
    public static Fruit createFruit(String fruit) {
        switch (fruit) {
            case "Ananas":
                return new Ananas();
            case "Banane":
                return new Banane();
            case "Cerise":
                return new Cerise();
            case "Kiwi":
                return new Kiwi();
            case "Orange":
                return new Orange();
            default:
                return null;
        }
    }
    
    /**
     * Crée un fruit en fonction du type rentré avec son prix et son origine
     * @param fruit le nom du fruit à créer
     * @param prix le prix du fruit
     * @param origine l'origine du fruit
     * @return le fruit créé
     */
    public static Fruit createFruit(String fruit, double prix, String origine) {
    switch (fruit) {
        case "Ananas":
            return new Ananas(prix, origine);
        case "Banane":
            return new Banane(prix, origine);
        case "Cerise":
            return new Cerise(prix, origine);
        case "Kiwi":
            return new Kiwi(prix, origine);
        case "Orange":
            return new Orange(prix, origine);
        default:
            return null;
        }
    }
    
    
}

