/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labcollection;

/**
 *
 * @author mk
 */
public class Employe implements Comparable{
    
    private String  matricule, nom, prenom;
    
    private int coutE,cin;
    
//  Construteurs
    public Employe(){
        
    }

    public Employe( String nom, String prenom) {
        coutE++;
        this.cin = coutE;
        this.nom = nom;
        this.prenom = prenom;
    }
    
//    Les accesseurs

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
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

    public int getCoutE() {
        return coutE;
    }

    @Override
    public String toString() {
        return "Employe{"+coutE + "cin=" + cin + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + '}';
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
        return this.matricule == other.matricule;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
    
    
}
