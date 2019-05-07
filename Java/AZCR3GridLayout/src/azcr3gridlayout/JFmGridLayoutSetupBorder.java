/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3gridlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author mk
 */
public class JFmGridLayoutSetupBorder extends JFrame       
       
{

    private static final long serialVersionUID = 1L;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JPanel monJPanel;
            
    
    public JFmGridLayoutSetupBorder(){
        
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
        
        monJPanel.setBackground(Color.ORANGE);
        
        //Pour ne pas coller le panneau sur le Frame
        monJPanel.setBorder(new EmptyBorder(20,20,20,20));
        
        //Une grille de 2 lignes, separation de 3 colonnes gap horizontal 30, gap vertical de 60
        monJPanel.setLayout(new GridLayout(3,1,30,60));
        
        monJPanel.add(btn1);
        monJPanel.add(btn2);
//        monJPanel.add(btn3);
//        monJPanel.add(btn4);
//        monJPanel.add(btn5);
//        monJPanel.add(btn6);
                
        
        
        
        //le panel monJPanel contient deux composants
        //monJPanel est consideré par ContentPane comme un seul composant
        getContentPane().add(monJPanel);
        
       
                }
    
    public static void main(String[] args) {
        new JFmGridLayoutSetupBorder().setVisible(true);
    }
    
}
