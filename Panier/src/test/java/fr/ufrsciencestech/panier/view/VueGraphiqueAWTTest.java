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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author va864097
 */
public class VueGraphiqueAWTTest {
    
    private static VueGraphiqueAWT vueg;
    private Controleur c;
    private Panier p;
    
    @Before
    public void setUp() {
        vueg = new VueGraphiqueAWT();
        p = new Panier(5);
        c = new Controleur();
        
        c.setPanier(p);
        p.addObserver(vueg);
        vueg.ajoutControleur(c);
    }
    
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        
        assertEquals(vueg.getAffiche().getText(), "0");
        p.ajout();
        assertEquals(vueg.getAffiche().getText(), "1");
        p.retrait();
        assertEquals(vueg.getAffiche().getText(), "0");
        
        vueg.setAffiche(new Label("0", Label.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");
    }

    @Test
    public void testIncr(){
        System.out.println("incr");
        assertNotNull(vueg);
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res);
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae);
        assertEquals(res.getText(), "1");
        
        plus.dispatchEvent(ae);
        assertEquals(res.getText(), "2");
    }
    
    @Test
    public void testDecrOk() {
        System.out.println("decr");
        
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae); 
        assertEquals(res.getText(), "1");
        
        ActionEvent ae2 = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(ae2); 
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testDecrZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Moins");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        ActionEvent ae = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(ae); 
        assertEquals(res.getText(), "0");
    }

   
    
}
