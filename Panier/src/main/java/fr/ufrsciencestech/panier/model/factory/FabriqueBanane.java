/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Banane;
import fr.ufrsciencestech.panier.model.Fruit;

/**
 * Fabrique de bananes
 * @author va864097
 */
public class FabriqueBanane implements Fabrique {

    /**
     * Fabrique une banane
     */
    @Override
    public Fruit fabriquer(){
        return new Banane();
    }
}