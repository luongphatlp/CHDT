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

        txtMaNV.setText(pn.getManv());

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
        
        String maNV = txtMaNV.getText().trim();

        // nếu không nhập thì giữ nguyên
        if(!maNV.isEmpty()){
            pn.setManv(maNV);
        }

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

        cbNCC = new javax.swing.JComboBox<>();

        dateNgay = new com.toedter.calendar.JDateChooser();

        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setTitle("Sửa Phiếu Nhập");

        java.awt.Container cp = getContentPane();
        cp.setLayout(new java.awt.GridLayout(5,2,10,10));

        cp.add(new javax.swing.JLabel("Mã Phiếu Nhập"));
        cp.add(txtMaPN);

        cp.add(new javax.swing.JLabel("Nhân viên tạo"));
        cp.add(txtMaNV);

        cp.add(new javax.swing.JLabel("Nhà cung cấp"));
        cp.add(cbNCC);

        cp.add(new javax.swing.JLabel("Ngày tạo"));
        cp.add(dateNgay);

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(this::btnLuuActionPerformed);
        cp.add(btnLuu);

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(this::btnHuyActionPerformed);
        cp.add(btnHuy);

        pack();
    }

    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JComboBox<NhaCungCapDTO> cbNCC;
    private com.toedter.calendar.JDateChooser dateNgay;

    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnHuy;

}