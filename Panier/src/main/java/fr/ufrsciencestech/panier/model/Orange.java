package fr.ufrsciencestech.panier.model;

/**
 *
 * @author roudet
 */
public class Orange extends FruitSimple {

	
    public Orange() 
    {
        this.prix = 0.5;  //prix en euros
        this.origine="Espagne";
    }
    
    public Orange(double prix, String origine) 
    {
	if(prix < 0)
	    this.prix = -prix;  //une solution possible pour interdire les prix negatifs
	else
	    this.prix = prix;

	if(origine.equals(""))
            this.origine = "Espagne";  //Espagne par défaut
	else
            this.origine = origine;   
    }

    @Override
    public String toString() {
        return "Orange de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return true;
    }

}
