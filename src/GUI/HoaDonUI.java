package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.HoaDonBUS;
import BUS.KhuyenMaiBUS;
import DAO.HoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.DienThoaiDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
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
        customTable();
        veBangHoaDon();
    }
    public void veBangHoaDon(){
        ArrayList<SanPhamDTO> list = bus.selectAllDienThoai();
        DefaultTableModel model = (DefaultTableModel) bangsanpham.getModel();
        model.setRowCount(0);
        for (SanPhamDTO dt : list) {
            model.addRow(new Object[]{
                dt.getMaSP(),
                dt.getTenSP(),
                dt.getSoLuong(),
                dt.getDonGia()
            });
        }
    }
    public void capNhatSoLuong(){
        int rowGioHang = bangchitietsanpham.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần sửa!");
            return;
        }

        int soLuongMoi = (int) spcapnhatsoluong.getValue();
        int donGia = Integer.parseInt(bangchitietsanpham.getValueAt(rowGioHang, 2).toString());

        int thanhTienMoi = bus.tinhThanhTien(soLuongMoi, donGia);

        bangchitietsanpham.setValueAt(soLuongMoi, rowGioHang, 4);
        bangchitietsanpham.setValueAt(thanhTienMoi, rowGioHang, 5);

        tinhLaiTongTien();
        javax.swing.JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng!");
    }
    public void boChonSanPham(){
        DefaultTableModel model= (DefaultTableModel) bangchitietsanpham.getModel();
        int row=bangchitietsanpham.getSelectedRow();
        if(row!=-1){
            model.removeRow(row);
        }else{
            JOptionPane.showMessageDialog(null,"Vui lòng chọn dòng để xóa");
            return;
        }
    }
    public void thanhToan(){
                if (bangchitietsanpham.getRowCount() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Giỏ hàng trống!");
            return;
        }
        
        String pttt =cbpttt.getSelectedItem().toString();
        if (pttt.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn phương thức thanh toán!");
            return;
        }
        if(txtsdt.getText().equals("") || txthoten.getText().equals("") || txtemail.getText().equals("")){
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng nhập đày đủ thông tin khách hàng");
            return;
        }
        KhachHangDTO kh = bus.layKhachHangBySDT(txtsdt.getText());
        if(kh==null){
            JOptionPane.showMessageDialog(null, "Không tồn tại khách hàng");
            return;
        } 
        String makh=kh.getMa();
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) bangchitietsanpham.getModel();
        String tongTien = lbtongtien.getText();
        String maHD=bus.taoMaHD();
        java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);
        
        XacNhanTTUI xn = new XacNhanTTUI(parent, true, model, tongTien, pttt, maHD);
        xn.setVisible(true);
        
        if (xn.getReturnStatus() == XacNhanTTUI.RET_OK) {

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Giỏ hàng trống!");
                return;
            }

            ArrayList<SanPhamDTO> ds = new ArrayList<>();
            ArrayList<ChiTietHoaDonDTO> dscthd= new ArrayList<>();

            for (int i = 0; i < model.getRowCount(); i++) {
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(model.getValueAt(i, 0).toString());
                sp.setTenSP(model.getValueAt(i, 1).toString());
                sp.setSoLuong(Integer.parseInt(model.getValueAt(i, 4).toString()));
                ds.add(sp);
            }
            String mahd=bus.taoMaHD();
            for (int i = 0; i < model.getRowCount(); i++) {
                ChiTietHoaDonDTO cthd = new ChiTietHoaDonDTO();
                cthd.setMaHD(mahd);
                cthd.setMaSP(model.getValueAt(i, 0).toString());
                cthd.setSoLuong(Integer.parseInt(model.getValueAt(i, 4).toString()));
                cthd.setDonGia(Integer.parseInt(model.getValueAt(i, 2).toString()) - Integer.parseInt(model.getValueAt(i, 3).toString()));
                cthd.setThanhTien(Integer.parseInt(model.getValueAt(i, 4).toString()));
                dscthd.add(cthd);
            }
            HoaDonDTO hd = thanhToan(mahd);

            int ok = bus.insert(hd);
            
            
            if (ok==0) {
                JOptionPane.showMessageDialog(null, "Lỗi lưu hóa đơn!");
                return;
            }
            bus.capNhatSoLuongSanPham(dscthd);
            bus.insertCTHD(dscthd);
            
            ThemBaoHanhUI tbh = new ThemBaoHanhUI(makh, hd.getMaHD(), ds);
            tbh.setVisible(true);

            // Reset UI
            model.setRowCount(0);
            lbtongtien.setText("0đ");
            cbpttt.setSelectedIndex(0);
            veBangHoaDon();
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangsanpham = new javax.swing.JTable();
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
        jSeparator3 = new javax.swing.JSeparator();
        lbtongtien = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        spcapnhatsoluong = new javax.swing.JSpinner();
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

        bangsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã điện thoại", "Tên điện thoại", "Số lượng", "Đơn giá"
            }
        ));
        bangsanpham.setSelectionBackground(new java.awt.Color(26, 75, 128));
        bangsanpham.setSelectionForeground(new java.awt.Color(255, 255, 255));
        bangsanpham.setShowHorizontalLines(true);
        bangsanpham.setShowVerticalLines(true);
        bangsanpham.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(bangsanpham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SẢN PHẨM ");

        bangchitietsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Đơn giá", "Giảm", "Số lượng", "Thành tiền"
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

        lbtongtien.setBackground(new java.awt.Color(102, 255, 51));
        lbtongtien.setFont(new java.awt.Font("Segoe UI Black", 0, 33)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(49, 180, 118));
        lbtongtien.setText("0");

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Số lượng:");

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 236));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus.png"))); // NOI18N
        jButton4.setText(" Bỏ chọn Sản phẩm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        spcapnhatsoluong.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel7.setText("Email khách:");

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel10.setText("Tên khách:");

        jLabel12.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel12.setText("SĐT khách:");

        cbpttt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbpttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Thẻ ngân hàng" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel13)
                        .addGap(37, 37, 37)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(519, 519, 519)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
                            .addComponent(jSeparator3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(404, 404, 404)
                                .addComponent(jSeparator2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(264, 264, 264)
                                        .addComponent(jLabel6)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(180, 180, 180)
                                            .addComponent(lbtongtien))
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
                                            .addComponent(jButton3))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(spcapnhatsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton2)
                                            .addGap(70, 70, 70)
                                            .addComponent(jButton4)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(201, 201, 201)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lbtongtien))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spcapnhatsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGap(50, 50, 50)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(73, 73, 73)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

    }//GEN-LAST:event_btnThanhToanActionPerformed

    public HoaDonDTO thanhToan(String mahd){
        HoaDonDTO hd=new HoaDonDTO();
        hd.setMaHD(mahd);

        hd.setNgay( LocalDateTime.now());
        hd.setMaNV(DTO.TaiKhoanSession.nvDangNhap.getMaNV());

        
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
            sp.setSoLuong(Integer.parseInt(model.getValueAt(i, 4).toString()));
            ds.add(sp);
        }
        return ds;
    }
    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        thanhToan();
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int rowGioHang = bangchitietsanpham.getSelectedRow();
        if (rowGioHang == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm trong giỏ hàng cần sửa!");
            return;
        }
        
        int soLuongMoi = (int) spcapnhatsoluong.getValue();
        int donGia = Integer.parseInt(bangchitietsanpham.getValueAt(rowGioHang, 2).toString());
        int giam=Integer.parseInt(bangchitietsanpham.getValueAt(rowGioHang, 3).toString());
        
        int thanhTienMoi = soLuongMoi * (donGia-giam) ;

        bangchitietsanpham.setValueAt(soLuongMoi, rowGioHang, 4);
        bangchitietsanpham.setValueAt(thanhTienMoi, rowGioHang, 5);
        tinhLaiTongTien();
        javax.swing.JOptionPane.showMessageDialog(this, "Đã cập nhật số lượng!");
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int row = bangsanpham.getSelectedRow();
        if (row == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng!");
            return;
        }
        
        String maSP = bangsanpham.getValueAt(row, 0).toString();
        String tenSP = bangsanpham.getValueAt(row, 1).toString();
        int soLuongTon = Integer.parseInt(bangsanpham.getValueAt(row, 2).toString());
        int donGia = Integer.parseInt(bangsanpham.getValueAt(row, 3).toString());

        int soLuongMua = (int) jSpinner1.getValue();

        if (bus.checkSoLuong(soLuongMua, soLuongTon)) {

            int thanhTien = bus.tinhThanhTien(soLuongMua, donGia);

            DefaultTableModel modelGioHang = (DefaultTableModel) bangchitietsanpham.getModel();

            boolean exists = false;
            for (int i = 0; i < bangchitietsanpham.getRowCount(); i++) {
                if (bangchitietsanpham.getValueAt(i, 0).equals(tenSP)) {
                    int currentQty = (int) bangchitietsanpham.getValueAt(i, 4);
                    int newQty = currentQty + soLuongMua;

                    if (newQty <= soLuongTon) {
                        bangchitietsanpham.setValueAt(newQty, i, 4);
                        bangchitietsanpham.setValueAt(newQty * donGia, i, 5);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tổng số lượng trong giỏ vượt quá tồn kho!");
                    }
                    exists = true;
                    break;
                }
            }
            
            if (!exists) {
                ChiTietHoaDonDTO cthd=new ChiTietHoaDonDTO();
                cthd.setMaSP(maSP);
                cthd.setDonGia(donGia);
                cthd.setSoLuong(soLuongMua);
                cthd.setThanhTien(thanhTien);
                Vector row1=new Vector();
                row1.add(cthd.getMaSP());
                row1.add(tenSP);
                row1.add(cthd.getDonGia());
                int giam=tinhKhuyenMai(cthd);
                row1.add(giam);
                row1.add(cthd.getSoLuong());
                row1.add(thanhTien-giam);
                modelGioHang.addRow(row1);
                
            }

            tinhLaiTongTien();
        }
    }
    public int tinhKhuyenMai(ChiTietHoaDonDTO cthd){
        return bus.tinhTienSauKhuyenMai(cthd);
    }
        private void tinhLaiTongTien() {
            int tong = 0;
            for (int i = 0; i < bangchitietsanpham.getRowCount(); i++) {
                tong += Integer.parseInt(bangchitietsanpham.getValueAt(i, 5).toString());
            }
            lbtongtien.setText(String.valueOf(tong));
    }//GEN-LAST:event_jButton1MouseClicked

    private void bangchitietsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangchitietsanphamMouseClicked
         int rowGioHang = bangchitietsanpham.getSelectedRow();

    if (rowGioHang != -1) {
        String masp = bangchitietsanpham.getValueAt(rowGioHang, 0).toString();
        int soLuongHienTai = Integer.parseInt(bangsanpham.getValueAt(rowGioHang, 2).toString());

        int soLuongTonKho = -1;

        for (int i = 0; i < bangsanpham.getRowCount(); i++) {
            if (bangsanpham.getValueAt(i, 0).toString().equals(masp)) {
                soLuongTonKho = Integer.parseInt(bangsanpham.getValueAt(i, 2).toString());
                break;
            }
        }

        // ❗ Không tìm thấy sản phẩm
        if (soLuongTonKho <= 0) {
            JOptionPane.showMessageDialog(null, "Sản phẩm hết hàng hoặc không tồn tại!");
            return;
        }

        // ❗ Ép value vào khoảng hợp lệ
        if (soLuongHienTai > soLuongTonKho) {
            soLuongHienTai = soLuongTonKho;
        }

        javax.swing.SpinnerNumberModel model =
            new javax.swing.SpinnerNumberModel(soLuongHienTai, 1, soLuongTonKho, 1);

        spcapnhatsoluong.setModel(model);
    }
    }//GEN-LAST:event_bangchitietsanphamMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String sdt=txtsdt.getText();
        KhachHangDTO kh= bus.layKhachHangBySDT(sdt);
        if(kh==null){
            JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng");
            return;
        }
        txthoten.setText(kh.getHoten());
        txtemail.setText(kh.getEmail());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row=bangchitietsanpham.getSelectedRow();
        if(row!=-1){
            DefaultTableModel model=(DefaultTableModel) bangchitietsanpham.getModel();
            model.removeRow(row);
            bangchitietsanpham.setModel(model);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    private void customTable() {
        // 1. Chỉnh Font Arial, kích thước 16 cho nội dung bảng
        java.awt.Font tableFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18);
        bangsanpham.setFont(tableFont);

        bangsanpham.setRowHeight(30);
        bangsanpham.getTableHeader().setOpaque(false);
//        jTable1.getTableHeader().setBackground(new Color(32,136,203));
//        jTable1.getTableHeader().setForeground(new Color(32,132,230));
        bangsanpham.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        for (int i = 0; i < bangsanpham.getColumnCount(); i++) {
            bangsanpham.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        resizeColumnWidth(bangsanpham);
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
    
        private void tinhLaiTongHoaDon() {
        DefaultTableModel model = (DefaultTableModel) bangchitietsanpham.getModel();
        long tongMoi = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                // Cột 3 là Thành tiền
                String strThanhTien = model.getValueAt(i, 5).toString().replaceAll("[^0-9]", "");
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
    private javax.swing.JTable bangsanpham;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbpttt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JSpinner spcapnhatsoluong;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
