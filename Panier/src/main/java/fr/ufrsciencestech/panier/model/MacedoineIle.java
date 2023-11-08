/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

/**
 *
 * @author waldislav
 */
public class MacedoineIle extends Macedoine implements Fruit{
    
    public MacedoineIle(){
        super();
        this.ajouteFruit(FruitFactory.createFruit("Ananas"));
        this.ajouteFruit(FruitFactory.createFruit("Banane"));
    }
}
