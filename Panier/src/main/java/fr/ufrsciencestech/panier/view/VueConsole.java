/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.model.Panier;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 *
 * @author celine
 */
public class VueConsole implements PropertyChangeListener { //implements Observer{
    private String trace;
    
    /**
     * @return the trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * @param trace the trace to set
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }
    
    public VueConsole(){
        trace = "Valeur initiale : " + 0;
        System.out.println(trace);
    }
    
    //public void update(Observable m, Object compte){   //This method is called whenever the observed object is changed
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        Panier p = (Panier) evt.getSource();
        
        trace = "Nouvelle valeur : " + p.getTaillePanier();
        System.out.println(trace);
    }
}
