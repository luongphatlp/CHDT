package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.HoaDonBUS;
import BUS.KhuyenMaiBUS;
import DAO.HoaDonDAO;
import DTO.DienThoaiDTO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonUI extends javax.swing.JPanel {

    public HoaDonUI() {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();

        initComponents();
        try {
            loadMaKhuyenMaiToCombo(); // Gọi hàm đổ dữ liệu vào JComboBox
        } catch (Exception e) {
            System.out.println("Lỗi load khuyến mãi: " + e.getMessage());
        }
        String maHD = generateRandomHD();
        jLabel3.setText("Mã hóa đơn: " + maHD);

        HoaDonDAO a = new HoaDonDAO();
        ArrayList<DienThoaiDTO> list = a.selectAllDienThoai();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (DienThoaiDTO dt : list) {
            model.addRow(new Object[]{
                dt.getMa(),
                dt.getTen(),
                dt.getSoLuong(),
                dt.getDonGia()
            });
        }
        System.out.println(list.size());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSpinner2 = new javax.swing.JSpinner();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 103, 174));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1710, 70));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("THANH TOÁN - HÓA ĐƠN SẢN PHẨM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addContainerGap(820, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điện thoại", "Tên điện thoại", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SẢN PHẨM ");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GIỎ HÀNG");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 236));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus (1).png"))); // NOI18N
        jButton1.setText(" Thêm sản phẩm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 236));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/arrow-comparison.png"))); // NOI18N
        jButton2.setText("Thay đổi số lượng");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel3.setText("Mã hóa đơn:");

        jLabel4.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel4.setText("Phương thức thanh toán");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        jLabel5.setText("TỔNG TIỀN HÓA ĐƠN");

        jLabel7.setBackground(new java.awt.Color(51, 255, 51));
        jLabel7.setFont(new java.awt.Font("Roboto Lt", 0, 29)); // NOI18N
        jLabel7.setText("đ");

        btnThanhToan.setBackground(new java.awt.Color(0, 153, 153));
        btnThanhToan.setFont(new java.awt.Font("Roboto Lt", 1, 21)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/coin.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.setBorderPainted(false);
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        buttonGroup1.add(jCheckBox2);
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 2, 19)); // NOI18N
        jCheckBox2.setText("thanh toán trực tiếp");

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 2, 19)); // NOI18N
        jCheckBox3.setText("thanh toán trả sau");

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.setFont(new java.awt.Font("Segoe UI", 2, 19)); // NOI18N
        jCheckBox4.setText("chuyển khoản");

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 2, 19)); // NOI18N
        jCheckBox5.setText("MOMO");

        jLabel9.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel9.setText("Khuyến mãi");

        jLabel11.setBackground(new java.awt.Color(102, 255, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 33)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 180, 118));
        jLabel11.setText("0");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Số lượng:");

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 236));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        jButton4.setText(" Bỏ chọn Sản phẩm");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jSpinner2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(70, 70, 70)
                                        .addComponent(jButton4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jCheckBox2)
                                                .addGap(48, 48, 48)
                                                .addComponent(jCheckBox4)
                                                .addGap(52, 52, 52)
                                                .addComponent(jCheckBox5))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(53, 53, 53)
                                        .addComponent(jCheckBox3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(180, 180, 180)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel13)
                        .addGap(37, 37, 37)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpinner2)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void capNhatGiaTheoKhuyenMai() {
        String maKMSelected = jComboBox1.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        ChiTietKhuyenMaiBUS ctkmBus = new ChiTietKhuyenMaiBUS();

        for (int i = 0; i < model.getRowCount(); i++) {
            String maSP = model.getValueAt(i, 0).toString(); // Giả sử cột 0 là Mã SP
            int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString()); // Cột 2 là Số lượng
            int donGiaGoc = Integer.parseInt(model.getValueAt(i, 3).toString()); // Cột 3 là Đơn giá

            int phanTramGiam = 0;
            if (!maKMSelected.equals("Không áp dụng")) {
                phanTramGiam = ctkmBus.getPhanTramGiamGia(maKMSelected, maSP);
            }

            // Tính toán thành tiền mới: (Đơn giá * Số lượng) * (100 - % giảm) / 100
            int thanhTienMoi = (donGiaGoc * soLuong) * (100 - phanTramGiam) / 100;

            // Cập nhật lại cột Thành tiền (giả sử là cột 4)
            model.setValueAt(thanhTienMoi, i, 4);
        }

        // Đừng quên gọi hàm tính tổng tiền cuối cùng của hóa đơn sau khi cập nhật bảng
        // tinhTongTienHoaDon(); 
    }

    private void loadMaKhuyenMaiToCombo() {
        KhuyenMaiBUS kmBus = new KhuyenMaiBUS();
        ArrayList<KhuyenMaiDTO> listKM = kmBus.getDSKMHoatDong();

        // Tạm thời tắt sự kiện để tránh việc ComboBox bị trống gây lỗi
        // jComboBox1.removeActionListener(jComboBox1.getActionListeners()[0]); 
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Không áp dụng");

        if (listKM != null && !listKM.isEmpty()) {
            for (KhuyenMaiDTO km : listKM) {
                jComboBox1.addItem(km.getMa());
            }
        }

        // Set mặc định chọn cái đầu tiên (Không áp dụng)
        jComboBox1.setSelectedIndex(0);
    }
    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        if (jTable2.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Giỏ hàng trống!");
            return;
        }

        // --- Logic lấy Phương thức thanh toán chuẩn ---
        String pttt = "";
        if (jCheckBox2.isSelected()) {
            pttt = "Thanh toán trực tiếp";
        } else if (jCheckBox3.isSelected()) {
            pttt = "Thanh toán trả sau";
        } else if (jCheckBox4.isSelected()) {
            pttt = "Chuyển khoản";
        } else if (jCheckBox5.isSelected()) {
            pttt = "MOMO";
        }

        if (pttt.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức thanh toán!");
            return;
        }

        // 1. Lấy mã khuyến mãi đang được chọn từ jComboBox1
        // Thêm kiểm tra null để tránh lỗi nếu ComboBox trống
        String maKM = "";
        if (jComboBox1.getSelectedItem() != null) {
            maKM = jComboBox1.getSelectedItem().toString();
        } else {
            maKM = "Không có";
        }

        // Lấy dữ liệu bảng và tổng tiền
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable2.getModel();
        String tongTien = jLabel11.getText();
        String maHD = jLabel3.getText().replace("Mã hóa đơn: ", "");

        // 2. Gọi Dialog với đầy đủ tham số (đã thêm maKM vào cuối)
        XacNhanTTUI xn = new XacNhanTTUI(
                (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this),
                true,
                model,
                tongTien,
                pttt,
                maHD,
                maKM
        );

        xn.setVisible(true);

        if (xn.getReturnStatus() == XacNhanTTUI.RET_OK) {
            // Clear giỏ hàng sau khi xác nhận thành công
            model.setRowCount(0);
            jLabel11.setText("0");

            // Reset ComboBox về trạng thái ban đầu (nếu cần)
            if (jComboBox1.getItemCount() > 0) {
                jComboBox1.setSelectedIndex(0);
            }

            // Bỏ chọn các checkbox (Nếu bạn dùng ButtonGroup cho CheckBox)
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            jCheckBox5.setSelected(false);

            javax.swing.JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        }

    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng!");
            return;
        }

        String maSP = jTable1.getValueAt(row, 0).toString();
        String tenSP = jTable1.getValueAt(row, 1).toString();
        int soLuongTon = Integer.parseInt(jTable1.getValueAt(row, 2).toString());
        int donGia = Integer.parseInt(jTable1.getValueAt(row, 3).toString());

        int soLuongMua = (int) jSpinner1.getValue();

        HoaDonBUS bus = new HoaDonBUS();
        if (bus.checkSoLuong(soLuongMua, soLuongTon)) {

            int thanhTien = bus.tinhThanhTien(soLuongMua, donGia);

            DefaultTableModel modelGioHang = (DefaultTableModel) jTable2.getModel();

            boolean exists = false;
            for (int i = 0; i < jTable2.getRowCount(); i++) {
                if (jTable2.getValueAt(i, 0).equals(tenSP)) {
                    int currentQty = (int) jTable2.getValueAt(i, 2);
                    int newQty = currentQty + soLuongMua;

                    if (newQty <= soLuongTon) {
                        jTable2.setValueAt(newQty, i, 2);
                        jTable2.setValueAt(newQty * donGia, i, 3);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tổng số lượng trong giỏ vượt quá tồn kho!");
                    }
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                modelGioHang.addRow(new Object[]{
                    tenSP,
                    donGia,
                    soLuongMua,
                    thanhTien
                });
            }

            tinhLaiTongTien();
        }
    }

    private void tinhLaiTongTien() {
        int tong = 0;
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            tong += Integer.parseInt(jTable2.getValueAt(i, 3).toString());
        }
        jLabel11.setText(String.valueOf(tong));
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int rowGioHang = jTable2.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần sửa!");
            return;
        }

        int soLuongMoi = (int) jSpinner2.getValue();
        int donGia = Integer.parseInt(jTable2.getValueAt(rowGioHang, 1).toString());

        HoaDonBUS bus = new HoaDonBUS();
        int thanhTienMoi = bus.tinhThanhTien(soLuongMoi, donGia);

        jTable2.setValueAt(soLuongMoi, rowGioHang, 2);
        jTable2.setValueAt(thanhTienMoi, rowGioHang, 3);

        tinhLaiTongTien();
        javax.swing.JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng!");
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int rowGioHang = jTable2.getSelectedRow();
        if (rowGioHang != -1) {
            String tenSP = jTable2.getValueAt(rowGioHang, 0).toString();
            int soLuongHienTai = (int) jTable2.getValueAt(rowGioHang, 2);
            int soLuongTonKho = 0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                if (jTable1.getValueAt(i, 1).toString().equals(tenSP)) {
                    soLuongTonKho = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
                    break;
                }
            }
            javax.swing.SpinnerNumberModel model = new javax.swing.SpinnerNumberModel(soLuongHienTai, 1, soLuongTonKho, 1);
            jSpinner2.setModel(model);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        int rowGioHang = jTable2.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong giỏ hàng để xóa!");
            return;
        }
        String tenSP = jTable2.getValueAt(rowGioHang, 0).toString();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn bỏ chọn " + tenSP + " ra khỏi giỏ hàng không?",
                "Xác nhận xóa",
                javax.swing.JOptionPane.YES_NO_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            DefaultTableModel modelGioHang = (DefaultTableModel) jTable2.getModel();
            modelGioHang.removeRow(rowGioHang);
            tinhLaiTongTien();
            jSpinner2.setValue(1);
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm khỏi giỏ hàng.");
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem() == null) {
            return;
        }

        // Sau khi kiểm tra an toàn mới gọi logic giảm giá
        capNhatGiaTheoKhuyenMai();
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    private String generateRandomHD() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder("HD");
        java.util.Random random = new java.util.Random();

        // Tạo 6 ký tự ngẫu nhiên sau chữ "HD"
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
