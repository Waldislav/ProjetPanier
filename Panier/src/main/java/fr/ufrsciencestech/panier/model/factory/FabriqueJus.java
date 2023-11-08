/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Jus;

/**
 * Fabrique de jus de fruits
 * @author va864097
 */
public class FabriqueJus implements Fabrique {
    
    private Fruit f;
    
    /**
     * Fabrique un jus de fruits
     * @param f le fruit créant le jus
     */
    public FabriqueJus(Fruit f){
        this.f=f;
    }
    
    /**
     * Fabrique un jus de fruits
     */
    @Override
    public Fruit fabriquer(){
        return new Jus(f);
    }
}