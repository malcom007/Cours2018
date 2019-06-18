/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Exceptions.NoYetConnection;
import Exceptions.AucunDonneeCat;
import Exceptions.AucunDonnee;
import Vue.HeureSystem;
import Exceptions.finArticle;
import java.nio.channels.NotYetConnectedException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.Observable;

/**
 *
 * @author mk
 */
public class ModeleVueArticle extends Observable {

    private static final String hote = "jdbc:derby://localhost:1527/Evaluation2";
    private static final String usager = "malcom007";
    private static final String passwd = "%Nathan12";

    private Connection myConnection = null;
    private String sqlc;
    private Statement stmt;
    private ResultSet rS;

    private int lastPosition;

    private Article article;

    private static Timestamp timestamp;
    HeureSystem timeStampe = new HeureSystem();

    private boolean testConnexion, verifyTest = true, verifyCat = true;

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

    PreparedStatement pstmt = null;

    String insertTableSQL = "INSERT INTO ARTICLE (CODEARTICLE, DesignationA, CodeCat, PRIX,LASTMODFIED) VALUES (?,?,?,?,?)";

    public Connection getDBConnection() throws NoYetConnection {

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

    /**
     * *
     * Methode permettant de recuperer le premier article
     *
     * @throws SQLException
     * @throws AucunDonnee
     */
    public void getFirstArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select * from Article";

        myConnection = getDBConnection();

        rS = prepareStatementQuery(sqlc);

        //On se positionne au premier produit
        rS.first();

        if (!rS.first()) {

            throw new AucunDonnee("Il n'y a aucune donnée dans la base de donnée");
        }

        createArticle(rS);

        getDisconnect();

    }

    public void getLastArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select * from Article";
        myConnection = getDBConnection();

        rS = prepareStatementQuery(sqlc);

        //On se positionne au dernier
        rS.last();

        if (!rS.last()) {

            throw new AucunDonnee("Il n'y a aucune donnée dans la base de donnée");
        }

        createArticle(rS);

        getDisconnect();

    }

    public void getNextArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select * from Article";
        myConnection = getDBConnection();

        rS = prepareStatementQuery(sqlc);
        if (!rS.first()) {

            throw new AucunDonnee("Il n'y a aucune donnée dans la base de donnée");
        }
        rS.absolute(lastPosition);

        if (!rS.next()) {
            throw new AucunDonnee("Vous êtes au dernier, impossible de faire suivant");
        }

        //A supprimer
        System.out.println("Dernier produit " + rS.getString(2));

        createArticle(rS);

        getDisconnect();

    }

    public void getPreviousArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select * from Article";
        myConnection = getDBConnection();

        rS = prepareStatementQuery(sqlc);

        if (!rS.first()) {

            throw new AucunDonnee("Il n'y a aucune donnée dans la base de donnée");
        }

        rS.absolute(lastPosition);

        if (rS.previous()) {
            //Move to previous             
            System.out.println("Precedent sera " + lastPosition);
            createArticle(rS);
        } else {
            throw new AucunDonnee("Vous êtes au Premier!!!!!");
        }

        //A supprimer
        System.out.println("Premier produit " + rS.getString(2));

        getDisconnect();

    }

    /**
     * *
     * Methode permettant de retourne au dernir article avant la création
     *
     * @throws SQLException
     * @throws AucunDonnee
     */
    public void getReturnABeforeCreatingArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select * from Article";

        myConnection = getDBConnection();

        rS = prepareStatementQuery(sqlc);

        if (!rS.first()) {

            throw new AucunDonnee("Aucune donnée a afficher presentement!");
        }

        if (lastPosition < 1) {

            rS.absolute(lastPosition);
        } else {
            rS.absolute(lastPosition - 1);
        }

        rS.next();
        //Move to previous             
        System.out.println("Precedent sera " + lastPosition);
        createArticle(rS);

        getDisconnect();

    }

    /**
     * *
     * Medhode permettant d'envoyer des requette de type Select Pour le
     * ResultSet
     *
     * @param SQL_SELECT
     * @return
     * @throws SQLException
     */
    private ResultSet prepareStatementQuery(String SQL_SELECT) throws SQLException, NoYetConnection {

        myConnection = getDBConnection();
        pstmt = myConnection.prepareStatement(SQL_SELECT, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        return pstmt.executeQuery();
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
    public void setArticle(String codeArticle, String designation, String codeCategorie, double Prix) throws SQLException, AucunDonnee, NoYetConnection, AucunDonneeCat {

        myConnection = getDBConnection();

        verifyIfCategory(codeCategorie);
        System.out.println("SIKA ARTICLE" + verifyCat + " categor est " + codeCategorie);

        if (verifyCat) {

            verifyIdArticle(codeArticle);

            System.out.println("Verification cat est sika " + verifyCat);

            //On appelle la methode getConnection    
            if (verifyTest == true) {

                System.out.println("verify article " + verifyTest);

                pstmt = myConnection.prepareStatement(insertTableSQL);
                pstmt.setString(1, codeArticle.toUpperCase());
                pstmt.setString(2, designation.toUpperCase());
                pstmt.setString(3, codeCategorie.toUpperCase());
                pstmt.setDouble(4, Prix);

                pstmt.setTimestamp(5, getCurrentTimeStamp());

                pstmt.executeUpdate();

            }

        }
        getDisconnect();

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

    private void verifyIfCategory(String id) throws SQLException, AucunDonnee, NoYetConnection, AucunDonneeCat {
        verifyCat = false;

        sqlc = "Select CODECATEG from Categorie where CODECATEG=?";

        pstmt = myConnection.prepareStatement(sqlc);

        int trouveCount = 0;

        pstmt.setString(1, id.toUpperCase());

        rS = pstmt.executeQuery();

        while (rS.next()) {

            trouveCount = 1;
            verifyCat = true;

        }

        pstmt = myConnection.prepareStatement("SELECT * FROM CATEGORIE");
        rS = pstmt.executeQuery();

        String mesCategories = "";

        while (rS.next()) {

            mesCategories += rS.getString(1).toString() + "  ";

        }

        if (trouveCount != 1) {
            verifyCat = false;

            throw new AucunDonneeCat("Aucune catégorie ayant l'id: " + id + "! Categories utilisable : " + mesCategories);
        }

    }

    private void getDisconnect() throws SQLException {
        pstmt.close();
        //rS.close();
        myConnection.close();
        System.out.println("Deconnection a la base de donnée à " + getCurrentTimeStamp());

    }

    private void verifyIdArticle(String codeArticle) throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "Select CodeArticle from ARTICLE where CodeArticle=?";

        pstmt = myConnection.prepareStatement(sqlc);

        pstmt.setString(1, codeArticle.toLowerCase());

        rS = pstmt.executeQuery();

        while (rS.next() || codeArticle == "") {
            verifyTest = false;
            throw new AucunDonnee("ID " + codeArticle.toUpperCase() + " Existant, aucun doublon possible");

        }

    }

    private void createArticle(ResultSet rS) throws SQLException {

        System.out.println("Nous créer un article et ");
        article = new Article();

        article.setCodeA(rS.getString(1));

        article.setDesignationA(rS.getString(2));
        article.setCodeCategA(rS.getString(3));
        article.setPrixA(rS.getDouble(4));

        //On marque comme etant modifié
        setChanged();

        //On notifie l'observer du changement avec l'objet articlé crée
        notifyObservers(article);
        System.out.println("fin de notification ");

        lastPosition = rS.getRow();

        System.out.println("Prochaine position " + lastPosition);

    }

    public void modifydArticle(String newCodeArticle, String designation, String codeCategorie, double Prix) throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "SELECT * FROM ARTICLE ";

        myConnection = getDBConnection();

        pstmt = myConnection.prepareStatement(sqlc, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        rS = pstmt.executeQuery();

        rS.absolute(lastPosition);

        rS.updateString(1, newCodeArticle);
        rS.updateString(2, designation);
        rS.updateString(3, codeCategorie);
        rS.updateDouble(4, Prix);

        rS.updateRow();

        getDisconnect();

    }

    public void deleteArticle() throws SQLException, AucunDonnee, NoYetConnection {

        sqlc = "SELECT * FROM ARTICLE ";

        myConnection = getDBConnection();

        pstmt = myConnection.prepareStatement(sqlc, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        rS = pstmt.executeQuery();

        if (!rS.first()) {
            throw new AucunDonnee("La base de données est vide");
        }

        rS.absolute(lastPosition);
        rS.deleteRow();

        if (!rS.first()) {
            throw new AucunDonnee("Toutes les données ont été supprimées");
        } else {
            getFirstArticle();
        }

        getDisconnect();

    }

    /**
     * *****************************************************************
     *
     * METHODE OPTIONNEL AU CAS IL N'Y A PAS DE PASE DE DONNÉÉ
     *
     ******************************************************************
     */
    public void createTableCategorie() throws SQLException, NoYetConnection {
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

    public void createTableArticle() throws SQLException, NoYetConnection {
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

}
