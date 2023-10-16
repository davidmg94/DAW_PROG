package prog10.entornografico;

import conexionBBDD.ConexionBBDD;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {

        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrameLogin = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogueo = new javax.swing.JButton();
        jLabelElegirBBDD = new javax.swing.JLabel();
        btnElegirBBDD = new javax.swing.JButton();
        jLabelBBDD = new javax.swing.JLabel();

        jFrameLogin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrameLogin.setTitle("Login");

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        pwdPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña");

        btnLogueo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogueo.setText("Login");
        btnLogueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogueoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrameLoginLayout = new javax.swing.GroupLayout(jFrameLogin.getContentPane());
        jFrameLogin.getContentPane().setLayout(jFrameLoginLayout);
        jFrameLoginLayout.setHorizontalGroup(
            jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameLoginLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addGroup(jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogueo)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(pwdPass))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jFrameLoginLayout.setVerticalGroup(
            jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrameLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnLogueo)
                .addGap(29, 29, 29))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elegir el SID de la Base de Datos");

        jLabelElegirBBDD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelElegirBBDD.setText("Elige el SID de la BBDD");

        cmbBBDD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbBBDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XEPDB1", "XE" }));
        cmbBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBBDDActionPerformed(evt);
            }
        });

        btnElegirBBDD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnElegirBBDD.setText("Aceptar");
        btnElegirBBDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirBBDDActionPerformed(evt);
            }
        });

        jLabelBBDD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelBBDD.setText("SID ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelBBDD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabelElegirBBDD))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(btnElegirBBDD)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelElegirBBDD)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBBDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBBDD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnElegirBBDD)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogueoActionPerformed

        //Cogemos los textos
        String user = Login.txtUsuario.getText();
        String pass = new String(Login.pwdPass.getPassword());
        String sid = Login.cmbBBDD.getSelectedItem().toString();

        if (ConexionBBDD.construirConexion(sid, user, pass) != null) {
            //abre una nueva ventana
            EntornoGrafico ventana = new EntornoGrafico();
            ventana.setVisible(true);
            //Cierra la ventana actual
            jFrameLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "El acceso es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLogueoActionPerformed

    private void btnElegirBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirBBDDActionPerformed
        jFrameLogin.setVisible(true);
        jFrameLogin.setSize(400, 250);
        jFrameLogin.setLocationRelativeTo(null);
        this.dispose();
        cmbBBDD.setSelectedIndex(0);
    }//GEN-LAST:event_btnElegirBBDDActionPerformed

    private void cmbBBDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBBDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBBDDActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirBBDD;
    private javax.swing.JButton btnLogueo;
    public static final javax.swing.JComboBox<String> cmbBBDD = new javax.swing.JComboBox<>();
    private javax.swing.JFrame jFrameLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBBDD;
    private javax.swing.JLabel jLabelElegirBBDD;
    public static final javax.swing.JPasswordField pwdPass = new javax.swing.JPasswordField();
    public static final javax.swing.JTextField txtUsuario = new javax.swing.JTextField();
    // End of variables declaration//GEN-END:variables
}
