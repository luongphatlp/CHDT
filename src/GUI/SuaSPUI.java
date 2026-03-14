package GUI;

import DTO.SanPhamDTO;
import BUS.SanPhamBUS;
import java.util.ArrayList; 
import javax.swing.*;
import java.awt.*;

public class SuaSPUI extends JFrame {
    private SanPhamBUS spBUS;
    private SanPhamUI parent; 
    private JTextField txtMa, txtTen, txtSoLuong, txtDonGia, txtDVT, txtMaHang;
    private JButton btnLuu;

    public SuaSPUI(SanPhamDTO sp, SanPhamUI parent, SanPhamBUS spBUS) {
        this.parent = parent;
        this.spBUS = spBUS;

        setTitle("Sửa Thông Tin Sản Phẩm - " + sp.getMaSP());
        setSize(450, 550);
        setLayout(new GridLayout(7, 2, 15, 15)); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        add(new JLabel("  Mã sản phẩm:"));
        txtMa = new JTextField(sp.getMaSP());
        txtMa.setEditable(false); 
        add(txtMa);

        add(new JLabel("  Tên sản phẩm:"));
        txtTen = new JTextField(sp.getTenSP());
        add(txtTen);

        add(new JLabel("  Số lượng:"));
        txtSoLuong = new JTextField(String.valueOf(sp.getSoLuong()));
        add(txtSoLuong);

        add(new JLabel("  Đơn giá:"));
        txtDonGia = new JTextField(String.valueOf(sp.getDonGia()));
        add(txtDonGia);

        add(new JLabel("  Đơn vị tính:"));
        txtDVT = new JTextField(sp.getDonViTinh());
        add(txtDVT);

        add(new JLabel("  Mã hãng:"));
        txtMaHang = new JTextField(sp.getMaHang());
        add(txtMaHang);

        btnLuu = new JButton("Lưu thay đổi");
        btnLuu.setBackground(new Color(18, 77, 122)); 
        btnLuu.setForeground(Color.WHITE);
        add(btnLuu);

        btnLuu.addActionListener(e -> {
            try {
                if(txtTen.getText().isEmpty() || txtDVT.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không được để trống thông tin!");
                    return;
                }

                SanPhamDTO spNew = new SanPhamDTO();
                spNew.setMaSP(txtMa.getText());
                spNew.setTenSP(txtTen.getText());
                spNew.setSoLuong(Integer.parseInt(txtSoLuong.getText().trim()));
                spNew.setDonGia(Integer.parseInt(txtDonGia.getText().trim()));
                spNew.setDonViTinh(txtDVT.getText());
                spNew.setMaHang(txtMaHang.getText());
                if (this.spBUS.sua(spNew)) { 
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    this.parent.loadDataToTable(this.spBUS.getDS()); 
                    this.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Số lượng và đơn giá phải là số nguyên!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
            }
        });
    }
}