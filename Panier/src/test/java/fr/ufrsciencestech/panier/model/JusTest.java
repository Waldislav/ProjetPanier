/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.model;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 *
 * @author ao5843431
 */
public class JusTest {
    
    @Test
    public void testIsSeedless(){
        Fruit fruit = new Orange(0.5,"France");
        Jus jus = new Jus(fruit);
        assertFalse(jus.isSeedless());
    }
    
    @Test
    public void testtoString(){
        Fruit fruit = new Orange(0.5,"France");
        Jus jus = new Jus(fruit);
        assertEquals("Orange(Jus) de France à 1.0 euros",jus.toString());
    }
    
    @Test
    public void testgetOrigin(){
        
        Fruit fruit = new Orange(0.5,"France");
        String expected = "France";
        String result = fruit.getOrigine();
        assertEquals(expected,result);
    }
    
    @Test
    public void testgetPrix(){
        Fruit fruit = new Orange(0.5,"France");
        Jus jus = new Jus(fruit);
        double expected = 1.0;
        double result = jus.getPrix();
        double tolerance = 0.0001;

        assertEquals(expected, result, tolerance);
    }
}
