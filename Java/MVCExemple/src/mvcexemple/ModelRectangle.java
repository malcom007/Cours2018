/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexemple;

import java.util.Observable;

/**
 *
 * @author malcom
 */
public class ModelRectangle  extends Observable{
    
    private int longeur, largeur;
    
    public ModelRectangle(int longueur, int largeur){
        this.longeur=longueur;
        this.largeur=largeur;
    }
    
    public int perimetre(){
        
        return longeur*4;
    }
    
    public int surface(){
        return longeur*largeur;
    }
    
}
