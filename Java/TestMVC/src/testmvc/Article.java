/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmvc;

/**
 *
 * @author Mery
 */
public class Article {
   private String codeArticle;
   private String designationArticle;
   private String codeCategorie;
   private double prixUnitaire;
   //constructeurs
public Article() {
        this.codeArticle = codeArticle;
        this.designationArticle = designationArticle;
        this.codeCategorie = codeCategorie;
        this.prixUnitaire = prixUnitaire;
    }
   
    public Article(String codeArticle, String designationArticle, String codeCategorie, double prixUnitaire) {
        this.codeArticle = codeArticle;
        this.designationArticle = designationArticle;
        this.codeCategorie = codeCategorie;
        this.prixUnitaire = prixUnitaire;
    }
    
//Les getters et les setters

    public String getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(String codeArticle) {
        this.codeArticle = codeArticle;
    }

    public String getDesignationArticle() {
        return designationArticle;
    }

    public void setDesignationArticle(String designationArticle) {
        this.designationArticle = designationArticle;
    }

    public String getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        this.codeCategorie = codeCategorie;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
   
}
