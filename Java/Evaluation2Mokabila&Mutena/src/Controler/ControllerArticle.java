/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Exceptions.EmptyFiled;
import Exceptions.AucunDonnee;
import Exceptions.AucunDonneeCat;

import Model.ModeleVueArticle;
import Exceptions.NoYetConnection;
import Vue.VueArticle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author malcom
 */
public class ControllerArticle {

    private VueArticle viewArticle;
    private ModeleVueArticle modelArtilce;

    private static int countEventP = 0, countEventD = 0;

    public ControllerArticle(VueArticle vue, ModeleVueArticle model) throws SQLException {
        this.modelArtilce = model;
        this.viewArticle = vue;

        //Adding a Observer to our model
        model.addObserver(vue);

        vue.getjTxtCodeArticle().setEnabled(false);
        vue.getjTxtCodeCategorie().setEnabled(false);
        vue.getjTxtDesignation().setEnabled(false);
        vue.getjTxtPrixUnit().setEnabled(false);

        vue.getjBtnPremier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    modelArtilce.getFirstArticle();

                    countEventP++;

                    if (countEventP >= 2) {
                        throw new AucunDonnee("Vous êtes deja au premier ");
                    }

                    //jBtnPremier(e);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {
                    countEventP = 0;
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }

        });

        vue.getjBtnSuivant().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelArtilce.getNextArticle();

                } catch (SQLException ex) {
                    Logger.getLogger(ControllerArticle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AucunDonnee ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        vue.getjBtnPrecedent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelArtilce.getPreviousArticle();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        vue.getjBtnDernier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    modelArtilce.getLastArticle();

                    countEventD++;
                    System.out.println("count btn Dernier " + countEventD);

                    if (countEventD >= 2) {
                        //countEventD=0;
                        throw new AucunDonnee("Vous êtes deja au dernier");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {

                    countEventD = 0;
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        vue.getjBtnAnnuler().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelArtilce.getReturnABeforeCreatingArticle();

                    //Activation des boutons
                    vue.getjBtnAjout().setEnabled(false);
                    vue.getjBtnAnnuler().setEnabled(false);

                    vue.getjBtnNouveau().setEnabled(true);
                    vue.getjBtnDernier().setEnabled(true);
                    vue.getjBtnModifier().setEnabled(true);
                    vue.getjBtnPrecedent().setEnabled(true);
                    vue.getjBtnPremier().setEnabled(true);
                    vue.getjBtnSuivant().setEnabled(true);
                    vue.getjBtnSupprimer().setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Ajout de l'articlé annulé");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {
                    //Activation des boutons
                    vue.getjBtnAjout().setEnabled(false);
                    vue.getjBtnAnnuler().setEnabled(false);

                    vue.getjBtnNouveau().setEnabled(true);
                    vue.getjBtnDernier().setEnabled(true);
                    vue.getjBtnModifier().setEnabled(true);
                    vue.getjBtnPrecedent().setEnabled(true);
                    vue.getjBtnPremier().setEnabled(true);
                    vue.getjBtnSuivant().setEnabled(true);
                    vue.getjBtnSupprimer().setEnabled(true);

                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        vue.getjBtnAjout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //Activation des boutons
                    vue.getjBtnAjout().setEnabled(false);
                    vue.getjBtnAnnuler().setEnabled(false);

                    vue.getjBtnNouveau().setEnabled(true);
                    vue.getjBtnDernier().setEnabled(true);
                    vue.getjBtnModifier().setEnabled(true);
                    vue.getjBtnPrecedent().setEnabled(true);
                    vue.getjBtnPremier().setEnabled(true);
                    vue.getjBtnSuivant().setEnabled(true);
                    vue.getjBtnSupprimer().setEnabled(true);

                    double prix = Double.valueOf(viewArticle.getjTxtPrixUnit().getText());

                    String codeA = vue.getjTxtCodeArticle().getText();
                    String desigA = vue.getjTxtDesignation().getText();
                    String categA = vue.getjTxtCodeCategorie().getText();

                    if (codeA == "" || desigA == "" && categA == "") {

                        throw new EmptyFiled(" Voud devez renseigner tout le champs!  Categorie disponible 001 - 002 - 003 ");
                    }

                    if (prix <= 1) {

                        throw new NumberFormatException(" Le prix d'article doit etre supperieur a 1$");
                    }

                    model.setArticle(codeA, desigA, categA, prix);

                    vue.getjBtnAnnuler().setEnabled(false);
                    vue.getjBtnAjout().setEnabled(false);
                    vue.getjBtnNouveau().setEnabled(true);

                    JOptionPane.showMessageDialog(null, desigA + " A été ajouté");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonneeCat ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (EmptyFiled ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

                try {
                    model.getReturnABeforeCreatingArticle();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (AucunDonnee ex) {
                    vue.getjTxtCodeArticle().setText("");
                    vue.getjTxtCodeCategorie().setText("");
                    vue.getjTxtDesignation().setText("");
                    vue.getjTxtPrixUnit().setText("");
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

        vue.getjBtnModifier().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double prix = Double.valueOf(viewArticle.getjTxtPrixUnit().getText());

                    String codeA = vue.getjTxtCodeArticle().getText();
                    String desigA = vue.getjTxtDesignation().getText();
                    String categA = vue.getjTxtCodeCategorie().getText();

                    if (codeA == "" || desigA == "" && categA == "") {

                        throw new EmptyFiled(" Voud devez renseigner tout le champs! Categorie disponible 001 - 002 - 003 ");
                    }

                    if (prix <= 1) {

                        throw new NumberFormatException("Voudez entrer un prix supérieur a 1$");
                    }

                    modelArtilce.modifydArticle(codeA, desigA, categA, prix);

                    JOptionPane.showMessageDialog(null, "Articlé modifié avec succès!");

                    modelArtilce.getReturnABeforeCreatingArticle();

                } catch (SQLException ex) {
                    Logger.getLogger(ControllerArticle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AucunDonnee ex) {
                    Logger.getLogger(ControllerArticle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EmptyFiled ex) {
                    Logger.getLogger(ControllerArticle.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoYetConnection ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        vue.getjBtnNouveau().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vue.getjBtnAjout().setEnabled(true);
                vue.getjBtnAnnuler().setEnabled(true);

                vue.getjBtnNouveau().setEnabled(false);
                vue.getjBtnDernier().setEnabled(false);
                vue.getjBtnModifier().setEnabled(false);
                vue.getjBtnPrecedent().setEnabled(false);
                vue.getjBtnPremier().setEnabled(false);
                vue.getjBtnSuivant().setEnabled(false);
                vue.getjBtnSupprimer().setEnabled(false);

                vue.getjTxtCodeArticle().setText("");
                vue.getjTxtCodeCategorie().setText("");
                vue.getjTxtDesignation().setText("");
                vue.getjTxtPrixUnit().setText("");

                vue.getjTxtCodeArticle().setEnabled(true);
                vue.getjTxtCodeCategorie().setEnabled(true);
                vue.getjTxtDesignation().setEnabled(true);
                vue.getjTxtPrixUnit().setEnabled(true);

            }

        });

        vue.getjBtnSupprimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    modelArtilce.deleteArticle();

                    JOptionPane.showMessageDialog(null, "Article supprimé!");

                } catch (AucunDonnee ex) {
                    System.out.println("msg erreur ");
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                } catch (Exception ex) {
                    System.out.println("msg erreur ");
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

    }

}
