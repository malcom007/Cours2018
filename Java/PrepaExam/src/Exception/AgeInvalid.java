/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author mk
 */
public class AgeInvalid extends Exception {

    public AgeInvalid(String age_inferieur_a_1) {
        super(age_inferieur_a_1);
    }
    
}
