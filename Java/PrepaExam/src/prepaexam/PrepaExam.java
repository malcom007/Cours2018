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
public class PrepaExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gestion Gestionnaire = new Gestion();
        
        Departement d1 = new Departement("Informatique");
        Departement d2 = new Departement("Finance");
        Departement d3 = new Departement("Marketing");
        
        Employe e1 = new Employe("acab", "toufik", "bellal");
        Employe e2 = new Employe("acab", "salma", "sfar");
        Employe e3 = new Employe("acab", "daniel", "demeules");
        Employe e4 = new Employe("acab", "yassine", "Khnisi");
        Employe e5 = new Employe("acab", "houssine", "rageud");
        Employe e6 = new Employe("acab", "bob", "max");
        
        Gestionnaire.ajouterEmployeDepartement(e6, d3);
        Gestionnaire.ajouterEmployeDepartement(e5, d2);
        Gestionnaire.ajouterEmployeDepartement(e4, d1);
        Gestionnaire.ajouterEmployeDepartement(e2, d2);
        Gestionnaire.ajouterEmployeDepartement(e3, d3);
        Gestionnaire.ajouterEmployeDepartement(e1, d1);
        
        System.out.println("******Affichage departements");
        
        
            
        
        
    }
    
}
