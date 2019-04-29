/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3cr3borderlayout;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author mk
 */
public class JFmBorderLayout extends JFrame       
       
{

    private static final long serialVersionUID = 1L;
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
   
            
    
    public JFmBorderLayout(){
        
        setTitle("Demo FLow Layot");
        setBounds(300,300,600,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        btn1= new JButton("Bt 1");
        btn2= new JButton("Bt 2");
        btn3= new JButton("Bt 3 33333333333333333333335444555455");
        btn4= new JButton("Bt 4");
        btn5= new JButton("Bt 5");
        btn6= new JButton("Bt 6");
        
        getContentPane().add(btn1,BorderLayout.WEST);
        getContentPane().add(btn2,BorderLayout.NORTH);
        getContentPane().add(btn3,BorderLayout.CENTER);
        getContentPane().add(btn4,BorderLayout.SOUTH);
        getContentPane().add(btn5,BorderLayout.EAST);
        
       
                }
    
    public static void main(String[] args) {
        new JFmBorderLayout().setVisible(true);
    }
    
}
