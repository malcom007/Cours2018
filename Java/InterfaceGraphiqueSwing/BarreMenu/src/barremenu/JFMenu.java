/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barremenu;

/**
 *
 * @author mk
 */
public class JFMenu extends javax.swing.JFrame {

    /**
     * Creates new form JFMenu
     */
    public JFMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlMenu = new javax.swing.JLabel();
        jMBar = new javax.swing.JMenuBar();
        jMApplication = new javax.swing.JMenu();
        jMIQuitter = new javax.swing.JMenuItem();
        jMEdition = new javax.swing.JMenu();
        jMIAjouter = new javax.swing.JMenuItem();
        jMISupprimer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setBounds(new java.awt.Rectangle(0, 23, 500, 300));
        setPreferredSize(new java.awt.Dimension(800, 300));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 100);
        flowLayout1.setAlignOnBaseline(true);
        jPanel1.setLayout(flowLayout1);

        jlMenu.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jlMenu.setText("Menu");
        jlMenu.setToolTipText("");
        jPanel1.add(jlMenu);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMApplication.setText("Application");

        jMIQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK));
        jMIQuitter.setMnemonic('Q');
        jMIQuitter.setText("Quitter");
        jMIQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIQuitterActionPerformed(evt);
            }
        });
        jMApplication.add(jMIQuitter);

        jMBar.add(jMApplication);

        jMEdition.setText("Edition");

        jMIAjouter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMIAjouter.setMnemonic('A');
        jMIAjouter.setText("Ajouter");
        jMIAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIAjouterActionPerformed(evt);
            }
        });
        jMEdition.add(jMIAjouter);

        jMISupprimer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMISupprimer.setMnemonic('u');
        jMISupprimer.setText("Supprimer");
        jMISupprimer.setToolTipText("");
        jMISupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISupprimerActionPerformed(evt);
            }
        });
        jMEdition.add(jMISupprimer);

        jMBar.add(jMEdition);

        setJMenuBar(jMBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIQuitterActionPerformed
        jlMenu.setText(jMIQuitter.getText());
    }//GEN-LAST:event_jMIQuitterActionPerformed

    private void jMIAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIAjouterActionPerformed
        jlMenu.setText(jMIAjouter.getText());
    }//GEN-LAST:event_jMIAjouterActionPerformed

    private void jMISupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISupprimerActionPerformed
        if (jMISupprimer.isArmed()) {
            jlMenu.setText(jMISupprimer.getText());
        }else
            jlMenu.setText("Selectionnez un éléments");
    }//GEN-LAST:event_jMISupprimerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMApplication;
    private javax.swing.JMenuBar jMBar;
    private javax.swing.JMenu jMEdition;
    private javax.swing.JMenuItem jMIAjouter;
    private javax.swing.JMenuItem jMIQuitter;
    private javax.swing.JMenuItem jMISupprimer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlMenu;
    // End of variables declaration//GEN-END:variables
}
