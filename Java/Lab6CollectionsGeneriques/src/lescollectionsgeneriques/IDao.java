/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lescollectionsgeneriques;

import java.util.ArrayList;

/**
 *
 * @author mk
 */
public interface IDao {
    
    /**
     * Méthode permettant d'ajouter un objet o de type Salle.
     * @param maSalle
     * @return 
     */
    public boolean Create(Salle maSalle);
    
    /**
     * Méthode permettant de supprimer un objet o de type Salle.
     * @param maSalle
     * @return 
     */
    public boolean delete(Salle maSalle);
    
    /**
     * Méthode permettant de modifier un objet o de type Salle.
     * @param maSalle
     * @return 
     */
    public boolean update(Salle maSalle);
    
    /**
     * Méthode permettant de renvoyer un objet(Salle) dont id est passé en paramètre.
     * @param id
     * @return 
     */
    public Salle findById(int id);
    
    /**
     * Méthode permettant de renvoyer la liste des objets(Salles) de type Salle.
     * @return 
     */
    public ArrayList<Salle> findAll();
    
    
}
