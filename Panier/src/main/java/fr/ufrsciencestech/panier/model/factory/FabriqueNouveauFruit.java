/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.NouveauFruit;

/**
 *
 * @author va864097
 */
public class FabriqueNouveauFruit implements Fabrique {
    
    private String nom;
    
    public FabriqueNouveauFruit(String nom){
        this.nom = nom;
    }
    
    @Override
    public Fruit fabriquer(){
        return new NouveauFruit(nom);
    }
}