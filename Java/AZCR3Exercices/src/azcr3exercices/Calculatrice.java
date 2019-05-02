/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;





/**
 *
 * @author mk
 */
public class Calculatrice extends JFrame{
    
    private JPanel mainPanel ,nordPanel,centerPanel,eastPanel;
    private JTextField resultTxtField;
    private double initialValue,total=0,secondValue;
    private String memoryTemp;
    
    /**
     * 
     * @param titre pour definir le titre de ma fênetre
     */
    public Calculatrice(String titre){
        
        setTitle(titre);
        //Taille de mon frame
        setSize(450, 300);
        //On centre la fênetre
        setLocationRelativeTo(null);
        //On tue la tâche a la fermeture 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        /*      -----------------------------------
                Creation de mon conteneur Principal
                -----------------------------------
        */ 
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5,5));
        mainPanel.setBackground(Color.CYAN);
        //création bordure autour de notre main avec 4px d'épaisseur
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.CYAN));
        
        /*      ---------------------------------
                Création des Pannels de division
                ---------------------------------
        */
        nordPanel = new JPanel();
        nordPanel.setBackground(Color.red);
        nordPanel.setBorder(new LineBorder(Color.BLACK,2));
        //Le borderLayout prend tout le bord
        nordPanel.setLayout(new BorderLayout(2,2));
        
        resultTxtField= new JTextField();
        resultTxtField.setEnabled(false);
        nordPanel.add(resultTxtField);
        mainPanel.add(nordPanel, BorderLayout.NORTH);
        
        
        
        
        getContentPane().add(mainPanel);
        
    }
    
    
    public static void main(String[] args) {
        
        Calculatrice monFrame = new Calculatrice("Calculatrice");        
        monFrame.setVisible(true);
                
        
    }
    
    
    
}
