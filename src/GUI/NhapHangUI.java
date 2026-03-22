/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import BUS.ChiTietPhieuNhapBUS;
import BUS.NhapHangBUS;
import BUS.PhieuNhapHangBUS;
import BUS.DienThoaiBUS;
import BUS.NhaCungCapBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapHangDTO;
import DTO.TaiKhoanSession;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author THANH NHAN
 */
public class NhapHangUI extends javax.swing.JPanel {

    /**
     * Creates new form NhapHangUI
     */
    public NhapHangUI() {
        try {
            com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        customTable();
        loadDienThoai();
        jTextField3.setText(taoMaPhieuNhap());
        jTextField3.setEditable(false);
        loadNhaCungCap(); 
        jDateChooser1.setDate(new Date());
        if (TaiKhoanSession.nvDangNhap != null) {
        jTextField2.setText(TaiKhoanSession.nvDangNhap.getMaNV());
        jTextField2.setEditable(false);
        }
    }
    private void customTable() {
        
        java.awt.Font tableFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18);
        jTable2.setFont(tableFont);
        jTable2.setRowHeight(30);

        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jTable3.setFont(tableFont);
        jTable3.setRowHeight(30);

        jTable3.getTableHeader().setOpaque(false);
        jTable3.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        for (int i = 0; i < jTable3.getColumnCount(); i++) {
            jTable3.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    public void loadTableSanPham(ArrayList<Vector> ds){
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        for(Vector nh : ds){
            model.addRow(nh);
        }
    }
    public void tinhTongTien(){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        
        jLabel8.setText(String.valueOf(getTongTien()));
    }
    public long getTongTien(){

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        long tong = 0;

        for(int i=0;i<model.getRowCount();i++){

            long gia = Long.parseLong(model.getValueAt(i,4).toString());
            tong += gia;

        }

        return tong;
    }
    public void capNhatSTT(){

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        for(int i = 0; i < model.getRowCount(); i++){
            model.setValueAt(i+1, i, 0);
        }
    }
    public String taoMaPhieuNhap() {

        Random rd = new Random();
        String ma;
        PhieuNhapHangBUS bus = new PhieuNhapHangBUS();
        do{
            int so = 10000 + rd.nextInt(90000);
            ma = "PN" + so;

        }while(bus.kiemTraMaPN(ma));

        return ma;
    }
    public void loadDienThoai(){

        DienThoaiBUS bus = new DienThoaiBUS();
        bus.docDS();

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);

        for(Vector v : bus.dsdt){
            model.addRow(v);
        }
    }
    public void loadNhaCungCap(){

        NhaCungCapBUS bus = new NhaCungCapBUS();
        ArrayList<NhaCungCapDTO> ds = bus.getDS();

        jComboBox2.removeAllItems();

        for(NhaCungCapDTO ncc : ds){

            jComboBox2.addItem(ncc);
        }
    }
    public void xuatPDF(String path){

        try{

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("PHIEU NHAP HANG"));
            document.add(new Paragraph(" "));

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

            PdfPTable table = new PdfPTable(model.getColumnCount());

            for(int i=0;i<model.getColumnCount();i++){
                table.addCell(model.getColumnName(i));
            }

            for(int i=0;i<model.getRowCount();i++){
                for(int j=0;j<model.getColumnCount();j++){
                    table.addCell(model.getValueAt(i,j).toString());
                }
            }

            document.add(table);

            document.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1710, 1080));

        jPanel1.setPreferredSize(new java.awt.Dimension(855, 1080));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(820, 130));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
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
                .addGap(32, 32, 32)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnreset)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã máy", "Tên máy", "Đơn giá"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel1.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel6.setPreferredSize(new java.awt.Dimension(855, 110));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Số lượng:");

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(476, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton5)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel2.setPreferredSize(new java.awt.Dimension(855, 1080));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(849, 250));

        jLabel1.setText("Mã phiếu nhập:");

        jLabel2.setText("Mã Nhân viên:");

        jLabel3.setText("Nhà cung cấp:");

        jLabel4.setText("Ngày:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jDateChooser1.setEnabled(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pen.png"))); // NOI18N
        jButton2.setText("Sửa số lượng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bin.png"))); // NOI18N
        jButton3.setText("Xóa sản phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (2).png"))); // NOI18N
        jButton1.setText(" Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(jLabel4)
                            .addGap(85, 85, 85)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.setPreferredSize(new java.awt.Dimension(849, 110));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel5.setText("Tổng tiền:");

        jButton4.setBackground(new java.awt.Color(49, 140, 112));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Nhập hàng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 32)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(50, 148, 104));
        jLabel8.setText("0");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("đ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(238, 238, 238)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 949, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        jTextField1.setText("");
        TableRowSorter<?> sorter = (TableRowSorter<?>) jTable3.getRowSorter();
        if (sorter != null) {
            sorter.setRowFilter(null); // bỏ filter
        }
        loadDienThoai();
    }//GEN-LAST:event_btnresetActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        int result = fileChooser.showOpenDialog(this);

        if(result == JFileChooser.APPROVE_OPTION){

            File file = fileChooser.getSelectedFile();

            try{
                FileInputStream fis = new FileInputStream(file);
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheetAt(0);

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

                for(int i = 1; i <= sheet.getLastRowNum(); i++){ // bỏ dòng tiêu đề
                    Row row = sheet.getRow(i);

                    if(row == null) continue;

                    String masp = row.getCell(0).toString();
                    String tensp = row.getCell(1).toString();
                    int soluong = (int) row.getCell(2).getNumericCellValue();
                    long dongia = (long) row.getCell(3).getNumericCellValue();

                    long thanhtien = soluong * dongia;

                    model.addRow(new Object[]{
                        model.getRowCount() + 1,
                        masp,
                        tensp,
                        soluong,
                        thanhtien
                    });
                }

                workbook.close();
                fis.close();

                tinhTongTien();

                JOptionPane.showMessageDialog(this, "Nhập Excel thành công!");

            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi đọc file Excel!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable2.getSelectedRow();
    
        if(row == -1){
            JOptionPane.showMessageDialog(this,"Chọn sản phẩm cần sửa");
            return;
        }

        int soLuongCu = Integer.parseInt(jTable2.getValueAt(row, 3).toString());
        long thanhTienCu = Long.parseLong(jTable2.getValueAt(row, 4).toString());
        long donGia = thanhTienCu / soLuongCu;
        // nhập số lượng mới
        String input = JOptionPane.showInputDialog(this, "Nhập số lượng mới:", soLuongCu);

        if(input == null) return; // bấm cancel

        try{
            int soLuongMoi = Integer.parseInt(input);

            if(soLuongMoi <= 0){
                JOptionPane.showMessageDialog(this, "Số lượng phải > 0");
                return;
            }

            // cập nhật bảng
            jTable2.setValueAt(soLuongMoi, row, 3);

            long thanhTien = soLuongMoi * donGia;
            jTable2.setValueAt(thanhTien, row, 4);
            tinhTongTien();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable2.getSelectedRow();

        if(row == -1){
            JOptionPane.showMessageDialog(null,"Hãy chọn sản phẩm cần xóa");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.removeRow(row);

        capNhatSTT();

        tinhTongTien();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
              
        String maPN = jTextField3.getText();
        System.out.println("MaPN: " + maPN);
        String maNV = jTextField2.getText();
        if(maNV == null || maNV.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống!");
            return;
        }
        NhaCungCapDTO ncc = (NhaCungCapDTO) jComboBox2.getSelectedItem();
        String maNCC = ncc.getMaNCC();
        Date today = new Date();
        jDateChooser1.setDate(today);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngay = sdf.format(today);
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        if(model.getRowCount() == 0){
            JOptionPane.showMessageDialog(this,"Chưa có sản phẩm để nhập");
            return;
        }
        SanPhamBUS spBus = new SanPhamBUS();
        NhapHangBUS bus = new NhapHangBUS();   
        bus.docDSNH();
        long tongTien = getTongTien();
        PhieuNhapHangDTO pn = new PhieuNhapHangDTO();
        pn.setMapn(maPN);
        pn.setMancc(maNCC);
        pn.setManv(maNV);
        pn.setNgay(ngay);
        pn.setTongtien((int) tongTien);
        pn.setTrangthai("Đang hoạt động");

        PhieuNhapHangBUS busPN = new PhieuNhapHangBUS();
        busPN.docDSPN();
        busPN.them(pn);
        ChiTietPhieuNhapBUS ctBUS = new ChiTietPhieuNhapBUS();

        for (int i = 0; i < model.getRowCount(); i++) {

            String maSP = model.getValueAt(i, 1).toString();
            int soLuong = Integer.parseInt(model.getValueAt(i, 3).toString());
            long thanhTien = Long.parseLong(model.getValueAt(i, 4).toString());

            ChiTietPhieuNhapDTO ct = new ChiTietPhieuNhapDTO();
            ct.setMapn(maPN);
            ct.setMasp(maSP);
            ct.setSl(soLuong);
            ct.setTongtien(thanhTien);

            ctBUS.them(ct);
            //spBus.tangSoLuong(maSP, soLuong);
        }
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Bạn có muốn xuất file PDF không?",
            "Xuất PDF",
            JOptionPane.YES_NO_OPTION
        );

        if(confirm == JOptionPane.YES_OPTION){

            String path = "phieunhap.pdf";

            xuatPDF(path);

            int open = JOptionPane.showConfirmDialog(
                    this,
                    "Xuất PDF thành công. Bạn có muốn mở file không?",
                    "Mở PDF",
                    JOptionPane.YES_NO_OPTION
            );

            if(open == JOptionPane.YES_OPTION){
                try{
                    Desktop.getDesktop().open(new File(path));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

        JOptionPane.showMessageDialog(this,"Nhập hàng thành công");
        model.setRowCount(0);
        jLabel8.setText("0");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = jTable3.getSelectedRow();
    
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Hãy chọn sản phẩm");
            return;
        }
        int dongia = Integer.parseInt(jTable3.getValueAt(row, 2).toString());
        String masp = jTable3.getValueAt(row,0).toString();
        String tensp = jTable3.getValueAt(row,1).toString();
        int soluong = (int) jSpinner1.getValue();
        if(soluong <= 0){
            JOptionPane.showMessageDialog(this, "Không thêm do số lượng bằng 0!");
            return;
        }
        int gia = dongia * soluong;
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        model.addRow(new Object[]{
            model.getRowCount()+1,
            masp,
            tensp,
            soluong,
            gia
        });

      
        tinhTongTien();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTable3.setRowSorter(sorter);

        sorter.setRowFilter(RowFilter.regexFilter(jTextField1.getText()));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test Nhập Hàng");

        NhapHangUI panel = new NhapHangUI();

        frame.add(panel);

        frame.setSize(1200,700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<NhaCungCapDTO> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
