/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmvc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author Mery
 */
public class ModeleVueArticle extends Observable {
 
      
      private static final String hote = "jdbc:derby://localhost:1527/Cohorte384";
    private static final String usager = "malcom007";
    private static final String passwd = "%Adelia12";
      
      private Connection con=null;
      private String sqlc;
      private Statement stmt = null;
      private ResultSet rS;
      private PreparedStatement pstmt;
      
      boolean flat = true;
      
      int index = 0;
      int indexCourant = 1;
    
      public Connection getConnexion(){
          Connection con=null;
          try{
              con=DriverManager.getConnection(hote,usager,passwd);
              stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
              System.out.println("Connexion obtenue");;
          }
          catch(SQLException e){
              e.printStackTrace();
        }
          return con;
          
      }
      
      
    public Statement getStmt() {
        return stmt;
    }
    


      
      public boolean premierArticle(){
          flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
              System.out.println("test "+ rS.toString());
             rS.first();
              System.out.println("Mon indice de départ "+rS.getRow());

                donnees(rS);
               
           
          }
          catch(Exception ex){
              ex.printStackTrace();
          }
      return flat;
      }
      


       
      
      public boolean suivantArticle(){
          flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             
             if(!rS.isLast()){
                rS.next();
                donnees(rS);
              }
             else
                 flat = false;
          }
          catch(Exception ex){
              ex.printStackTrace();
          }
      return flat;
      }
      
      
      
      public boolean dernierArticle(){
      flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             
             if(!rS.isLast()){
                rS.last();
                donnees(rS);
               }
             else
                 flat = false;      
          }
          catch(Exception ex){
              ex.printStackTrace();
          }
      return flat;
      }
      
      
      
      public boolean precedentArticle(){
      flat = true;
          try{
              
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             System.out.println("Jetait en nouveau = " + rS.getRow());
             if(!rS.isFirst() && rS.getRow() != 0){
                rS.previous();
                donnees(rS);
            }
             else{
                 flat = false;
                 rS.absolute(index);
             }
          }
          catch(Exception ex){
          }
      return flat;
      }
      
      
      
      public boolean nouveauArticle(){
      flat = true;
          try{
              
             if(index != 0){indexCourant = index;}
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             
            }
          catch(Exception ex){
              ex.printStackTrace();
              flat = false;
          }
      return flat;
      }
      
      
              
              
      public boolean annulerArticle(){
      flat = true;
          try{
             
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(indexCourant);
             donnees(rS);
            }
          catch(Exception ex){
              ex.printStackTrace();
              flat = false;
          }
      return flat;
      }
      
      
      public boolean ajouterArticle(String codeArticle, String desigArticle, String codeCategorie, double prixArticle){
      flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             
             donneesNouveau(rS, codeArticle, desigArticle, codeCategorie, prixArticle);
            }
          catch(Exception ex){
              ex.printStackTrace();
              flat = false;
          }
      return flat;
      }
      
      
      
       public boolean modifierArticle(String codeArticle, String desigArticle, String codeCategorie, double prixArticle){
      flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             donneesUpdate(rS, codeArticle, desigArticle, codeCategorie, prixArticle);
            }
          catch(Exception ex){
              ex.printStackTrace();
              flat = false;
          }
      return flat;
      }
      
      
      
      public boolean supprimerArticle(){
      flat = true;
          try{
             rS = coxSql("Select * from ARTICLE");
             rS.absolute(index);
             rS.deleteRow();
             rS.first();
             donnees(rS);
            }
          catch(Exception ex){
              ex.printStackTrace();
              flat = false;
          }
      return flat;
      }
      
      
            
    public ResultSet coxSql(String query) throws SQLException{
           con=DriverManager.getConnection(hote,usager,passwd);
           sqlc= query;
           return stmt.executeQuery(sqlc);

    }
    
      
    public void donnees( ResultSet rS ) throws SQLException{
      
      Article art = new Article(); 
        art.setCodeArticle(rS.getString(1));
        art.setDesignationArticle(rS.getString(2));
        art.setCodeCategorie(rS.getString(3));
        art.setPrixUnitaire(rS.getDouble(4));
        System.out.println("Nom Article "+rS.getString(2));
        System.out.println(rS.getRow());

        setChanged();
        notifyObservers(art);
        
     index = getStmt().getResultSet().getRow();
      }
    
    
    public void donneesNouveau( ResultSet rS, String s1, String s2, String s3, double p1 ) throws SQLException{
  
       System.out.println(" Valuer s1 = " + s1);
        System.out.println(" Valuer s2 = " + s2);
        System.out.println(" Valuer s3 = " + s3);
        System.out.println(" Valuer p1 = " + p1);
        
      rS.moveToInsertRow();
      rS.updateString(1, s3);
      rS.updateString(2, s1);
      rS.updateString(3, s2);
      rS.updateDouble(4, p1);
      rS.insertRow();
      
  
      index = getStmt().getResultSet().getRow();
      
      Article art = new Article(); 
        art.setCodeArticle(rS.getString(1));
        art.setDesignationArticle(rS.getString(2));
        art.setCodeCategorie(rS.getString(3));
        art.setPrixUnitaire(rS.getDouble(4));
        

        System.out.println(getStmt().getResultSet().getRow());

        setChanged();
        notifyObservers(art);

     
      }
      
    
    public void donneesUpdate( ResultSet rS, String s1, String s2, String s3, double p1 ) throws SQLException{
  
       System.out.println(" Valuer s1 = " + s1);
        System.out.println(" Valuer s2 = " + s2);
        System.out.println(" Valuer s3 = " + s3);
        System.out.println(" Valuer p1 = " + p1);
       
      rS.updateString(1, s3);
      rS.updateString(2, s1);
      rS.updateString(3, s2);
      rS.updateDouble(4, p1);
      rS.updateRow();      
  
      index = getStmt().getResultSet().getRow();
      
      Article art = new Article(); 
        art.setCodeArticle(rS.getString(1));
        art.setDesignationArticle(rS.getString(2));
        art.setCodeCategorie(rS.getString(3));
        art.setPrixUnitaire(rS.getDouble(4));
        

        System.out.println(getStmt().getResultSet().getRow());

        setChanged();
        notifyObservers(art);

     
      }
      

}
