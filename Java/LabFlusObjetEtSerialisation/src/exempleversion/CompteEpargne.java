/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleversion;

/**
 *
 * @author mk
 */
public class CompteEpargne extends CompteBancaire{
    
    private double tauxInteret;
    
    private static int countEpargne;
    //Constructeur d'initialisation
    public CompteEpargne(){
        
    }
    
    //Constructeur d'instanciation

    public CompteEpargne(String titulaire, double solde, String devise,double tauxInteret) {
        super(titulaire, solde, devise);
        countEpargne++;
        this.tauxInteret = tauxInteret;
    }
    
    
    //Les ascesseurs
    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public static int getCountEpargne() {
        return countEpargne;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+tauxInteret;
    }
    
    
    
    
    
    
    
    
    
}
