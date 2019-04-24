package AZ3CR2;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mk
 */
public class Cadre extends JFrame{
    
    public Cadre(){
        super("Test du Cadre");
        
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mesObjets = new JPanel();
        mesObjets.setLocale(null);
        
        JPanel mesDimensions = new JPanel();
        mesDimensions.setLocale(null);
        
        JLabel nom = new JLabel("Nom ");
        JTextField inputNom = new JTextField(" ",15);
        
        
        
        
        mesObjets.add(nom);
        mesObjets.add(inputNom);
        
        
        getContentPane().add(mesObjets);
        
        
        
        
    }
    
    public static void main(String[] args) {
        
        new Cadre().setVisible(true);
        
    }
    
}
