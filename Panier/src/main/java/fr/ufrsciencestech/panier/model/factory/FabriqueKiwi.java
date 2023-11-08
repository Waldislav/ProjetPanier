/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.Kiwi;

/**
 * Fabrique de kiwis
 * @author va864097
 */
public class FabriqueKiwi implements Fabrique {

    /**
     * Fabrique un kiwi
     */
    @Override
    public Fruit fabriquer(){
        return new Kiwi();
    }
}