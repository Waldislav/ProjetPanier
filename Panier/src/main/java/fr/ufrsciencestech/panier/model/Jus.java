
package fr.ufrsciencestech.panier.model;
import java.util.ArrayList;
import fr.ufrsciencestech.panier.model.Fruit;
/**
 * Classe des jus de fruits permet d'acheter un jus d'un ou plusieurs fruits
 * @author vr144361
 */
public class Jus implements Fruit{
    
    private Fruit fruit;
    
    
    public Jus(Fruit fruit){
        this.fruit = fruit;
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
        String retour = this.fruit.getClass().getSimpleName() + "(Jus) de " + this.fruit.getOrigine() + " à  " + this.getPrix() + " euros";
        return retour;
    }
    @Override
    public String getOrigine(){
        String retour = "ORIGINES: " + this.fruit.getOrigine();
        return retour;
    }
    @Override
    public double getPrix(){
        double retour = 0;
        retour = this.fruit.getPrix() + 0.5;
        return retour;
    }
            
}
