/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package GUI;

import BUS.BaoHanhBUS;
import BUS.SanPhamBUS;
import DTO.BaoHanhDTO;
import DTO.ChiTietBaoHanhDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import static GUI.XacNhanTTUI.RET_CANCEL;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH NHAN
 */
public class ThemBaoHanhUI extends javax.swing.JDialog {
    BaoHanhBUS bus=new BaoHanhBUS();
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ThemBaoHanhUI.class.getName());
    private javax.swing.table.DefaultTableModel modelDuLieu;
    public static final int RET_CANCEL = 0;
    public static final int RET_OK = 1;
    //private int returnStatus = RET_CANCEL;

    public LocalDate tinhNgayHetHan(LocalDate ngay, int thoiHan) {
        return ngay.plusMonths(thoiHan);
    }
    public void veBangChiTietBaoHanh(ArrayList<SanPhamDTO> dssp,String ngay){
        SanPhamBUS bus=new SanPhamBUS();
        Vector header=new Vector();
        header.add("STT");
        header.add("IMEI");
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Thời hạn bảo hành");
        header.add("Hết hạn");
        DefaultTableModel model =new DefaultTableModel(header,0);
        int stt=1;
        LocalDate hientai=LocalDate.parse(ngay);
        for(SanPhamDTO sp:dssp){
            for(int i=1;i<=sp.getSoLuong();i++){
                Vector row =new Vector();
                row.add(stt++);
                row.add("");
                row.add(sp.getMaSP());
                row.add(sp.getTenSP());
                int thoihan=bus.layCTSPByMaSP(sp.getMaSP()).getBaoHanh();
                row.add(thoihan);
                LocalDate ngayhethan=tinhNgayHetHan(hientai,thoihan);
                row.add(ngayhethan);
                model.addRow(row);
            }
        }
        bangchitietbaohanh.setModel(model);
    }

    public ThemBaoHanhUI(String makh, String mahd, ArrayList<SanPhamDTO> dssp) {
        initComponents();
        String mabh = bus.taoMaBH();
        txtmabaohanh.setText(mabh);

        LocalDate ngay = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        txtngaylap.setText(ngay.format(formatter));

        txtmahoadon.setText(mahd);

        // Nhân viên
        if (DTO.TaiKhoanSession.nvDangNhap != null) {
            txtmanhanvien.setText(DTO.TaiKhoanSession.nvDangNhap.getMaNV());
        }

        // Khách hàng
        KhachHangDTO kh = bus.getKHByMaKH(makh);
        if (kh != null) {
            txtmakhachhang.setText(makh);
            txttenkh.setText(kh.getHoten());
            txtsdt.setText(kh.getDt());
            txtemail.setText(kh.getEmail());
        }
        String n=ngay.toString();
        
        veBangChiTietBaoHanh(dssp, n);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmabaohanh = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtngaylap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmahoadon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtmanhanvien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttenkh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangchitietbaohanh = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtimei = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtmakhachhang = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        okButton.setBackground(new java.awt.Color(0, 102, 102));
        okButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("Xác nhận");
        okButton.setBorderPainted(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 51, 51));
        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(151, 180, 198));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BẢO HÀNH ĐIỆN THOẠI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(148, 148, 148))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel2.setText("Mã bảo hành");

        txtmabaohanh.setBackground(new java.awt.Color(244, 244, 214));
        txtmabaohanh.setForeground(new java.awt.Color(0, 0, 0));
        txtmabaohanh.setText("\n");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel4.setText("Mã hóa đơn");

        txtngaylap.setBackground(new java.awt.Color(244, 244, 214));
        txtngaylap.setForeground(new java.awt.Color(0, 0, 0));
        txtngaylap.setText("\n");
        txtngaylap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtngaylapActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel5.setText("Ngày lập");

        txtmahoadon.setBackground(new java.awt.Color(244, 244, 214));
        txtmahoadon.setForeground(new java.awt.Color(0, 0, 0));
        txtmahoadon.setText("\n");
        txtmahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmahoadonActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel6.setText("Tên khách");

        txtmanhanvien.setBackground(new java.awt.Color(244, 244, 214));
        txtmanhanvien.setForeground(new java.awt.Color(0, 0, 0));
        txtmanhanvien.setText("\n");
        txtmanhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanhanvienActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel7.setText("Thông tin khách hàng");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel8.setText("Nhân viên");

        txttenkh.setBackground(new java.awt.Color(244, 244, 214));
        txttenkh.setForeground(new java.awt.Color(0, 0, 0));
        txttenkh.setText("\n");
        txttenkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenkhActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel9.setText("SĐT ");

        txtsdt.setBackground(new java.awt.Color(244, 244, 214));
        txtsdt.setForeground(new java.awt.Color(0, 0, 0));
        txtsdt.setText("\n");
        txtsdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel10.setText("Email");

        txtemail.setBackground(new java.awt.Color(244, 244, 214));
        txtemail.setForeground(new java.awt.Color(0, 0, 0));
        txtemail.setText("\n");
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        bangchitietbaohanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "IMEI", "Mã sản phẩm", "Tên sản phẩm", "Thời hạn bảo hành", "Hết hạn"
            }
        ));
        bangchitietbaohanh.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bangchitietbaohanhAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(bangchitietbaohanh);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel11.setText("IMEI");

        txtimei.setForeground(new java.awt.Color(0, 0, 0));
        txtimei.setText("\n");
        txtimei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimeiActionPerformed(evt);
            }
        });

        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel12.setText("Mã khách hàng");

        txtmakhachhang.setBackground(new java.awt.Color(244, 244, 214));
        txtmakhachhang.setForeground(new java.awt.Color(0, 0, 0));
        txtmakhachhang.setText("\n");
        txtmakhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmakhachhangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtimei, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmabaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmabaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtmahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmanhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtimei, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        getRootPane().setDefaultButton(okButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void insert(){
        BaoHanhDTO bh=new BaoHanhDTO();
        bh.setMaBH(txtmabaohanh.getText());
        bh.setMaKH(txtmakhachhang.getText());
        NhanVienDTO nv=DTO.TaiKhoanSession.nvDangNhap;
        bh.setMaNV(nv.getMaNV());
        String ngaylap=txtngaylap.getText();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(ngaylap, formatter);
            bh.setNgayLap(date);
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Sai định dạng ngày");
        }
        bus.insert(bh);
    }
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // Bạn có thể thêm logic kiểm tra dữ liệu ở đây trước khi đóng
        if (txtmabaohanh.getText().trim().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng không để trống mã bảo hành!");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) bangchitietbaohanh.getModel();
        for(int i=0;i<model.getRowCount();i++){
            if(model.getValueAt(i,1).equals("")){
                javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng không để trống mã IMEI!");
                return;
            }
        }
        BaoHanhDTO bh=new BaoHanhDTO();
        String mabh=txtmabaohanh.getText();
        bh.setMaBH(mabh);
        bh.setMaKH(txtmakhachhang.getText());
        bh.setMaNV(txtmanhanvien.getText());
        bh.setNgayLap(LocalDate.parse(txtngaylap.getText()));
        bus.insert(bh);
        
        ArrayList<ChiTietBaoHanhDTO> ds=new ArrayList<>();
        for(int i=0;i<model.getRowCount();i++){
            ChiTietBaoHanhDTO ctbh=new ChiTietBaoHanhDTO();
            ctbh.setMaBH(mabh);
            ctbh.setIMEI(model.getValueAt(i, 1).toString());
            ctbh.setNgay(LocalDate.parse(model.getValueAt(i, 5).toString()));
            ds.add(ctbh);
        }
        
        bus.insertCTBH(ds);
       
        // Nếu bạn muốn lưu vào DB ngay tại đây, hãy gọi hàm DAO
        
        // Hoặc đơn giản là đóng dialog và báo về cho HoaDonUI biết là đã xong
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(
                null,
                "Bạn có chắc muốn xóa không?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION
            );
        if (result == JOptionPane.YES_OPTION) {
            doClose(RET_CANCEL);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void txtngaylapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtngaylapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtngaylapActionPerformed

    private void txtmahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmahoadonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmahoadonActionPerformed

    private void txtmanhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanhanvienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanhanvienActionPerformed

    private void txttenkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenkhActionPerformed

    private void txtsdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtimeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimeiActionPerformed

    private void bangchitietbaohanhAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bangchitietbaohanhAncestorAdded
        // TODO add your handling code here:
        int row;
        row=bangchitietbaohanh.getSelectedRow();
        if(row!=-1){
            String imei=  bangchitietbaohanh.getValueAt(row,1).toString();
            txtimei.setText(imei);
        }
    }//GEN-LAST:event_bangchitietbaohanhAncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String imei = txtimei.getText().trim();

        if (imei.isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Vui lòng nhập IMEI");
            return;
        }

        int row = bangchitietbaohanh.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng");
            return;
        }
        boolean kt=true;
        // kiểm tra trùng
        for (int i = 0; i < bangchitietbaohanh.getRowCount(); i++) {
            if (i == row) continue; // bỏ qua dòng đang chọn

            Object value = bangchitietbaohanh.getValueAt(i, 1);
            if (value != null && imei.equals(value.toString())) {
                JOptionPane.showMessageDialog(null, "Trùng IMEI");
                return;
            }
        }
        if(kt && !bus.KtIMEI(imei)){
            JOptionPane.showMessageDialog(null, "Đã tồn tại IMEI trong hệ thống");
            return;
        }
        // nếu không trùng thì set
        bangchitietbaohanh.setValueAt(imei, row, 1);
        txtimei.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtmakhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmakhachhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmakhachhangActionPerformed

    private void doClose(int retStatus) {
        //returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public void setThongTinBaoHanh() {

    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangchitietbaohanh;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtimei;
    private javax.swing.JTextField txtmabaohanh;
    private javax.swing.JTextField txtmahoadon;
    private javax.swing.JTextField txtmakhachhang;
    private javax.swing.JTextField txtmanhanvien;
    private javax.swing.JTextField txtngaylap;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttenkh;
    // End of variables declaration//GEN-END:variables

    //private int returnStatus = RET_CANCEL;
}
