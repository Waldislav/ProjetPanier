/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author cp326381
 */
public abstract class fruitSimple implements Fruit{
    protected double prix;
    protected String origine;
 
    /**
     * Retourne le prix du fruit
     */
    public double getPrix(){
    return prix;
    }

    /**
     * Modifie le prix du fruit
     * @param prix le nouveau prix du fruit
     */
    public void setPrix(double prix){
	this.prix=prix;
    }

    /**
     * Retourne l'origine du fruit
     */
    public String getOrigine(){
	return origine;
    }
 
    /**
     * Modifie l'origine du fruit
     * @param origine la nouvelle origine du fruit
     */
    public void setOrigine(String origine){
	this.origine=origine;
    }

    /**
     * Retourne une chaine de caractères décrivant le fruit
     */
    @Override
    public abstract String toString();
    
    /**
     * Retourne vrai si les deux fruits sont equivalentes, faux sinon
     */
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (prix == fs.prix && origine.equals(fs.origine));
        }
        return false;
    }

    /**
     * Retourne vrai si le fruit n'a pas de pepins, faux sinon
     */
    public abstract boolean isSeedless();

}
