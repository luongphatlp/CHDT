package GUI;

import BUS.NhaCungCapBUS;
import DTO.NhaCungCapDTO;
import javax.swing.JOptionPane;

public class SuaNCCUI extends javax.swing.JDialog {
    private NhaCungCapDTO ncc;
    private NhaCungCapUI parent;
    private NhaCungCapBUS bus;

    public SuaNCCUI(NhaCungCapDTO ncc, NhaCungCapUI parent, NhaCungCapBUS bus) {
        this.ncc = ncc;
        this.parent = parent;
        this.bus = bus;
        initComponents();
        setModal(true);
        fillData();
        setLocationRelativeTo(null);
    }

    private void fillData() {
        txtMa.setText(ncc.getMaNCC());
        txtTen.setText(ncc.getTenNCC());
        txtDiaChi.setText(ncc.getDiaChi());
        txtSDT.setText(ncc.getSoDienThoai());
        txtMa.setEditable(false); 
    }

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {
        String ten = txtTen.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSDT.getText().trim();

        if (!sdt.matches("\\d{10,11}")) { 
          JOptionPane.showMessageDialog(this, "Số điện thoại phải từ 10-11 ký số!");
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
   private void initComponents() {
    txtMa = new javax.swing.JTextField();
    txtTen = new javax.swing.JTextField();
    txtDiaChi = new javax.swing.JTextField();
    txtSDT = new javax.swing.JTextField();
    btnLuu = new javax.swing.JButton();
    btnHuy = new javax.swing.JButton();
    setTitle("Sửa Nhà Cung Cấp");
    java.awt.Container cp = getContentPane();
    cp.setLayout(new java.awt.GridLayout(5, 2, 10, 10));

    cp.add(new javax.swing.JLabel(" Mã NCC:"));
    cp.add(txtMa);
    cp.add(new javax.swing.JLabel(" Tên NCC:"));
    cp.add(txtTen);
    cp.add(new javax.swing.JLabel(" Số điện thoại:"));
    cp.add(txtSDT);
    cp.add(new javax.swing.JLabel(" Địa chỉ:"));
    cp.add(txtDiaChi);
    
    btnLuu.setText("Lưu");
    btnLuu.addActionListener(this::btnLuuActionPerformed);
    cp.add(btnLuu);

    btnHuy.setText("Hủy");
    btnHuy.addActionListener(this::btnHuyActionPerformed);
    cp.add(btnHuy);

    pack();
}
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); 
    }
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnHuy;
}