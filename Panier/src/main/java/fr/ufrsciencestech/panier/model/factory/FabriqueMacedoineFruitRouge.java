/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.MacedoineFruitsRouge;

/**
 * Fabrique de macedoine de fruits rouges
 * @author va864097
 */
public class FabriqueMacedoineFruitRouge implements Fabrique {

    /**
     * Fabrique une macedoine de fruits rouges
     */
    @Override
    public Fruit fabriquer(){
        MacedoineFruitsRouge m = new MacedoineFruitsRouge();
        m.ajouteFruit(new FabriqueNouveauFruit("Fraise").fabriquer());
        m.ajouteFruit(new FabriqueCerise().fabriquer());
        return m;
    }
}