/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleversion;

import java.util.ArrayList;

/**
 *
 * @author mk
 */
public class Gestion {
    
    ArrayList<CompteCourant> listeComptesCheques = new ArrayList<>();
    ArrayList<CompteEpargne> listeComptesEpargnes = new ArrayList<>();
    
    /**
     * Methode to add new Cheque Account
     * @param titulaire
     * @param solde
     * @param devise
     * @param numeroCB
     * @param decouvertMaxi 
     */
    public void AjouterCompteCheque(String titulaire, double solde,String devise, String numeroCB, double decouvertMaxi){        
        
            listeComptesCheques.add(new CompteCourant(titulaire, solde,devise,numeroCB, decouvertMaxi));
        
    }
    
    /**
     * Methode to add new Saving Account
     * @param titulaire
     * @param solde
     * @param devise
     * @param tauxInteret 
     */
    public void AjouterCompteEpargne(String titulaire, double solde, String devise,double tauxInteret){
        
        listeComptesEpargnes.add(new CompteEpargne(titulaire, solde,devise, tauxInteret));
    }
    
    /**
     * Methode to show all Cheques Account
     * @return 
     */
    public String AfficherListeCompteCheque(){
        String resultCheque="";
        
        for (CompteCourant monCompteCourant : listeComptesCheques) {
            
            resultCheque = monCompteCourant.toString()+ "\n";
            
        }
        
        return resultCheque;
        
    }
    
    /**
     * Methode to show all Saving Account
     * @return 
     */
    public String AfficherListeCompteEpargne(){
        
        String resultEpargne="";
        
        for (CompteEpargne monCompteEpargne : listeComptesEpargnes) {
            
            resultEpargne = monCompteEpargne.toString()+ "\n";
            
        }
        
        return resultEpargne;
        
    }
    
}
