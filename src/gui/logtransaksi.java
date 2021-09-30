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
 * @author user
 */
public class logtransaksi extends javax.swing.JDialog {

    private DefaultTableModel log_transaksi;
    private String SQL;
    
    /**
     * Creates new form logtransaksi
     */
    public logtransaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tampildata();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_log = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log Transaksi");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("**Riwayat Transaksi**");

        tbl_log.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Detail Order", "ID Order", "No Meja", "Tanggal", "ID User", "Nama User", "ID Masakan", "Nama Masakan", "Harga", "Keterangan", "Status Order"
            }
        ));
        jScrollPane1.setViewportView(tbl_log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jLabel1)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(logtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logtransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                logtransaksi dialog = new logtransaksi(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_log;
    // End of variables declaration//GEN-END:variables
    private void tampildata() {
        DefaultTableModel log_transaksi = (DefaultTableModel) tbl_log.getModel();
        log_transaksi.setRowCount(0);
        java.sql.Connection DB = new Database().connect();
        try {
            java.sql.Statement stmt = DB.createStatement();
            SQL = "SELECT detail_order.id_detail_order, `order`.id_order, `order`.no_meja, `order`.tanggal, user.id_user, user.nama_user, masakan.id_masakan, masakan.nama_masakan, masakan.harga, `order`.keterangan, `order`.status_order\n" +"\n" +
                  "FROM user,`order`,masakan,detail_order \n"+
                  "WHERE detail_order.id_order = `order`.id_order AND `order`.id_user = user.id_user AND detail_order.id_masakan = masakan.id_masakan GROUP BY detail_order.id_order";
            java.sql.ResultSet res = stmt.executeQuery(SQL);
            Object [] data = new Object[11];
        while(res .next()){
            data[0] = res .getObject("id_detail_order");
            data[1] = res .getObject("id_order");
            data[2] = res .getObject("no_meja");
            data[3] = res .getObject("tanggal");
            data[4] = res .getObject("id_user");
            data[5] = res .getObject("nama_user");
            data[6] = res.getObject("id_masakan");
            data[7] = res.getObject("nama_masakan");
            data[8] = res.getObject("harga");
            data[9] = res.getObject("keterangan");
            data[10] = res.getObject("status_order");
            log_transaksi.addRow(data);
        }
            } catch (Exception e) {}
    }

}
