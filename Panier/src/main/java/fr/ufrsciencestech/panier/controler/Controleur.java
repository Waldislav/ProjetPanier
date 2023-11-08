/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;


import fr.ufrsciencestech.panier.model.*;
import fr.ufrsciencestech.panier.model.factory.*;


import fr.ufrsciencestech.panier.model.FruitFactory;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author va864097
 */
public class Controleur implements ActionListener {
    
    Panier p;
    String typeFruit;
    Fabrique fabrique;
    boolean isJus;
    
    public Controleur() {
        super();
        typeFruit = "Orange"; // Valeur par défaut
        
    }
    
    public void setPanier(Panier p) {
        this.p = p;
    }
    
    public void setTypeFruit() {
        switch(typeFruit){
            case "Orange" : fabrique = new FabriqueOrange(); break;
            case "Banane" : fabrique = new FabriqueBanane(); break;
            case "Cerise" : fabrique = new FabriqueCerise(); break;
            case "Kiwi" : fabrique = new FabriqueKiwi(); break;
            case "Ananas" : fabrique = new FabriqueAnanas(); break;
            default : fabrique = null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Component comp =(Component) e.getSource();

        
        if(comp.getName().equals("Plus")){
            try {
                if (isJus)
                    p.ajout(FruitFactory.createJus(typeFruit));
                else
                    p.ajout(FruitFactory.createFruit(typeFruit));

            } catch (PanierPleinException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (comp.getName().equals("liste")) {
       
            JComboBox liste = (JComboBox) comp;
            typeFruit = String.valueOf(liste.getSelectedItem());
            System.out.println("Tiens tiens tiens => "+typeFruit);
        }
        else if (comp.getName().equals("Moins")) {
            
            try {
                p.retrait();
            } catch (PanierVideException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (comp.getName().equals("Jus")) 
        {
            isJus = !isJus;
            System.out.println("Jus => "+isJus);
        }
    }
    
}
