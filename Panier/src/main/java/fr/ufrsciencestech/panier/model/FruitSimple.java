/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author cp326381
 */
public abstract class FruitSimple implements Fruit{
    protected double prix;
    protected String origine;
 
    
    public double getPrix(){
    return prix;
    }

    public void setPrix(double prix){
	this.prix=prix;
    }

    public String getOrigine(){
	return origine;
    }
 
    public void setOrigine(String origine){
	this.origine=origine;
    }

    @Override
    public abstract String toString();
    
    
    @Override
    public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (prix == fs.prix && origine.equals(fs.origine));
        }
        return false;
    }

    public abstract boolean isSeedless();
    //predicat indiquant qu'une orange a des pepins

}
