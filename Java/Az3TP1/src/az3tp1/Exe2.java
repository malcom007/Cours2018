/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az3tp1;

/**
 *
 * @author mk
 */
public class Exe2 extends javax.swing.JFrame {

    /**
     * Creates new form Exe2
     */
    public Exe2() {
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
        jPanel2 = new javax.swing.JPanel();
        BtnAjoutDon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        montantAjout = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 300));

        jPanel1.setLayout(new java.awt.BorderLayout());

        BtnAjoutDon.setText("Ajouter Don");
        BtnAjoutDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjoutDonActionPerformed(evt);
            }
        });
        jPanel2.add(BtnAjoutDon);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);
        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setText("Nouveau Don");
        jPanel3.add(jLabel1);

        montantAjout.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        montantAjout.setText("0");
        montantAjout.setPreferredSize(new java.awt.Dimension(60, 22));
        jPanel3.add(montantAjout);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel2.setText("Total Don");
        jPanel4.add(jLabel2);

        Total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Total.setText("0");
        Total.setEnabled(false);
        Total.setPreferredSize(new java.awt.Dimension(60, 22));
        jPanel4.add(Total);

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAjoutDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjoutDonActionPerformed
        double montEntre =Double.parseDouble(montantAjout.getText());
        double montTotal=Double.parseDouble(Total.getText())+montEntre;
        
        Total.setText(Double.toString(montTotal));
    }//GEN-LAST:event_BtnAjoutDonActionPerformed

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
            java.util.logging.Logger.getLogger(Exe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exe2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exe2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjoutDon;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField montantAjout;
    // End of variables declaration//GEN-END:variables
}
