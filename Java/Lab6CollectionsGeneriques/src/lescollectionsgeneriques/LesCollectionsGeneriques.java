/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lescollectionsgeneriques;

import java.util.Scanner;

/**
 *
 * @author mk
 */
public class LesCollectionsGeneriques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SalleService ss = new SalleService();
        
        ss.Create(new Salle("A150", "Salle A"));
        ss.Create(new Salle("A180", "Salle B"));
        ss.Create(new Salle("A175", "Salle C"));
        ss.Create(new Salle("B225", "Salle D"));
        ss.Create(new Salle("B105", "Salle S"));
        
        
        
        //Afficher la liste des salles
        System.out.println("Liste des salles");
        System.out.println("================");
        System.out.println("");
        System.out.print("ID \tCODE \tLIBELE");
        
        System.out.println("\n-- \t---- \t------");
        for (Salle maSalle : ss.findAll()) {            
            System.out.println(maSalle.toString()+"\n");            
        }
        
        //Suppression d'une salle
        ss.delete(ss.findById(2));
        System.out.println("Liste des salles après suppression");
        System.out.println("==================================");
        System.out.println("");
        System.out.print("ID \tCODE \tLIBELE");
        
        System.out.println("\n-- \t---- \t------");
        for (Salle maSalle : ss.findAll()) {            
            System.out.println(maSalle.toString()+"\n");            
        }
        
        //Modifier les informations d'une salle
        Scanner input = new Scanner(System.in);
        Salle salleToModify = ss.findById(3);
        System.out.println(ss.findById(3).toString());
        
        System.out.println("Donner le nouveau code: ");
        salleToModify.setCode(input.nextLine());
        System.out.println("Donner le nouveau libelle: ");
        salleToModify.setLibelle(input.nextLine());
        
        
        System.out.println("Liste des salles après MODIFICATION");
        ss.update(salleToModify);
        System.out.println("===================================");
        System.out.println("");
        System.out.print("ID \tCODE \tLIBELE");
        
        System.out.println("\n-- \t---- \t------");
        for (Salle maSalle : ss.findAll()) {            
            System.out.println(maSalle.toString()+"\n");            
        }
    }
    
}
