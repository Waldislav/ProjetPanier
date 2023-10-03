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
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        p = new Panier(5);
        c = new Controleur();
        
        c.setPanier(p);
        p.addObserver(vueg);
        vueg.ajoutControleur(c);
    }
    
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
       
    }

    @Test
    public void testIncr(){
        System.out.println("incr");
        assertNotNull(vueg);
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res);
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        plus.doClick();
        assertEquals(res.getText(), "1");
        
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        plus.doClick();
        assertEquals(res.getText(), "1");
        
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testDecrZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
}
