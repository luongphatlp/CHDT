/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Admin
 */

import BUS.PhieuNhapHangBUS;
import BUS.NhaCungCapBUS;
import DTO.PhieuNhapHangDTO;
import DTO.NhaCungCapDTO;
import java.awt.Container;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class SuaPNUI extends javax.swing.JDialog {

    private PhieuNhapHangDTO pn;
    private PhieuNhapUI parent;
    private PhieuNhapHangBUS bus;
    private NhaCungCapBUS busNCC;

    public SuaPNUI(PhieuNhapHangDTO pn, PhieuNhapUI parent, PhieuNhapHangBUS bus) {
        this.pn = pn;
        this.parent = parent;
        this.bus = bus;
        this.busNCC = new NhaCungCapBUS();

        initComponents();
        setModal(true);

        loadComboBoxNCC();
        fillData();

        setLocationRelativeTo(null);
    }

    private void loadComboBoxNCC(){
        busNCC.docDS();

        for(NhaCungCapDTO ncc : busNCC.getDS()){
            cbNCC.addItem(ncc);
        }
    }

    private void fillData(){

        txtMaPN.setText(pn.getMapn());
        txtMaPN.setEditable(false);
        dateNgay.setEnabled(false);
        txtMaNV.setText(pn.getManv());
        txtTongTien.setText(String.valueOf(pn.getTongtien()));

        try{
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(pn.getNgay());
            dateNgay.setDate(date);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(int i=0;i<cbNCC.getItemCount();i++){
            NhaCungCapDTO ncc = cbNCC.getItemAt(i);
            if(ncc.getMaNCC().equals(pn.getMancc())){
                cbNCC.setSelectedIndex(i);
                break;
            }
        }
    }

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt){
        

        // NCC
        NhaCungCapDTO ncc = (NhaCungCapDTO) cbNCC.getSelectedItem();
        if(ncc != null){
            pn.setMancc(ncc.getMaNCC());
        }

        // Ngày
        if(dateNgay.getDate() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngay = sdf.format(dateNgay.getDate());
            pn.setNgay(ngay);
        }
        try{
            int tongTien = Integer.parseInt(txtTongTien.getText());
            pn.setTongtien(tongTien);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Tổng tiền không hợp lệ!");
            return;
        }

        // Trạng thái
        String trangThai = cbTrangThai.getSelectedItem().toString();
        pn.setTrangthai(trangThai);
        if(bus.sua(pn)){
            JOptionPane.showMessageDialog(this,"Cập nhật phiếu nhập thành công!");

            parent.loadTable();

            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this,"Cập nhật thất bại!");
        }
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt){
        this.dispose();
    }

    private void initComponents(){

        txtMaPN = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        cbNCC = new javax.swing.JComboBox<>();
        cbTrangThai = new javax.swing.JComboBox<>();
        cbTrangThai.addItem("Đang hoạt động");
        cbTrangThai.addItem("Dừng hoạt động");
        dateNgay = new com.toedter.calendar.JDateChooser();

        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setTitle("Sửa Phiếu Nhập");

        Container cp = getContentPane();
        cp.setLayout(new javax.swing.BoxLayout(cp, javax.swing.BoxLayout.Y_AXIS));

        // padding
        ((javax.swing.JComponent) cp).setBorder(
            javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );


        // ===== Hàm tạo 1 dòng =====
        java.util.function.BiFunction<String, java.awt.Component, javax.swing.JPanel> createRow = (label, comp) -> {
            javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

            javax.swing.JLabel lbl = new javax.swing.JLabel(label);
            lbl.setPreferredSize(new java.awt.Dimension(130, 25)); // fix độ rộng label

            comp.setPreferredSize(new java.awt.Dimension(200, 30));

            panel.add(lbl);
            panel.add(comp);

            return panel;
        };


        // ===== Thêm từng dòng =====
        cp.add(createRow.apply("Mã Phiếu Nhập", txtMaPN));
        cp.add(createRow.apply("Nhà cung cấp", cbNCC));
        cp.add(createRow.apply("Ngày tạo", dateNgay));
        cp.add(createRow.apply("Tổng tiền", txtTongTien));
        cp.add(createRow.apply("Trạng thái", cbTrangThai));


        // ===== BUTTON =====
        javax.swing.JPanel panelBtn = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(this::btnLuuActionPerformed);
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(this::btnHuyActionPerformed);
        panelBtn.add(btnLuu);
        panelBtn.add(btnHuy);

        cp.add(panelBtn);
        
        pack();
    }

    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JComboBox<NhaCungCapDTO> cbNCC;
    private com.toedter.calendar.JDateChooser dateNgay;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JButton btnLuu;
    
    private javax.swing.JButton btnHuy;

}