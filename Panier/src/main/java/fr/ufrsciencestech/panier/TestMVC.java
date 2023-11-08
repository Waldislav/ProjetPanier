package fr.ufrsciencestech.panier;


import fr.ufrsciencestech.panier.controler.Controleur;
import fr.ufrsciencestech.panier.model.Panier;
import fr.ufrsciencestech.panier.view.VueConsole;
import fr.ufrsciencestech.panier.view.VueG;
import fr.ufrsciencestech.panier.view.VueGraphiqueAWT;
import fr.ufrsciencestech.panier.view.VueGraphiqueSimple;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author va864097
 */
public class TestMVC {
    
    private VueG vueGraph;
    private Controleur controlSimple;
   
    public VueG getVueg(){
        return vueGraph;
    }
    
    public void setVueg(VueG vueg)
    {
        this.vueGraph = vueg;
    }
    
    public Controleur getControleur(){
        return controlSimple;
    }
    
    public void setControleur(Controleur controleur){
        this.controlSimple = controleur;
    }
    
    public void initListe(Panier p){
        p.ajoutTypeFruit("Orange");
        p.ajoutTypeFruit("Cerise");
        p.ajoutTypeFruit("Banane");
        p.ajoutTypeFruit("Ananas");
        p.ajoutTypeFruit("Kiwi");
        p.ajoutTypeFruit("Macédoine des Iles");
        p.ajoutTypeFruit("Macédoine de Fruits Rouges");
        p.ajoutTypeFruit("Macédoine de tout les fruits");
    }
    
    public TestMVC() {
        vueGraph = new VueGraphiqueSimple();
        controlSimple = new Controleur();
        Panier p = new Panier(5);
        VueConsole vueC = new VueConsole();
        
        controlSimple.setPanier(p);
        controlSimple.setFrame((VueGraphiqueSimple) vueGraph);
        p.addObserver(vueGraph);
        p.addObserver(vueC);
        vueGraph.ajoutControleur(controlSimple);
        
        initListe(p);
       
    }
    
    public static void main(String []args){
        //Lancer en dur
        TestMVC test = new TestMVC();
        
    }
}
