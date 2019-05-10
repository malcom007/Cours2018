/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenintra;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author mk
 */
public class Collection{
    
    private ArrayList<Integer> maList = new ArrayList<>();

    public Collection() {
    }

    public Collection(ArrayList<Integer> liste){
        maList=liste;        
    }
    
    public void ajoute(Integer a){
        maList.add(a);
    }
    
    public int taille() {
        return maList.size();
    }
    
    public Integer occurence (Integer a){
        int f=0;
        for (Integer integer : maList) {
            f = Collections.frequency(maList,a);
            return f;            
        }
       return f;
    }
    
    
    //a retravailler
    public Integer getElement (int i){
        return i;
    }

    @Override
    public String toString() {
        String ensemble="Ensemble vide";
        for (Integer integer : maList) {
            return integer.toString();
        }
        return ensemble;
        
    }
    
    public ArrayList<Integer> union (ArrayList<Integer> x){
        ArrayList<Integer> NewTab = new ArrayList<>();
        for (Integer valX : x) {
            if (maList.contains(valX)) {
                NewTab.add(valX);
                return NewTab;
            }
            
        }
        return NewTab;
        
        
    }
    
    
    
    
    
}
