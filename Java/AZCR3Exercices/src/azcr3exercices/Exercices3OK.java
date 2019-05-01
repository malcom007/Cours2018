/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author mk
 */
public class Exercices3OK extends JFrame{
    
    private JButton jbntOK, jbntAnnuler;
    private JCheckBox tennis, squash, natation, athletisme, randonnee, foot, basket, volley,petanque;
    private JLabel nom, prenom, adresse, sexe, panalInfos;
    private JTextField inputNom, inputprenom;
    private ButtonGroup groupRadio;
    private JRadioButton sexeH, sexeF;
    private JTextArea inputAdress;
    
    
    /**
     * 
     * @param monTitre pour definir le titre de ma fênetre
     */
    public Exercices3OK(String monTitre){
        
        setTitle(monTitre);
        //Taille de mon frame
        setSize(300,400);
        //On centre la fênetre
        setLocationRelativeTo(null);
        //On tue la tâche a la fermeture 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*      -----------------------------------
                Creation de mon conteneur Principal
                -----------------------------------
        */        
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout(5,5));
        MainPanel.setBackground(Color.CYAN);
        //création bordure autour de notre main avec 4px d'épaisseur
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.yellow));
        
        /*      ---------------------------------
                Création des Pannels de division
                ---------------------------------
        */
        //Pannel du centre
        JPanel centerJPanel = new JPanel();
        centerJPanel.setBorder(new LineBorder(Color.BLACK,4));
        centerJPanel.setBackground(Color.ORANGE);
        centerJPanel.setLayout(new BorderLayout());
        //Pannel East
        JPanel eastJPanel = new JPanel();
        eastJPanel.setBorder(new LineBorder(Color.BLACK,4));
        eastJPanel.setBackground(Color.PINK);
        eastJPanel.setLayout(new GridLayout(9,1,5,5));
        //Pannel Sud
        JPanel sudJPanel = new JPanel();
        sudJPanel.setBorder(new LineBorder(Color.BLACK,4));
        sudJPanel.setBackground(Color.MAGENTA);
        sudJPanel.setLayout(new FlowLayout());
        //Fin création des pannels de division
        
        /*      -------------------
                Mes Panels spéciaux
                -------------------
        */
        // Sexes par default a FlowLayout
        JPanel sexeSudPanel = new JPanel(); 
        sexeSudPanel.setBackground(Color.ORANGE);
        JPanel centreNordPanel = new JPanel();
        centreNordPanel.setBackground(Color.ORANGE);
        centreNordPanel.setLayout(new GridLayout(0,1));
        
        
        
        
        //Fin des mes Pannels Spéciaux
        
        /*      -------------------
                  Éléments Centres
                -------------------
        */ 
        nom = new JLabel("Nom");
        inputNom = new JTextField();
        prenom = new JLabel("Prenom");
        inputprenom = new JTextField();
        adresse = new JLabel("Adresse:");
                
        centreNordPanel.add(nom);
        centreNordPanel.add(inputNom);
        centreNordPanel.add(prenom);
        centreNordPanel.add(inputprenom);
        centreNordPanel.add(adresse);
        
        centerJPanel.add(centreNordPanel, BorderLayout.NORTH);
        
        //Adresse
        inputAdress = new JTextArea();        
        //centerJPanel.add(adresse, BorderLayout.NORTH);
        centerJPanel.add(inputAdress);
        
        //Sexes
        sexe = new JLabel("Sexe");
        sexeH = new JRadioButton("Homme");
        sexeF = new JRadioButton("Femme");
        //Intenciation de ButtonGroup
//        groupRadio = new ButtonGroup();
//        groupRadio.add(sexeF);
//        groupRadio.add(sexeH);
        sexeSudPanel.add(sexe);
        sexeSudPanel.add(sexeF);
        sexeSudPanel.add(sexeH);        
        //Ajout
        centerJPanel.add(sexeSudPanel, BorderLayout.SOUTH);
        //Ajout de mon Center au PanelMainPrincipal
        MainPanel.add(centerJPanel, BorderLayout.CENTER);
        
        
        /*      -------------------
                    Éléments Sud
                -------------------
        */        
        jbntOK = new JButton("OK");
        jbntAnnuler = new JButton("Annuler");
        //Ajouts des éléments Sud
        sudJPanel.add(jbntOK);
        sudJPanel.add(jbntAnnuler);
        //Ajout de mon SudPanel au PanelMainPrincipal
        MainPanel.add(sudJPanel, BorderLayout.SOUTH);
        //Fin ajout éléments Sud
        
        //Éléments de mon JPanel East
        tennis = new JCheckBox("Tennis");
        squash = new JCheckBox("Squash");
        natation = new JCheckBox("Natation");
        athletisme = new JCheckBox("Athletisme");
        randonnee = new JCheckBox("Randonnee");
        foot = new JCheckBox("Foot");
        basket = new JCheckBox("Basket");
        volley = new JCheckBox("Volley");
        petanque = new JCheckBox("Petanque");
        //Ajouts des éléments dans le EAST
        eastJPanel.add(tennis);
        eastJPanel.add(squash);
        eastJPanel.add(natation);
        eastJPanel.add(athletisme);
        eastJPanel.add(randonnee);
        eastJPanel.add(foot);
        eastJPanel.add(basket);
        eastJPanel.add(volley);
        eastJPanel.add(petanque);
        //Fin des éléments East
        
        
        
        //Ajouts des Pannels des division dans mainPanel
        
        MainPanel.add(eastJPanel, BorderLayout.EAST);
        
        
        
        getContentPane().add(MainPanel);
        
    }
    
    public static void main(String[] args) {
        
        Exercices3OK monFrame = new Exercices3OK("Exercice 3 Fini");
        monFrame.setVisible(true);
        
    }
    
}
