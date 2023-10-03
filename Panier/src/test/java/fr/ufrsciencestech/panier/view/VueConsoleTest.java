/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ufrsciencestech.panier.view;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.model.PanierPleinException;
import fr.ufrsciencestech.panier.model.PanierVideException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueConsoleTest {
    private VueConsole vuec;
    private Panier p;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuec = new VueConsole();
        p = new Panier(5);
    }
        
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");    
       
        //si on oublie d'ajouter la vue comme observateur du modele, elle ne se met pas à jour correctement
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
        p.ajout();
        assertTrue(p.getTaillePanier() == 1);
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);   //aucune influence sur la vue
        
        //si on ajoute la vue comme observateur du modele, elle se met à jour correctement
        assertEquals(vuec.getTrace(), "Valeur initiale : " + 0);
        p.addObserver(vuec);    //on ajoute la vue comme observateur du modele
        //on passe par la methode setCompteur de la classe Modele :
        p.ajout();
        assertTrue(p.getTaillePanier() == 2);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 2);  //mise à jour correcte
        
        //Nouveau ajout
        p.ajout();
        assertTrue(p.getTaillePanier() == 3);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 3);  //mise à jour correcte
        
        //on passe par la methode update de la classe Modele (en decrementant trop) :
        try{
            for(int i=0; i<4; i++) p.retrait();
        } catch(PanierVideException e) {}
        assertTrue(p.getTaillePanier() == 0);
        assertEquals(vuec.getTrace(), "Nouvelle valeur : " + 0);  //mise à jour correcte
    }
}