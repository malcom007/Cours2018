/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AZ3CR2;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.GlyphMetrics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mk
 */
public class ImprimerOK extends JFrame {
    
    public ImprimerOK(){
        
        super("Imprimer");
        
        
        setLocation(300,300);        
        setSize(600,300);        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
        JPanel monPanel = new JPanel();        
        monPanel.setLayout(null);
        
        JButton imprimer = new JButton("Imprimer");
        imprimer.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        monPanel.add(imprimer);
        
        imprimer.setBounds(200, 15, 200, 30);
        
        //permet d'empecher l'agrandissement
        super.setResizable(false);
        
        getContentPane().add(monPanel);
        
        /*
        * Pour chaque bouton on lui crée un objet anonyme
        * Ici on ajoute l'action pour bouton
        * On lui donne comme parametre l'object */
        imprimer.addActionListener(new ActionListener() {
            //On lui met une methode pour réagir
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(imprimer, "Impression Impossible"); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
    }
    
    public static void main(String[] args) {
        
        new ImprimerOK().setVisible(true);
        
    }


    
    
    
}
