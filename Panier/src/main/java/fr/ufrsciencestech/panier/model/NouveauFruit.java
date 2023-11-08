package fr.ufrsciencestech.panier.model;

import fr.ufrsciencestech.panier.model.Fruit;

/**
 *
 * @author roudet
 */
public class NouveauFruit extends FruitSimple {

    private String nom;
	
    public NouveauFruit(String nom) 
    {
        this.nom = nom;
        if(nom == "" || nom == null)
            this.nom = "Fruit Inconnu";
        this.prix = 0.5;
        this.origine="Espagne";
    }
    
    public NouveauFruit(String nom, double prix, String origine) 
    {
        this.nom = nom;
        if(nom == "" || nom == null)
            this.nom = "Fruit Inconnu";
        
	if(prix < 0)
	    this.prix = -prix;
	else
	    this.prix = prix;

	if(origine.equals("") || origine == null)
            this.origine = "Italie";
	else
            this.origine = origine;   
    }
    
    @Override
    public String toString() {
        return nom+" de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
