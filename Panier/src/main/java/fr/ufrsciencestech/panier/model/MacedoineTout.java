/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author waldislav
 */
public class MacedoineTout extends Macedoine implements Fruit{
    
    public MacedoineTout(){
        super();
        this.ajouteFruit(FruitFactory.createFruit("Orange"));
        this.ajouteFruit(FruitFactory.createFruit("Cerise"));
        this.ajouteFruit(FruitFactory.createFruit("Banane"));
        this.ajouteFruit(FruitFactory.createFruit("Ananas"));
        this.ajouteFruit(FruitFactory.createFruit("Kiwi"));
    }
}