/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.sql.Connection;
import config.Database;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pc9
 */
public class level extends javax.swing.JDialog {

    private DefaultTableModel DftTblModel_ListLevel;
    private String SQL;
    /**
     * Creates new form level
     */
    public level(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        autonumber();
        setform(false);
        btn_new.setEnabled(true);
        btn_update.setEnabled(false);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_cancel_edit.setVisible(false);
        listlevel();
    }

    public void autonumber() {
        java.sql.Connection DB = new config.Database().connect();
        txt_idlevel.setEnabled(false);
        try{
        SQL = "SELECT MAX(RIGHT(id_level,1)) AS NO FROM level";
        java.sql.PreparedStatement pst = DB.prepareStatement(SQL);
        java.sql.ResultSet rst = pst.executeQuery();
        while (rst.next()) {
                if (rst.first() == false) {
                    txt_idlevel.setText("1");
                } else {
                    rst.last();
                    int auto_id = rst.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int angka = no.length();
                    for (int j = 0; j < 3 - angka; j++) {
                        no = no;
                    }
                    txt_idlevel.setText(no);
                }
            }
        rst.close();
        }catch (Exception e){JOptionPane.showMessageDialog(null, e);}
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
        jLabel1 = new javax.swing.JLabel();
        txt_idlevel = new javax.swing.JTextField();
        txt_namalevel = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_cancel_edit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_level = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Level");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("| Tambah Level Pengguna");

        btn_new.setText("Baru");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_save.setText("Simpan");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_delete.setText("Hapus");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_cancel_edit.setText("Cancel Edit");
        btn_cancel_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancel_editActionPerformed(evt);
            }
        });

        jLabel4.setText("| List Level Pengguna");

        tbl_level.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Level", "Nama Level"
            }
        ));
        tbl_level.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_levelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_level);

        jLabel2.setText("ID Level                :");

        jLabel3.setText("Nama Level           : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_cancel_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_new)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_update)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_save)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_delete)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_idlevel)
                                            .addComponent(txt_namalevel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idlevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_namalevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_update)
                    .addComponent(btn_save)
                    .addComponent(btn_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        setform(true);
        txt_idlevel.requestFocus(true);
        btn_save.setEnabled(true);
        btn_update.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_cancel_edit.setVisible(false);
    }//GEN-LAST:event_btn_newActionPerformed

    private void tbl_levelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_levelMouseClicked
        // TODO add your handling code here:
        txt_idlevel.setEnabled(false);
        btn_new.setEnabled(true);
        btn_edit.setEnabled(true);
        btn_delete.setEnabled(true);
        btn_update.setEnabled(false);
        btn_save.setEnabled(false);
        btn_cancel_edit.setVisible(false);
        
        int baris = tbl_level.getSelectedRow();
        txt_idlevel.setText(DftTblModel_ListLevel.getValueAt(baris, 0).toString());
        txt_namalevel.setText(DftTblModel_ListLevel.getValueAt(baris, 1).toString());
    }//GEN-LAST:event_tbl_levelMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        java.sql.Connection DB = new Database().connect();
        try {
                SQL = "UPDATE LEVEL set nama_level = '"+ txt_namalevel.getText() +"' WHERE id_level = '" + txt_idlevel.getText() + "'";
                java.sql.PreparedStatement stmt = DB.prepareStatement(SQL);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                listlevel();
                autonumber();
                 baru();
                 setform(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data gagal diupdate", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        
        btn_update.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_new.setEnabled(true);
        btn_cancel_edit.setVisible(false);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        if (txt_idlevel.getText().isEmpty() || txt_namalevel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane,"Silahkan isi data terlebih dahulu !","Informasi",JOptionPane.INFORMATION_MESSAGE);
        } else {
            java.sql.Connection DB = new Database().connect();
        try {
            java.sql.PreparedStatement stmt = DB.prepareStatement("INSERT INTO LEVEL (id_level, nama_level) VALUES (?, ?)");
            try {
                stmt.setString(1, txt_idlevel.getText());
                stmt.setString(2, txt_namalevel.getText());
                stmt.executeUpdate();
                listlevel();
                autonumber();
                baru();
                setform(false);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data gagal disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
        btn_new.setEnabled(true);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_cancel_edit.setVisible(false);
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        java.sql.Connection DB = new Database().connect();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ?", "Message", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                SQL = "DELETE FROM level WHERE id_level = '" + txt_idlevel.getText() + "'";
                java.sql.PreparedStatement stmt = DB.prepareStatement(SQL);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                listlevel();
                autonumber();
                baru();
                setform(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        btn_new.setEnabled(true);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_update.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_cancel_edit.setVisible(false);
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        setform(true);
        btn_edit.setVisible(true);
        btn_update.setEnabled(true);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_new.setEnabled(false);
        btn_cancel_edit.setVisible(true);
        txt_idlevel.setEnabled(false);
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_cancel_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancel_editActionPerformed
        // TODO add your handling code here:
        autonumber();
        baru();
        btn_new.setEnabled(true);
        btn_update.setEnabled(false);
        btn_save.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_cancel_edit.setVisible(false);
    }//GEN-LAST:event_btn_cancel_editActionPerformed

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
            java.util.logging.Logger.getLogger(level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                level dialog = new level(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel_edit;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_level;
    private javax.swing.JTextField txt_idlevel;
    private javax.swing.JTextField txt_namalevel;
    // End of variables declaration//GEN-END:variables
private void baru() {
    txt_namalevel.setText(null);
}
 
private void setform(boolean b) {
    txt_namalevel.setEnabled(b);
}

private void listlevel() {
    DftTblModel_ListLevel = new DefaultTableModel();
        DftTblModel_ListLevel.addColumn("ID Level");
        DftTblModel_ListLevel.addColumn("Nama Level");

        tbl_level.setModel(DftTblModel_ListLevel);
        java.sql.Connection DB = new Database().connect();
        try {
            java.sql.Statement stmt = DB.createStatement();
            SQL = "SELECT * FROM LEVEL";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_ListLevel.addRow(new Object[]{
                    res.getString("id_level"),
                    res.getString("nama_level")
                });
            }
        } catch (Exception e) {

        }
        
}
}
