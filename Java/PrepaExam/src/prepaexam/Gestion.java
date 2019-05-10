/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepaexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mk
 */
public class Gestion implements InterfaceSociete{
    
    Map<Employe, Departement> MonDepartement= new HashMap<>();

    @Override
    public void ajouterEmployeDepartement(Employe e, Departement d) {
        MonDepartement.put(e, d);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        MonDepartement.remove(e);
    }

    @Override
    public void afficherLesEmployesLeursDepartements() {
        for (Map.Entry<Employe, Departement> maListe : MonDepartement.entrySet()) {
            Employe e= maListe.getKey();
            Departement d= maListe.getValue();
            
            System.out.println(e+" "+d);
            
        }
    }

    @Override
    public void afficherLesEmployes() {
        for (Employe employe : MonDepartement.keySet()) {
            
            System.out.println(employe);
            
        }
    }

    @Override
    public void afficherLesDepartements() {
        for (Departement depart : MonDepartement.values()) {
            System.out.println(depart);
        }
    }

    @Override
    public void afficherDepartement(Employe e) {
        System.out.println(MonDepartement.get(e));
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return MonDepartement.containsKey(e);
    }

    @Override
    public boolean rechercherDepartement(Departement e) {
        return MonDepartement.containsValue(e);
    }
    
}
