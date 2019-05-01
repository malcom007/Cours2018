/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;





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
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.red);
        
        
        
    }
    
    
    public static void main(String[] args) {
        
        Calculatrice monFrame = new Calculatrice("Calculatrice");        
        monFrame.setVisible(true);
                
        
    }
    
    
    
}
