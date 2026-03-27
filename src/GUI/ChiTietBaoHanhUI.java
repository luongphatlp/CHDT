
package GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH NHAN
 */
public class ChiTietBaoHanhUI extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChiTietBaoHanhUI.class.getName());
    private javax.swing.table.DefaultTableModel modelGioHang;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;

    public ChiTietBaoHanhUI(java.awt.Frame parent, boolean modal, DefaultTableModel model) {
        super(parent, modal);
        this.modelGioHang = model;
        initComponents();
        setupBaoHanhData();

    }

    private void setupBaoHanhData() {
        if (modelGioHang == null || modelGioHang.getRowCount() == 0) {
            return;
        }

        // --- PHẦN HIỂN THỊ CHO JLABEL ---
        // 1. jLabel3: Hiện mã bảo hành ngẫu nhiên 10 ký tự
        jLabel3.setText("Mã bảo hành: " + generateRandomString(10));

        // 2. jLabel6: Hiện thời gian thực hiện tại
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        jLabel6.setText("Thời gian tạo: " + dtf.format(now));

        // --- PHẦN ĐỔ DỮ LIỆU VÀO BẢNG ---
        javax.swing.table.DefaultTableModel modelTable = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        modelTable.setRowCount(0);

        for (int i = 0; i < modelGioHang.getRowCount(); i++) {
            // Lấy tên máy (Đã fix logic lấy cột chứa chữ ở các bước trước)
            String tenMay = "";
            Object obj0 = modelGioHang.getValueAt(i, 0);
            Object obj1 = modelGioHang.getValueAt(i, 1);

            // Kiểm tra xem cột nào là tên máy (tránh lấy nhầm cột giá tiền)
            if (obj1.toString().matches("-?\\d+(\\.\\d+)?") || obj1.toString().contains("000")) {
                tenMay = obj0.toString();
            } else {
                tenMay = obj1.toString();
            }

            int soLuong = 1;
            try {
                soLuong = Integer.parseInt(modelGioHang.getValueAt(i, 2).toString());
            } catch (Exception e) {
                soLuong = 1;
            }

            // Lấy thời hạn từ DB (Hàm đã sửa tên cột MaBH)
            int thoiHan = getThoiHanBaoHanhFromDB(tenMay);

            for (int j = 0; j < soLuong; j++) {
                modelTable.addRow(new Object[]{
                    generateRandomString(10), // IMEI ngẫu nhiên
                    tenMay,
                    thoiHan + " tháng"
                });
            }
        }
    }

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private int getThoiHanBaoHanhFromDB(String tenMay) {
        int thoiHan = 12;
        // Luôn đảm bảo tên cột là MaBH và Ma theo đúng file SQL chdt(4).sql
        String sql = "SELECT bh.ThoiGian FROM baohanh bh "
                + "JOIN dienthoai dt ON dt.MaBH = bh.Ma "
                + "WHERE dt.Ten = ?";

        try (java.sql.Connection con = DATABASE.Connect.getConnection(); java.sql.PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, tenMay.trim());
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    thoiHan = rs.getInt("ThoiGian");
                }
            }
        } catch (Exception e) {
            System.out.println("Loi SQL: " + e.getMessage());
        }
        return thoiHan;
    }

    public int getReturnStatus() {
        return returnStatus;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(0, 102, 102));
        cancelButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setBackground(new java.awt.Color(0, 102, 102));
        okButton.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("Xác nhận");
        okButton.setFocusPainted(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(39, 94, 94));
        jPanel2.setPreferredSize(new java.awt.Dimension(950, 55));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CHI TIẾT BẢO HÀNH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel3.setText("Mã Bảo hành:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã IMEI", "Tên sản phẩm", "Thời hạn bảo hành", "Tình trạng", "Xử lý"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel6.setText("Thời gian tạo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String maBH = jLabel3.getText().replace("Mã Bảo hành: ", "").trim();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable2.getModel();

        ArrayList<DTO.BaoHanhDTO> ds = new ArrayList<>();
        int thoiHan = Integer.parseInt(model.getValueAt(0, 2).toString().replaceAll("[^0-9]", ""));

        for (int i = 0; i < model.getRowCount(); i++) {
            //ds.add(new DTO.BaoHanhDTO(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(), null));
        }

        BUS.BaoHanhBUS bus = new BUS.BaoHanhBUS();
        /*if (bus.xuLyLuuBaoHanh(maBH, thoiHan, ds)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lưu thành công!");
            this.dispose(); // Đóng cửa sổ
        }*/
    }//GEN-LAST:event_okButtonActionPerformed
    private void updateMainTable() {
        // Nếu bạn có một instance của BaoHanhDienThoaiUI, hãy gọi loadData() của nó ở đây
        // Hoặc đơn giản là thông báo cho người dùng nhấn 'Reset/Làm mới' trên giao diện chính
    }
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChiTietBaoHanhUI dialog = new ChiTietBaoHanhUI(new javax.swing.JFrame(), true, new javax.swing.table.DefaultTableModel());
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
