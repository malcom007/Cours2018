/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicescours1;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mk
 */
public class Rectangle extends JFrame{
    
    public Rectangle(){
        super();        
        setSize(900,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mesDimensions = new JPanel();
        mesDimensions.setLocale(null);
        
        JLabel longueur = new JLabel("Longueur: ");        
        JTextField inputLongueur= new JTextField("0",5);
        inputLongueur.setHorizontalAlignment(JTextField.RIGHT);
        //
        JLabel largeur = new JLabel("Largeur: ");
        JTextField inputLargeur = new JTextField("0",5);
        inputLargeur.setHorizontalAlignment(JTextField.RIGHT);
        
        JButton calculer = new JButton("Calculer");
                
        JLabel perimetre = new JLabel("Perimetre: ");
        JTextField monPerimetre = new JTextField("0",5);
        monPerimetre.setHorizontalAlignment(JTextField.RIGHT);
        
        JLabel surface = new JLabel("Surface: ");
        JTextField maSurface = new JTextField("0",5);
        maSurface.setHorizontalAlignment(JTextField.RIGHT);
              
        
        mesDimensions.add(longueur);
        mesDimensions.add(inputLongueur);
        
        mesDimensions.add(largeur);
        mesDimensions.add(inputLargeur);
        
        mesDimensions.add(calculer);
        
        mesDimensions.add(perimetre);
        mesDimensions.add(monPerimetre);
        
        mesDimensions.add(surface);
        mesDimensions.add(maSurface);
        
        longueur.setBounds(10,15,150,30);
        inputLongueur.setBounds(50,15,2,5);
        
        
        
        
        getContentPane().add(mesDimensions);
    }
    
    
    public static void main(String[] args) {
        new Rectangle().setVisible(true);
    }
    
}
