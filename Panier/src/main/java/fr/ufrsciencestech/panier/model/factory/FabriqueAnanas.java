/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Ananas;
import fr.ufrsciencestech.panier.model.Fruit;

/**
 * Fabrique d'ananas
 * @author va864097
 */
public class FabriqueAnanas implements Fabrique {
    
    /**
     * Fabrique un ananas
     */
    @Override
    public Fruit fabriquer(){
        return new Ananas();
    }
}