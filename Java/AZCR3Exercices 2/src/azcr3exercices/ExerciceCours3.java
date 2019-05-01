/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author mk
 */
public class ExerciceCours3 extends JFrame{
    public ExerciceCours3(String monTitre){
        setTitle(monTitre);
        //Taille de mon frame
        setSize(350,400);
        //On centre la fênetre
        setLocationRelativeTo(null);
        //On tue la tâche a la fermeture 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JLabel nom = new JLabel("Nom");        
        JTextField inputNom = new JTextField();
                
        JLabel prenom = new JLabel("Prenom");
        JTextField inputPrenom = new JTextField();
        
        JLabel adresse = new JLabel("Adresse");        
        JTextArea inputAdresse = new JTextArea();
        
        
        
        
        
        JLabel sexe = new JLabel("Sexe");
        //Création button Radion
        //On commence par crée un objet de type ButtonGroup
        ButtonGroup groupRadio = new ButtonGroup();
        JRadioButton sexeH = new JRadioButton("Homme");
        JRadioButton sexeF = new JRadioButton("Femme");
        groupRadio.add(sexeF);
        groupRadio.add(sexeH);
        
        sexeF.setLayout(new FlowLayout());
        sexeH.setLayout(new FlowLayout());
        
        //Création CHckbox
        JCheckBox tennis = new JCheckBox("Tennis");
        JCheckBox squash = new JCheckBox("Squash");
        JCheckBox natation = new JCheckBox("Natation");
        JCheckBox athletisme = new JCheckBox("Athletisme");
        JCheckBox randonnee = new JCheckBox("Randonnee");
        JCheckBox foot = new JCheckBox("Foot");
        JCheckBox basket = new JCheckBox("Basket");
        JCheckBox volley = new JCheckBox("Volley");
        JCheckBox petanque = new JCheckBox("Petanque");
        
        JButton ok = new JButton("OK");
        JButton annuler = new JButton("Annuler");
        
        //On crée un Conteneur Main
        Container principalMain = new Container();
        principalMain.setLayout(new BorderLayout(5,5));
        principalMain.setBackground(Color.RED);                
        //on definit la couleur des bordures
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GREEN));
        
        
        
        //Panel du centre
        JPanel centerPanel = new JPanel();
        //On definit une couleur pour nos bordures de cette panel
        centerPanel.setBorder(new LineBorder(Color.BLACK,10));
        centerPanel.setBackground(Color.ORANGE);
        //on ajoute un padding
        centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        centerPanel.setLayout(new GridLayout(7,1,5,5));
        
        
        JPanel sexePanel = new JPanel();        
        sexePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        sexePanel.setBackground(Color.ORANGE);
        //
        sexePanel.add(sexe);
        sexePanel.add(sexeF);
        sexePanel.add(sexeH);
        
        
        //On ajoute les element a ce panel
        centerPanel.add(nom);
        centerPanel.add(inputNom);
        centerPanel.add(prenom);
        centerPanel.add(inputPrenom);
        centerPanel.add(adresse);
        centerPanel.add(inputAdresse);
        
        centerPanel.add(sexePanel);

        
        
        
        //
        JPanel eastPanel= new JPanel();
        eastPanel.setBorder(new LineBorder(Color.BLACK,10));
        eastPanel.setBackground(Color.PINK);
        eastPanel.setBorder(new EmptyBorder(5,5,5,5));
        eastPanel.setLayout(new GridLayout(9,1,5,5));
        
        eastPanel.add(tennis);
        eastPanel.add(squash);
        eastPanel.add(natation);
        eastPanel.add(athletisme);
        eastPanel.add(randonnee);
        eastPanel.add(foot);
        eastPanel.add(basket);
        eastPanel.add(volley);
        eastPanel.add(petanque);
        
        
        
        //
        JPanel southPanel = new JPanel();
        southPanel.setBorder(new LineBorder(Color.BLACK, 10));
        southPanel.setBackground(Color.CYAN);
        southPanel.setBorder(new EmptyBorder(5,5,5,5));
        southPanel.setLayout(new FlowLayout());
        
        southPanel.add(ok);
        southPanel.add(annuler);
        
        
        
        principalMain.add(centerPanel, BorderLayout.CENTER);
        principalMain.add(eastPanel, BorderLayout.EAST);
        principalMain.add(southPanel, BorderLayout.SOUTH);
        
        getContentPane().add(principalMain);
                
        
    }
    
    
    
    
    public static void main(String[] args) {
        
        ExerciceCours3 monJFrame = new ExerciceCours3("Exercice 3");
        monJFrame.setVisible(true);
        
        
    }
    
}
