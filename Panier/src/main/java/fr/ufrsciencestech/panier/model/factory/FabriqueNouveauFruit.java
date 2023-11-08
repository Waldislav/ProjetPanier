/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.NouveauFruit;

/**
 * Fabrique de nouveaux fruits
 * @author va864097
 */
public class FabriqueNouveauFruit implements Fabrique {
    
    // Nom du nouveau fruit à fabriquer
    private String nom;
    
    /**
     * Fabrique un nouveau fruit
     * @param nom le nom du fruit
     */
    public FabriqueNouveauFruit(String nom){
        this.nom = nom;
    }
    
    /**
     * Fabrique un nouveau fruit à partir du nom
     */
    @Override
    public Fruit fabriquer(){
        return new NouveauFruit(nom);
    }
}