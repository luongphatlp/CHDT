package GUI;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import BUS.SanPhamBUS;
import DTO.SanPhamDTO;

public class SanPhamUI extends javax.swing.JPanel {

    private SanPhamBUS spBUS = new SanPhamBUS();
    private DefaultTableModel model;

    public SanPhamUI() {
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        customTable();
        loadDataToTable(spBUS.getDS());
    }

    public void loadDataToTable(ArrayList<SanPhamDTO> ds) {
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (SanPhamDTO sp : ds) {
            String giaTien = String.format("%,d VNĐ", sp.getDonGia());
            String ramRom = sp.getBoNho();
            if (ramRom == null || ramRom.isEmpty()) {
                ramRom = "Chưa có";
            }
            model.addRow(new Object[]{
                stt++, sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), giaTien, ramRom
            });
        }
        //resizeColumnWidth(jTable1);
        autoFitColumns(jTable1);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1710, 1080));

        jPanel1.setPreferredSize(new java.awt.Dimension(1710, 1080));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(1710, 170));

        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
        jToolBar1.setRollover(true);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png")));
        jButton1.setText("   Thêm  ");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bin.png")));
        jButton2.setText(" Xóa ");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pen.png")));
        jButton3.setText("   Sửa   ");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document.png")));
        jButton4.setText("Xem chi tiết");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator1);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png")));
        jButton5.setText("Nhập Excel");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 20));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (2).png")));
        jButton6.setText("Xuất Excel");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton6);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(820, 90));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tất cả", "Mã", "Tên"}));

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png")));
        btnreset.setText("Làm mới");
        btnreset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnreset)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1)
                                        .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(18, 77, 122));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 41));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SẢN PHẨM ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addContainerGap(1477, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 334, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "STT", "Mã máy", "Tên máy", "Số lượng", "Đơn giá", "RAM/ROM"
                }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton2.addActionListener(e -> {
            int row = jTable1.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa!");
                return;
            }
            String ma = jTable1.getValueAt(row, 1).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa mã: " + ma, "Thông báo", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (spBUS.xoa(ma)) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    loadDataToTable(spBUS.getDS());
                }
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                String text = jTextField1.getText().trim();
                int index = jComboBox1.getSelectedIndex();
                loadDataToTable(spBUS.timKiem(text, index));
            }
        });

        jButton3.addActionListener(e -> {
            int row = jTable1.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa!");
                return;
            }
            String ma = jTable1.getValueAt(row, 1).toString();
            SanPhamDTO spFull = spBUS.getChiTiet(ma);
            if (spFull != null) {
                SuaSPUI suaForm = new SuaSPUI(spFull, this, this.spBUS);
                suaForm.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu chi tiết của sản phẩm này!");
            }
        });

        jButton5.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn file Excel để nhập");
            int userSelection = fileChooser.showOpenDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileOpen = fileChooser.getSelectedFile();
                try {
                    int count = spBUS.nhapExcel(fileOpen);
                    JOptionPane.showMessageDialog(this, "Nhập thành công " + count + " sản phẩm mới!");
                    loadDataToTable(spBUS.getDS());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi nhập file: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        jButton6.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu file Excel");
            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".xlsx")) {
                    fileToSave = new File(filePath + ".xlsx");
                }
                try {
                    spBUS.xuatExcel(fileToSave);
                    JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xuất file: " + ex.getMessage());
                }
            }
        });
    }

    private void customTable() {

        java.awt.Font tableFont = new java.awt.Font("SF-Pro", java.awt.Font.BOLD, 18);
        jTable1.setFont(tableFont);
        jTable1.setRowHeight(30);

        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));

        jTable1.setShowVerticalLines(true);
        jTable1.setGridColor(new java.awt.Color(230, 230, 230));
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 1));
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void resizeColumnWidth(javax.swing.JTable table) {
        final javax.swing.table.TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 70;
            for (int row = 0; row < table.getRowCount(); row++) {
                javax.swing.table.TableCellRenderer renderer = table.getCellRenderer(row, column);
                java.awt.Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 15, width);
            }
            if (width > 400) {
                width = 400;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void autoFitColumns(javax.swing.JTable table) {
        final javax.swing.table.TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            // 1. Khởi tạo độ rộng bằng độ rộng của Header
            javax.swing.table.TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Object headerValue = table.getColumnModel().getColumn(column).getHeaderValue();
            java.awt.Component headerComp = headerRenderer.getTableCellRendererComponent(table, headerValue, false, false, -1, column);
            int width = headerComp.getPreferredSize().width + 20; // Thêm padding cho header

            // 2. Duyệt qua các hàng để tìm ô có nội dung dài nhất (Giới hạn 50 dòng để tối ưu)
            int maxRow = Math.min(table.getRowCount(), 50);
            for (int row = 0; row < maxRow; row++) {
                javax.swing.table.TableCellRenderer renderer = table.getCellRenderer(row, column);
                java.awt.Component comp = table.prepareRenderer(renderer, row, column);
                // Lấy độ rộng ưu tiên của nội dung + một khoảng đệm (padding)
                width = Math.max(comp.getPreferredSize().width + 15, width);
            }

            // 3. Giới hạn độ rộng tối đa để tránh cột quá dài (ví dụ: cột thông số kỹ thuật)
            if (width > 500) {
                width = 500;
            }

            // 4. Thiết lập độ rộng cho cột
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText("");
        spBUS.docDS();
        loadDataToTable(spBUS.getDS());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        ThemSPUI them = new ThemSPUI();
        them.setVisible(true);
        if (them.getReturnStatus() == ThemSPUI.RET_OK) {
            spBUS.docDS();
            loadDataToTable(spBUS.getDS());
        }
    }

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xem!");
            return;
        }
        String ma = jTable1.getValueAt(row, 1).toString();
        SanPhamDTO spFull = spBUS.getChiTiet(ma);

        if (spFull != null) {
            ChiTietSanPhamUI detailForm = new ChiTietSanPhamUI(spFull);
            detailForm.setVisible(true);
        }
    }

    private javax.swing.JButton btnreset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;

    public static void main(String args[]) {
        /* Set Look and Feel (Giao diện FlatLaf) */
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Tạo một cửa sổ Frame ảo để chứa Panel */
        java.awt.EventQueue.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Test Giao Diện Sản Phẩm");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

            // Khởi tạo Panel của bạn
            SanPhamUI panel = new SanPhamUI();

            // Thêm Panel vào Frame
            frame.add(panel);

            // Tối ưu kích thước test (Thay vì dùng pack() khó kiểm soát)
            frame.setSize(1200, 800);
            frame.setLocationRelativeTo(null); // Hiển thị giữa màn hình
            frame.setVisible(true);
        });
    }
}
