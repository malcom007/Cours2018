/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foreachloopsearchcompare;

import java.util.*;

/**
 *
 * @author mk
 */
public class ForEachLoopSearchCompare {

    private static ArrayList<String> NouveauTableau = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Déclaration des tableaux
        List<String> TableauBase = new ArrayList<>(Arrays.asList(new String[]{"1", "2", "3"}));

        //Ajout des element ds le tableau de base
        TableauBase.add("Merci");
        TableauBase.add("Jean");
        TableauBase.add("Paul");
        TableauBase.add("Paul");
        TableauBase.add("");

        System.out.println("**** Affichage de tableau 1 ****");
        for (String monString : TableauBase) {
            System.out.println(monString + "\t");
        }

        System.out.println("**** Affichage du resultat de recherche ****");
        //Creation variable pour stocker monElement
        String currentString = null;

        for (String ajoutString : NouveauTableau) {

            for (String nextString : TableauBase) {

                if (isNullOrEmpty(currentString)) {
                    currentString = nextString;
                    NouveauTableau.add(currentString);
                }
                
                currentString = nextString;
            }
            
                NouveauTableau.add(currentString);

        }

        System.out.println("\t****Apres insertion dans le tableau***");
        for (String InsertString : NouveauTableau) {

            System.out.println("\t" + InsertString);
        }
        System.out.println("\t***************************");
        System.out.println("current" + currentString);

    }

    public static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

//    public static boolean equalsA(String currentString) {
//        
//        for (String InsertString : NouveauTableau) {
//            
//                if (isNullOrEmpty(InsertString))) {
//                    NouveauTableau.add(currentString);
//                }
//            }
//        
//        if (obj == null) {
//            return false;
//        }
//        
//        return true;
//    }
}
