/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author cp326381
 */
public abstract class FruitSimpleTest {
    
    abstract FruitSimple createFruit(double prix, String origine);
    abstract FruitSimple createFruitNull();
    
    @Test
    public void testGetPrix() {
        FruitSimple fs = createFruit(0.5,"France");
        double expected = 0.5;
        double result = fs.getPrix();
        assertTrue(expected == result);
        
        // Test pour createFruitNull();
        FruitSimple fs_null = createFruitNull();
        assertNull(fs_null);
    }
}
