/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreapaExamen2;

/**
 *
 * @author mk
 */
public class Salle {
    private String code, libelle;
    private int id;
    
    private static int countS;
    
    public Salle(){
        
    }

    public Salle(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
        this.id = countS++;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public static int getCountS() {
        return countS;
    }

    
    
    

    @Override
    public String toString() {
        return id+"\t"+code+"\t"+libelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj ==null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salle other = (Salle)obj;
        return this.id == other.id;
        
        
    }
    
    
    
    
    
    
}
