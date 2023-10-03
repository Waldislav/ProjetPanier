/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import java.awt.Button;
import java.awt.Label;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author va864097
 */
public class VueGraphiqueAWT extends java.awt.Frame implements VueG{

    /**
     * Creates new form VueGraphiqueAWT
     */
    public VueGraphiqueAWT() {
        initComponents();
        this.setSize(220, 220);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public Button getInc(){
        return this.inc;
    }
    
    public Button getDec(){
        return this.dec;
    }
     
    public Label getAffiche(){
        return this.affiche;
    }
    
    public void setAffiche(Label affiche){
        this.affiche = affiche;
    }
    
    public void ajoutControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        affiche = new java.awt.Label();
        dec = new java.awt.Button();
        inc = new java.awt.Button();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        affiche.setAlignment(1);
        affiche.setName("Affichage"); // NOI18N
        affiche.setText("0");
        add(affiche, java.awt.BorderLayout.CENTER);

        dec.setLabel("-");
        dec.setName("Moins"); // NOI18N
        add(dec, java.awt.BorderLayout.SOUTH);

        inc.setLabel("+");
        inc.setName("Plus"); // NOI18N
        add(inc, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label affiche;
    private java.awt.Button dec;
    private java.awt.Button inc;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        Panier p = (Panier) pce.getSource();
        getAffiche().setText(((Integer)p.getTaillePanier()).toString());
    }
}
