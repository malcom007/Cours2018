/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lescollectionsgeneriques;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mk
 */
public class SalleService implements IDao {

    ArrayList<Salle> listeSalles = new ArrayList<>();

    @Override
    public boolean Create(Salle maSalle) {

        return listeSalles.add(maSalle);
    }

    @Override
    public boolean delete(Salle maSalle) {

        return listeSalles.remove(maSalle);
    }

    @Override
    public boolean update(Salle o) {

        for (Salle maSalle : listeSalles) {

            if (maSalle.getId() == o.getId()) {
                maSalle.setCode(o.getCode());
                maSalle.setLibelle(o.getLibelle());
                return true;

            }
        }
        return false;
    }

    @Override
    public Salle findById(int id) {

        for (Salle MaSalle : listeSalles) {
            if (MaSalle.getId() == id) {

                return MaSalle;

            }
        }
        return null;
    }

    @Override
    public ArrayList<Salle> findAll() {
        return listeSalles;
    }

}
