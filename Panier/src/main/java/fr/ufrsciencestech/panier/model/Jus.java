
package fr.ufrsciencestech.panier.model;
import java.util.ArrayList;
import fr.ufrsciencestech.panier.model.Fruit;
/**
 * Classe des jus de fruits permet d'acheter un jus d'un ou plusieurs fruits
 * @author vr144361
 */
public class Jus implements Fruit{
    
    private ArrayList<Fruit> composition;
    
    
    public Jus(){
        this.composition = new ArrayList<Fruit>();
    }
    
    /**
     * Ajoute un Fruit à la compostion du jus
     * @param f  désigne le fruit à ajouter dans le jus  
     */
    public void ajoutFruit(Fruit f){
        this.composition.add(f);
    }
    /**
     * Indique si le jus de fruit possède des pépins/noyaux
     * @return Toujours faux (qui a vu un jus de fruit plein de pépin)
     */
    @Override
    public boolean isSeedless(){
        return false;
    }
    
    /**
     * Indique la composition du jus de fuit actuel
     * @return la composition du jus fruit au format texte lisible par un humain
     */
    @Override
    public String toString(){
        String retour = "Jus de:\n";
        for (Fruit f : this.composition ){
            retour = retour.concat(f.toString()+"\n");
        }
        return retour;
    }
    @Override
    public String getOrigine(){
        String retour = "ORIGINES:\n";
        for (Fruit f : this.composition ){
            retour = retour.concat(f.getOrigine()+"\n");
        }
        return retour;
    }
    @Override
    public double getPrix(){
        double retour = 0;
        for (Fruit f : this.composition ){
            retour += f.getPrix();
        }
        return retour;
    }
            
}
