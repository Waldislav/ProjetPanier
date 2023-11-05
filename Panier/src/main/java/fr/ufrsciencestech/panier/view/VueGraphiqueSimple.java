/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;

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
        this.setSize(320, 320);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public JButton getInc(){
        return this.inc;
    }
    
    public JButton getDec(){
        return this.dec;
    }

    public JCheckBox getJus() {
        return jCheckBoxJus;
    }
     
    public JTextArea getAfficheListe(){
        return this.affiche;
    }
    
    public void setAffiche(JTextArea affiche){
        this.affiche = affiche;
    }
    
    public JComboBox getComboFruit(){
        return this.comboBoxFruit;
    }
    
    public void setComboFruit(JComboBox comboBoxFruit) {
        this.comboBoxFruit = comboBoxFruit;
    }
    
    public void ajoutControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        getComboFruit().addActionListener(c);
        getJus().addActionListener(c);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelPrix = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inc = new javax.swing.JButton();
        comboBoxFruit = new javax.swing.JComboBox<>();
        jCheckBoxJus = new javax.swing.JCheckBox();
        dec = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        affiche = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Prix");
        jPanel1.add(jLabel3);

        jLabelPrix.setText("0");
        jPanel1.add(jLabelPrix);

        jLabel1.setText("€");
        jPanel1.add(jLabel1);

        inc.setText("+");
        inc.setName("Plus"); // NOI18N
        jPanel1.add(inc);

        comboBoxFruit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orange", "Cerise", "Banane", "Ananas" }));
        comboBoxFruit.setName("liste"); // NOI18N
        jPanel1.add(comboBoxFruit);
        comboBoxFruit.getAccessibleContext().setAccessibleName("");

        jCheckBoxJus.setText("Jus");
        jCheckBoxJus.setName("Jus"); // NOI18N
        jPanel1.add(jCheckBoxJus);


        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        dec.setText("-");
        dec.setName("Moins"); // NOI18N
        getContentPane().add(dec, java.awt.BorderLayout.SOUTH);

        affiche.setColumns(20);
        affiche.setRows(5);
        affiche.setName("affiche"); // NOI18N
        jScrollPane2.setViewportView(affiche);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        Panier p = (Panier) pce.getSource();
        getAfficheListe().setText(p.toString());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea affiche;
    private javax.swing.JComboBox<String> comboBoxFruit;
    private javax.swing.JButton dec;
    private javax.swing.JButton inc;
    private javax.swing.JCheckBox jCheckBoxJus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPrix;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
