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
public class AccesBDResultSet {

    private static String hote = "jdbc:derby://localhost:1527/Cohorte384";
    private static String usager = "malcom007";
    private static String passwd = "%Adelia12";

    private Connection myConnection = null;
    private String sqlc;
    private Statement stmt;
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

    public void getEtudiants() {
        try {
            myConnection = getConnection();

            //ResultSet est une equivalence de Cursor Dans oracle
            //TYPE_SCROLL_SENSITIVE permet d'avancer et de reculler
            //CONCUR_UPDATABLE 
            stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            sqlc = "Select * from art";
            rS = stmt.executeQuery(sqlc);
            while (rS.next()) {
                System.out.println(rS.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rS.close();
                stmt.close();
                myConnection.close();
            } catch (Exception e) {
                Logger.getLogger(AccesBDResultSet.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void getEtudiantsWhere(int num) throws SQLException, AucunDonnee {

        myConnection = getConnection();

        //ResultSet est une equivalence de Cursor Dans oracle
        //TYPE_SCROLL_SENSITIVE permet d'avancer et de reculler
        //CONCUR_UPDATABLE                 
        stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        sqlc = "Select * from Etudiant where numetudiant= " + num;
        rS = stmt.executeQuery(sqlc);

        if (rS != null) {
            System.out.println(rS.getString(2));

        } else {
            throw new AucunDonnee("Aucune correspondance avec l'id: " + num);
        }

    }

    public void getEtudiantsIf(int id) throws SQLException, AucunDonnee {

        myConnection = getConnection();

        //ResultSet est une equivalence de Cursor Dans oracle
        //TYPE_SCROLL_SENSITIVE permet d'avancer et de reculler
        //CONCUR_UPDATABLE 
        stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        sqlc = "Select * from Etudiant";
        rS = stmt.executeQuery(sqlc);
        int trouveCount = 0;
        while (rS.next()) {
            if (rS.getInt(1) == id) {
                System.out.println(rS.getString(2));
                trouveCount = 1;
            }

        }
        if (trouveCount != 1) {
            throw new AucunDonnee("Aucune correspondance avec l'id " + id);

        }
    }

    public void getDisconnect() throws SQLException {
        stmt.close();
        rS.close();
        myConnection.close();
        System.out.println("Deconnection a la base de donnée");

    }

    public void setEtudiantResultSet(int num, String nom, double note, int numgroup) throws SQLException {

        myConnection = getConnection();

        //ResultSet est une equivalence de Cursor Dans oracle
        //TYPE_SCROLL_SENSITIVE permet d'avancer et de reculler
        //CONCUR_UPDATABLE                 
        stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        sqlc = "Select * from Etudiant ";
        rS = stmt.executeQuery(sqlc);
        
        //On demande a resultSet de changer vers l'insertion d'une ligne
        rS.moveToInsertRow();
        rS.updateInt(1, num);
        rS.updateString(2, nom);
        rS.updateDouble(3, note);
        rS.updateInt(4, numgroup);
        rS.insertRow();
        rS.moveToCurrentRow();
        
        System.out.println("Fonntion");
    }
    
    

}
