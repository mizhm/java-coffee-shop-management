/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.GUI.bill;

import coffeeshop.DAO.impl.BillDao;
import coffeeshop.DTO.Bill;
import coffeeshop.DTO.User;
import coffeeshop.Util.BaseMessage;
import coffeeshop.Util.Common;
import coffeeshop.Util.Constant;
import coffeeshop.Util.DbUtil;
import coffeeshop.Util.Excel;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lombok.extern.log4j.Log4j;

@Log4j
public class PnlBill extends javax.swing.JPanel implements JDSearchBill.CallbackBillSearch, JDDeleteBill.CallbackBillDelete, JDBill.CallbackBillExit {

    Frame parent;
    DbUtil dbUtil;

    Bill bill;
    List<Bill> bills = new ArrayList<>();

    BillDao billDao;
    private BaseMessage response;

    /**
     * Creates new form PnlCategory
     *
     * @param parent
     * @param dbUtil
     * @param user
     */
    public PnlBill(Frame parent, DbUtil dbUtil, User user) {
        initComponents();
        this.parent = parent;
        this.dbUtil = dbUtil;
        this.billDao = new BillDao(dbUtil);

        if (user.getRole() != 1) {
            lblView.setVisible(false);
            lblDelete.setVisible(false);
        }

        loading(null);
    }

    private void loading(Bill newBill) {
        bill = null;
        tblBill.removeAll();
        bills = billDao.getAll(newBill);

        String columns[] = {"Id", "Nhân viên", "Bàn", "Tổng tiền", "Giảm giá", "Trạng thái", "Thời gian"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0);

        if (!Common.isNullOrEmpty(bills)) {
            bills.forEach(obj -> {
                dtm.addRow(new Object[]{obj.getId(), obj.getUser_name(), obj.getTable_name(), obj.getTotal_price(), obj.getDiscount(), obj.getStatus() ? "Đã thanh toán" : "Chưa thanh toán", obj.getCreated_at()});
            });

            tblBill.getSelectionModel().addListSelectionListener((ListSelectionEvent lse) -> {
                int position = tblBill.getSelectedRow();
                if (position >= 0) {
                    bill = bills.get(position);
                }

            });

            tblBill.changeSelection(0, 0, false, false);
        }

        tblBill.setModel(dtm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblView = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        lblDelete = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();
        lblExport = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBill = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 50, 20));

        lblView.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_bill_50px.png"))); // NOI18N
        lblView.setText("Xem");
        lblView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblView.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblView.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewMouseClicked(evt);
            }
        });
        jPanel2.add(lblView);

        lblSearch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_search_50px_1.png"))); // NOI18N
        lblSearch.setText("Tìm kiếm");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });
        jPanel2.add(lblSearch);

        lblDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_delete_50px.png"))); // NOI18N
        lblDelete.setText("Xoá");
        lblDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteMouseClicked(evt);
            }
        });
        jPanel2.add(lblDelete);

        lblRefresh.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_repeat_50px_1.png"))); // NOI18N
        lblRefresh.setText("Làm mới");
        lblRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
        });
        jPanel2.add(lblRefresh);

        lblExport.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblExport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/icons8_repeat_50px_1.png"))); // NOI18N
        lblExport.setText("Xuất Excel");
        lblExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblExport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        lblExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExportMouseClicked(evt);
            }
        });
        jPanel2.add(lblExport);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tblBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblBill.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBill.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblBill);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseClicked
        if (!Common.isNullOrEmpty(bill)) {
            JDBill jdb = new JDBill(parent, true, dbUtil, this, bill);
            jdb.setVisible(true);
        }
    }//GEN-LAST:event_lblViewMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        JDSearchBill jdsb = new JDSearchBill(parent, true, dbUtil, this);
        jdsb.setVisible(true);
    }//GEN-LAST:event_lblSearchMouseClicked

    private void lblDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteMouseClicked
        if (!Common.isNullOrEmpty(bill)) {
            JDDeleteBill deleteBill = new JDDeleteBill(parent, true, dbUtil, this, bill);
            deleteBill.setVisible(true);
        }
    }//GEN-LAST:event_lblDeleteMouseClicked

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        loading(null);
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void lblExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportMouseClicked
        if (!Common.isNullOrEmpty(bills)) {
            try {
                Excel excel = new Excel(dbUtil);
                String table = "Bills";
                String excelFilePath = excel.getFileName(table.concat("_Export"));

                JFileChooser excelFileChooser = new JFileChooser(".");
                excelFileChooser.setDialogTitle("Lưu file ...");
                excelFileChooser.setSelectedFile(new File(excelFilePath));
                Action details = excelFileChooser.getActionMap().get("viewTypeDetails");
                details.actionPerformed(null);
                // Kiểu định dạng file xuất
                FileNameExtensionFilter fnef = new FileNameExtensionFilter("Files", "xls", "xlsx", "xlsm");
                //Setting extension for selected file names
                excelFileChooser.setFileFilter(fnef);

                int chooser = excelFileChooser.showSaveDialog(null);

                if (chooser == JFileChooser.APPROVE_OPTION) {
                    excel.export(table, excelFileChooser.getSelectedFile().getPath());
                    JOptionPane.showMessageDialog(this, "Xuất hoá đơn thành công");
                }
            } catch (HeadlessException e) {
                response = new BaseMessage(Constant.ERROR_RESPONSE, e.getMessage());
                log.error(Common.createMessageLog(null, response, "btnExportActionPerformed"));
            }
        }
    }//GEN-LAST:event_lblExportMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblExport;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblView;
    private javax.swing.JTable tblBill;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionBillDelete() {
        loading(null);
    }

    @Override
    public void actionBillExit() {
        loading(null);
    }

    @Override
    public void actionBillSearch(Bill bill) {
        loading(bill);
    }
}
