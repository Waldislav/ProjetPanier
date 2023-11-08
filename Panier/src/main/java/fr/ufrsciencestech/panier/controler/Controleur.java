/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;


import fr.ufrsciencestech.panier.model.Fruit;
import fr.ufrsciencestech.panier.model.factory.*;


import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
import fr.ufrsciencestech.panier.view.DiagAjout;
import fr.ufrsciencestech.panier.view.VueGraphiqueSimple;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    VueGraphiqueSimple frame;
    DiagAjout diag;
    boolean isJus;
    
    public Controleur() {
        super();
        typeFruit = "Orange"; // Valeur par défaut
        
    }
    
    public void setFrame(VueGraphiqueSimple frame){
        this.frame = frame;
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
            case "Macédoine des Iles" : fabrique = new FabriqueMacedoineIle(); break;
            case "Macédoine de Fruits Rouges" : fabrique = new FabriqueMacedoineFruitRouge(); break;
            case "Macédoine de tout les fruits" : fabrique = new FabriqueMacedoineTout(); break;
            default : fabrique = new FabriqueNouveauFruit(typeFruit); break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Component comp =(Component) e.getSource();
        
        if(comp.getName().equals("Plus")){
            setTypeFruit();
            Fruit fruit = fabrique.fabriquer();
            try{
                if(isJus) {
                    fabrique = new FabriqueJus(fruit);
                    fruit = fabrique.fabriquer();
                }
                p.ajout(fruit);
            } catch (PanierPleinException ex){
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (comp.getName().equals("liste")) {
            JComboBox liste = (JComboBox) comp;
            typeFruit = String.valueOf(liste.getSelectedItem());
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
        else if (comp.getName().equals("nouveau")) {
            diag = new DiagAjout(frame, true);
            diag.ajoutControleur(this);
            diag.setVisible(true);
            
        } 
        else if (comp.getName().equals("nomFruit") || comp.getName().equals("ajoutFruit")) {
            String nomFruit = diag.getNom().getText();
            System.out.println("Eh bah ?");
            if(!nomFruit.equals("")){
                p.ajoutTypeFruit(nomFruit);
                diag.setVisible(false);
            }
        }
    }
    
}
