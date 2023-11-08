/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model.factory;

import fr.ufrsciencestech.panier.model.Ananas;
import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.MacedoineIle;

/**
 *
 * @author va864097
 */
public class FabriqueMacedoineIle implements Fabrique {
    @Override
    public Fruit fabriquer(){
        MacedoineIle m = new MacedoineIle();
        m.ajouteFruit(new FabriqueAnanas().fabriquer());
        m.ajouteFruit(new FabriqueBanane().fabriquer());
        return m;
    }
}