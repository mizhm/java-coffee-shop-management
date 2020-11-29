/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author TUANANH-DESKTOP
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLoginNew
     */
    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null);

        // Custom code
        lblBackground.setBounds(0, 0, 960, 610);
        lblBackground.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/com/example/assets/img/background.png")).getImage().getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), 1)));

        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);

        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                txtEmail.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String email = txtEmail.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();
        boolean validate = true;

        // Reset to default
        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 36, 40)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(34, 36, 40)),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        lblEmail.setForeground(new Color(220, 221, 222));
        lblPassword.setForeground(new Color(220, 221, 222));

        if (email.equals("")) {
            txtEmail.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblEmail.setForeground(new Color(240, 71, 71));
            lblEmailError.setText("Email không được để trống");
            lblEmailError.setVisible(true);
            validate = false;
        } else {
            String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            if (!email.matches(email_regex)) {
                txtEmail.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(240, 71, 71)),
                        BorderFactory.createEmptyBorder(5, 8, 5, 8)));
                lblEmail.setForeground(new Color(240, 71, 71));
                lblEmailError.setText("Email không đúng định dạng");
                lblEmailError.setVisible(true);
                validate = false;
            }
        }

        if (password.equals("")) {
            txtPassword.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblPassword.setForeground(new Color(240, 71, 71));
            lblPasswordError.setText("Mật khẩu không được để trống");
            lblPasswordError.setVisible(true);
            validate = false;
        }

        if (validate == true) {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPasswordMouseClicked
        JOptionPane.showMessageDialog(null, "Vui lòng liên hệ admin để lấy lại mật khẩu.");
    }//GEN-LAST:event_lblForgotPasswordMouseClicked

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        JOptionPane.showMessageDialog(null, "Vui lòng liên hệ admin để đăng ký tài khoản.");        // TODO add your handling code here:
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackround = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        boxLogin = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        lblQuestionRegister = new javax.swing.JLabel();
        lblForgotPassword = new javax.swing.JLabel();
        lblHeaderPrimary = new javax.swing.JLabel();
        lblHeaderSecondary = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Cửa Hàng Cafe - Version 1.0");
        setMinimumSize(new java.awt.Dimension(960, 610));
        setResizable(false);
        setSize(new java.awt.Dimension(960, 610));

        panelBackround.setMaximumSize(new java.awt.Dimension(960, 610));
        panelBackround.setMinimumSize(new java.awt.Dimension(960, 610));
        panelBackround.setPreferredSize(new java.awt.Dimension(960, 610));
        panelBackround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("QUẢN LÝ CỬA HÀNG CAFE");
        panelBackround.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 960, -1));

        panelLogin.setBackground(new java.awt.Color(54, 57, 63));
        panelLogin.setMaximumSize(new java.awt.Dimension(480, 406));
        panelLogin.setMinimumSize(new java.awt.Dimension(480, 406));
        panelLogin.setPreferredSize(new java.awt.Dimension(480, 406));

        boxLogin.setBackground(new java.awt.Color(54, 57, 63));
        boxLogin.setMinimumSize(new java.awt.Dimension(416, 342));
        boxLogin.setPreferredSize(new java.awt.Dimension(416, 342));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(142, 146, 151));
        lblEmail.setText("EMAIL");

        txtEmail.setBackground(new java.awt.Color(48, 51, 57));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(220, 221, 222));
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 36, 40)));
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        txtPassword.setBackground(new java.awt.Color(48, 51, 57));
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(220, 221, 222));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(34, 36, 40)));
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(114, 137, 218));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.setFocusable(false);
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(114, 137, 218));
        lblRegister.setText("Đăng ký");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        lblQuestionRegister.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQuestionRegister.setForeground(new java.awt.Color(114, 118, 125));
        lblQuestionRegister.setText("Cần một tài khoản?");

        lblForgotPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblForgotPassword.setForeground(new java.awt.Color(114, 137, 218));
        lblForgotPassword.setText("Quên mật khẩu?");
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPasswordMouseClicked(evt);
            }
        });

        lblHeaderPrimary.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblHeaderPrimary.setForeground(new java.awt.Color(255, 255, 255));
        lblHeaderPrimary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeaderPrimary.setText("Chào mừng trở lại");

        lblHeaderSecondary.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblHeaderSecondary.setForeground(new java.awt.Color(185, 187, 190));
        lblHeaderSecondary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeaderSecondary.setText("Rất vui mừng khi được gặp lại bạn!");

        lblEmailError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblEmailError.setForeground(new java.awt.Color(240, 71, 71));
        lblEmailError.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmailError.setText("Email không được để trống");
        lblEmailError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(142, 146, 151));
        lblPassword.setText("MẬT KHẨU");

        lblPasswordError.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblPasswordError.setForeground(new java.awt.Color(240, 71, 71));
        lblPasswordError.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblPasswordError.setText("Mật khẩu không được để trống");
        lblPasswordError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout boxLoginLayout = new javax.swing.GroupLayout(boxLogin);
        boxLogin.setLayout(boxLoginLayout);
        boxLoginLayout.setHorizontalGroup(
            boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeaderSecondary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblHeaderPrimary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtEmail)
            .addComponent(txtPassword)
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(boxLoginLayout.createSequentialGroup()
                        .addComponent(lblQuestionRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(boxLoginLayout.createSequentialGroup()
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasswordError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        boxLoginLayout.setVerticalGroup(
            boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxLoginLayout.createSequentialGroup()
                .addComponent(lblHeaderPrimary)
                .addGap(10, 10, 10)
                .addComponent(lblHeaderSecondary)
                .addGap(18, 18, 18)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblEmailError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(lblPasswordError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblForgotPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(boxLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestionRegister)
                    .addComponent(lblRegister)))
        );

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(boxLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(boxLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelBackround.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackground.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblBackground.setMaximumSize(new java.awt.Dimension(960, 610));
        lblBackground.setMinimumSize(new java.awt.Dimension(960, 610));
        lblBackground.setPreferredSize(new java.awt.Dimension(960, 610));
        panelBackround.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boxLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblForgotPassword;
    private javax.swing.JLabel lblHeaderPrimary;
    private javax.swing.JLabel lblHeaderSecondary;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblQuestionRegister;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBackround;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
