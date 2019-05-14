/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofelement;

/**
 *
 * @author mk
 */
public class JFListe extends javax.swing.JFrame {

    /**
     * Creates new form JFListe
     */
    public JFListe() {
        initComponents();
        
        //On ajoute le ce code pour recuperer la valeur selectionné par default
        JLAffiche.setText("Vous avez selectioné: "+MaListe.getSelectedValue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JCenterPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MaListe = new javax.swing.JList<>();
        JSouthPanel = new javax.swing.JPanel();
        JLAffiche = new javax.swing.JLabel();
        Ajouter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        MaListe.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "adresse1@hotmail.com", "adresse2@gmail.com", "adresse3@yahoo.com", "adresse4@caramail.com", "adresse5@mk.com" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        MaListe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MaListe.setPreferredSize(new java.awt.Dimension(350, 200));
        MaListe.setSelectedIndex(0);
        MaListe.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                MaListeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(MaListe);

        JCenterPanel.add(jScrollPane1);

        getContentPane().add(JCenterPanel, java.awt.BorderLayout.CENTER);

        JSouthPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JSouthPanel.setPreferredSize(new java.awt.Dimension(163, 135));
        JSouthPanel.setLayout(new java.awt.GridLayout(0, 1));

        JLAffiche.setText("Selectionnez un element");
        JSouthPanel.add(JLAffiche);

        Ajouter.setText("Ajouter");
        Ajouter.setPreferredSize(new java.awt.Dimension(97, 30));
        Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterActionPerformed(evt);
            }
        });
        JSouthPanel.add(Ajouter);

        getContentPane().add(JSouthPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MaListeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_MaListeValueChanged
        JLAffiche.setText("Vous avez selectioné: "+MaListe.getSelectedValue());
    }//GEN-LAST:event_MaListeValueChanged

    private void AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterActionPerformed
        
    }//GEN-LAST:event_AjouterActionPerformed

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
            java.util.logging.Logger.getLogger(JFListe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFListe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFListe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFListe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFListe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ajouter;
    private javax.swing.JPanel JCenterPanel;
    private javax.swing.JLabel JLAffiche;
    private javax.swing.JPanel JSouthPanel;
    private javax.swing.JList<String> MaListe;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
