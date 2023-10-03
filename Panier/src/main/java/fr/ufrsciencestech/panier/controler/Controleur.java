/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Orange;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
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
    
    public Controleur() {
        super();
    }
    
    public void setPanier(Panier p) {
        this.p = p;
    }
    
    public void setTypeFruit(String type) {
        this.typeFruit = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component comp =(Component) e.getSource();
        if(comp.getName().equals("Plus")){
            try {
                Orange o = new Orange();
                if(typeFruit == "Orange")
                    o = new Orange(5,"Malte");
                p.ajout(o);
            } catch (PanierPleinException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (comp.getName().equals("liste")){
            JComboBox liste = (JComboBox) comp;
            typeFruit = String.valueOf(liste.getSelectedItem());
            System.out.println("Tiens tiens tiens =>"+typeFruit);
        }
        else if (comp.getName().equals("Moins")) 
        {
            try {
                p.retrait();
            } catch (PanierVideException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
