package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SuaNCCUI extends JDialog {
    private NhaCungCapDTO ncc;
    private NhaCungCapUI parent;
    private NhaCungCapBUS bus;
    private JTextField txtMa, txtTen, txtDiaChi, txtSDT;
    private JButton btnLuu, btnHuy;

    public SuaNCCUI(NhaCungCapDTO ncc, NhaCungCapUI parent, NhaCungCapBUS bus) {
        this.ncc = ncc;
        this.parent = parent;
        this.bus = bus;
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        } catch (Exception ex) { ex.printStackTrace(); }

        setModal(true);
        setTitle("Cập Nhật Nhà Cung Cấp");
        setSize(600, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(151, 180, 198));
        JLabel lblTitle = new JLabel("CẬP NHẬT NHÀ CUNG CẤP");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        pnHeader.add(lblTitle);
        add(pnHeader, BorderLayout.NORTH);

        JPanel pnBody = new JPanel();
        pnBody.setLayout(new BoxLayout(pnBody, BoxLayout.Y_AXIS));
        pnBody.setBackground(Color.WHITE);
        pnBody.setBorder(BorderFactory.createEmptyBorder(25, 45, 25, 45));

        JPanel groupInfo = createGroupPanel("THÔNG TIN NHÀ CUNG CẤP");
        addInput(groupInfo, "Mã NCC (Không sửa):", txtMa = new JTextField(ncc.getMaNCC()));
        txtMa.setEditable(false);
        addInput(groupInfo, "Tên nhà cung cấp:", txtTen = new JTextField(ncc.getTenNCC()));
        addInput(groupInfo, "Số điện thoại:", txtSDT = new JTextField(ncc.getSoDienThoai()));
        addInput(groupInfo, "Địa chỉ:", txtDiaChi = new JTextField(ncc.getDiaChi()));

        pnBody.add(groupInfo);
        add(pnBody, BorderLayout.CENTER);

        JPanel pnFooter = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        pnFooter.setBackground(Color.WHITE);

        btnLuu = new JButton("LƯU THAY ĐỔI");
        btnLuu.setBackground(new Color(0, 102, 102));
        btnLuu.setForeground(Color.WHITE);
        btnLuu.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnLuu.setPreferredSize(new Dimension(180, 45));
        btnLuu.addActionListener(e -> btnLuuActionPerformed());

        btnHuy = new JButton("HỦY BỎ");
        btnHuy.setBackground(new Color(255, 51, 51));
        btnHuy.setForeground(Color.WHITE);
        btnHuy.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnHuy.setPreferredSize(new Dimension(140, 45));
        btnHuy.addActionListener(e -> dispose());

        pnFooter.add(btnLuu);
        pnFooter.add(btnHuy);
        add(pnFooter, BorderLayout.SOUTH);
    }

    private JPanel createGroupPanel(String title) {
        JPanel panel = new JPanel(new GridLayout(0, 1, 0, 10));
        panel.setBackground(Color.WHITE);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(151, 180, 198), 1), 
            title, 0, 0, new Font("Segoe UI", Font.BOLD, 14), new Color(151, 180, 198)
        );
        panel.setBorder(BorderFactory.createCompoundBorder(titledBorder, BorderFactory.createEmptyBorder(15, 25, 20, 25)));
        return panel;
    }

    private void addInput(JPanel panel, String labelText, JTextField input) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));
        label.setForeground(new Color(50, 50, 50));
        panel.add(label);

        input.setBackground(Color.WHITE);
        input.setForeground(Color.BLACK);
        input.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        input.setBorder(BorderFactory.createLineBorder(new Color(151, 180, 198), 1));
        input.setMargin(new Insets(2, 10, 2, 10));
        panel.add(input);
    }

    private void btnLuuActionPerformed() {
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();

        if (!sdt.matches("^0\\d{9}$")) { 
          JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ! Vui lòng nhập đúng 10 số và bắt đầu bằng số 0.");
          return;
        }
        if (ten.isEmpty() || diaChi.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin nhà cung cấp!");
            return;
        }
        ncc.setTenNCC(ten);
        ncc.setDiaChi(diaChi);
        ncc.setSoDienThoai(sdt);
        
        if (bus.sua(ncc)) { 
            JOptionPane.showMessageDialog(this, "Cập nhật nhà cung cấp thành công!");
            parent.loadDataToTable(bus.getDS()); 
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại, vui lòng kiểm tra lại!");
        }
    }
}