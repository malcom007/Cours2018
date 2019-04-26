/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleversion;



/**
 * Compte pour les diff comptes
 * @author mk
 */
public class CompteBancaire {

    
    
    private String titulaire, devise;
    private double solde;
    
    private int count;
    
    
    
    //Constructeur d'initialisation
    public CompteBancaire(){
        
    }
    //Constructeur d'instanciation
    public CompteBancaire(String titulaire, double solde, String devise) {
        count++;
        this.titulaire = titulaire;
        this.devise = devise;
        this.solde = solde;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "\t"+titulaire+" \t"+solde+devise;
    }

    

    
    
    
    
    
    
    
}
