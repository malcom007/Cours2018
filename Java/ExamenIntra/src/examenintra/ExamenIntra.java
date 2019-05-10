/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenintra;

import java.util.ArrayList;

/**
 *
 * @author mk
 */
public class ExamenIntra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> maTab = new ArrayList<>();
        maTab.add(1);
        
        
        Collection maCollections = new Collection();        
        maCollections.ajoute(5);
        maCollections.ajoute(20);
        
        System.out.println(maCollections.occurence(5));
        System.out.println(maCollections.toString());
    }
    
}
