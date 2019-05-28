/*
boite de dialogue
 */
package az3cr5menuetdialogue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class DjfmDialogue3 extends JFrame implements ActionListener {
   private JToolBar barre = new JToolBar();
   private JButton connecter = new JButton("Se connecter");
   private Authentification authentifier;
   
   public DjfmDialogue3() {
      super("Les boîtes de dialogue");
      connecter.addActionListener(this);
      barre.add(connecter);
      add(barre, BorderLayout.NORTH);
      getContentPane().setBackground(Color.RED);
      setSize(300, 250);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      if (authentifier==null) authentifier = new Authentification();
      if (authentifier.afficher()) setTitle(authentifier.getRésultat());
   }   
   
   public static void main(String[] args) { new DjfmDialogue3(); }
   
   private class Authentification extends JDialog {
      private JTextField utilisateur = new JTextField();
      private JPasswordField motDePasse = new JPasswordField();
      private JPanel panneau = new JPanel();
      private JButton ok = new JButton("OK");
      private JButton annuler = new JButton("Annuler");
      private JPanel sud = new JPanel();  
      private boolean validation;
      private String résultat;
      
      public Authentification() {
         super(DjfmDialogue3.this, "Authentification", true);
         setSize(250, 110);
         panneau.setLayout(new GridLayout(2, 2));
         panneau.add(new JLabel("  Utilisateur :"));
         panneau.add(utilisateur);
         panneau.add(new JLabel("  Mot de passe :"));
         panneau.add(motDePasse);
         add(panneau);
         ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               validation = true;
               résultat = utilisateur.getText().equalsIgnoreCase("Emmanuel REMY") ?
                  motDePasse.getText().equals("manu") ? "Authentifié" : "Mot de passe incorrect" :
                  "Utilisateur inconnu";               
               setVisible(false);
            }
         });
         sud.add(ok);
         annuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setVisible(false);
            }
         });
         sud.add(annuler);
         add(sud, BorderLayout.SOUTH);        
      }
      
      public boolean afficher() {
         validation = false;
         résultat = "Aucun";
         motDePasse.setText("");
         setVisible(true);
         return validation;
      }
      
      public String getRésultat() { return résultat; }
   }
}