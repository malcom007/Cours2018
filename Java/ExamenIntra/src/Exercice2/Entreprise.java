/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mk
 */
public class Entreprise {

    private String nom;
    private ArrayList<Employe> employes = new ArrayList<>();

    public Entreprise(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void ajouter(Employe emp) throws EmployeExistantException, invalidSetEntrepriseException {
        for (Employe employe : employes) {
            if (employe.getNom()==(emp.getNom())) {
                throw new EmployeExistantException(emp.getNom() + " Employé existant");

            }

        }

        Entreprise sonEntreprise = emp.getEntreprise();
        if (sonEntreprise != null) {
            sonEntreprise.employes.remove(emp);
        }

        emp.setEntreprise(this);
    }

    public void enleverEmploye(Employe emp) throws RetraitEmployeException, invalidSetEntrepriseException {
        if (!employes.remove(emp)) {
            throw new RetraitEmployeException(" Aucun employé portant le nom de: " + emp.getNom());
        }
        emp.setEntreprise(null);
    }

    public String toString() {
        StringBuilder emp
                = new StringBuilder(nom + ": \n");

        for (Employe employe : employes) {
            emp.append("\t" + employe.getNom() + "\n");
        }

        return emp.toString();
    }

}
