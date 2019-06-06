/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premieraplicationbd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        AccesBDResultSet myConnexion = new AccesBDResultSet();
        AccesBDPreparedStatement myConnexionPreparedStatement = new AccesBDPreparedStatement();

        try {
            
            
            myConnexion.setEtudiantResultSet(85, "Jean", 15, 285);
//            System.out.println("Insertion completé");
            myConnexion.getEtudiantsIf(85);
            
//            System.out.println("\n**** Avec PreparedStatement****\n");
//            myConnexionPreparedStatement.getEtudiantsIf(1001);
//            myConnexionPreparedStatement.setEtudiantResultSet(55, "Jean Paul", 15, 285);
//            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (AucunDonnee e){
            System.out.println(e.getMessage());
        }
        finally {

            try {
                //myConnexion.getDisconnect();
                myConnexionPreparedStatement.getDisconnect();
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
