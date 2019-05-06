/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lescollectionsgeneriques;

/**
 *
 * @author mk
 */
public class Salle {
    
    private int id;
    private String code, libelle;
    private int countS;
    
    //COnstructeurs
    public Salle(){
        
    }

    public Salle(String code, String libelle) {
        this.id=countS++;
        this.code = code;
        this.libelle = libelle;
    }
    
    //Les accesseurs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCountS() {
        return countS;
    }

    @Override
    public String toString() {
        return "Salle " + "id=" + id + "\t code=" + code + "\t libelle=" + libelle + '}';
    }
    
    

    
    
    
    
    
}
