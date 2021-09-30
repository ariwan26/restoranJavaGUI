/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import config.Database;
/**
 *
 * @author Asus
 */
public class login extends javax.swing.JFrame {

    private String SQL;
    
    /**
     * Creates new form FrmLogin
     */
    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        checkbox_password = new javax.swing.JCheckBox();
        txt_password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("LOGIN");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        checkbox_password.setText("Show Password");
        checkbox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkbox_passwordActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        btnlogin.setText("Masuk");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(223, 223, 223))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkbox_password)
                        .addComponent(jLabel2))
                    .addComponent(btnlogin))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkbox_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlogin)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkbox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_passwordActionPerformed
        // TODO add your handling code here:
        if(checkbox_password.isSelected()) {
            txt_password.setEchoChar((char)0);
        } else {
            txt_password.setEchoChar('*');
        }
    }//GEN-LAST:event_checkbox_passwordActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
       main m = new main();
       order o = new order(this, true);
        java.sql.Connection conn = new Database().connect();
       try {
           java.sql.Statement stmt = conn.createStatement();
           SQL = "SELECT * FROM USER INNER JOIN LEVEL ON USER.`id_level` = LEVEL.`id_level` WHERE username='"+ txt_username.getText() +"' AND PASSWORD='"+ txt_password.getText() +"'";    
           java.sql.ResultSet res = stmt.executeQuery(SQL);
           if(res.next()) {
             if(txt_username.getText().equals(res.getString("username")) && txt_password.getText().equals(res.getString("password"))) {
             m.lblnamauser.setText(res.getString("nama_user"));
             m.lbliduser.setText(res.getString("id_user"));
             m.lblhakakses.setText(res.getString("nama_level"));
             m.info.setText(res.getString("nama_level"));
             if (res.getString("id_level").equals("1")) {
                    m.setVisible(true);
                    this.dispose();
                } else if(res.getString("id_level").equals("2")) {
                    m.menu_riwayat.setVisible(false);
                    m.btntransaksi.setVisible(false);
                    m.setVisible(true);
                    m.menu_entry.setVisible(false);
                    o.txtiduser.setText(res.getString("id_user"));
                    this.dispose();
                } else if(res.getString("id_level").equals("3")) {
                    m.setVisible(true);
                    m.menu_entry.setVisible(false);
                    m.btnorder.setVisible(false);
                    o.txtiduser.setText(res.getString("id_user"));
                    this.dispose();
                } else if(res.getString("id_level").equals("4")) {
                    m.setVisible(true);
                    m.btnlaporan.setVisible(true);
                    m.btnstruk.setVisible(true);
                    m.btnadduser.setVisible(false);
                    m.menu_entry.setVisible(false);
                    m.btnadduser.setVisible(false);
                    m.btnorder.setVisible(false);
                    m.btnorder.setVisible(false);
                    m.menu_riwayat.setVisible(false);
                    m.btntransaksi.setVisible(false);
                    o.txtiduser.setText(res.getString("id_user"));
                    this.dispose();
                } else if(res.getString("id_level").equals("5")) {
                    m.btnadduser.setVisible(false);
                    m.menu_entry.setVisible(false);
                    m.menu_riwayat.setVisible(false);
                    m.btntransaksi.setVisible(false);
                    o.txtiduser.setText(res.getString("id_user"));
                    o.setVisible(true);
                    this.dispose();
               }
              }
            } else {
             JOptionPane.showMessageDialog(rootPane,"Username / Password tidak terdaftar","Peringatan",JOptionPane.WARNING_MESSAGE);
                txt_username.setText(null);
                txt_password.setText(null);
                txt_username.requestFocus();
            }
           }
       catch(Exception e) {
           JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_btnloginActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JCheckBox checkbox_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}