/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Exceptions.AucunDonnee;
import Exceptions.finArticle;
import Model.ModeleVueArticle;
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
        
        ModeleVueArticle myConnexion = new ModeleVueArticle();
        
        
        
        /*new VueArticle().setVisible(true);*/
        String codeArticle =" 007", designation="Galaxy S9 ", codeCategorie="CAT01";
        double prix = 795.58;
        
        try {
            
            myConnexion.setArticle(codeArticle, designation, codeCategorie, prix);
            myConnexion.getAllArticles();
            
          
            
                
        }
        catch(AucunDonnee e){
            System.out.println(e.getMessage());
            
        } 
        catch(finArticle d){
            System.out.println(d.getMessage());
        }
        catch (Exception e) {
        }
        
        
        
   
        
    }
    
}
