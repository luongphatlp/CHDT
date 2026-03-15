package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.HoaDonBUS;
import BUS.KhuyenMaiBUS;
import DAO.HoaDonDAO;
import DTO.DienThoaiDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonUI extends javax.swing.JPanel {
    HoaDonBUS bus=new HoaDonBUS();
    public HoaDonUI() {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();

        initComponents();
        try {
            loadMaKhuyenMaiToCombo(); // Gọi hàm đổ dữ liệu vào JComboBox
        } catch (Exception e) {
            System.out.println("Lỗi load khuyến mãi: " + e.getMessage());
        }
        HoaDonDAO a = new HoaDonDAO();
        ArrayList<DienThoaiDTO> list = a.selectAllDienThoai();
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capNhatTongTienVoiKhuyenMai();
            }
        });
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
        customTable();
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
        bangchitietsanpham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lbtongtien = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        cbpttt = new javax.swing.JComboBox<>();

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
        jTable1.setSelectionBackground(new java.awt.Color(26, 75, 128));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SẢN PHẨM ");

        bangchitietsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        bangchitietsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangchitietsanphamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangchitietsanpham);

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

        jLabel4.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel4.setText("Phương thức thanh toán");

        jLabel5.setBackground(new java.awt.Color(51, 255, 51));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 29)); // NOI18N
        jLabel5.setText("TỔNG TIỀN HÓA ĐƠN");

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
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel9.setText("Khuyến mãi");

        lbtongtien.setBackground(new java.awt.Color(102, 255, 51));
        lbtongtien.setFont(new java.awt.Font("Segoe UI Black", 0, 33)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(49, 180, 118));
        lbtongtien.setText("0");

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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSpinner2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel7.setText("Email khách:");

        jButton3.setText("Tìm");

        jLabel10.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel10.setText("Tên khách:");

        jLabel12.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel12.setText("SĐT khách:");

        txthoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotenActionPerformed(evt);
            }
        });

        cbpttt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbpttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Thẻ ngân hàng" }));

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
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(180, 180, 180)
                                        .addComponent(lbtongtien))
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                            .addComponent(jSeparator3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txthoten)
                                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(70, 70, 70)
                                        .addComponent(jButton4))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(264, 264, 264)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbtongtien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGap(50, 50, 50)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(137, 137, 137))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txthotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotenActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        int rowGioHang = bangchitietsanpham.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm trong giỏ hàng để xóa!");
            return;
        }
        String tenSP = bangchitietsanpham.getValueAt(rowGioHang, 0).toString();
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Bạn có muốn bỏ chọn " + tenSP + " ra khỏi giỏ hàng không?",
            "Xác nhận xóa",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            DefaultTableModel modelGioHang = (DefaultTableModel) bangchitietsanpham.getModel();
            modelGioHang.removeRow(rowGioHang);
            tinhLaiTongTien();
            jSpinner2.setValue(1);
            javax.swing.JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm khỏi giỏ hàng.");
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            capNhatThanhTienTheoKhuyenMai();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

    }//GEN-LAST:event_btnThanhToanActionPerformed

    public HoaDonDTO thanhToan(){
        HoaDonDTO hd=new HoaDonDTO();
        hd.setMaHD(bus.taoMaHD());
        hd.setNgay(new Date());
        hd.setMaNV(UTIL.TaiKhoanSession.nvDangNhap.getMaNV());
        
        KhachHangDTO kh=bus.layKhachHangBySDT(txtsdt.getText());
        if(kh==null){
            KhachHangDTO kh1=new KhachHangDTO();
            kh1.setMa(bus.taoMaKH());
            kh1.setHoten(txthoten.getText());
            kh1.setEmail(txtemail.getText());
            kh1.setDt(txtsdt.getText());
            bus.themKH(kh1);
            hd.setMaKH(kh1.getMa());
        }else
            hd.setMaKH(bus.layKhachHangBySDT(txtsdt.getText()).getMa());
        String tt=lbtongtien.getText();
        hd.setTongTien(Integer.parseInt(tt));
        hd.setPTTT(cbpttt.getSelectedItem().toString());
        return hd;
    }
    public ArrayList<SanPhamDTO> chuyenDSSanPham(){
        DefaultTableModel model = (DefaultTableModel) bangchitietsanpham.getModel();
        ArrayList<SanPhamDTO> ds=new ArrayList<>();
        for(int i=0;i<model.getRowCount();i++){
            SanPhamDTO sp=new SanPhamDTO();
            sp.setMaSP(model.getValueAt(i, 0).toString());
            sp.setTenSP(model.getValueAt(i, 1).toString());
            sp.setDonGia(Integer.parseInt(model.getValueAt(i, 2).toString()));
            sp.setSoLuong(Integer.parseInt(model.getValueAt(i, 3).toString()));
            ds.add(sp);
        }
        return ds;
    }
    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        if (bangchitietsanpham.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Giỏ hàng trống!");
            return;
        }

        String pttt =cbpttt.getSelectedItem().toString();
        if (pttt.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức thanh toán!");
            return;
        }

        String maKM = (jComboBox1.getSelectedItem() != null) ? jComboBox1.getSelectedItem().toString() : "Không có";
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) bangchitietsanpham.getModel();
        String tongTien = lbtongtien.getText();
        String maHD=bus.taoMaHD();
        java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        XacNhanTTUI xn = new XacNhanTTUI(parent, true, model, tongTien, pttt, maHD, maKM);
        xn.setVisible(true);
        
        if (xn.getReturnStatus() == XacNhanTTUI.RET_OK) {
            // Khởi tạo ThemBaoHanhUI và truyền model giỏ hàng vào để xử lý cho ChiTietBaoHanhUI sau này
            HoaDonDTO hd=thanhToan();
            ThemBaoHanhUI tbh = new ThemBaoHanhUI();
            tbh.setVisible(true);

            // Làm mới giao diện sau khi hoàn tất
            model.setRowCount(0);
            lbtongtien.setText("0đ");
            jComboBox1.setSelectedIndex(0);
            cbpttt.setSelectedIndex(0);

        }

    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int rowGioHang = bangchitietsanpham.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần sửa!");
            return;
        }

        int soLuongMoi = (int) jSpinner2.getValue();
        int donGia = Integer.parseInt(bangchitietsanpham.getValueAt(rowGioHang, 1).toString());

        HoaDonBUS bus = new HoaDonBUS();
        int thanhTienMoi = bus.tinhThanhTien(soLuongMoi, donGia);

        bangchitietsanpham.setValueAt(soLuongMoi, rowGioHang, 2);
        bangchitietsanpham.setValueAt(thanhTienMoi, rowGioHang, 3);

        tinhLaiTongTien();
        javax.swing.JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng!");
    }//GEN-LAST:event_jButton2MouseClicked

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

            DefaultTableModel modelGioHang = (DefaultTableModel) bangchitietsanpham.getModel();

            boolean exists = false;
            for (int i = 0; i < bangchitietsanpham.getRowCount(); i++) {
                if (bangchitietsanpham.getValueAt(i, 0).equals(tenSP)) {
                    int currentQty = (int) bangchitietsanpham.getValueAt(i, 2);
                    int newQty = currentQty + soLuongMua;

                    if (newQty <= soLuongTon) {
                        bangchitietsanpham.setValueAt(newQty, i, 2);
                        bangchitietsanpham.setValueAt(newQty * donGia, i, 3);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tổng số lượng trong giỏ vượt quá tồn kho!");
                    }
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                modelGioHang.addRow(new Object[]{
                    maSP,
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
            for (int i = 0; i < bangchitietsanpham.getRowCount(); i++) {
                tong += Integer.parseInt(bangchitietsanpham.getValueAt(i, 3).toString());
            }
            lbtongtien.setText(String.valueOf(tong));
    }//GEN-LAST:event_jButton1MouseClicked

    private void bangchitietsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangchitietsanphamMouseClicked
        int rowGioHang = bangchitietsanpham.getSelectedRow();
        if (rowGioHang != -1) {
            String tenSP = bangchitietsanpham.getValueAt(rowGioHang, 0).toString();
            int soLuongHienTai = (int) bangchitietsanpham.getValueAt(rowGioHang, 2);
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
    }//GEN-LAST:event_bangchitietsanphamMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    private void customTable() {
        // 1. Chỉnh Font Arial, kích thước 16 cho nội dung bảng
        java.awt.Font tableFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18);
        jTable1.setFont(tableFont);

        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setOpaque(false);
//        jTable1.getTableHeader().setBackground(new Color(32,136,203));
//        jTable1.getTableHeader().setForeground(new Color(32,132,230));
        jTable1.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        resizeColumnWidth(jTable1);
    }

    private void resizeColumnWidth(javax.swing.JTable table) {
        final javax.swing.table.TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 70; // Độ rộng tối thiểu
            for (int row = 0; row < table.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer renderer = table.getCellRenderer(row, column);
                java.awt.Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 15, width);
            }
            if (width > 400) {
                width = 400; // Giới hạn độ rộng tối đa
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void capNhatGiaTheoKhuyenMai() {
        String maKMSelected = jComboBox1.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) bangchitietsanpham.getModel();
        ChiTietKhuyenMaiBUS ctkmBus = new ChiTietKhuyenMaiBUS();

        for (int i = 0; i < model.getRowCount(); i++) {
            String maSP = model.getValueAt(i, 0).toString(); // Giả sử cột 0 là Mã SP
            int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString()); // Cột 2 là Số lượng
            int donGiaGoc = Integer.parseInt(model.getValueAt(i, 3).toString()); // Cột 3 là Đơn giá

            int phanTramGiam = 0;
            if (!maKMSelected.equals("Không áp dụng")) {
                phanTramGiam = ctkmBus.layPhanTramGiam(maKMSelected, maSP);
            }

            // Tính toán thành tiền mới: (Đơn giá * Số lượng) * (100 - % giảm) / 100
            int thanhTienMoi = (donGiaGoc * soLuong) * (100 - phanTramGiam) / 100;

            // Cập nhật lại cột Thành tiền (giả sử là cột 4)
            model.setValueAt(thanhTienMoi, i, 4);
        }

        // Đừng quên gọi hàm tính tổng tiền cuối cùng của hóa đơn sau khi cập nhật bảng
        // tinhTongTienHoaDon(); 
    }

    private void capNhatTongTienVoiKhuyenMai() {
        Object selectedItem = jComboBox1.getSelectedItem();
        if (selectedItem == null) {
            return;
        }

        String maKM = selectedItem.toString();
        ChiTietKhuyenMaiBUS ctkmBUS = new ChiTietKhuyenMaiBUS();
        DefaultTableModel modelGioHang = (DefaultTableModel) bangchitietsanpham.getModel();
        DefaultTableModel modelSanPham = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < modelGioHang.getRowCount(); i++) {
            try {
                String maSP = modelGioHang.getValueAt(i, 0).toString().trim();
                int soLuong = Integer.parseInt(modelGioHang.getValueAt(i, 2).toString().replaceAll("[^0-9]", ""));

                // Lấy Đơn giá gốc từ bảng sản phẩm (jTable1 - Cột 3) để tính toán luôn chính xác
                long donGiaGoc = 0;
                for (int j = 0; j < modelSanPham.getRowCount(); j++) {
                    if (modelSanPham.getValueAt(j, 0).toString().trim().equals(maSP)) {
                        donGiaGoc = Long.parseLong(modelSanPham.getValueAt(j, 3).toString().replaceAll("[^0-9]", ""));
                        break;
                    }
                }

                // Nếu không tìm thấy giá gốc ở jTable1, lấy giá ở cột 1 của jTable2 làm gốc
                if (donGiaGoc == 0) {
                    donGiaGoc = Long.parseLong(modelGioHang.getValueAt(i, 1).toString().replaceAll("[^0-9]", ""));
                }

                // Tra cứu % giảm giá từ database
                int phanTramGiam = 0;
                if (!maKM.equals("Không áp dụng") && !maKM.equals("Chọn mã KM")) {
                    phanTramGiam = ctkmBUS.layPhanTramGiam(maKM, maSP);
                }

                // TÍNH TOÁN: Thành tiền = (Đơn giá * Số lượng) * (100 - % giảm) / 100
                long thanhTienMoi = (donGiaGoc * soLuong) * (100 - phanTramGiam) / 100;

                // Cập nhật lại cột Thành tiền (index 3)
                modelGioHang.setValueAt(String.format("%,d", thanhTienMoi).replace(",", ".") + "đ", i, 3);

            } catch (Exception e) {
                System.err.println("Lỗi xử lý khuyến mãi dòng " + i + ": " + e.getMessage());
            }
        }
        // Cuối cùng, cập nhật jLabel11
        tinhLaiTongHoaDon();
    }

    private void capNhatThanhTienTheoKhuyenMai() {
        if (jComboBox1.getSelectedItem() == null) {
            return;
        }
        String maKMSelected = jComboBox1.getSelectedItem().toString();

        BUS.ChiTietKhuyenMaiBUS ctkmBUS = new BUS.ChiTietKhuyenMaiBUS();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) bangchitietsanpham.getModel();
        long tongTienMoi = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                // Lấy Tên SP từ cột 0 để tìm Mã SP tương ứng (vì bảng jTable2 của bạn đang hiển thị Tên ở cột 0)
                String tenSP = model.getValueAt(i, 0).toString();
                String maSP = "";

                // Tìm Mã SP dựa trên Tên SP từ jTable1 (Bảng sản phẩm gốc)
                for (int j = 0; j < jTable1.getRowCount(); j++) {
                    if (jTable1.getValueAt(j, 1).toString().equals(tenSP)) {
                        maSP = jTable1.getValueAt(j, 0).toString();
                        break;
                    }
                }

                // Lấy Đơn giá (cột 1) và Số lượng (cột 2)
                long donGia = Long.parseLong(model.getValueAt(i, 1).toString().replaceAll("[^0-9]", ""));
                int soLuong = Integer.parseInt(model.getValueAt(i, 2).toString().replaceAll("[^0-9]", ""));

                int phanTramGiam = 0;
                // Nếu không phải là "Không áp dụng", thực hiện tra cứu % giảm trong BUS
                if (!maKMSelected.equals("Không áp dụng")) {
                    phanTramGiam = ctkmBUS.layPhanTramGiam(maKMSelected, maSP);
                }

                // Tính toán thành tiền sau khi giảm %
                long thanhTienMoi = (donGia * soLuong) * (100 - phanTramGiam) / 100;

                // Cập nhật lại cột Thành tiền (cột 3) của jTable2
                model.setValueAt(thanhTienMoi + "đ", i, 3);

                tongTienMoi += thanhTienMoi;

            } catch (Exception e) {
                System.err.println("Lỗi tính toán tại dòng " + i + ": " + e.getMessage());
            }
        }

        // 2. Cập nhật nhãn tổng tiền hóa đơn
        lbtongtien.setText(tongTienMoi + "đ");
        tinhLaiTongHoaDon();

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
    }    private String generateIMEI(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        java.util.Random rnd = new java.util.Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }    private void tinhLaiTongHoaDon() {
        DefaultTableModel model = (DefaultTableModel) bangchitietsanpham.getModel();
        long tongMoi = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                // Cột 3 là Thành tiền
                String strThanhTien = model.getValueAt(i, 3).toString().replaceAll("[^0-9]", "");
                if (!strThanhTien.isEmpty()) {
                    tongMoi += Long.parseLong(strThanhTien);
                }
            } catch (Exception e) {
                System.err.println("Lỗi tính tổng: " + e.getMessage());
            }
        }
        // Cập nhật nhãn hiển thị tổng tiền
        lbtongtien.setText(String.format("%,d", tongMoi).replace(",", ".") + "đ");    
    }   
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
    private javax.swing.JTable bangchitietsanpham;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbpttt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
