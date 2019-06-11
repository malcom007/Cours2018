/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.AucunDonnee;
import Vue.HeureSystem;
import Exceptions.finArticle;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Observable;

/**
 *
 * @author mk
 */
public class ModeleVueArticle extends Observable{

    private static final String hote = "jdbc:derby://localhost:1527/Cohorte384";
    private static final String usager = "malcom007";
    private static final String passwd = "%Adelia12";

    private Connection myConnection = null;
    private String sqlc;
    private Statement stmt;
    private ResultSet rS;

    private static Timestamp timestamp;
    HeureSystem timeStampe = new HeureSystem();

    private boolean testConnexion, verifyTest=true;

    private static final String CREATE_TABLE_ARTICLE_SQL = "CREATE TABLE Article ("
            + "CodeArticle Varchar(5),"
            + "DesignationA Varchar(50) NOT NULL,"
            + "CodeCat Varchar(5) "
            + "CONSTRAINT ARTICL_FK_CODCAT REFERENCES Categorie(CodeCateg),"
            + "Prix Double,"
            + "LastModfied TimeStamp,"
            + "PRIMARY KEY (CodeArticle))";

    private static final String CREATE_TABLE_CATEGORIE_SQL = "CREATE TABLE Categorie ("
            + "CodeCateg Varchar(5),"
            + "DesignationC Varchar(50) NOT NULL,"
            + "PRIMARY KEY (CodeCateg))";

    PreparedStatement preparedStatementInsert = null;

    String insertTableSQL = "INSERT INTO ARTICLE (CODEARTICLE, DesignationA, CodeCat, PRIX,LASTMODFIED) VALUES (?,?,?,?,?)";

    public Connection getDBConnection() {

        Connection myConnection = null;
        System.out.println("Connecting to a selected database...");

        try {
            myConnection = DriverManager.getConnection(hote, usager, passwd);
            System.out.println("\nConnected database successfully   " + getCurrentTimeStamp() + "\n");
            testConnexion = true;
        } catch (SQLException e) {
            System.out.println("\nErreur de connexion a la base de données, verifier le mot de passe ou login à " + getCurrentTimeStamp() + "\n");
            testConnexion = false;
        }
        return myConnection;
    }
    
    public void getFirstArticle() throws SQLException{
        getDBConnection();
        
        rS= prepareStatementQuery("Select * from Article");
        
        
        
        
        
    }
    /***
     * Medhode permettant d'envoyer des requette de type Select 
     * Pour le ResultSet
     * @param SQL_SELECT
     * @return
     * @throws SQLException 
     */
    private ResultSet prepareStatementQuery(String SQL_SELECT) throws SQLException{
        
        preparedStatementInsert = myConnection.prepareStatement(SQL_SELECT);
        
        return preparedStatementInsert.executeQuery();
    }

    /**
     * *
     * Ajout d'un nouveau article
     *
     * @param codeArticle
     * @param designation
     * @param codeCategorie
     * @param Prix
     */
    public void setArticle(String codeArticle, String designation, String codeCategorie, double Prix) throws SQLException, AucunDonnee {
        
        sqlc = "SELECT COUNT(CODECATEG) (CODEARTICLE, DesignationA, CodeCat, PRIX,LastModfied) VALUES (?,?,?,?,?)";
        
        verifyIdArticle(codeArticle);
        System.out.println(verifyTest);
        
        if (verifyTest) {
            verifyIfCategory(codeCategorie);
            

            //On appelle la methode getConnection    
            if (verifyTest) {
                myConnection = getDBConnection();                
                

                preparedStatementInsert = myConnection.prepareStatement(insertTableSQL);
                preparedStatementInsert.setString(1, codeArticle);
                preparedStatementInsert.setString(2, designation);
                preparedStatementInsert.setString(3, codeCategorie);
                preparedStatementInsert.setDouble(4, Prix);

                preparedStatementInsert.setTimestamp(5, getCurrentTimeStamp());

                preparedStatementInsert.executeUpdate();
                

                System.out.println("Insertion du :   " + designation + " completé à " + timeStampe.getCurrentTimeStamp());

                System.out.println("\nDeconnexiont à la BD à " + getCurrentTimeStamp() + "\n");
                getDisconnect();
            }            
                
        }

        

    }

    public void getAllArticles() throws Exception {
        
            myConnection = getDBConnection();

            stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            sqlc = "Select * from article ";

            rS = stmt.executeQuery(sqlc);

            while (rS.next()) {
                System.out.println(rS.getString(2) + " " + rS.getString(5));
                
            }
            if (!rS.next()) {
                throw new finArticle("Vous êtes au dernier article ");
                
            }
            
//            while (rS.previous()) {
//                System.out.println("avant dernier article "+rS.getString(2)+" "+rS.getString(5));
//            }
//            
//
//            
//
//            if (!rS.previous()) {
//                throw new finArticle("Vous êtes au premier article !");
//            }
    }
            
            
            
            

        

    

    
public void createTableCategorie() throws SQLException {
        //Connection a la base de données
        myConnection = getDBConnection();

        try {
            testConnexion = ifTableExist("Categorie");

            stmt = myConnection.createStatement();

            if (testConnexion) {
                stmt.executeUpdate("DROP TABLE Categorie");
                System.out.println("Table supprimé  ");
            } else {
                stmt.executeUpdate(CREATE_TABLE_CATEGORIE_SQL);
                System.out.println("Table Categorie Created " + getCurrentTimeStamp() + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void createTableArticle() throws SQLException {
        //Connection a la base de données
        testConnexion = true;

        try {

            myConnection = getDBConnection();
            testConnexion = ifTableExist("Article");
            stmt = myConnection.createStatement();
            System.out.println(testConnexion + " ma connexion");

            if (testConnexion) {
                stmt.executeUpdate("DROP TABLE Article");
                System.out.println("Table supprimé  ");
            } else {
                System.out.println("Creation article");
                stmt.executeUpdate(CREATE_TABLE_ARTICLE_SQL);
                System.out.println("Table Article created  " + getCurrentTimeStamp() + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (myConnection != null) {
                    myConnection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * *
     * Methode permettant de recuperer l'heureDuSystème
     *
     * @return
     */
    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

    /**
     * *
     * Methode qui permet de verifier si la table existe
     *
     * @return
     * @throws SQLException
     */
    private boolean ifTableExist(String tableName) throws SQLException {

        sqlc = "select * from " + tableName + " where 1=0";

        stmt = (Statement) myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            rS = stmt.executeQuery(sqlc);
            rS.close();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("\n*** Creation de la table ***\n");
            return false;
        }
    }

    private void verifyIfCategory(String id) throws SQLException, AucunDonnee {
        verifyTest=false;

        sqlc = "Select CODECATEG from Categorie where CODECATEG=?";
        myConnection = getDBConnection();
        preparedStatementInsert = myConnection.prepareStatement(sqlc);

        int trouveCount = 0;

        preparedStatementInsert.setString(1, id.toUpperCase());

        rS = preparedStatementInsert.executeQuery();

        while (rS.next()) {
            System.out.println(rS.getString(1));
            trouveCount = 1;
            verifyTest=true;

        }

        if (trouveCount != 1) {
            verifyTest = false;
            throw new AucunDonnee("Aucune catégorie ayant l'id: " + id);
        }
        getDisconnect();

    }

    private void getDisconnect() throws SQLException {
        preparedStatementInsert.close();
        //rS.close();
        myConnection.close();
        System.out.println("Deconnection a la base de donnée à " + getCurrentTimeStamp());

    }

    private void verifyIdArticle(String codeArticle) throws SQLException, AucunDonnee {
        

        sqlc = "Select CodeArticle from ARTICLE where CodeArticle=?";
        myConnection = getDBConnection();
        preparedStatementInsert = myConnection.prepareStatement(sqlc);

        

        preparedStatementInsert.setString(1, codeArticle.toLowerCase());

        rS = preparedStatementInsert.executeQuery();

        while (rS.next()) {
            verifyTest = true;
            System.out.println(rS.getString(1).toUpperCase());
            getDisconnect();
            
            throw new AucunDonnee("ID " + codeArticle.toUpperCase()+" Existant, aucun doublon possible");

        }

        
        

    }

  

}
