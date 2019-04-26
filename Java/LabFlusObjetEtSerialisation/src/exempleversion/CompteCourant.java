/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleversion;

/**
 * Classe compte chèque qui hérite de la classe compteBancaire
 * @author mk
 */
public class CompteCourant extends CompteBancaire{
    
    private String numeroCB;
    private double decouvertMaxi;
    
    private static int countCourant;
    
    //Constructeur d'initialisation
    public CompteCourant(){
        
    }

    public CompteCourant(String titulaire, double solde, double decouvertMaxi) {
        super(titulaire, solde);
        countCourant++;
        this.numeroCB = "2019"+countCourant;
        this.decouvertMaxi = decouvertMaxi;
    }

    public String getNumeroCB() {
        return numeroCB;
    }

    

    public double getDecouvertMaxi() {
        return decouvertMaxi;
    }

    public void setDecouvertMaxi(double decouvertMaxi) {
        this.decouvertMaxi = decouvertMaxi;
    }

    public static int getCountCourant() {
        return countCourant;
    }

    @Override
    public String toString() {
        return "\t"+this.numeroCB+super.toString()+"\t"+decouvertMaxi;
    }

    
    
    
    
}
