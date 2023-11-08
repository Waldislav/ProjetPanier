/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ao5843431
 */
public class MacedoineTest {
    private Macedoine macedoine;
    
    @Before
    public void setUp() {
        macedoine = new Macedoine();
    }
    
    @Test
    public void testIsSeedlessTrue(){
        assertTrue(macedoine.isSeedless()); 
    }
    
    @Test
    public void testIsSeedlessFalse(){
        macedoine.ajouteFruit(new Cerise(0.6,"Itlie"));
        assertFalse(macedoine.isSeedless()); 
    }
    
    @Test
    public void testGetPrix() {
        macedoine.ajouteFruit(new Orange(0.5, "France"));
        macedoine.ajouteFruit(new Kiwi(1.0, "Nouvelle-Zélande"));
        double expected = 1.5;
        double result = macedoine.getPrix();
        double tolerance = 0.001;
        assertEquals(expected, result, tolerance);
    }
    
    @Test
    public void testGetOrigine() {
    macedoine.ajouteFruit(new Orange(0.5, "France"));
    macedoine.ajouteFruit(new Kiwi(1.0, "Nouvelle-Zélande"));
    String expected = "Origine des fruits : France, Nouvelle-Zélande, ";
    String result = macedoine.getOrigine();
    assertEquals(expected, result);
    }
}
