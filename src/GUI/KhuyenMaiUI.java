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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        String ma=buskm.taoMaKM();
        txtmakhuyenmai.setText(ma);
        veBangKhuyenMai();
        customTable();
    }

    private void customTable() {
        
        java.awt.Font tableFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18);
        bangkhuyenmai.setFont(tableFont);
        bangkhuyenmai.setRowHeight(30);

        bangkhuyenmai.getTableHeader().setOpaque(false);
        bangkhuyenmai.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));

        bangchitietkhuyenmai.setFont(tableFont);
        bangchitietkhuyenmai.setRowHeight(30);

        bangchitietkhuyenmai.getTableHeader().setOpaque(false);
        bangchitietkhuyenmai.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        for (int i = 0; i < bangkhuyenmai.getColumnCount(); i++) {
            bangkhuyenmai.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < bangchitietkhuyenmai.getColumnCount(); i++) {
            bangchitietkhuyenmai.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
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
        public void veBangKhuyenMai(String key,Date b,Date k,int tinhtrang){      
        Vector header=new Vector();
        header.add("Mã KM");
        header.add("Tên KM");
        header.add("Ngày BĐ");
        header.add("Ngày KT");
        header.add("Ghi chú");
        DefaultTableModel model=new DefaultTableModel(header,0);
        for(KhuyenMaiDTO km:buskm.docDS()){
            boolean ktkey=key.equals(km.getMa()) || km.getTen().contains(key);
            boolean dkngay = true;
            boolean kttt=false;
            LocalDate now=LocalDate.now();
            LocalDate bd=LocalDate.MIN;
            if(b!=null)
                    bd=b.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate kt=LocalDate.MAX;
            if(k!=null)
                    kt=k.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ngayBD = km.getNgayBD();
            LocalDate ngayKT = km.getNgayKT();
            switch (tinhtrang) {
                case 1:
                    if(!now.isAfter(ngayKT) && !now.isBefore(ngayBD)){
                        kttt=true;
                    }   break;
                case 0:
                    if(now.isAfter(ngayKT) || now.isBefore(ngayBD)){
                        kttt=true;
                    }   break;
                default:
                    kttt=true;
                    break;
            }
            if(bd != null && kt == null){
                dkngay = !ngayBD.isBefore(bd);
            }
            else if(bd == null && kt != null){
                dkngay = !ngayKT.isAfter(kt);
            }
            else if(bd != null && kt != null){
                dkngay = !ngayBD.isBefore(bd) && !ngayKT.isAfter(kt);
            }
            if(ktkey && dkngay && kttt){
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
        header.add("Giá gốc");
        header.add("% Giảm");
        header.add("Giá khuyến mãi");
        header.add("Edit");
        header.add("Delete");
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
            public Class getColumnClass(int column){
                if(column == 5 || column == 6){
                    return Icon.class; // 👈 2 cột Edit + Delete
                }
                return Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column){
                return column == 5 || column == 6;
            }
        };
        ImageIcon iconEdit = new ImageIcon(getClass().getResource("/icon/pen.png"));
        ImageIcon iconDelete = new ImageIcon(getClass().getResource("/icon/minus.png"));
        ArrayList<ChiTietKhuyenMaiDTO> ds = busctkm.docDSTheoMaKM(makm);
        for(ChiTietKhuyenMaiDTO km:ds){
            Vector row=new Vector();
            row.add(km.getSanPham().getMaSP());
            row.add(km.getSanPham().getTenSP());
            row.add(km.getSanPham().getDonGia());
            row.add(km.getPhanTram());
            int giagoc=km.getSanPham().getDonGia();
            int giakhuyenmai=giagoc - giagoc*km.getPhanTram()/100;
            row.add(giakhuyenmai);
            row.add(iconEdit);
            row.add(iconDelete);
            model.addRow(row);
        }
        bangchitietkhuyenmai.setModel(model);
    }
    public void veBangChiTietKhuyenMaiTheoKey(String makm,String key,int phantram){
        Vector header=new Vector();
        header.add("Mã SP");
        header.add("Tên SP");
        header.add("Giá gốc");
        header.add("% Giảm");
        header.add("Giá khuyến mãi");
        header.add("Edit");
        header.add("Delete");
        DefaultTableModel model=new DefaultTableModel(header,0);
        ArrayList<ChiTietKhuyenMaiDTO> ds = busctkm.docDSTheoMaKM(makm);
        for(ChiTietKhuyenMaiDTO km:ds){
            boolean ktkey=true;
            if(!key.equals(""))
                ktkey=key.equals(km.getSanPham().getMaSP()) || km.getSanPham().getTenSP().contains(key);
            boolean ktphantram=true;
            if(phantram != 0)
                ktphantram= phantram==km.getPhanTram();
            if(ktkey && ktphantram){
                Vector row=new Vector();
                row.add(km.getSanPham().getMaSP());
                row.add(km.getSanPham().getTenSP());
                row.add(km.getSanPham().getDonGia());
                row.add(km.getPhanTram());
                int giagoc=km.getSanPham().getDonGia();
                int giakhuyenmai=giagoc - giagoc*km.getPhanTram()/100;
                row.add(giakhuyenmai);
                row.add("edit");
                row.add("delete");
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

        km.setNgayBD(datebatdaukhuyenmai.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        km.setNgayKT(datebatdaukhuyenmai.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        km.setGhiChu(areatxtghichu.getText());
        buskm.add(km);
    }
    public void suaKhuyenMai(){
        KhuyenMaiDTO km =new KhuyenMaiDTO();
        int row=bangkhuyenmai.getSelectedRow();
        String makmbandau=bangkhuyenmai.getValueAt(row, 0).toString();
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

        km.setNgayBD(datebatdaukhuyenmai.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        km.setNgayKT(dateketthuckhuyenmai.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
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
        header.add("Giảm %");
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
                public Class getColumnClass(int column){
                    if(column == 0){
                        return Boolean.class;
                    }
                    if(column == 7){
                        return Integer.class;
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
            row.add(sp.getTenSP());
            row.add(sp.getSoLuong());
            row.add(sp.getDonGia());
            row.add(bussp.getCTSPByMaSP(sp.getMaSP()).getBaoHanh());
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
        chinhsuachitietkhuyenmaidialog = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtmasanphamkhuyenmai = new javax.swing.JTextField();
        txttensanphamkhuyenmai = new javax.swing.JTextField();
        spinnersanphamgiam = new javax.swing.JSpinner();
        btncapnhatchinhsuasanphamkhuyenmai = new javax.swing.JButton();
        btnhuychinhsuasanphamkhuyenmai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmakhuyenmai = new javax.swing.JTextField();
        txttenkhuyenmai = new javax.swing.JTextField();
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
        jButton5 = new javax.swing.JButton();
        dateketthuckhuyenmaitimkiem = new com.toedter.calendar.JDateChooser();
        datebatdaukhuyenmaitimkiem = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnresetchitietkhuyenmai = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        spinnersanpham = new javax.swing.JSpinner();
        btnresetkhuyenmai1 = new javax.swing.JButton();
        cbtimkiemtinhtrang = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        spinnergiamchung = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Chỉnh sửa khuyến mãi");

        jLabel12.setText("Mã sản phẩm:");

        jLabel13.setText("Tên sản phẩm:");

        jLabel14.setText("% giảm:");

        txtmasanphamkhuyenmai.setEnabled(false);

        txttensanphamkhuyenmai.setEnabled(false);

        spinnersanphamgiam.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        btncapnhatchinhsuasanphamkhuyenmai.setText("Cập nhật");
        btncapnhatchinhsuasanphamkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatchinhsuasanphamkhuyenmaiActionPerformed(evt);
            }
        });

        btnhuychinhsuasanphamkhuyenmai.setText("Hủy");
        btnhuychinhsuasanphamkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhuychinhsuasanphamkhuyenmaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chinhsuachitietkhuyenmaidialogLayout = new javax.swing.GroupLayout(chinhsuachitietkhuyenmaidialog.getContentPane());
        chinhsuachitietkhuyenmaidialog.getContentPane().setLayout(chinhsuachitietkhuyenmaidialogLayout);
        chinhsuachitietkhuyenmaidialogLayout.setHorizontalGroup(
            chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(jLabel11))
                        .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtmasanphamkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttensanphamkhuyenmai)
                                .addComponent(spinnersanphamgiam))))
                    .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btncapnhatchinhsuasanphamkhuyenmai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnhuychinhsuasanphamkhuyenmai)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        chinhsuachitietkhuyenmaidialogLayout.setVerticalGroup(
            chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chinhsuachitietkhuyenmaidialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtmasanphamkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txttensanphamkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(spinnersanphamgiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(chinhsuachitietkhuyenmaidialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncapnhatchinhsuasanphamkhuyenmai)
                    .addComponent(btnhuychinhsuasanphamkhuyenmai))
                .addContainerGap(17, Short.MAX_VALUE))
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
                .addContainerGap(1183, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(1710, 1080));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(192, 31, 31));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sale.png"))); // NOI18N
        jLabel2.setText("KHUYẾN MÃI");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel3.setText("Mã khuyến mãi:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel4.setText("Tên khuyến mãi:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        jLabel6.setText("Ngày bắt đầu:");

        txtmakhuyenmai.setEnabled(false);

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
                "Mã KM", "Tên KM", "Ngày bắt đầu"
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
        jLabel10.setText("Tìm sản phẩm:");

        txttimkiemchitietkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemchitietkhuyenmaiActionPerformed(evt);
            }
        });

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
                "Mã SP", "Tên SP", "Giá gốc", "% giảm", "Giá khuyến mãi", "Edit", "Delete"
            }
        ));
        bangchitietkhuyenmai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangchitietkhuyenmaiMouseClicked(evt);
            }
        });
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel5.setText("Từ:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel15.setText("Đến:");

        btnresetchitietkhuyenmai.setBackground(new java.awt.Color(56, 134, 155));
        btnresetchitietkhuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnresetchitietkhuyenmai.setForeground(new java.awt.Color(255, 255, 255));
        btnresetchitietkhuyenmai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnresetchitietkhuyenmai.setText("Reset");
        btnresetchitietkhuyenmai.setBorderPainted(false);
        btnresetchitietkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetchitietkhuyenmaiActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel16.setText("%");

        spinnersanpham.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        btnresetkhuyenmai1.setBackground(new java.awt.Color(56, 134, 155));
        btnresetkhuyenmai1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnresetkhuyenmai1.setForeground(new java.awt.Color(255, 255, 255));
        btnresetkhuyenmai1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnresetkhuyenmai1.setText("Reset");
        btnresetkhuyenmai1.setBorderPainted(false);
        btnresetkhuyenmai1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetkhuyenmai1ActionPerformed(evt);
            }
        });

        cbtimkiemtinhtrang.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        cbtimkiemtinhtrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn trạng thái", "Hoạt động", "Ngừng" }));
        cbtimkiemtinhtrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtimkiemtinhtrangActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel18.setText("Tình trạng:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel19.setText("% giảm chung:");

        spinnergiamchung.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jButton6.setBackground(new java.awt.Color(56, 134, 155));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jButton6.setText("Áp dụng tất cả");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(56, 134, 155));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bin.png"))); // NOI18N
        jButton8.setText("Xóa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtmakhuyenmai)
                                            .addComponent(txttenkhuyenmai)
                                            .addComponent(datebatdaukhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                            .addComponent(dateketthuckhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(spinnergiamchung, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)
                                .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnersanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(34, 34, 34)
                                .addComponent(btnresetchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(205, 205, 205))
                            .addComponent(jButton5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2154, 2154, 2154))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttimkiemkhuyenmai)
                                    .addComponent(cbtimkiemtinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(datebatdaukhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateketthuckhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(49, 49, 49)
                                        .addComponent(btnresetkhuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton8))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2294, 2294, 2294))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txttimkiemkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateketthuckhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datebatdaukhuyenmaitimkiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 40, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txttenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(datebatdaukhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateketthuckhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel18))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbtimkiemtinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3))
                            .addComponent(btnresetkhuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jButton8)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel16)
                            .addComponent(spinnersanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(btnresetchitietkhuyenmai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(spinnergiamchung, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
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
        Date bd=datebatdaukhuyenmaitimkiem.getDate();
        Date kt=dateketthuckhuyenmaitimkiem.getDate();
        String tt=cbtimkiemtinhtrang.getSelectedItem().toString();
        int indextt;
        if(tt.equals("Hoạt động"))
            indextt=1;
        else if(tt.equals("Ngừng")) 
            indextt=0;
        else 
            indextt=2;
        veBangKhuyenMai(key,bd,kt,indextt);
        xoaForm();
        xoaBangChiTietKhuyenMai();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = bangkhuyenmai.getSelectedRow();
        String makm=bangkhuyenmai.getValueAt(row, 0).toString();
        if(row == -1){
            JOptionPane.showMessageDialog(null,"Vui lòng chọn khuyến mãi trước!");
            return;
        }
        String key=txttimkiemchitietkhuyenmai.getText();
        int phantram=Integer.parseInt( spinnersanpham.getValue().toString());
        veBangChiTietKhuyenMaiTheoKey(makm,key,phantram);
    }//GEN-LAST:event_jButton4ActionPerformed

    public void veBangSuaSanPhamKhuyenMai(){
        chinhsuachitietkhuyenmaidialog.setSize(600,400);
        chinhsuachitietkhuyenmaidialog.setLocation(300,200);
        chinhsuachitietkhuyenmaidialog.setVisible(true);
        
        int row=bangchitietkhuyenmai.getSelectedRow();
        String masp= bangchitietkhuyenmai.getValueAt(row, 0).toString();  
        String tensp=bangchitietkhuyenmai.getValueAt(row, 1).toString();  
        int phantram=Integer.parseInt(bangchitietkhuyenmai.getValueAt(row, 3).toString());  
        
        txtmasanphamkhuyenmai.setText(masp);
        txttensanphamkhuyenmai.setText(tensp);
        spinnersanphamgiam.setValue(phantram);
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        int row = bangkhuyenmai.getSelectedRow();
        if(row>=0){
            chonsanphamdialog.setSize(600,400);
            chonsanphamdialog.setLocation(300,200);
            chonsanphamdialog.setVisible(true);
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
        if(bangchonsanphamkhuyenmai.isEditing()){
            bangchonsanphamkhuyenmai.getCellEditor().stopCellEditing();
        }
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
                int phantram = 0;

                Object value = model.getValueAt(i, 5);

                if(value != null && !value.toString().trim().isEmpty()){
                    phantram = Integer.parseInt(value.toString().trim());
                }
                
                ctkm.setMaKM(makm);
                ctkm.setSanPham(sp);
                ctkm.setPhanTram(phantram);
                busctkm.add(ctkm);
                veBangChiTietKhuyenMai(makm);
                 chonsanphamdialog.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnxacnhanActionPerformed

    private void bangchitietkhuyenmaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangchitietkhuyenmaiMouseClicked
        // TODO add your handling code here:
        int row=bangchitietkhuyenmai.getSelectedRow();
        int column=bangchitietkhuyenmai.getSelectedColumn();
        
        if(column == 5){
            veBangSuaSanPhamKhuyenMai();
        }
        else if(column == 6){
            int confirm= JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm này?");
            if(confirm == JOptionPane.YES_OPTION){
                String makm=bangkhuyenmai.getValueAt(bangkhuyenmai.getSelectedRow(),0).toString();
                String masp= bangchitietkhuyenmai.getValueAt(row,0).toString();
                busctkm.delete(makm,masp);
                veBangChiTietKhuyenMai(makm);
            }
        }
    }//GEN-LAST:event_bangchitietkhuyenmaiMouseClicked

    private void btncapnhatchinhsuasanphamkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhatchinhsuasanphamkhuyenmaiActionPerformed
        // TODO add your handling code here:
        int row;
        row=bangkhuyenmai.getSelectedRow(); 
        if(row == -1) return;
        String makm= bangkhuyenmai.getValueAt(row, 0).toString();
        String masp= txtmasanphamkhuyenmai.getText();
        String tensp= txttensanphamkhuyenmai.getText();
        int phantram=Integer.parseInt(spinnersanphamgiam.getValue().toString());
        ChiTietKhuyenMaiDTO ctkm=new ChiTietKhuyenMaiDTO();
        ctkm.setMaKM(makm);
        
        SanPhamDTO sp=new SanPhamDTO();
        sp.setMaSP(masp);
        sp.setTenSP(tensp);
        ctkm.setSanPham(sp);
        
        ctkm.setPhanTram(phantram);
        
        busctkm.update(ctkm);
        veBangChiTietKhuyenMai(makm);
        chinhsuachitietkhuyenmaidialog.setVisible(false);
    }//GEN-LAST:event_btncapnhatchinhsuasanphamkhuyenmaiActionPerformed

    private void btnhuychinhsuasanphamkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhuychinhsuasanphamkhuyenmaiActionPerformed
        // TODO add your handling code here:
        spinnersanphamgiam.setValue(0);
    }//GEN-LAST:event_btnhuychinhsuasanphamkhuyenmaiActionPerformed

    private void btnresetchitietkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetchitietkhuyenmaiActionPerformed
        // TODO add your handling code here:    
        txttimkiemchitietkhuyenmai.setText("");
        spinnersanpham.setValue(0);
        int row;
        row=bangkhuyenmai.getSelectedRow(); 
        if(row == -1) return;
        String makm= bangkhuyenmai.getValueAt(row, 0).toString();
        veBangChiTietKhuyenMai(makm);
    }//GEN-LAST:event_btnresetchitietkhuyenmaiActionPerformed

    private void btnresetkhuyenmai1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetkhuyenmai1ActionPerformed
        // TODO add your handling code here:
        String ma=buskm.taoMaKM();
        txtmakhuyenmai.setText(ma);
        txttenkhuyenmai.setText("");
        datebatdaukhuyenmai.setDate(null);
        dateketthuckhuyenmai.setDate(null);
        areatxtghichu.setText("");
        txttimkiemkhuyenmai.setText("");
        datebatdaukhuyenmaitimkiem.setDate(null);
        dateketthuckhuyenmaitimkiem.setDate(null);
        cbtimkiemtinhtrang.setSelectedIndex(0);
        veBangKhuyenMai();
        DefaultTableModel model=(DefaultTableModel) bangchitietkhuyenmai.getModel();
        model.setRowCount(0);
        bangchitietkhuyenmai.setModel(model);
    }//GEN-LAST:event_btnresetkhuyenmai1ActionPerformed

    private void txttimkiemchitietkhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemchitietkhuyenmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemchitietkhuyenmaiActionPerformed

    public void suaKhuyenMaTatCa(String makm){
        int phantram=Integer.parseInt( spinnergiamchung.getValue().toString());
        busctkm.updatePhanTramGiam(phantram,makm);
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int row;
        row=bangkhuyenmai.getSelectedRow(); 
        if(row == -1) return;
        String makm= bangkhuyenmai.getValueAt(row, 0).toString();
        suaKhuyenMaTatCa(makm);
        veBangChiTietKhuyenMai(makm);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbtimkiemtinhtrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtimkiemtinhtrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtimkiemtinhtrangActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Bạn muốn xóa khuyến mãi này");
        if(ok==JOptionPane.YES_OPTION){
            int row1=bangkhuyenmai.getSelectedRow();
            if(row1==-1){
                JOptionPane.showMessageDialog(null, "Vui lòng chọn mã khuyến mãi");
                return;
            }
            String makm=bangkhuyenmai.getValueAt(row1, 0).toString();
            buskm.deleteKM(makm);
            veBangKhuyenMai();
        }
        
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areatxtghichu;
    private javax.swing.JTable bangchitietkhuyenmai;
    private javax.swing.JTable bangchonsanphamkhuyenmai;
    private javax.swing.JTable bangkhuyenmai;
    private javax.swing.JButton btncapnhatchinhsuasanphamkhuyenmai;
    private javax.swing.JButton btnhuychinhsuasanphamkhuyenmai;
    private javax.swing.JButton btnresetchitietkhuyenmai;
    private javax.swing.JButton btnresetkhuyenmai1;
    private javax.swing.JButton btnxacnhan;
    private javax.swing.JComboBox<String> cbtimkiemtinhtrang;
    private javax.swing.JDialog chinhsuachitietkhuyenmaidialog;
    private javax.swing.JDialog chonsanphamdialog;
    private com.toedter.calendar.JDateChooser datebatdaukhuyenmai;
    private com.toedter.calendar.JDateChooser datebatdaukhuyenmaitimkiem;
    private com.toedter.calendar.JDateChooser dateketthuckhuyenmai;
    private com.toedter.calendar.JDateChooser dateketthuckhuyenmaitimkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner spinnergiamchung;
    private javax.swing.JSpinner spinnersanpham;
    private javax.swing.JSpinner spinnersanphamgiam;
    private javax.swing.JTextField txtmakhuyenmai;
    private javax.swing.JTextField txtmasanphamkhuyenmai;
    private javax.swing.JTextField txttenkhuyenmai;
    private javax.swing.JTextField txttensanphamkhuyenmai;
    private javax.swing.JTextField txttimkiemchitietkhuyenmai;
    private javax.swing.JTextField txttimkiemkhuyenmai;
    // End of variables declaration//GEN-END:variables
}
