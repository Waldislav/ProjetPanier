/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.MacedoineFruitsRouge;

/**
 *
 * @author va864097
 */
public class FabriqueMacedoineTout implements Fabrique {
    @Override
    public Fruit fabriquer(){
        MacedoineFruitsRouge m = new MacedoineFruitsRouge();
        m.ajouteFruit(new FabriqueOrange().fabriquer());
        m.ajouteFruit(new FabriqueCerise().fabriquer());
        m.ajouteFruit(new FabriqueBanane().fabriquer());
        m.ajouteFruit(new FabriqueAnanas().fabriquer());
        m.ajouteFruit(new FabriqueKiwi().fabriquer());
        return m;
    }
}