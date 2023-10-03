package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.Fruit;

/**
 *
 * @author roudet
 */
public class Cerise extends FruitSimple {

	
    public Cerise() 
    {
        this.prix = 0.6;  //prix en euros
        this.origine="Italie";
    }
    
    public Cerise(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals("") || origine == null)
            this.origine = "Italie";  //Espagne par défaut
	else
            this.origine = origine;   
    }
    
    @Override
    public String toString() {
        return "Cerise de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
