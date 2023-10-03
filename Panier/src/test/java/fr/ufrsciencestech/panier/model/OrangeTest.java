/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author cp326381
 */
public class OrangeTest extends FruitSimpleTest {

    @Override
    FruitSimple createFruit(double prix, String origine) {
        return new Orange(prix, origine);
    }

    @Override
    FruitSimple createFruitNull() {
        return null;
    }
    
}
