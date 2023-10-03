/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author va864097
 */
public interface VueG extends PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt);
    //public void update(Observable m, Object o);
    public void ajoutControleur(Controleur c);
}
