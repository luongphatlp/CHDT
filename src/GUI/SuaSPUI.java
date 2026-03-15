package GUI;

import DTO.SanPhamDTO;
import BUS.SanPhamBUS;
import javax.swing.*;
import java.awt.*;

public class SuaSPUI extends JFrame {
    private SanPhamBUS spBUS;
    private SanPhamUI parent;
    private JTextField txtMa, txtTen, txtDonGia, txtDVT, txtMaHang;
    private JTextField txtMau, txtManHinh, txtKichThuoc, txtChip, txtCamTruoc, txtCamSau, txtPin;
    private JSpinner spinSoLuong;
    private JComboBox<String> cbRam, cbBoNhoNgoai, cbHeDieuHanh, cbBaoHanh;
    private JButton btnLuu, btnHuy;

    public SuaSPUI(SanPhamDTO sp, SanPhamUI parent, SanPhamBUS spBUS) {
        this.parent = parent;
        this.spBUS = spBUS;
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        } catch (Exception ex) { ex.printStackTrace(); }

        setTitle("CẬP NHẬT THÔNG TIN SẢN PHẨM");
        setSize(700, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(18, 77, 122));
        JLabel lblTitle = new JLabel("CHỈNH SỬA CHI TIẾT");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(Color.WHITE);
        pnHeader.add(lblTitle);
        add(pnHeader, BorderLayout.NORTH);

        JPanel pnBody = new JPanel(new GridLayout(0, 2, 20, 15));
        pnBody.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        pnBody.add(new JLabel("Mã máy (Không được sửa):"));
        txtMa = new JTextField(sp.getMaSP());
        txtMa.setEditable(false);
        pnBody.add(txtMa);
        pnBody.add(new JLabel("Tên máy:"));
        txtTen = new JTextField(sp.getTenSP());
        pnBody.add(txtTen);
        pnBody.add(new JLabel("Màu sắc:"));
        txtMau = new JTextField(sp.getMau());
        pnBody.add(txtMau);
        pnBody.add(new JLabel("Màn hình:"));
        txtManHinh = new JTextField(sp.getManHinh());
        pnBody.add(txtManHinh);
        pnBody.add(new JLabel("Kích thước màn hình:"));
        txtKichThuoc = new JTextField(sp.getKichThuoc());
        pnBody.add(txtKichThuoc);
        pnBody.add(new JLabel("Chipset:"));
        txtChip = new JTextField(sp.getChip());
        pnBody.add(txtChip);
        pnBody.add(new JLabel("RAM:"));
        cbRam = new JComboBox<>(new String[]{"4 GB", "6 GB", "8 GB", "12 GB", "16 GB", "32 GB"});
        cbRam.setSelectedItem(sp.getRam());
        pnBody.add(cbRam);
        pnBody.add(new JLabel("Bộ nhớ trong (ROM):"));
        cbBoNhoNgoai = new JComboBox<>(new String[]{"64 GB", "128 GB", "256 GB", "512 GB", "1 TB", "2 TB"});
        cbBoNhoNgoai.setSelectedItem(sp.getBoNhoNgoai() + " GB");
        pnBody.add(cbBoNhoNgoai);
        pnBody.add(new JLabel("Camera Trước (MP):"));
        txtCamTruoc = new JTextField(String.valueOf(sp.getCamTruoc()));
        pnBody.add(txtCamTruoc);
        pnBody.add(new JLabel("Camera Sau (MP):"));
        txtCamSau = new JTextField(String.valueOf(sp.getCamSau()));
        pnBody.add(txtCamSau);
        pnBody.add(new JLabel("Dung lượng Pin (mAh):"));
        txtPin = new JTextField(String.valueOf(sp.getPin()));
        pnBody.add(txtPin);
        pnBody.add(new JLabel("Hệ điều hành:"));
        cbHeDieuHanh = new JComboBox<>(new String[]{"Android", "iOS", "HarmonyOS"});
        cbHeDieuHanh.setSelectedItem(sp.getHeDieuHanh());
        pnBody.add(cbHeDieuHanh);
        pnBody.add(new JLabel("Bảo hành:"));
        cbBaoHanh = new JComboBox<>(new String[]{"6 tháng", "12 tháng", "18 tháng", "24 tháng", "36 tháng"});
        cbBaoHanh.setSelectedItem(sp.getBaoHanh() + " tháng");
        pnBody.add(cbBaoHanh);
        pnBody.add(new JLabel("Đơn giá (VNĐ):"));
        txtDonGia = new JTextField(String.valueOf(sp.getDonGia()));
        pnBody.add(txtDonGia);
        pnBody.add(new JLabel("Số lượng kho:"));
        spinSoLuong = new JSpinner(new SpinnerNumberModel(sp.getSoLuong(), 0, 1000, 1));
        pnBody.add(spinSoLuong);
        add(new JScrollPane(pnBody), BorderLayout.CENTER);

        JPanel pnFooter = new JPanel();
        btnLuu = new JButton("LƯU THAY ĐỔI");
        btnLuu.setBackground(new Color(25, 154, 133));
        btnLuu.setForeground(Color.WHITE);
        btnLuu.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnHuy = new JButton("HỦY BỎ");
        btnHuy.addActionListener(e -> dispose());
        pnFooter.add(btnLuu);
        pnFooter.add(btnHuy);
        add(pnFooter, BorderLayout.SOUTH);
        btnLuu.addActionListener(e -> saveAction());
    }

    private void saveAction() {
        try {
            
            if (txtTen.getText().trim().isEmpty() || txtDonGia.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ các trường bắt buộc!");
                return;
            }
            SanPhamDTO spNew = new SanPhamDTO();
            spNew.setMaSP(txtMa.getText());
            spNew.setTenSP(txtTen.getText().trim());
            spNew.setSoLuong((int) spinSoLuong.getValue());
            spNew.setDonGia(Integer.parseInt(txtDonGia.getText().trim()));
            spNew.setDonViTinh("Cái");
            spNew.setMaHang("H1"); 
            spNew.setMau(txtMau.getText().trim());
            spNew.setManHinh(txtManHinh.getText().trim());
            spNew.setKichThuoc(txtKichThuoc.getText().trim());
            spNew.setChip(txtChip.getText().trim());
            spNew.setRam(cbRam.getSelectedItem().toString());
            spNew.setBoNhoNgoai(Integer.parseInt(cbBoNhoNgoai.getSelectedItem().toString().replaceAll("[^0-9]", "")));
            spNew.setCamTruoc(Integer.parseInt(txtCamTruoc.getText().trim().replaceAll("[^0-9]", "")));
            spNew.setCamSau(Integer.parseInt(txtCamSau.getText().trim().replaceAll("[^0-9]", "")));
            spNew.setPin(Integer.parseInt(txtPin.getText().trim().replaceAll("[^0-9]", "")));
            spNew.setHeDieuHanh(cbHeDieuHanh.getSelectedItem().toString());

            if (spBUS.sua(spNew)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                parent.loadDataToTable(spBUS.getDS());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Các trường số lượng, đơn giá, camera, pin phải là số!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}