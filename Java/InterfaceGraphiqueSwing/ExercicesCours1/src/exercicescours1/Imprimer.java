/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicescours1;

import java.awt.Component;
import java.awt.font.GlyphMetrics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mk
 */
public class Imprimer extends JFrame{
    
    public Imprimer(){
        
        super("Imprimer");
        
        
        setLocation(300,300);        
        setSize(600,300);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        JPanel monPanel = new JPanel();        
        monPanel.setLayout(null);
        
        JButton imprimer = new JButton("Imprimer");
        imprimer.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        monPanel.add(imprimer);
        
        imprimer.setBounds(150, 15, 100, 30);
        
        //permet d'empecher l'agrandissement
        super.setResizable(false);
        
        getContentPane().add(monPanel);
        
        
    }
    
    public static void main(String[] args) {
        
        new Imprimer().setVisible(true);
        
    }
    
    
    
}
