package View;

import Connect.JoConnentMySQL;
import JoSQL.JoSQL;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class frm_Major extends javax.swing.JFrame {

    JoConnentMySQL con = new JoConnentMySQL("localhost",
            "root", "@min2020", "db_myschool");
    JoSQL sql = new JoSQL(con.getConnectMySQL(), "tb_department");
    JoSQL sqlmj = new JoSQL(con.getConnectMySQL(), "tb_major");
    DefaultComboBoxModel comModel = new DefaultComboBoxModel();
    DefaultTableModel model = new DefaultTableModel();

    public frm_Major() {
        initComponents();
        model = (DefaultTableModel) tbMJ.getModel();
        showDPM();
        showMajor();
    }

    private void showDPM() {
        try {
            ResultSet rs = sql.getSelectAll();
            while (rs.next()) {
                comModel.addElement(rs.getString(2));
            }
            cbDPM.setModel(comModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMajor() {
        try {
            String sqlcmd = "SELECT majorID,dpname,majorName FROM tb_major\n"
                    + "INNER JOIN tb_department ON tb_major.dpID = tb_department.dpid";
            ResultSet rs = con.getConnectMySQL().createStatement().executeQuery(sqlcmd);
            int row = tbMJ.getRowCount() - 1;
            while (row >= 0) {
                model.removeRow(row--);
            }
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getInt(1), rs.getString(2), rs.getString(3)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMajorSearch() {
        try {
            String sqlcmd = "SELECT majorID,dpname,majorName FROM tb_major\n"
                    + "INNER JOIN tb_department ON tb_major.dpID = tb_department.dpid WHERE majorName LIKE '%" + txtSearch.getText() + "%' OR  dpname LIKE '%"+txtSearch.getText()+"%'";
            ResultSet rs = con.getConnectMySQL().createStatement().executeQuery(sqlcmd);
            int row = tbMJ.getRowCount() - 1;
            while (row >= 0) {
                model.removeRow(row--);
            }
            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{no++, rs.getInt(1), rs.getString(2), rs.getString(3)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myLable1 = new Componnet.MyLable();
        txtSearch = new javax.swing.JTextField();
        myLable2 = new Componnet.MyLable();
        cbDPM = new javax.swing.JComboBox<>();
        myLable3 = new Componnet.MyLable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMJ = new Componnet.MyTable();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        txtMajorName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myLable1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        myLable1.setText("ພາກວິຊາ");
        myLable1.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel1.add(myLable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 260, 40));

        txtSearch.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 170, 40));

        myLable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        myLable2.setText("ຈັດການຂໍ້ມູນສາຂາວິຊາ");
        myLable2.setFont(new java.awt.Font("Phetsarath OT", 0, 18)); // NOI18N
        jPanel1.add(myLable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 260, 40));

        cbDPM.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        cbDPM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbDPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 260, 40));

        myLable3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        myLable3.setText("ຊື່ສາຂາວິຊາ");
        myLable3.setFont(new java.awt.Font("Phetsarath OT", 0, 14)); // NOI18N
        jPanel1.add(myLable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 260, 40));

        tbMJ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "ໄອດີສາຂາ", "ຊື່ພາກວິຊາ", "ຊື່ສາຂາ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMJ);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 520, 250));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, 40));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 40));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, 40));

        txtMajorName.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        jPanel1.add(txtMajorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 260, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(576, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            PreparedStatement pre = sqlmj.getCreate();
            pre.setString(1, null);
            pre.setInt(2, cbDPM.getSelectedIndex() + 1);
            pre.setString(3, txtMajorName.getText());
            pre.executeUpdate();
            showMajor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            int row = tbMJ.getSelectedRow();
            String ID = tbMJ.getValueAt(row, 1).toString();
            PreparedStatement pre = sqlmj.getUpdate(ID);
            pre.setInt(1, cbDPM.getSelectedIndex() + 1);
            pre.setString(2, txtMajorName.getText());
            pre.executeUpdate();
            showMajor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = tbMJ.getSelectedRow();
            String ID = tbMJ.getValueAt(row, 1).toString();
            PreparedStatement pre = sqlmj.getDelete(ID);
            pre.executeUpdate();
            showMajor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        showMajorSearch();
    }//GEN-LAST:event_txtSearchKeyPressed

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
            java.util.logging.Logger.getLogger(frm_Major.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Major.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Major.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Major.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Major().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbDPM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Componnet.MyLable myLable1;
    private Componnet.MyLable myLable2;
    private Componnet.MyLable myLable3;
    private Componnet.MyTable tbMJ;
    private javax.swing.JTextField txtMajorName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
