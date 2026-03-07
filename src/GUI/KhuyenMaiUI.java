/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.ChiTietKhuyenMaiBUS;
import BUS.KhuyenMaiBUS;
import BUS.SanPhamBUS;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THANH NHAN
 */
public class KhuyenMaiUI extends javax.swing.JPanel {

    KhuyenMaiBUS buskm=new KhuyenMaiBUS();
    ChiTietKhuyenMaiBUS busctkm=new ChiTietKhuyenMaiBUS();
    public KhuyenMaiUI() {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();

        initComponents();
        veBangKhuyenMai();
    }

    public void veBangKhuyenMai(){      
        Vector header=new Vector();
        header.add("Mã KM");
        header.add("Tên KM");
        header.add("Ngày BĐ");
        header.add("Ngày KT");
        header.add("Ghi chú");
        DefaultTableModel model=new DefaultTableModel(header,0);
        for(KhuyenMaiDTO km:buskm.docDS()){
            Vector row=new Vector();
            row.add(km.getMa());
            row.add(km.getTen());
            row.add(km.getNgayBD());
            row.add(km.getNgayKT());
            row.add(km.getGhiChu());
            model.addRow(row);
        }
        bangkhuyenmai.setModel(model);
    }
        public void veBangKhuyenMai(String key){      
        Vector header=new Vector();
        header.add("Mã KM");
        header.add("Tên KM");
        header.add("Ngày BĐ");
        header.add("Ngày KT");
        header.add("Ghi chú");
        DefaultTableModel model=new DefaultTableModel(header,0);
        for(KhuyenMaiDTO km:buskm.docDS()){
            if(key.equals(km.getMa()) || km.getTen().contains(key)){
                Vector row=new Vector();
                row.add(km.getMa());
                row.add(km.getTen());
                row.add(km.getNgayBD());
                row.add(km.getNgayKT());
                row.add(km.getGhiChu());
                model.addRow(row);
            }
        }
        bangkhuyenmai.setModel(model);
    }
    public void veBangChiTietKhuyenMai(String makm){
        Vector header=new Vector();
        header.add("Mã SP");
        header.add("Tên SP");
        header.add("Phần trăm");
        DefaultTableModel model=new DefaultTableModel(header,0);
        ArrayList<ChiTietKhuyenMaiDTO> ds = busctkm.docDSTheoMaKM(makm);
        for(ChiTietKhuyenMaiDTO km:ds){
            Vector row=new Vector();
            row.add(km.getSanPham().getMaSP());
            row.add(km.getSanPham().getTen());
            row.add(km.getPhanTram());
            model.addRow(row);
        }
        bangchitietkhuyenmai.setModel(model);
    }
    public void veBangChiTietKhuyenMaiTheoKey(String key){
        Vector header=new Vector();
        header.add("Mã SP");
        header.add("Tên SP");
        header.add("Phần trăm");
        DefaultTableModel model=new DefaultTableModel(header,0);
        ArrayList<ChiTietKhuyenMaiDTO> ds = busctkm.docDSTheoMaKM(key);
        for(ChiTietKhuyenMaiDTO km:ds){
            if(key.equals(km.getSanPham().getMaSP()) || key.equals(km.getSanPham().getTen()) ){
                Vector row=new Vector();
                row.add(km.getSanPham().getMaSP());
                row.add(km.getSanPham().getTen());
                row.add(km.getPhanTram());
                model.addRow(row);
            }
        }
        bangchitietkhuyenmai.setModel(model);
    }
    public void xoaForm(){
        txtmakhuyenmai.setText("");
        txttenkhuyenmai.setText("");
        datebatdaukhuyenmai.setDate(null);
        dateketthuckhuyenmai.setDate(null);
        areatxtghichu.setText("");
    }
    public void xoaBangChiTietKhuyenMai(){
        DefaultTableModel model = (DefaultTableModel) bangchitietkhuyenmai.getModel();
        model.setRowCount(0);
    }
    public void themKhuyenMai(){
        KhuyenMaiDTO km =new KhuyenMaiDTO();
        String ma=txtmakhuyenmai.getText();
        String ten=txttenkhuyenmai.getText();
        int kt=0;
        String thongbao="";
        if(ma.equals("")){
            thongbao+=" Mã khuyến mãi ";
            kt=1;
        }else if(buskm.kiemTraMaKhuyenMaiTonTai(ma)){
            JOptionPane.showMessageDialog(null,"Mã khuyến mãi đã tồn tại");
            return;
        }
        if(ten.equals("")){
            thongbao+=" Tên khuyến mãi ";
            kt=1;
        }
        if(datebatdaukhuyenmai.getDate()==null){
            thongbao+=" Ngày bắt đầu ";
            kt=1;
        }
        if(dateketthuckhuyenmai.getDate()==null){
            thongbao+=" Ngày kết thúc ";
            kt=1;
        }
        if(datebatdaukhuyenmai.getDate().after(dateketthuckhuyenmai.getDate())){
            JOptionPane.showMessageDialog(null,"Ngày bắt đầu phải nhỏ hoặc bằng ngày kết thúc");
            return;
        }
        if(kt==1){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập "+thongbao);
            return ;
        }
        km.setMa(ma);
        km.setTen(ten);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        km.setNgayBD(sdf.format(datebatdaukhuyenmai.getDate()));
        km.setNgayKT(sdf.format(dateketthuckhuyenmai.getDate()));
        km.setGhiChu(areatxtghichu.getText());
        buskm.add(km);
    }
    public void suaKhuyenMai(){
        KhuyenMaiDTO km =new KhuyenMaiDTO();
        int row=bangkhuyenmai.getSelectedRow();
        String makmbandau=bangkhuyenmai.getValueAt(row, 1).toString();
        String ma=txtmakhuyenmai.getText();
        String ten=txttenkhuyenmai.getText();
        int kt=0;
        String thongbao="";
        if(ma.equals("")){
            thongbao+=" Mã khuyến mãi ";
            kt=1;
        }else if(!buskm.kiemTraMaKhuyenMaiTonTai(ma) || !makmbandau.equals(ma)){
            JOptionPane.showMessageDialog(null,"Không thay đổi mã");
            txtmakhuyenmai.setText(makmbandau);
            return;
        }
        if(ten.equals("")){
            thongbao+=" Tên khuyến mãi ";
            kt=1;
        }
        if(datebatdaukhuyenmai.getDate()==null){
            thongbao+=" Ngày bắt đầu ";
            kt=1;
        }
        if(dateketthuckhuyenmai.getDate()==null){
            thongbao+=" Ngày kết thúc ";
            kt=1;
        }
        if(datebatdaukhuyenmai.getDate().after(dateketthuckhuyenmai.getDate())){
            JOptionPane.showMessageDialog(null,"Ngày bắt đầu phải nhỏ hoặc bằng ngày kết thúc");
            return;
        }
        if(kt==1){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập "+thongbao);
            return ;
        }
        km.setMa(ma);
        km.setTen(ten);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        km.setNgayBD(sdf.format(datebatdaukhuyenmai.getDate()));
        km.setNgayKT(sdf.format(dateketthuckhuyenmai.getDate()));
        km.setGhiChu(areatxtghichu.getText());
        buskm.update(km);
    }
    public void veBangChonSanPhamKhuyenMai(String makm){
        Vector header =new Vector();
        header.add("Chọn");
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Đơn vị tính");
        header.add("Mã hãng");
        header.add("Giảm %");
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
            public Class getColumnClass(int column){
                if(column == 0){
                    return Boolean.class;
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row,int column){
                return column == 0 || column == 7;
            }
        };
        SanPhamBUS bussp=new SanPhamBUS();
        ArrayList<SanPhamDTO> dssp=bussp.selectSanPhamKhongTrongKhuyenMai(makm);
        for(SanPhamDTO sp:dssp){
            Vector row= new Vector();
            row.add(false);
            row.add(sp.getMaSP());
            row.add(sp.getTen());
            row.add(sp.getSoLuong());
            row.add(sp.getDonGia());
            row.add(sp.getDonViTinh());
            row.add(sp.getMaHang());
            row.add(0);
            model.addRow(row);
        }
        bangchonsanphamkhuyenmai.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chonsanphamdialog = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        bangchonsanphamkhuyenmai = new javax.swing.JTable();
        btnxacnhan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmakhuyenmai = new javax.swing.JTextField();
        txttenkhuyenmai = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        dateketthuckhuyenmai = new com.toedter.calendar.JDateChooser();
        datebatdaukhuyenmai = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areatxtghichu = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangkhuyenmai = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txttimkiemkhuyenmai = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txttimkiemchitietkhuyenmai = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        bangchitietkhuyenmai = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();

        bangchonsanphamkhuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "2", "2", "2"},
                {null, "2", "2", null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Chọn", "Mã sản phẩm", "Tên sản phẩm", "Số lượng"
            }
        ));
        jScrollPane4.setViewportView(bangchonsanphamkhuyenmai);

        btnxacnhan.setText("Xác nhận");
        btnxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chonsanphamdialogLayout = new javax.swing.GroupLayout(chonsanphamdialog.getContentPane());
        chonsanphamdialog.getContentPane().setLayout(chonsanphamdialogLayout);
        chonsanphamdialogLayout.setHorizontalGroup(
            chonsanphamdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chonsanphamdialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(chonsanphamdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        chonsanphamdialogLayout.setVerticalGroup(
            chonsanphamdialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chonsanphamdialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnxacnhan, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(69, 66, 158));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1710, 60));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 41)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHƯƠNG TRÌNH KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(1150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(192, 31, 31));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sale.png"))); // NOI18N
        jLabel2.setText("KHUYẾN MÃI");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel3.setText("Mã khuyến mãi:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel4.setText("Tên khuyến mãi:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel5.setText("Giá trị:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel6.setText("Ngày bắt đầu:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel8.setText("Ghi chú:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel9.setText("Ngày kết thúc:");

        areatxtghichu.setColumns(20);
        areatxtghichu.setRows(5);
        jScrollPane1.setViewportView(areatxtghichu);

        jButton1.setBackground(new java.awt.Color(56, 134, 155));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(56, 134, 155));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bangkhuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KM", "Tên KM", "Phần trăm"
            }
        ));
        bangkhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangkhuyenmaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bangkhuyenmai);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel7.setText("Tìm khuyến mãi");

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton3.setText("Tìm");
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel10.setText("Tìm sản phẩm");

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButton4.setText("Tìm");
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        bangchitietkhuyenmai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Giá gốc", "Giá KM", ""
            }
        ));
        jScrollPane3.setViewportView(bangchitietkhuyenmai);

        jButton5.setBackground(new java.awt.Color(56, 134, 155));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus.png"))); // NOI18N
        jButton5.setText("Thêm sản phẩm");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(txttenkhuyenmai)
                            .addComponent(dateketthuckhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datebatdaukhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtmakhuyenmai)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttimkiemkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txttimkiemkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(datebatdaukhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateketthuckhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

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
    }// </editor-fold>//GEN-END:initComponents

    private void bangkhuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangkhuyenmaiMouseClicked
        // TODO add your handling code here:
        int row = bangkhuyenmai.getSelectedRow();
        if(row>=0){
            try {
                String makm = bangkhuyenmai.getValueAt(row,0).toString();
                String tenkm = bangkhuyenmai.getValueAt(row,1).toString();
                txtmakhuyenmai.setText(makm);
                txttenkhuyenmai.setText(tenkm);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date bd = sdf.parse(bangkhuyenmai.getValueAt(row,2).toString());
                Date kt = sdf.parse(bangkhuyenmai.getValueAt(row,3).toString());
                datebatdaukhuyenmai.setDate(bd);
                dateketthuckhuyenmai.setDate(kt);
                areatxtghichu.setText(bangkhuyenmai.getValueAt(row,4).toString());
                veBangChiTietKhuyenMai(makm);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_bangkhuyenmaiMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        themKhuyenMai();
        veBangKhuyenMai();
        xoaForm();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String key=txttimkiemkhuyenmai.getText();
        veBangKhuyenMai(key);
        xoaForm();
        xoaBangChiTietKhuyenMai();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = bangkhuyenmai.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn khuyến mãi trước!");
            return;
        }
        String key=txttimkiemchitietkhuyenmai.getText();
        veBangChiTietKhuyenMaiTheoKey(key);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        chonsanphamdialog.setSize(600,400);
         chonsanphamdialog.setLocation(300,200);
         chonsanphamdialog.setVisible(true);
        int row = bangkhuyenmai.getSelectedRow();
        if(row>=0){
            String ma=bangkhuyenmai.getValueAt(row, 0).toString();
            veBangChonSanPhamKhuyenMai(ma);
        }
        

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        suaKhuyenMai();    
        xoaForm();
        veBangKhuyenMai();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxacnhanActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) bangchonsanphamkhuyenmai.getModel();
        for(int i = 0; i < model.getRowCount(); i++){

            int row = bangkhuyenmai.getSelectedRow();
            if(row<0) return;   
            String makm=bangkhuyenmai.getValueAt(row, 0).toString();
            Boolean checked = (Boolean) model.getValueAt(i, 0);
            
            if(checked != null && checked){
                ChiTietKhuyenMaiDTO ctkm=new ChiTietKhuyenMaiDTO();
                
                String masp =model.getValueAt(i, 1).toString();
                SanPhamDTO sp=new SanPhamDTO();
                sp.setMaSP(masp);
                int phantram=0;
                
                if(!model.getValueAt(i, 7).toString().isEmpty())
                    phantram =Integer.parseInt(model.getValueAt(i, 7).toString());
                
                ctkm.setMaKM(makm);
                ctkm.setSanPham(sp);
                ctkm.setPhanTram(phantram);
                busctkm.add(ctkm);
                veBangChiTietKhuyenMai(makm);
                 chonsanphamdialog.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnxacnhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areatxtghichu;
    private javax.swing.JTable bangchitietkhuyenmai;
    private javax.swing.JTable bangchonsanphamkhuyenmai;
    private javax.swing.JTable bangkhuyenmai;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JDialog chonsanphamdialog;
    private com.toedter.calendar.JDateChooser datebatdaukhuyenmai;
    private com.toedter.calendar.JDateChooser dateketthuckhuyenmai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField txtmakhuyenmai;
    private javax.swing.JTextField txttenkhuyenmai;
    private javax.swing.JTextField txttimkiemchitietkhuyenmai;
    private javax.swing.JTextField txttimkiemkhuyenmai;
    // End of variables declaration//GEN-END:variables
}
