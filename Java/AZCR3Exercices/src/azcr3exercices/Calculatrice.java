/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package azcr3exercices;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;





/**
 *
 * @author mk
 */
public class Calculatrice extends JFrame{
    
    private JPanel mainPanel ,nordPanel,centerPanel,eastPanel;
    private JTextField resultTxtField;
    private double initialValue,total=0,secondValue;
    private String memoryTemp, reset="0", operateur;
    private JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnPlus,btnMoin,btnMulti,btnDiv,btnEgal,btnReset,btnVirgule;
    
    private void setAll(String inputValue) {
                String All = resultTxtField.getText()+inputValue;
                resultTxtField.setText(All);
            }
    
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
        mainPanel.setLayout(new BorderLayout(2,2));
        mainPanel.setBackground(Color.CYAN);
        //création bordure autour de notre main avec 4px d'épaisseur
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.CYAN));
        
        /*      ---------------------------------
                Création Pannel Nord
                ---------------------------------
        */
        nordPanel = new JPanel();
        nordPanel.setBackground(Color.red);
        nordPanel.setBorder(new LineBorder(Color.BLACK,2));
        //Le borderLayout prend tout le bord
        nordPanel.setLayout(new BorderLayout(2,2));
        
        resultTxtField= new JTextField();
        resultTxtField.setEnabled(false);
        //Alignement a droite
        resultTxtField.setHorizontalAlignment(SwingConstants.RIGHT);
        //Valeur par defaut
        resultTxtField.setText("");
        nordPanel.add(resultTxtField);
        //Ajout de mon nordPanel au MainPanel
        mainPanel.add(nordPanel, BorderLayout.NORTH);
        
        /*      ---------------------------------
                Création Pannel Centre
                ---------------------------------
        */
        
        centerPanel = new JPanel();        
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBorder(new EmptyBorder(20,20,20,20));
        centerPanel.setLayout(new GridLayout(4,3,5,5) );
        
        centerPanel.add(btn7=new JButton("7"));
        centerPanel.add(btn8=new JButton("8"));
        centerPanel.add(btn9=new JButton("9"));
        
        centerPanel.add(btn4=new JButton("4"));
        centerPanel.add(btn5=new JButton("5"));
        centerPanel.add(btn6=new JButton("6"));
        
        centerPanel.add(btn1=new JButton("1"));
        centerPanel.add(btn2=new JButton("2"));
        centerPanel.add(btn3=new JButton("3"));
        
        centerPanel.add(btn0=new JButton("0"));
        centerPanel.add(btnVirgule=new JButton(","));
        centerPanel.add(btnReset=new JButton("C"));
        
        mainPanel.add(centerPanel);
        
        /*      ---------------------------------
                Création Pannel East
                ---------------------------------
        */
        
        eastPanel = new JPanel();
        eastPanel.setBackground(Color.GRAY);
        eastPanel.setBorder(new EmptyBorder(20,20,20,20));
        eastPanel.setLayout(new GridLayout(5,1,5,5) );
        
        
        eastPanel.add(btnDiv=new JButton("/"));
        eastPanel.add(btnMulti=new JButton("X"));
        eastPanel.add(btnMoin=new JButton("-"));
        eastPanel.add(btnPlus=new JButton("+"));
        eastPanel.add(btnEgal=new JButton("="));
        
        mainPanel.add(eastPanel, BorderLayout.EAST);
        
        
        
        /*      ---------------------------------
                Ajout Actions Boutons
                ---------------------------------
        */
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTxtField.setText(resultTxtField.getText()+0); //To change body of generated methods, choose Tools | Templates.
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("1");
            }
        });
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("2");
            }
        });
        
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("3");
            }
        });
        
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("4");
            }
        });
        
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("5");
            }
        });
        
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("6");
            }
        });
        
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("7");
            }
        });
        
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAll("8");
            }
        });
        
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                   
                    setAll("9");
                    
                
                
                
            }
        });
        
        btnVirgule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setAll(".");
                
            }

            
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTxtField.setText("");
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        getContentPane().add(mainPanel);
        
    }
    
    
    public static void main(String[] args) {
        
        Calculatrice monFrame = new Calculatrice("Calculatrice by Malcom");        
        monFrame.setVisible(true);
                
        
    }
    
    
    
}
