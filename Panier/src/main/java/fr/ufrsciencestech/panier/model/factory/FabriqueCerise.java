/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Cerise;
import fr.ufrsciencestech.panier.model.Fruit;

/** 
 * Fabrique de cerises
 * @author va864097
 */
public class FabriqueCerise implements Fabrique {

    /**
     * Fabrique une cerise
     */
    @Override
    public Fruit fabriquer(){
        return new Cerise();
    }
}