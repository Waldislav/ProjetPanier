/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.*;
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

    
    // Test pour setPrix()
    @Test
    public void testSetPrix() {
        // TRUE
        FruitSimple fs = createFruit(0.5,"France");
        fs.setPrix(0.6);
        double expected = 0.6;
        double result = fs.getPrix();
        assertTrue(expected == result);
        
        // FALSE
        FruitSimple fs2 = createFruit(0.5,"France");
        fs2.setPrix(0.6);
        double expected2 = 0.5;
        double result2 = fs2.getPrix();
        assertFalse(expected2 == result2);

        // Test pour createFruitNull();
        FruitSimple fs_null = createFruitNull();
        assertNull(fs_null);
    }

    // Test setOrigine()
    @Test
    public void testSetOrigine() {
        // TRUE
        FruitSimple fs = createFruit(0.5,"France");
        fs.setOrigine("Espagne");
        String expected = "Espagne";
        String result = fs.getOrigine();
        assertTrue(expected.equals(result));
        
        // FALSE
        FruitSimple fs2 = createFruit(0.5,"France");
        fs2.setOrigine("Espagne");
        String expected2 = "France";
        String result2 = fs2.getOrigine();
        assertFalse(expected2.equals(result2));

        // NULL
        FruitSimple fs_null = createFruitNull();
        assertNull(fs_null);
    }

    @Test
    public void testToString() {
        FruitSimple fs = createFruit(0.5,"France");
        String expected = "Orange de France à 0.5 euros";
        String result = fs.toString();
        assertEquals(expected,result);      
    }
    
    @Test
    public void testToStringNull(){
        FruitSimple fs_null = createFruitNull();
        assertNull(fs_null);
    }

    @Test
    public void testEquals() {
        // TRUE
        FruitSimple fs = createFruit(0.5,"France");
        FruitSimple fs2 = createFruit(0.5,"France");
        boolean expected = true;
        boolean result = fs.equals(fs2);
        assertTrue(expected == result);
        
        // FALSE
        FruitSimple fs3 = createFruit(0.5,"Espagne");
        boolean expected2 = false;
        boolean result2 = fs.equals(fs3);
        assertTrue(expected2 == result2);

        // NULL
        FruitSimple fs_null = createFruitNull();
        assertNull(fs_null);
    }


}
