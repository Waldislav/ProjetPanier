/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author va864097
 */
public class VueGraphiqueSimple extends javax.swing.JFrame implements VueG{

    /**
     * Creates new form VueGraphiqueSimple
     */
    public VueGraphiqueSimple() {
        initComponents();
        this.setSize(220, 220);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public JButton getInc(){
        return this.inc;
    }
    
    public JButton getDec(){
        return this.dec;
    }
     
    public JLabel getAffiche(){
        return this.affiche;
    }
    
    public void setAffiche(JLabel affiche){
        this.affiche = affiche;
    }
    
    public void ajoutControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        affiche = new javax.swing.JLabel();
        dec = new javax.swing.JButton();
        inc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        affiche.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        affiche.setText("0");
        affiche.setToolTipText("");
        affiche.setName("Affichage"); // NOI18N
        getContentPane().add(affiche, java.awt.BorderLayout.CENTER);

        dec.setText("-");
        dec.setName("Moins"); // NOI18N
        getContentPane().add(dec, java.awt.BorderLayout.PAGE_END);

        inc.setText("+");
        inc.setName("Plus"); // NOI18N
        getContentPane().add(inc, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        Panier p = (Panier) pce.getSource();
        getAffiche().setText(((Integer)p.getTaillePanier()).toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel affiche;
    private javax.swing.JButton dec;
    private javax.swing.JButton inc;
    // End of variables declaration//GEN-END:variables
}
