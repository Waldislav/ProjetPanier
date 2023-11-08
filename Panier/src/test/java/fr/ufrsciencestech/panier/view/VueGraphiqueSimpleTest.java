/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.view;

import fr.ufrsciencestech.panier.TestUtils;
import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author va864097
 */
public class VueGraphiqueSimpleTest {
    private static VueGraphiqueSimple vueg;
    private Controleur c;
    private Panier p;
    
    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimple();
        p = new Panier(2);
        c = new Controleur();
        
        c.setPanier(p);
        p.addObserver(vueg);
        vueg.ajoutControleur(c);
        p.initListe();
    }
    
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
       
    }
    
    //Test du bouton +
    @Test
    public void testIncr(){
        System.out.println("incr");
        assertNotNull(vueg);
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "affiche");
        assertNotNull(res);
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        String newLine = System.getProperty("line.separator");
        String affichage = "Orange de Espagne à 0.5 euros" + newLine;
        plus.doClick();
        assertEquals(res.getText(), affichage);
        
        affichage += affichage;
        
        plus.doClick();
        assertEquals(res.getText(), affichage);
        
        plus.doClick();
        assertEquals(res.getText(), affichage);
    }
    
    //Test du bouton -
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        
        assertNotNull(vueg);  // Instantiated?
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "affiche");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        String newLine = System.getProperty("line.separator");
        String affichage = "Orange de Espagne à 0.5 euros" + newLine;
        
        plus.doClick();
        assertEquals(res.getText(), affichage);
    
        minus.doClick();
        assertEquals(res.getText(), "");
        
        minus.doClick();
        assertEquals(res.getText(), "");
        
    }
    
    //Test du passage d'un fruit à un jus
    @Test
    public void testJus() {
        System.out.println("jus");
        assertNotNull(vueg);  // Instantiated?
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "affiche");
        assertNotNull(res); // Component found?
        JCheckBox jus = (JCheckBox)TestUtils.getChildNamed(vueg, "Jus");
        assertNotNull(jus);
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        jus.doClick();
        
        plus.doClick();
        String affichage = "Orange(Jus) de Espagne à  1.0 euros\n";
        assertEquals(res.getText(), affichage);
        
        jus.doClick();
        plus.doClick();
        affichage += "Orange de Espagne à 0.5 euros\n";
        assertEquals(res.getText(), affichage);  
    }
    
    //Test sur le remplissage de la liste de fruit
    @Test
    public void testComboBoxItems() {
        System.out.println("liste");

        String[] expectedItems = {"Orange", "Cerise", "Banane", "Ananas", "Kiwi", "Macédoine des Iles", "Macédoine de Fruits Rouges", "Macédoine de tout les fruits"}; // Les éléments attendus dans la combobox
        
        JComboBox fruits = vueg.getComboFruit();

        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) fruits.getModel();
        assertEquals(8, model.getSize());
        for(int i=0;i<8;i++)
            assertEquals(expectedItems[i], model.getElementAt(i));
    }
    
    //Test sur la selection de la liste de fruit
    @Test
    public void testComboBoxSelection() {
        System.out.println("selec");

        JComboBox<String> comboBox = vueg.getComboFruit();
        comboBox.setSelectedItem("Cerise");
        assertEquals("Cerise", comboBox.getSelectedItem());
    }
    
    //Test d'ajout d'un nouveau fruit
    @Test
    public void testNouveauFruit() {
        System.out.println("nouveauFruit");
        
        assertNotNull(vueg);  // Instantiated?
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "affiche");
        assertNotNull(res); // Component found?

        p.ajoutTypeFruit("Mangue");

        JComboBox<String> comboBox = vueg.getComboFruit();

        comboBox.setSelectedItem("Cerise");

        assertEquals("Cerise", comboBox.getSelectedItem());
    }

}
