/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author mk
 */
public class Exercices3OK extends JFrame{
    
    private JButton jbntOK, jbntAnnuler;
    
    /**
     * 
     * @param monTitre pour definir le titre de ma fênetre
     */
    public Exercices3OK(String monTitre){
        
        setTitle(monTitre);
        //Taille de mon frame
        setSize(350,400);
        //On centre la fênetre
        setLocationRelativeTo(null);
        //On tue la tâche a la fermeture 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        //Creation de mon conteneur Principal
        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout(5,5));
        MainPanel.setBackground(Color.CYAN);
        //création bordure autour de notre main avec 4px d'épaisseur
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.yellow));
        
        //Création des Pannels de division
        //Pannel du centre
        JPanel centerJPanel = new JPanel();
        centerJPanel.setBorder(new LineBorder(Color.BLACK,4));
        centerJPanel.setBackground(Color.ORANGE);
        centerJPanel.setLayout(new GridLayout(7,1,5,5));
        //Pannel East
        JPanel eastJPanel = new JPanel();
        eastJPanel.setBorder(new LineBorder(Color.BLACK,4));
        eastJPanel.setBackground(Color.PINK);
        eastJPanel.setLayout(new GridLayout(7,1,5,5));
        //Pannel Sud
        JPanel sudJPanel = new JPanel();
        sudJPanel.setBorder(new LineBorder(Color.BLACK,4));
        sudJPanel.setBackground(Color.MAGENTA);
        sudJPanel.setLayout(new FlowLayout());
        //Fin création des pannels de division
        
        //Éléments de mon JPanl SUd
        jbntOK = new JButton("OK");
        jbntAnnuler = new JButton("Annuler");
        
        //Ajouts des éléments Sud
        sudJPanel.add(jbntOK);
        sudJPanel.add(jbntAnnuler);
        
        
        //Ajouts des Pannels des division dans mainPanel
        MainPanel.add(centerJPanel, BorderLayout.CENTER);
        MainPanel.add(eastJPanel, BorderLayout.EAST);
        MainPanel.add(sudJPanel, BorderLayout.SOUTH);
        
        
        getContentPane().add(MainPanel);
        
    }
    
    public static void main(String[] args) {
        
        Exercices3OK monFrame = new Exercices3OK("Exercice 3 Fini");
        monFrame.setVisible(true);
        
    }
    
}
