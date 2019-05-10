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
public class Employe {
    
    private String matricule, nom, prenom;
    private int cin;
    
    private static int countE;
    
    public Employe(){
        
    }

    public Employe(String matricule, String nom, String prenom) {
        this.cin=countE++;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCin() {
        return cin;
    }

    public static int getCountE() {
        return countE;
    }

    @Override
    public String toString() {
        return matricule + "\t " + nom + "\t " + prenom + "\t " + cin ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;  
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Employe other = (Employe) obj;
        return this.cin == other.cin;
    }
    
    
    
    

    
    
    
    
    
}
