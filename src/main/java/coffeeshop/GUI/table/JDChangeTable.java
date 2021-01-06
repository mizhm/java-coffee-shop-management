/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.GUI.table;

import coffeeshop.DAO.impl.AreaDao;
import coffeeshop.DAO.impl.BillDao;
import coffeeshop.DTO.Area;
import coffeeshop.DTO.Bill;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import coffeeshop.DTO.Table;
import coffeeshop.DAO.impl.TableDao;
import coffeeshop.Util.Common;
import coffeeshop.Util.DbUtil;
import java.util.Map;
import java.util.Objects;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Minh
 */
import coffeeshop.Util.BaseMessage;
import coffeeshop.Util.Constant;
import lombok.extern.log4j.Log4j;

@Log4j
public final class JDChangeTable extends javax.swing.JDialog {

    JDialog parent;
    CallbackTableChange callback;
    DbUtil dbUtil;

    Table table;
    Area area;
    Bill bill;

    List<Area> areas = new ArrayList<>();
    List<Table> tables = new ArrayList<>();

    AreaDao areaDao;
    TableDao tableDao;
    BillDao billDao;
    private BaseMessage response;

    public interface CallbackTableChange {

        public void actionTableChange();
    }

    /**
     * Creates new form JDCategoryCreate
     *
     * @param parent
     * @param modal
     * @param dbUtil
     * @param callback
     * @param table
     * @param bill
     */
    public JDChangeTable(JDialog parent, boolean modal, DbUtil dbUtil, CallbackTableChange callback, Table table, Bill bill) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.parent = parent;
        this.callback = callback;
        this.dbUtil = dbUtil;
        this.bill = bill;
        this.table = table;

        this.areaDao = new AreaDao(dbUtil);
        this.tableDao = new TableDao(dbUtil);
        this.billDao = new BillDao(dbUtil);

        loadArea();
    }

    public void loadArea() {
        cboTable.removeAllItems();
        areas = areaDao.getAll();
        DefaultComboBoxModel<Area> dcbm = new DefaultComboBoxModel<>();
        areas.forEach(obj -> {
            dcbm.addElement(obj);
        });
        cboArea.setModel(dcbm);

        if (!Common.isNullOrEmpty(table)) {
            areas.forEach(obj -> {
                if (Objects.equals(obj.getId(), table.getArea_id())) {
                    cboArea.setSelectedItem(obj);
                    loadTable(obj);
                }
            });
        }
    }

    public void loadTable(Area area) {
        cboTable.removeAllItems();

        if (!Common.isNullOrEmpty(area)) {
            tables = tableDao.getAll(new Table(area.getId()));
            DefaultComboBoxModel<Table> dcbm = new DefaultComboBoxModel<>();
            tables.forEach(obj -> {
                Bill newBill = billDao.getByTableId(new Bill(obj.getId(), false));

                if (Common.isNullOrEmpty(newBill)) {
                    dcbm.addElement(obj);
                }
            });
            cboTable.setModel(dcbm);

            if (!Common.isNullOrEmpty(table)) {
                tables.forEach(obj -> {
                    if (Objects.equals(obj.getId(), table.getId())) {
                        cboTable.setSelectedItem(obj);
                    }
                });
            }
        }
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
        btnChangeTable = new javax.swing.JButton();
        lblArea = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        cboTable = new javax.swing.JComboBox<>();
        lblTable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CẬP NHẬT BÀN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_product_50px_2.png"))); // NOI18N
        lblTitle.setText("ĐỔI BÀN");

        btnChangeTable.setBackground(new java.awt.Color(0, 204, 106));
        btnChangeTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnChangeTable.setForeground(new java.awt.Color(255, 255, 255));
        btnChangeTable.setText("Đổi bàn");
        btnChangeTable.setBorderPainted(false);
        btnChangeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChangeTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeTableActionPerformed(evt);
            }
        });

        lblArea.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblArea.setText("Khu vực");

        cboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAreaActionPerformed(evt);
            }
        });

        lblTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblTable.setText("Bàn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 427, Short.MAX_VALUE)
                        .addComponent(btnChangeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTable, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnChangeTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeTableActionPerformed
        int table_id = ((Table) cboTable.getSelectedItem()).getId();

        try {
            if (!Common.isNullOrEmpty(bill)) {
                bill.setTable_id(table_id);

                Map<String, Object> result = billDao.update(bill);

                if ((boolean) result.get("status") == true) {
                    JOptionPane.showMessageDialog(this, result.get("message"));
                    callback.actionTableChange();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, result.get("message"));
                }
            }
        } catch (Exception e) {
            response = new BaseMessage(Constant.ERROR_RESPONSE, e.getMessage());
            log.error(Common.createMessageLog(null, response, "btnModifyActionPerformed"));
        }
    }//GEN-LAST:event_btnChangeTableActionPerformed

    private void cboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAreaActionPerformed
        if (((Area) cboArea.getSelectedItem()).getId() != 0) {
            loadTable((Area) cboArea.getSelectedItem());
        }
    }//GEN-LAST:event_cboAreaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Area> cboArea;
    private javax.swing.JComboBox<Table> cboTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblTable;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
