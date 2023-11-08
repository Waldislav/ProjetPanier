/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Jus;

/**
 *
 * @author va864097
 */
public class FabriqueJus implements Fabrique {
    
    private Fruit f;
    
    public FabriqueJus(Fruit f){
        this.f=f;
    }
    
    @Override
    public Fruit fabriquer(){
        return new Jus(f);
    }
}