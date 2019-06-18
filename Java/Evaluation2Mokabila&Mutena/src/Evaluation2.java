/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Controler.ControllerArticle;
import Exceptions.AucunDonnee;
import Exceptions.finArticle;
import Model.ModeleVueArticle;
import Vue.VueArticle;
import java.sql.SQLException;

/**
 *
 * @author mk
 */
public class Evaluation2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        ModeleVueArticle myModel = new ModeleVueArticle();
        
        VueArticle myView = new VueArticle();  

        
        try {
            
            ControllerArticle controlleur = new ControllerArticle(myView, myModel);
            
            myView.setVisible(true);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        
   
        
    }
    
}
