/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice2;

import java.util.ArrayList;

/**
 *
 * @author mk
 */
public class Employe {
    
    private String nom;
  /** entreprise dans laquelle travaille l'employé */
  private Entreprise entreprise;

  protected Employe(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  

  public void setEntreprise(Entreprise entreprise) throws invalidSetEntrepriseException{
   
    if ((entreprise != null)&& (this.entreprise != null) ) {
      throw new invalidSetEntrepriseException("Impossible de faire un set sur l'entreprise");
    }
    this.entreprise = entreprise;
  }

  public Entreprise getEntreprise() {
    return entreprise;
  }


  public String toString() {
    String desc = nom + " ";
    if (entreprise != null) {
      desc += entreprise.getNom();
    }
    else {
      desc += "Oups";
    }
    return desc;
  }

    
    
    
    
}
