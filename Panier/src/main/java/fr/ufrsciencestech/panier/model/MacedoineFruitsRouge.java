/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author waldislav
 */
public class MacedoineFruitsRouge extends Macedoine implements Fruit{
    
    public MacedoineFruitsRouge(){
        super();
        this.ajouteFruit(FruitFactory.createFruit("Fraise"));
        this.ajouteFruit(FruitFactory.createFruit("Cerise"));
    }
}
