/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.GUI.user;

import coffeeshop.DTO.User;
import coffeeshop.DAO.impl.UserDao;
import coffeeshop.Util.Common;
import coffeeshop.Util.DbUtil;
import java.awt.Color;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh
 */
public final class JDModifyUser extends javax.swing.JDialog {

    User user;
    CallbackUserModify callback;
    UserDao userDao;

    interface CallbackUserModify {

        public void actionUserModify();
    }

    /**
     * Creates new form JDCategoryCreate
     *
     * @param parent
     * @param modal
     * @param dbUtil
     * @param callback
     * @param user
     */
    public JDModifyUser(java.awt.Frame parent, boolean modal, DbUtil dbUtil, CallbackUserModify callback, User user) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.callback = callback;
        this.userDao = new UserDao(dbUtil);

        if (!Common.isNullOrEmpty(user)) {
            lblTitle.setText("Sửa đổi người dùng");
            btnModify.setText("Sửa đổi");
            this.user = user;
            loadingData();
        }

        // Custom Style
        txtEmail.setBorder(BorderFactory.createCompoundBorder(
                txtEmail.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtName.setBorder(BorderFactory.createCompoundBorder(
                txtName.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        txtPassword.setBorder(BorderFactory.createCompoundBorder(
                txtPassword.getBorder(),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)));
        lblNameError.setVisible(false);
        lblEmailError.setVisible(false);
        lblPasswordError.setVisible(false);
        loadingRoles();
    }

    public void loadingData() {
        txtName.setText(this.user.getName());
        txtPassword.setText(this.user.getPassword());
        txtEmail.setText(this.user.getEmail());
        rdoActive.setSelected(this.user.getStatus());
        rdoNonActive.setSelected(this.user.getStatus() == false);
        cboPermission.setSelectedItem(this.user.getRole() == 1 ? "Super Admin" : "Nhân viên");
    }

    public void loadingRoles() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        String permissions[] = {"Super Admin", "Nhân viên"};
        for (String permission : permissions) {
            dcbm.addElement(permission);
        }

        cboPermission.setModel(dcbm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        rdoActive = new javax.swing.JRadioButton();
        rdoNonActive = new javax.swing.JRadioButton();
        btnModify = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPermission = new javax.swing.JLabel();
        cboPermission = new javax.swing.JComboBox();
        lblNameError = new javax.swing.JLabel();
        lblEmailError = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblPasswordError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CẬP NHẬT NGƯỜI DÙNG");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_product_50px_2.png"))); // NOI18N
        lblTitle.setText("THÊM MỚI NGƯỜI DÙNG");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 547, 60));

        lblName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblName.setText("Tên người dùng");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 89, 547, 30));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 547, 40));

        lblStatus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblStatus.setText("Trạng thái");
        jPanel1.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 513, 547, 30));

        rdoActive.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoActive);
        rdoActive.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        rdoActive.setSelected(true);
        rdoActive.setText("Hoạt động");
        jPanel1.add(rdoActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 545, 259, -1));

        rdoNonActive.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoNonActive);
        rdoNonActive.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        rdoNonActive.setText("Không hoạt động");
        rdoNonActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNonActiveActionPerformed(evt);
            }
        });
        jPanel1.add(rdoNonActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 545, 286, -1));

        btnModify.setBackground(new java.awt.Color(0, 204, 106));
        btnModify.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModify.setForeground(new java.awt.Color(255, 255, 255));
        btnModify.setText("Thêm mới");
        btnModify.setBorderPainted(false);
        btnModify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });
        jPanel1.add(btnModify, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 590, 120, 35));

        lblEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblEmail.setText("Email");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 203, 547, 30));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 239, 547, 40));

        lblPermission.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblPermission.setText("Quyền");
        jPanel1.add(lblPermission, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 419, 547, 30));

        jPanel1.add(cboPermission, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 455, 547, 40));

        lblNameError.setForeground(new java.awt.Color(240, 71, 71));
        lblNameError.setText("Không được để trống");
        jPanel1.add(lblNameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 547, -1));

        lblEmailError.setForeground(new java.awt.Color(240, 71, 71));
        lblEmailError.setText("Không được để trổng");
        jPanel1.add(lblEmailError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 285, 547, -1));

        lblPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblPassword.setText("Mật khẩu");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 317, 547, 30));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 353, 547, 40));

        lblPasswordError.setForeground(new java.awt.Color(240, 71, 71));
        lblPasswordError.setText("Không được để trổng");
        jPanel1.add(lblPasswordError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 399, 547, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNonActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNonActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNonActiveActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        String name = (String) txtName.getText().trim();
        String email = (String) txtEmail.getText().trim();
        String password = (String) txtPassword.getText().trim();
        int role = cboPermission.getSelectedItem() == "Super Admin" ? 1 : 0;
        boolean status = (boolean) rdoActive.isSelected();
        boolean validate = true;
        String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (name.equals("")) {
            txtName.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblName.setForeground(new Color(240, 71, 71));
            lblNameError.setVisible(true);
            validate = false;
        }

        if (password.equals("")) {
            txtPassword.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblPassword.setForeground(new Color(240, 71, 71));
            lblPasswordError.setVisible(true);
            validate = false;
        }

        if (txtEmail.getText().trim().equals("")) {
            txtEmail.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblEmail.setText("Không được để trống");
            lblEmail.setForeground(new Color(240, 71, 71));
            lblEmailError.setVisible(true);
            validate = false;
        } else if (!email.matches(email_regex)) {
            txtEmail.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(240, 71, 71)),
                    BorderFactory.createEmptyBorder(5, 8, 5, 8)));
            lblEmail.setText("Email bạn nhập không đúng định dạng!");
            lblEmail.setForeground(new Color(240, 71, 71));
            lblEmailError.setVisible(true);
            validate = false;
        }

        if (validate == true) {
            lblNameError.setVisible(false);
            lblEmailError.setVisible(false);
            try {
                User user = new User();
                user.setName(name);
                user.setStatus(status);
                user.setRole(role);
                user.setEmail(email);
                user.setPassword(password);

                if (Common.isNullOrEmpty(user)) {
                    Map<String, Object> result = userDao.create(user);

                    if ((boolean) result.get("status") == true) {
                        JOptionPane.showMessageDialog(null, "Thêm người dùng thành công!");
                        callback.actionUserModify();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm người dùng thất bại, lỗi: " + result.get("message") + "!");
                    }
                } else {
                    user.setId(this.user.getId());
                    System.out.println(user);
                    Map<String, Object> result = userDao.update(user);
                    if ((boolean) result.get("status") == true) {
                        JOptionPane.showMessageDialog(null, "Sửa người dùng thành công!");
                        callback.actionUserModify();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa người dùng thất bại, lỗi: " + result.get("message") + "!");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnModifyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModify;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboPermission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmailError;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblPermission;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JRadioButton rdoActive;
    private javax.swing.JRadioButton rdoNonActive;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
