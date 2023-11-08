package fr.ufrsciencestech.panier.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

/**
 *
 * @author roudet
 */
public class Panier{
    private ArrayList<Fruit> fruits; // attribut pour stocker les fruits
    private int contenanceMax; // nb maximum d'oranges que peut contenir le panier
    private ArrayList<String> typesFruit;
    PropertyChangeSupport pcs;

    /**
     * Constructeur par defaut (sans parametre) definissant une contenance max
     * @param contenanceMax la contenance maximale du panier
     */
    public Panier(int contenanceMax) { // initialise un panier vide ayant une certaine contenance maximale (precisee en
                                       // parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
        pcs = new PropertyChangeSupport(this);
        
        typesFruit = new ArrayList<String>();
        
        
    }
    
    /**
     * Initialise la liste des types de fruits
     */
    public void initListe(){
        this.ajoutTypeFruit("Orange");
        this.ajoutTypeFruit("Cerise");
        this.ajoutTypeFruit("Banane");
        this.ajoutTypeFruit("Ananas");
        this.ajoutTypeFruit("Kiwi");
        this.ajoutTypeFruit("Macédoine des Iles");
        this.ajoutTypeFruit("Macédoine de Fruits Rouges");
        this.ajoutTypeFruit("Macédoine de tout les fruits");
    }
    
    /**
     * Retourne la liste des types de fruits
     * @return la liste des types de fruits
     */
    public ArrayList<String> getTypesFruits(){
        return this.typesFruit;
    }
    
    /**
     * Ajoute un type de fruit à la liste
     * @param type le type de fruit à ajouter
     */
    public void ajoutTypeFruit(String type){
        
        ArrayList<String> old = (ArrayList<String>) typesFruit.clone();
        typesFruit.add(type);
        pcs.firePropertyChange("value", old, this.typesFruit);
    }

    /**
     * Retourne une chaine de caracteres composée de la liste des fruits presents dans le panier
     */
    @Override
    public String toString() { // affichage de ce qui est contenu dans le panier : liste des fruits presents
        String res = "";
        String newLine = System.getProperty("line.separator");
        for (int i = 0; i < fruits.size(); i++) {
            res += fruits.get(i).toString() + newLine;
        }
        return res;
    }
    
    /**
     * Ajoute un observateur à la liste
     * @param l Observateur à ajouter
     */
    public void addObserver(PropertyChangeListener l) {
	pcs.addPropertyChangeListener("value", l);
    }

    /**
     * Retire un observateur de la liste
     * @return Observateur à retirer
     */
    public ArrayList<Fruit> getFruits() { // accesseur du premier attribut
        return this.fruits;
    }

    /**
     * Modifie la liste des fruits
     * @param fruits Nouvelle liste de fruits
     */
    public void setFruits(ArrayList<Fruit> fruits) { // modificateur du premier attribut
        this.fruits = fruits;
    }

    /**
     * Retourne la taille du panier
     * @return la taille du panier
     */
    public int getTaillePanier() { // accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    /**
     * Retourne la contenance maximale du panier
     * @return la contenance maximale du panier
     */
    public int getContenanceMax() { // accesseur du second attribut
        return this.contenanceMax;
    }

    /**
     * Renvoie un fruit à l'indice i
     * @param i  indice du fruit à renvoyer
     * @return le fruit à l'indice i
     */
    // groupe 3
    public Fruit getFruit(int i) { 
        return fruits.get(i);                           
    }
    
    /**
     * Ajoute une orange au panier
     * @throws PanierPleinException si le panier est plein
     */
    public void ajout() throws PanierPleinException { 
                                                             
        ArrayList<Fruit> old = (ArrayList<Fruit>) this.fruits.clone();
        Orange o = new Orange();
        if (fruits.size() < contenanceMax) {
            fruits.add(o);
            pcs.firePropertyChange("value", old, this.fruits);
        }
        else
            throw new PanierPleinException();

    }

    /**
     * Ajoute un fruit au panier
     * @param o Fruit à ajouter
     * @throws PanierPleinException si le panier est plein
     */
    public void ajout(Fruit o) throws PanierPleinException { // ajoute le fruit o a la fin du panier si celui-ci n'est
                                                             // pas plein
        ArrayList<Fruit> old = (ArrayList<Fruit>) this.fruits.clone();
        if (!estPlein()) {
            fruits.add(o);
            pcs.firePropertyChange("value", old, this.fruits);
        }
        else
            throw new PanierPleinException();

    }

    /**
     * Modifier le fruit à l'indice i
     * @param i indice du fruit à modifier
     * @param f Nouveau fruit
     */
    public void setFruit(int i, Fruit f) { 
                                           
        if (i < fruits.size()) {
            if (fruits.get(i) instanceof Fruit) {
                fruits.set(i, f);
            }
        }    
    }

    /**
     * Renvoie si le panier est vide
     * @return true si le panier est vide, false sinon
     */
    public boolean estVide() { 
        return fruits.size() == 0;
    }

    /**
     * Renvoie si le panier est plein
     * @return  true si le panier est plein, false sinon
     */
    public boolean estPlein() { 
        return fruits.size() == contenanceMax;
    }

    /**
     * Retire le dernier fruit du panier
     * @throws PanierVideException si le panier est vide
     */
    public void retrait() throws PanierVideException { 
        ArrayList<Fruit> old = (ArrayList<Fruit>) this.fruits.clone();

        if(!this.estVide()) {
            fruits.remove(fruits.size()-1);
            pcs.firePropertyChange("value", old, this.fruits);
        }
        else 
            throw new PanierVideException();
    }

    /**
     * Calcule le prix total du panier en additionnant le prix de chaque fruit
     * @return le prix total du panier
     */
    public double getPrix() { 
                              
        double prix = 0;
        for (int i = 0; i < fruits.size(); i++) {
            prix += fruits.get(i).getPrix();
        }
        return prix;
    }

    /**
     * Supprime du panier les fruits provenant du pays origine
     * @param origine Pays d'origine des fruits à supprimer
     */
    public void boycotteOrigine(String origine) {
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getOrigine().toUpperCase().equals(origine.toUpperCase())) {
                fruits.remove(i);
                i--;
            }
            
        }
    }

    /**
     * Prédicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
     * @param o Panier à comparer
     */
    @Override
    public boolean equals(Object o) {            
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Panier panier = (Panier) o;

        if (contenanceMax != panier.contenanceMax)
            return false;
        return fruits != null ? fruits.equals(panier.fruits) : panier.fruits == null;
    }

    // tests
    public static void main(String[] args) {
        // Ecrire ici vos tests
        System.out.println("premier test Panier");
        Panier P = new Panier(10);
        System.out.println(P.toString());

        Banane banane = new Banane();
        Banane bananeParams = new Banane(158, "Danemark");
        Banane bananeNegatif = new Banane(-3, "Allemagne");

        System.out.println("Banane avec le const vide: " + banane);
        System.out.println("Banane avec les param initialisé: " + bananeParams);
        // test de Panier.equals(Object)
        Panier p1 = new Panier(3); // exemple de panier (ananas, orange, <vide>)
        Panier p2 = new Panier(3); // panier identique au premier
        Panier p3 = new Panier(3); // panier différent du premier (mais premier fruit identique)
        Panier p4 = new Panier(3); // panier différent du premier (mais seul les deux premiers fruits sont
                                   // identiques)
        Fruit f1 = (Fruit) new Ananas(3.56, "");
        Fruit f2 = (Fruit) new Orange(0.5, "France");
        try {
            p1.ajout(f1);
            p1.ajout(f2);
            p2.ajout(f1);
            p2.ajout(f2);
            p3.ajout(f1);
            p3.ajout(new Orange(0.5, "Espagne"));
            p4.ajout(f1);
            p4.ajout(f2);
            p4.ajout(new Orange(0.75, "Costa Rica"));
            if (p1.equals(p2) && !p1.equals(p3) && !p1.equals(p4) && !p3.equals(p4)) {
                System.out.println("Test Panier.equals(Object) : OK");
            } else {
                System.out.println("Test Panier.equals(Object) : NOK");
            }
        } catch (PanierPleinException e) {
            System.out.println("Test Panier.equals(Object) : NOK");
        }

        System.out.println("premier test Panier");
        P = new Panier(10);
        System.out.println(P.toString());

        System.out.println("Test ajout panier");
        try {
            for (int i = 0; i < 10; i++)
                P.ajout(new Orange());
            System.out.println("Ajout bien réalisé\n");
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }

        System.out.println("Test ajout panier");
        try {
            for (int i = 0; i < 10; i++)
                P.ajout(new Orange());
            System.out.println("Ajout bien réalisé\n");
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }
        System.out.println("Banane avec le prix negatif: " + bananeNegatif);

    }
}
