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
    
    public TestMVC() {
        /*vueGraph = new VueGraphiqueSimple();
        controlSimple = new Controleur();
        Panier p = new Panier(5);
        VueConsole vueC = new VueConsole();
        
        controlSimple.setPanier(p);
        p.addObserver(vueGraph);
        p.addObserver(vueC);
        vueGraph.ajoutControleur(controlSimple);
        */
    }
    
    public static void main(String []args){
        //Lancer en dur
        //TestMVC test = new TestMVC();
        
        //Avec Spring IoC
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        TestMVC test = (TestMVC)context.getBean("MVC");  //SpringIoC
        test.setControleur( (Controleur)context.getBean("Controleur") );  //SpringIoC
        test.setVueg( (VueG)context.getBean("Vue") );   //SpringIoC
         
        Panier p = new Panier(5); 
        test.getControleur().setPanier(p);  
        
        p.addObserver(test.getVueg());
        test.getVueg().ajoutControleur(test.getControleur());
        
        VueConsole vuec = new VueConsole();
        p.addObserver(vuec);
    }
}
