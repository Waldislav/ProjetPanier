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

    // groupe 1
    public Panier(int contenanceMax) { // initialise un panier vide ayant une certaine contenance maximale (precisee en
                                       // parametre)
        this.fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
        pcs = new PropertyChangeSupport(this);
        
        typesFruit = new ArrayList<String>();
        
        
    }
    
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
    
    public ArrayList<String> getTypesFruits(){
        return this.typesFruit;
    }
    
    public void ajoutTypeFruit(String type){
        
        ArrayList<String> old = (ArrayList<String>) typesFruit.clone();
        typesFruit.add(type);
        pcs.firePropertyChange("value", old, this.typesFruit);
    }

    @Override
    public String toString() { // affichage de ce qui est contenu dans le panier : liste des fruits presents
        String res = "";
        String newLine = System.getProperty("line.separator");
        for (int i = 0; i < fruits.size(); i++) {
            res += fruits.get(i).toString() + newLine;
        }
        return res;
    }
    
    public void addObserver(PropertyChangeListener l) {
	pcs.addPropertyChangeListener("value", l);
    }

    // groupe 2
    public ArrayList<Fruit> getFruits() { // accesseur du premier attribut
        return this.fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { // modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier() { // accesseur retournant la taille allouee pour l'attibut fruits
        return this.fruits.size();
    }

    public int getContenanceMax() { // accesseur du second attribut
        return this.contenanceMax;
    }

    // groupe 3
    public Fruit getFruit(int i) { // accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou
        return fruits.get(i);                           // null s'il n'y a rien a cet emplacement
    }
    
    public void ajout() throws PanierPleinException { // ajoute le fruit o a la fin du panier si celui-ci n'est
                                                             // pas plein
        ArrayList<Fruit> old = (ArrayList<Fruit>) this.fruits.clone();
        Orange o = new Orange();
        if (fruits.size() < contenanceMax) {
            fruits.add(o);
            pcs.firePropertyChange("value", old, this.fruits);
        }
        else
            throw new PanierPleinException();

    }

    // groupe 4
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

    public void setFruit(int i, Fruit f) { // modificateur du fruit contenu dans le panier a l'emplacement n°i par f
                                           // (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        if (i < fruits.size()) {
            if (fruits.get(i) instanceof Fruit) {
                fruits.set(i, f);
            }
        }    
    }

    public boolean estVide() { // predicat indiquant que le panier est vide
        return fruits.size() == 0;
    }

    public boolean estPlein() { // predicat indiquant que le panier est plein
        return fruits.size() == contenanceMax;
    }

    // groupe 5
    public void retrait() throws PanierVideException { // retire le dernier fruit du panier si celui-ci n'est pas vide
        ArrayList<Fruit> old = (ArrayList<Fruit>) this.fruits.clone();

        if(!this.estVide()) {
            fruits.remove(fruits.size()-1);
            pcs.firePropertyChange("value", old, this.fruits);
        }
        else 
            throw new PanierVideException();
    }

    // groupe 6
    public double getPrix() { // calcule le prix du panier par addition des prix de tous les fruits contenus
                              // dedans
        double prix = 0;
        for (int i = 0; i < fruits.size(); i++) {
            prix += fruits.get(i).getPrix();
        }
        return prix;
    }

    // groupe 7
    public void boycotteOrigine(String origine) { // supprime du panier tous les fruits provenant du pays origine
        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).getOrigine().toUpperCase().equals(origine.toUpperCase())) {
                fruits.remove(i);
                i--;
            }
            
        }
    }

    // groupe 8
    @Override
    public boolean equals(Object o) { /// predicat pour tester si 2 paniers sont equivalents : s'ils contiennent
                                      /// exactement les memes fruits
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
