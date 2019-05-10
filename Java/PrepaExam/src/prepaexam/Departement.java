/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepaexam;

/**
 *
 * @author mk
 */
public class Departement {
    
    private String nom;
    private int ID;
    
    private static int countD;
    
    public Departement(){
        
    }

    public Departement(String nom) {
        this.nom = nom;
        this.ID = countD++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return ID+"\t "+nom+"\t ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==null) {
            return  false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departement other = (Departement) obj;
        return this.ID==other.ID;
    }
    
    

    
    
    
    
    
    
}
