/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice2;

/**
 *
 * @author mk
 */
public class MonTest {
    
    public static void main(String[] args)  {
        
        try {
            Entreprise entreprise1 = new Entreprise("Coroli");        
        Entreprise entreprise2 = new Entreprise("Eden");
    
        Employe emp1 = new Employe("Jean");
        Employe emp2 = new Employe("Pierre");            
        
        entreprise1.ajouter(emp2);        
        entreprise1.ajouter(emp1);
        System.out.println("***Affichage des Entreprise***");
        System.out.println(entreprise1.toString());
        
        Employe emp3 = new Employe("Paul");
        Employe emp4 = new Employe("Jacque");
        Employe emp5 = new Employe("Jacque");

        
        entreprise2.ajouter(emp4);
        entreprise2.ajouter(emp3);
        entreprise2.ajouter(emp5);
        System.out.println("***Affichage de l'Entreprise 2***");
        System.out.println(entreprise2.toString());

        System.out.println("");
        System.out.println("***Affichage des Entreprise apres suppression***");
        entreprise1.enleverEmploye(emp2);
        entreprise2.enleverEmploye(emp4);
        
        System.out.println(entreprise1.toString());
        System.out.println(entreprise2.toString());            
        
        }catch(EmployeExistantException | RetraitEmployeException | invalidSetEntrepriseException e){
            System.err.println(e.getMessage());
        }
 
        
    }

  
    
}
