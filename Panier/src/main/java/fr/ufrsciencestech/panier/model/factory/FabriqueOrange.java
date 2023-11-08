/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Orange;

/**
 * Fabrique d'oranges
 * @author va864097
 */
public class FabriqueOrange implements Fabrique {

    /**
     * Fabrique une orange
     */
    @Override
    public Fruit fabriquer(){
        return new Orange();
    }
}