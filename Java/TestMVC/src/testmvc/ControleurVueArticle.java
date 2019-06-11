/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TALLER
 */
public class ControleurVueArticle {
    
    private VueArticle vue;
    private ModeleVueArticle model;
    
    String codeArticle, desigArticle, codeCategorie;
    double prixArticle;
    
    public ControleurVueArticle(VueArticle vue, ModeleVueArticle model) {
        this.vue = vue;
        this.model = model;
        
        model.addObserver(vue);
        
        vue.getPrecedent().setEnabled(false);        
        vue.getAjouter().setEnabled(false);
        vue.getAnnuler().setEnabled(false);
        
        vue.getPremier().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButPremierAP(e);
            }
        });
        
        vue.getDernier().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.getPrecedent().setEnabled(true);  
                vue.getSuivant().setEnabled(false); 
                jButDernierAP(e);
            }
        });
        
        vue.getSuivant().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.getPrecedent().setEnabled(true);   
                jButSuivantAP(e);
            }
        });
        
        vue.getPrecedent().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.getSuivant().setEnabled(true); 
                jButPrecedentAP(e);
            }
        });
        
        
        vue.getNouveau().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.getPremier().setEnabled(false);
                vue.getSuivant().setEnabled(false);
                vue.getPrecedent().setEnabled(false);
                vue.getDernier().setEnabled(false);
                vue.getNouveau().setEnabled(false);
                vue.getSupprimer().setEnabled(false);
                vue.getSupprimer().setEnabled(false);
                vue.getModifier().setEnabled(false);
                vue.getAjouter().setEnabled(true);
                vue.getAnnuler().setEnabled(true);
                jButNouveauAP(e);
            }
        });
        
        
        vue.getAnnuler().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.getPremier().setEnabled(true);
                vue.getSuivant().setEnabled(true);
                vue.getPrecedent().setEnabled(true);
                vue.getDernier().setEnabled(true);
                vue.getNouveau().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getModifier().setEnabled(true);
                jButAnnulerAP(e);
            }
        });
        
        
        vue.getAjouter().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButAjouterAP(e);
                vue.getPremier().setEnabled(true);
                vue.getSuivant().setEnabled(true);
                vue.getPrecedent().setEnabled(true);
                vue.getDernier().setEnabled(true);
                vue.getNouveau().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getModifier().setEnabled(true);
            }
        });
        
        
        vue.getModifier().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButModifierAP(e);
            }
        });
        
        
        vue.getSupprimer().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButSupprimerAP(e);
            }
        });
        
        
    }
    
    
    
    
    
    
    
    public void jButPremierAP (ActionEvent e){
        if(!model.premierArticle())
            JOptionPane.showMessageDialog(vue.getPremier(), " On est dÈja sur le premier item. ");
    };
    
    public void jButSuivantAP (ActionEvent e){
        if (!model.suivantArticle())
             JOptionPane.showMessageDialog(vue.getPremier(), " Il y a plus Items  ");

    };
    
    public void jButDernierAP (ActionEvent e){
        if(!model.dernierArticle())
            JOptionPane.showMessageDialog(vue.getPremier(), " On est dÈja sur le denier item. ");

    };
    

    public void jButPrecedentAP (ActionEvent e){
        if (!model.precedentArticle())
            JOptionPane.showMessageDialog(vue.getPremier(), " Il y a pas un Item Precedent ");

    };
    
    
    public void jButNouveauAP (ActionEvent e){
        vue.getCodeA().setText("");
        vue.getDesA().setText("");
        vue.getCodeC().setText("");
        vue.getPrix().setText("");
        if (!model.nouveauArticle()){
            JOptionPane.showMessageDialog(vue.getPremier(), " Oups Erreur de suppretion! ");}

    };
    
    
    
    
    public void jButAnnulerAP (ActionEvent e){
        if (!model.annulerArticle()){
            JOptionPane.showMessageDialog(vue.getPremier(), " Oups Erreur d annulation! ");}

    };
    
    
    public void jButAjouterAP (ActionEvent e){
        
        try {
            codeArticle = vue.getCodeA().getText();
            desigArticle = vue.getDesA().getText();
            codeCategorie = vue.getCodeC().getText();
            prixArticle = Double.parseDouble(vue.getPrix().getText());

            if (!model.ajouterArticle(codeArticle, desigArticle, codeCategorie, prixArticle)){
                JOptionPane.showMessageDialog(vue.getPremier(), " Oups Erreur d ajoute! ");}
            else{
                JOptionPane.showMessageDialog(vue.getPremier(), " Item a ete ajoutÈ ");

                // Enableds buttons
                vue.getPremier().setEnabled(true);
                vue.getSuivant().setEnabled(true);
                vue.getPrecedent().setEnabled(true);
                vue.getDernier().setEnabled(true);
                vue.getNouveau().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getSupprimer().setEnabled(true);
                vue.getModifier().setEnabled(true);
        }
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(vue.getPremier(),
                    " Sil vous plait, Entrez les donnees correctement");
            
            vue.getCodeA().setText("");
            vue.getDesA().setText("");
            vue.getCodeC().setText("");
            vue.getPrix().setText("");
        }
        

    };
    
    
    public void jButModifierAP (ActionEvent e){
        
        try {
            codeArticle = vue.getCodeA().getText();
            desigArticle = vue.getDesA().getText();
            codeCategorie = vue.getCodeC().getText();
            prixArticle = Double.parseDouble(vue.getPrix().getText());

            if (!model.modifierArticle(codeArticle, desigArticle, codeCategorie, prixArticle)){
                JOptionPane.showMessageDialog(vue.getPremier(), " Oups Erreur de modification! ");}
            else{
                JOptionPane.showMessageDialog(vue.getPremier(), " Item a ete modifie ");

        }
        } catch (Exception ex) {
            
        }
        

    };
    
    
    
    
    
    
    public void jButSupprimerAP (ActionEvent e){
        
        try {
            if (!model.supprimerArticle()){
                JOptionPane.showMessageDialog(vue.getPremier(), " Oups Erreur de suppretion! ");}
            else
            {JOptionPane.showMessageDialog(vue.getPremier(), " Item a ete supprime ");}
        
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(vue.getPremier(),
                    " Sil vous plait, Cherchez les donnees que vous voulez supprimer");
            
        }
        

    };
    
    
    
    
    
    
    
    

    
}
