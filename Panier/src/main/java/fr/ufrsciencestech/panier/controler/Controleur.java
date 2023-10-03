/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.controler;

import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author va864097
 */
public class Controleur implements ActionListener {
    
    Panier p;
    
    public Controleur() {
        super();
    }
    
    public void setPanier(Panier p) {
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component comp =(Component) e.getSource();
        if(comp.getName().equals("Plus")){
            try {
                p.ajout();
            } catch (PanierPleinException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else 
        {
            try {
                p.retrait();
            } catch (PanierVideException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
