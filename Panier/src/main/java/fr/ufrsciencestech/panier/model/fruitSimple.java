/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;
import Fruit;
/**
 *
 * @author vr144361
 */
public class fruitSimple implements Fruit{
    @Overide
    public boolean isSeedless(){}  //predicat indiquant si le fruit a ou non des pepins
    @Overide
    public double getPrix(){}      //prix unitaire du fruit (en euros)
    @Override
    public String getOrigine(){}   //pays d'origine du fruit
    @Override
    public boolean equals(Object o){}  //predicat pour tester si 2 fruits sont equivalents
    @Override
    public String toString(){}    //affichage d'un fruit
}
