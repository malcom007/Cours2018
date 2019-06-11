/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author malcom
 */
public class Article {
    
    private String codeA, designationA, codeCategA;
    private double prixA;

    
    //Mes constructeurs
    public Article() {
        
    }    
    public Article(String CodeA, String designationA, String codeCategA, double prixA){
        this.codeA=CodeA;
        this.designationA=designationA;
        this.codeCategA=codeCategA;
        this.prixA=prixA;
    }
    
    
    //Les ascesseurs
    public String getCodeA() {
        return codeA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public String getDesignationA() {
        return designationA;
    }

    public void setDesignationA(String designationA) {
        this.designationA = designationA;
    }

    public String getCodeCategA() {
        return codeCategA;
    }

    public void setCodeCategA(String codeCategA) {
        this.codeCategA = codeCategA;
    }

    public double getPrixA() {
        return prixA;
    }

    public void setPrixA(double prixA) {
        this.prixA = prixA;
    }
    
    
    
}
