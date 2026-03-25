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
            txtsdt.setText("");
            txthoten.setText("");
            txtemail.setText("");
            veBangHoaDon();
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        taokhachhang = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txttaomakh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttaohoten = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttaosdt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txttaoemail = new javax.swing.JTextField();
        bttaokhachhang = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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
        jLabel5 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        lbtongtien = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel13 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        spcapnhatsoluong = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        cbpttt = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Tạo khách hàng");

        jLabel9.setText("Mã khách hàng");

        txttaomakh.setEnabled(false);

        jLabel11.setText("Họ tên:");

        jLabel14.setText("Số điện thoại:");

        txttaosdt.setEnabled(false);

        jLabel15.setText("Email:");

        bttaokhachhang.setText("Xác nhận");
        bttaokhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttaokhachhangActionPerformed(evt);
            }
        });

        jButton6.setText("Hủy");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout taokhachhangLayout = new javax.swing.GroupLayout(taokhachhang.getContentPane());
        taokhachhang.getContentPane().setLayout(taokhachhangLayout);
        taokhachhangLayout.setHorizontalGroup(
            taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taokhachhangLayout.createSequentialGroup()
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taokhachhangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(taokhachhangLayout.createSequentialGroup()
                                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttaomakh)
                                    .addComponent(txttaohoten, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))
                            .addGroup(taokhachhangLayout.createSequentialGroup()
                                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttaosdt, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(txttaoemail)))))
                    .addGroup(taokhachhangLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel3))
                    .addGroup(taokhachhangLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(bttaokhachhang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        taokhachhangLayout.setVerticalGroup(
            taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taokhachhangLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttaomakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txttaohoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txttaosdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txttaoemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(taokhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttaokhachhang)
                    .addComponent(jButton6))
                .addContainerGap())
        );

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
                .addContainerGap(816, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(1710, 1010));

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

        cbpttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Thẻ ngân hàng" }));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách mua hàng"));

        jLabel12.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel12.setText("SĐT khách:");

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel10.setText("Tên khách:");

        jLabel7.setFont(new java.awt.Font("Roboto Lt", 0, 24)); // NOI18N
        jLabel7.setText("Email khách:");

        txthoten.setEnabled(false);

        txtemail.setEnabled(false);
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        cbpttt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbpttt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Thẻ ngân hàng" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13)
                        .addGap(37, 37, 37)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(spcapnhatsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(34, 34, 34)
                                .addComponent(jButton4)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(93, 93, 93)
                                        .addComponent(lbtongtien))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1088, 1088, 1088)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spcapnhatsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbpttt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbtongtien))
                        .addGap(18, 18, 18)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(133, 133, 133))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

    }//GEN-LAST:event_btnThanhToanActionPerformed

    public HoaDonDTO thanhToan(String mahd){
        HoaDonDTO hd=new HoaDonDTO();
        hd.setMaHD(mahd);

        hd.setNgay( LocalDateTime.now());
        hd.setMaNV(DTO.TaiKhoanSession.nvDangNhap.getMaNV());

        
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
                if (bangchitietsanpham.getValueAt(i, 0).equals(maSP)) {
                    int currentQty = (int) bangchitietsanpham.getValueAt(i, 4);
                    int newQty = currentQty + soLuongMua;

                    if (newQty <= soLuongTon) {
                        bangchitietsanpham.setValueAt(newQty, i, 4);
                        bangchitietsanpham.setValueAt(newQty * donGia, i, 5);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "Tổng số lượng trong giỏ vượt quá tồn kho!");
                        return;
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
        int soLuongHienTai = Integer.parseInt(bangchitietsanpham.getValueAt(rowGioHang, 4).toString());

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
        if(!bus.kTSDT(sdt)){
            JOptionPane.showMessageDialog(null,"Số điện thoại chỉ bao gồm số");
            txthoten.setText("");
            txtemail.setText("");
            return;
        }
        if(sdt.length()!=10){
            JOptionPane.showMessageDialog(null,"Số điện thoại bao gồm 10 số");
                txthoten.setText("");
                txtemail.setText("");
            return;
        }
        if(kh==null){
            if(JOptionPane.showConfirmDialog(null, "Không tìm thấy khách hàng-"
                    + "Bạn có muốn tạo khách hàng mới không.")==JOptionPane.YES_OPTION){
                taokhachhang.setSize(400,250);
                taokhachhang.setVisible(true);
                String makh=bus.taoMaKH();
                txttaomakh.setText(makh);
                String ssdt=txtsdt.getText();
                txttaosdt.setText(ssdt);
                return;
            }else{
                txthoten.setText("");
                txtemail.setText("");
                return;
            }
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
            tinhLaiTongHoaDon();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void bttaokhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttaokhachhangActionPerformed
        // TODO add your handling code here:
        String makh,hoten,sdt,email;
        if(txttaohoten.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên");
            return;
        }
        if(txttaosdt.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại");
            return; 
        }else if(!bus.kTSDT(txttaosdt.getText())){
            JOptionPane.showMessageDialog(null, "Số điện thoại chỉ bao gồm chữ số");
            return; 
        }else if(txttaosdt.getText().length()!=10){
            JOptionPane.showMessageDialog(null, "Số điện thoại bao gồm 10 số");
            return; 
        }
        if(txttaoemail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Vui lòng nhập email");
            return; 
        }else if(!bus.kTEmail(txttaoemail.getText())){
            JOptionPane.showMessageDialog(null, "Email không hợp lệ (abc@gmail.com)");
            return; 
        }
        makh=txttaomakh.getText();
        hoten=txttaohoten.getText();
        sdt=txttaosdt.getText();
        email=txttaoemail.getText();
        bus.taoKH(makh,hoten,sdt,email);
        taokhachhang.setVisible(false);
    }//GEN-LAST:event_bttaokhachhangActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        taokhachhang.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed
    private void customTable() {
        // 1. Chỉnh Font Arial, kích thước 16 cho nội dung bảng
        java.awt.Font tableFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18);
        bangsanpham.setFont(tableFont);

        bangsanpham.setRowHeight(30);
        bangsanpham.getTableHeader().setOpaque(false);
        bangsanpham.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        //
        bangchitietsanpham.setFont(tableFont);

        bangchitietsanpham.setRowHeight(30);
        bangchitietsanpham.getTableHeader().setOpaque(false);
        bangchitietsanpham.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        for (int i = 0; i < bangsanpham.getColumnCount(); i++) {
            bangsanpham.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < bangchitietsanpham.getColumnCount(); i++) {
            bangchitietsanpham.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        resizeColumnWidth(bangsanpham);
        resizeColumnWidth(bangchitietsanpham);
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
    private javax.swing.JButton bttaokhachhang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbpttt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JSpinner spcapnhatsoluong;
    private javax.swing.JDialog taokhachhang;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttaoemail;
    private javax.swing.JTextField txttaohoten;
    private javax.swing.JTextField txttaomakh;
    private javax.swing.JTextField txttaosdt;
    // End of variables declaration//GEN-END:variables
}
