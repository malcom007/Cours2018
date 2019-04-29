/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3cr3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mk
 */
public class JFmFlow2 extends JFrame       
       
{
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JPanel monJPanel;
            
    
    public JFmFlow2(){
        
        setTitle("Demo FLow Layot");
        setBounds(300,300,600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        btn1= new JButton("Bt 1");
        btn2= new JButton("Bt 2");
        btn3= new JButton("Bt 3 33333333333333333333335444555455");
        btn4= new JButton("Bt 4");
        btn5= new JButton("Bt 5");
        btn6= new JButton("Bt 6");
        
        monJPanel = new JPanel();
        
        //Par défaut un panel utilise FlowLayout
        //avec un alignement centré et un gap(marge) de 5px
        
        //Ici on change l'alignement de centré vers la droite
        //le 50 marge droit et 100 marge bas
        monJPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50,75));
        
        monJPanel.add(btn1);
        monJPanel.add(btn2);
        monJPanel.add(btn3);
        monJPanel.add(btn4);
        monJPanel.add(btn5);
        monJPanel.add(btn6);
        
        getContentPane().add(monJPanel);
                }
    
    public static void main(String[] args) {
        new JFmFlow2().setVisible(true);
    }
    
}
