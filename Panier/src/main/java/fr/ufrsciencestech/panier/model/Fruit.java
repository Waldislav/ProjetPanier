package fr.ufrsciencestech.panier.model;
/**
 * Interface Fruit
 * @author roudet
 */
public interface Fruit {
    
    /**
     * Retourne si le fruit a des pepins ou non
     * @return true si le fruit a des pepins, false sinon
     */
    public boolean isSeedless();  

    /**
     * Retourne le prix du fruit
     * @return le prix du fruit
     */
    public double getPrix();      

    /**
     * Retourne le pâys d'origine du fruit
     * @return le pays d'origine du fruit
     */
    public String getOrigine();   

    /**
     * Predicat pour tester si 2 fruits sont equivalents
     * @param o objet à comparer avec le fruit courant
     * @return true si les 2 fruits sont equivalents, false sinon
     */
    @Override
    public boolean equals(Object o);  

    /**
     * Retourne une chaine de caractères décrivant le fruit
     * @return une chaine de caractères décrivant le fruit
     */
    @Override
    public String toString();    
}
