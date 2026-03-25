package GUI;

import DTO.SanPhamDTO;
import DTO.ChiTietSanPhamDTO; 
import BUS.SanPhamBUS;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SuaSPUI extends JFrame {
    private SanPhamBUS spBUS;
    private SanPhamUI parent;
    private JTextField txtMa, txtTen, txtDonGia;
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
        setSize(750, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());      
        
        ChiTietSanPhamDTO ct = sp.getChiTiet();

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(25, 154, 133));
        JLabel lblTitle = new JLabel("CHỈNH SỬA CHI TIẾT SẢN PHẨM");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitle.setForeground(Color.WHITE);
        pnHeader.add(lblTitle);
        add(pnHeader, BorderLayout.NORTH);

        JPanel pnMainContent = new JPanel();
        pnMainContent.setLayout(new BoxLayout(pnMainContent, BoxLayout.Y_AXIS));
        pnMainContent.setBackground(Color.WHITE);
        pnMainContent.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JPanel groupBasic = createGroupPanel("THÔNG TIN CƠ BẢN");
        addInput(groupBasic, "Mã máy:", txtMa = new JTextField(sp.getMaSP()));
        txtMa.setEditable(false);
        addInput(groupBasic, "Tên máy:", txtTen = new JTextField(sp.getTenSP()));
        addInput(groupBasic, "Giá tiền:", txtDonGia = new JTextField(String.valueOf(sp.getDonGia())));

        JPanel groupConfig = createGroupPanel("CẤU HÌNH KỸ THUẬT");
        addInput(groupConfig, "Chipset:", txtChip = new JTextField(ct != null ? ct.getChip() : ""));
        addInput(groupConfig, "RAM:", cbRam = new JComboBox<>(new String[]{"4 GB", "6 GB", "8 GB", "12 GB", "16 GB"}));
        cbRam.setSelectedItem(ct != null ? ct.getRam() : "4 GB");
        addInput(groupConfig, "Bộ nhớ trong:", cbBoNhoNgoai = new JComboBox<>(new String[]{"64 GB", "128 GB", "256 GB", "512 GB", "1 TB"}));
        cbBoNhoNgoai.setSelectedItem(ct != null ? ct.getBoNhoNgoai() + " GB" : "64 GB");
        addInput(groupConfig, "Hệ điều hành:", cbHeDieuHanh = new JComboBox<>(new String[]{"Android", "iOS", "HarmonyOS"}));
        cbHeDieuHanh.setSelectedItem(ct != null ? ct.getHeDieuHanh() : "Android");

        JPanel groupOther = createGroupPanel("MÀN HÌNH & PIN");
        addInput(groupOther, "Màu sắc:", txtMau = new JTextField(ct != null ? ct.getMau() : ""));
        addInput(groupOther, "Màn hình:", txtManHinh = new JTextField(ct != null ? ct.getManHinh() : ""));
        addInput(groupOther, "Kích thước:", txtKichThuoc = new JTextField(ct != null ? ct.getKichThuoc() : ""));
        addInput(groupOther, "Dung lượng Pin:", txtPin = new JTextField(ct != null ? String.valueOf(ct.getPin()) : "0"));
        addInput(groupOther, "Camera trước (MP):", txtCamTruoc = new JTextField(ct != null ? String.valueOf(ct.getCamTruoc()) : "0"));
        addInput(groupOther, "Camera sau (MP):", txtCamSau = new JTextField(ct != null ? String.valueOf(ct.getCamSau()) : "0"));
        
        cbBaoHanh = new JComboBox<>(new String[]{"6 tháng", "12 tháng", "24 tháng"});
        cbBaoHanh.setSelectedItem(ct != null ? ct.getBaoHanh() + " tháng" : "12 tháng");
        addInput(groupOther, "Thời gian bảo hành:", cbBaoHanh);
        
        pnMainContent.add(groupBasic);
        pnMainContent.add(Box.createVerticalStrut(15));
        pnMainContent.add(groupConfig);
        pnMainContent.add(Box.createVerticalStrut(15));
        pnMainContent.add(groupOther);

        JScrollPane scroll = new JScrollPane(pnMainContent);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        JPanel pnFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 15));
        pnFooter.setBackground(Color.WHITE);
        
        btnLuu = new JButton("LƯU THAY ĐỔI");
        btnLuu.setBackground(new Color(25, 154, 133));
        btnLuu.setForeground(Color.WHITE);
        btnLuu.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnLuu.setPreferredSize(new Dimension(180, 45));
        
        btnHuy = new JButton("HỦY BỎ");
        btnHuy.setBackground(new Color(220, 53, 69));
        btnHuy.setForeground(Color.WHITE);
        btnHuy.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnHuy.setPreferredSize(new Dimension(120, 45));
        btnHuy.addActionListener(e -> dispose());
        
        pnFooter.add(btnLuu);
        pnFooter.add(btnHuy);
        add(pnFooter, BorderLayout.SOUTH);
        
        btnLuu.addActionListener(e -> saveAction());

        txtCamTruoc = new JTextField(ct != null ? String.valueOf(ct.getCamTruoc()) : "0");
        txtCamSau = new JTextField(ct != null ? String.valueOf(ct.getCamSau()) : "0");
        cbBaoHanh = new JComboBox<>(new String[]{"6 tháng", "12 tháng", "24 tháng"});
        cbBaoHanh.setSelectedItem(ct != null ? ct.getBaoHanh() + " tháng" : "12 tháng");
        spinSoLuong = new JSpinner(new SpinnerNumberModel(sp.getSoLuong(), 0, 1000, 1));
        spinSoLuong.setEnabled(false);
    }

    private JPanel createGroupPanel(String title) {
        JPanel panel = new JPanel(new GridLayout(0, 2, 20, 15));
        panel.setBackground(Color.WHITE);
        TitledBorder border = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(25, 154, 133)), 
            title, 0, 0, new Font("Segoe UI", Font.BOLD, 14), new Color(25, 154, 133)
        );
        panel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        return panel;
    }

    private void addInput(JPanel panel, String labelText, JComponent input) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(new Color(50, 50, 50)); 
        panel.add(label);

        if (input instanceof JTextField) {
            input.setBackground(Color.WHITE);
            input.setForeground(Color.BLACK);
            input.setBorder(BorderFactory.createLineBorder(new Color(25, 154, 133)));
            ((JTextField) input).setFont(new Font("Segoe UI", Font.PLAIN, 14));
        }
        panel.add(input);
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
            spNew.setDonGia(Integer.parseInt(txtDonGia.getText().trim().replace(".", "")));
            spNew.setBoNho(cbRam.getSelectedItem().toString() + " / " + cbBoNhoNgoai.getSelectedItem().toString());
            ChiTietSanPhamDTO ctNew = spNew.getChiTiet(); 
            ctNew.setMau(txtMau.getText().trim());
            ctNew.setManHinh(txtManHinh.getText().trim());
            ctNew.setKichThuoc(txtKichThuoc.getText().trim());
            ctNew.setChip(txtChip.getText().trim());
            ctNew.setRam(cbRam.getSelectedItem().toString());
            ctNew.setBoNhoNgoai(Integer.parseInt(cbBoNhoNgoai.getSelectedItem().toString().replaceAll("[^0-9]", "")));
            ctNew.setHeDieuHanh(cbHeDieuHanh.getSelectedItem().toString());
            ctNew.setPin(Integer.parseInt(txtPin.getText().trim().replaceAll("[^0-9]", "")));
            ctNew.setCamTruoc(Integer.parseInt(txtCamTruoc.getText().trim().replaceAll("[^0-9]", "")));
            ctNew.setCamSau(Integer.parseInt(txtCamSau.getText().trim().replaceAll("[^0-9]", "")));
            ctNew.setBaoHanh(Integer.parseInt(cbBaoHanh.getSelectedItem().toString().replaceAll("[^0-9]", "")));

            if (spBUS.sua(spNew)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                parent.loadDataToTable(spBUS.getDS());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi: " + ex.getMessage());
        }
    }
}