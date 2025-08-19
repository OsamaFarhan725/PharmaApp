
package PharmacyGUI;

import Database.Authenticator;


public class Pharmacy_sign_in extends javax.swing.JFrame {

    public static int branch_id  = 0;
    public Pharmacy_sign_in() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        user_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Model/lock.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 80, 150, 140);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 330, 110, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 250, 120, 20);

        password_field.setBorder(null);
        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(password_field);
        password_field.setBounds(90, 360, 210, 30);

        user_field.setBorder(null);
        user_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(user_field);
        user_field.setBounds(90, 280, 210, 30);

        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(50, 310, 270, 10);

        jSeparator3.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(50, 390, 270, 10);

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jButton1.setText("login");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(100, 410, 170, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Model/background.png"))); // NOI18N
        jLabel3.setText("bagraond");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-10, -20, 390, 580);

        setSize(new java.awt.Dimension(394, 546));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_fieldActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        if(!user_field.getText().isBlank() && !password_field.getText().isBlank())
        {
            branch_id = Authenticator.authenticateManager(user_field.getText(), password_field.getText());
            if(branch_id != 0)
            {
                 Pharmacy_home_screen aq = new Pharmacy_home_screen();
                 aq.setVisible(true);
                 this.dispose();
            }
        
        } else
        {
         //Nothing
        }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pharmacy_sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pharmacy_sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pharmacy_sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pharmacy_sign_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pharmacy_sign_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField user_field;
    // End of variables declaration//GEN-END:variables
}
