/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



/**
 *
 * @author va864097
 */

public class PanierTest {
    
    public PanierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Panier.
     * @throws fr.ufrsciencestech.panier.model.PanierPleinException
     */
    @Test
    public void testToString() throws PanierPleinException {
        System.out.println("toString");
        Panier instance = new Panier(1);
        Orange premiereOrange = mock(Orange.class);
        String expResult = "Orange d'Hawaï à 500€";
        when(premiereOrange.toString()).thenReturn(expResult);
        instance.ajout(premiereOrange);
        String result = instance.toString();
        assertEquals(expResult+System.getProperty("line.separator"), result);
        // TODO review the generated test code and remove the default call to fail.
    }


    /**
     * Test of getFruits method, of class Panier.
     */
    @Test
    public void testGetFruits() throws PanierPleinException {
        System.out.println("getFruits");
        Panier instance = new Panier(2);
        Kiwi unKiwi = mock(Kiwi.class);
        Orange deuxOrange = mock(Orange.class);
        ArrayList<Fruit> expResult = new ArrayList<Fruit>();
        expResult.add((Fruit)unKiwi);
        expResult.add((Fruit)deuxOrange);
        instance.ajout((Fruit) unKiwi);
        instance.ajout((Fruit) deuxOrange);
        ArrayList<Fruit> result = instance.getFruits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFruits method, of class Panier.
     */
    @Test
    public void testSetFruitsEtGetFruits() {
        System.out.println("setFruits");
        Orange unOrange = mock(Orange.class);
        ArrayList<Fruit> expResult = new ArrayList<Fruit>();
        expResult.add((Fruit)unOrange);
        Panier instance = new Panier(2);
        instance.setFruits(expResult);
        ArrayList<Fruit> result = instance.getFruits();
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTaillePanier method, of class Panier.
     */
    @Test
    public void testGetTaillePanier() {
        System.out.println("getTaillePanier");
        int expResult = 0;
        Panier instance = new Panier(expResult);
        int result = instance.getTaillePanier();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContenanceMax method, of class Panier.
     */
    @Test
    public void testGetContenanceMax() {
        System.out.println("getContenanceMax");
        Panier instance = new Panier(0);
        int expResult = 0;
        int result = instance.getContenanceMax();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   

    /**
     * Test of ajout method, of class Panier.
     */
    @Test
    public void testAjout_0args() throws Exception {
        System.out.println("ajout");
        Panier instance = new Panier(10);
        instance.ajout();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        String contenu = instance.toString();
        Orange test=new Orange();
        assertEquals(test.toString()+System.getProperty("line.separator"),contenu);
    }

}
