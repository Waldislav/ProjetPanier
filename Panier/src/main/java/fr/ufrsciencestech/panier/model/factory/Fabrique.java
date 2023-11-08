/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;

/**
 * Interface Fabrique
 * @author va864097
 */
public interface Fabrique {
    /**
     * Fabrique un fruit
     * @return un fruit
     */
    public Fruit fabriquer();
}
