package View;

import Connect.JoConnentMySQL;
import java.sql.*;
import javax.swing.JOptionPane;

public class frm_Login extends javax.swing.JFrame {
    
    JoConnentMySQL jocon = new JoConnentMySQL("localhost", "root", "@min2020", "db_myschool");
    
    public frm_Login() {
        initComponents();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myLable1 = new Componnet.MyLable();
        txtUser = new Componnet.myTextfield();
        txtPassword = new javax.swing.JPasswordField();
        myLable2 = new Componnet.MyLable();
        myLable3 = new Componnet.MyLable();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myLable1.setText("ສະບາຍດີ");
        myLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N
        jPanel1.add(myLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 150, 55));
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 250, -1));

        txtPassword.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 250, 30));

        myLable2.setText("User");
        jPanel1.add(myLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, -1, -1));

        myLable3.setText("Password");
        jPanel1.add(myLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, -1));

        btnRegister.setBackground(new java.awt.Color(0, 204, 153));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 250, 40));

        btnLogin.setBackground(new java.awt.Color(102, 153, 255));
        btnLogin.setText("login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 250, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(486, 368));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            String sql = "SELECT * FROM tb_user WHERE userName=? AND password=?";
            PreparedStatement pre = jocon.getConnectMySQL().prepareStatement(sql);
            pre.setString(1, txtUser.getText());
            pre.setString(2, txtPassword.getText());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                frm_Home home = new frm_Home();
                home.setVisible(true);
                home.showUser(rs.getString(2));
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Can't login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        new frm_Register().setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private Componnet.MyLable myLable1;
    private Componnet.MyLable myLable2;
    private Componnet.MyLable myLable3;
    private javax.swing.JPasswordField txtPassword;
    private Componnet.myTextfield txtUser;
    // End of variables declaration//GEN-END:variables
}
