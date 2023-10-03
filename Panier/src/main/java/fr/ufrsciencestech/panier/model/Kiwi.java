/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author cp326381
 */
public class Kiwi extends FruitSimple implements Fruit{
    
    public Kiwi() {
        this.prix = 1;
        this.origine = "Nouvelle-Zélande";
    }
    
    public Kiwi(double prix, String origine) {
        this.prix = 0;
        if (prix > this.prix) {this.prix = prix;}
        this.origine = origine;
    }
    
    @Override
    public String toString() {
        return "Kiwi de " + origine + " à " + prix + " euros";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
