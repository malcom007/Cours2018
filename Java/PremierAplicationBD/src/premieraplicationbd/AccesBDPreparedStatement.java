/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package premieraplicationbd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mk
 */
public class AccesBDPreparedStatement {

    private static final String hote = "jdbc:derby://localhost:1527/Cohorte384";
    private static final String usager = "malcom007";
    private static final String passwd = "%Adelia12";

    private Connection myConnection = null;
    private String sqlc;
    private PreparedStatement pstmt;
    private ResultSet rS;

    public Connection getConnection() {
        //Connection myConnection = null;

        try {
            myConnection = DriverManager.getConnection(hote, usager, passwd);

            System.out.println("Connexion à la base de donnée établie");
        } catch (Exception e) {
            System.err.println("Erreur de connexion " + e.getMessage());
        }
        return myConnection;
    }

    
    public void getEtudiantsIf(int id) throws SQLException, AucunDonnee {

        myConnection = getConnection();

        
        sqlc = "Select * from Etudiant where numetudiant=?";
        
        int trouveCount = 0;
        
        pstmt = myConnection.prepareStatement(sqlc);
        
        pstmt.setInt(1, id);
        
        rS = pstmt.executeQuery();
        
        while (rS.next()) {            
            System.out.println(rS.getString(2));
            trouveCount=1;
        }

        if (trouveCount != 1) {
            throw new AucunDonnee("Aucune catégorie portant ayant l'id: " + id);

        }
    }

    public void getDisconnect() throws SQLException {
        pstmt.close();
        //rS.close();
        myConnection.close();
        System.out.println("Deconnection a la base de donnée");

    }

    public void setEtudiantResultSet(int num, String nom, double note, int numgroup) throws SQLException {

        myConnection = getConnection();
        sqlc = "Insert Into Etudiant(numetudiant, nom, note,numgroupe) "
                + "values (?,?,?,?)";
                     
        pstmt = myConnection.prepareStatement(sqlc);
        pstmt.setInt(1, num);
        pstmt.setString(2, nom);
        pstmt.setDouble(3, note);
        pstmt.setInt(4, numgroup);
        
        //Permet d'envoyer l'ajout
        pstmt.executeUpdate();
        System.out.println("ca marche");
        
        

    }
    
    

}
