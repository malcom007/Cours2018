/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreapaExamen2;

/**
 *
 * @author mk
 */
public interface PrepaIDao {
    
    public boolean create(Salle s);
    public boolean delete(Salle dS);
    public boolean update(Salle uS);
    public Salle findById(int id);
    public ArrayList<Salle>
    
}
