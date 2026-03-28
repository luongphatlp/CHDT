package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SuaKHUI extends JDialog {
    private KhachHangDTO kh;
    private QLKhachHangUI parent;
    private KhachHangBUS bus;
    private JTextField txtMa, txtTen, txtSDT, txtEmail;
    private JButton btnLuu, btnHuy;

    public SuaKHUI(KhachHangDTO kh, QLKhachHangUI parent, KhachHangBUS bus) {
        this.kh = kh;
        this.parent = parent;
        this.bus = bus;
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        } catch (Exception ex) { ex.printStackTrace(); }

        setModal(true);
        setTitle("Cập Nhật Thông Tin Khách Hàng");
        setSize(600, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(151, 180, 198));
        JLabel lblTitle = new JLabel("CẬP NHẬT KHÁCH HÀNG");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        pnHeader.add(lblTitle);
        add(pnHeader, BorderLayout.NORTH);

        JPanel pnBody = new JPanel();
        pnBody.setLayout(new BoxLayout(pnBody, BoxLayout.Y_AXIS));
        pnBody.setBackground(Color.WHITE);
        pnBody.setBorder(BorderFactory.createEmptyBorder(25, 45, 25, 45));

        JPanel groupInfo = createGroupPanel("THÔNG TIN CHI TIẾT");
        addInput(groupInfo, "Mã khách hàng (Không sửa):", txtMa = new JTextField(kh.getMa()));
        txtMa.setEditable(false);
        addInput(groupInfo, "Tên khách hàng:", txtTen = new JTextField(kh.getHoten()));
        addInput(groupInfo, "Số điện thoại:", txtSDT = new JTextField(kh.getDt()));
        addInput(groupInfo, "Email:", txtEmail = new JTextField(kh.getEmail()));

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
        btnHuy.setBackground(new Color(220, 53, 69));
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
        String sdt = txtSDT.getText().trim();
        String email = txtEmail.getText().trim();

        if (ten.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        if (!sdt.matches("^0\\d{9,10}$")) { 
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ (9-10 số, bắt đầu bằng số 0)!");
            return;
        }
        if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");
            return;
        }

        kh.setHoten(ten);
        kh.setDt(sdt);
        kh.setEmail(email);
        
        if (bus.update(kh)) { 
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            parent.loadDataToTable(bus.getDSKH());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
        }
    }
}