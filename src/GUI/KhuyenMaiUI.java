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
        public void veBangKhuyenMai(String key,Date bd,Date kt){      
        Vector header=new Vector();
        header.add("Mã KM");
        header.add("Tên KM");
        header.add("Ngày BĐ");
        header.add("Ngày KT");
        header.add("Ghi chú");
        DefaultTableModel model=new DefaultTableModel(header,0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(KhuyenMaiDTO km:buskm.docDS()){
            try {
                boolean ktkey=key.equals(km.getMa()) || km.getTen().contains(key);
                
                boolean dkngay = true;
                
                Date ngayBD = sdf.parse(km.getNgayBD());
                Date ngayKT = sdf.parse(km.getNgayKT());
                
                if(bd != null && kt == null){
                    dkngay = !ngayBD.before(bd);
                }
                else if(bd == null && kt != null){
                    dkngay = !ngayKT.after(kt);
                }
                else if(bd != null && kt != null){
                    dkngay = !ngayBD.before(bd) && !ngayKT.after(kt);
                }
                
                if(ktkey && dkngay){
                    Vector row=new Vector();
                    row.add(km.getMa());
                    row.add(km.getTen());
                    row.add(km.getNgayBD());
                    row.add(km.getNgayKT());
                    row.add(km.getGhiChu());
                    model.addRow(row);
                }
            } catch (ParseException ex) {
                System.getLogger(KhuyenMaiUI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
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
        DefaultTableModel model=new DefaultTableModel(header,0);
        ArrayList<ChiTietKhuyenMaiDTO> ds = busctkm.docDSTheoMaKM(makm);
        for(ChiTietKhuyenMaiDTO km:ds){
            Vector row=new Vector();
            row.add(km.getSanPham().getMaSP());
            row.add(km.getSanPham().getTen());
            row.add(km.getSanPham().getDonGia());
            row.add(km.getPhanTram());
            int giagoc=Integer.parseInt(km.getSanPham().getDonGia());
            int giakhuyenmai=giagoc - giagoc*km.getPhanTram()/100;
            row.add(giakhuyenmai);
            row.add("edit");
            row.add("delete");
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
                ktkey=key.equals(km.getSanPham().getMaSP()) || km.getSanPham().getTen().contains(key);
            boolean ktphantram=true;
            if(phantram != 0)
                ktphantram= phantram==km.getPhanTram();
            if(ktkey && ktphantram){
                Vector row=new Vector();
                row.add(km.getSanPham().getMaSP());
                row.add(km.getSanPham().getTen());
                row.add(km.getSanPham().getDonGia());
                row.add(km.getPhanTram());
                int giagoc=Integer.parseInt(km.getSanPham().getDonGia());
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
        jSeparator1 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        dateketthuckhuyenmaitimkiem = new com.toedter.calendar.JDateChooser();
        datebatdaukhuyenmaitimkiem = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnresetchitietkhuyenmai = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        spinnersanpham = new javax.swing.JSpinner();
        btnresetkhuyenmai1 = new javax.swing.JButton();

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Mã sản phẩm:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Tên sản phẩm:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("% giảm:");

        txtmasanphamkhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtmasanphamkhuyenmai.setEnabled(false);

        txttensanphamkhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txttensanphamkhuyenmai.setEnabled(false);

        spinnersanphamgiam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        spinnersanphamgiam.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        btncapnhatchinhsuasanphamkhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btncapnhatchinhsuasanphamkhuyenmai.setText("Cập nhật");
        btncapnhatchinhsuasanphamkhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhatchinhsuasanphamkhuyenmaiActionPerformed(evt);
            }
        });

        btnhuychinhsuasanphamkhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateketthuckhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datebatdaukhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(txttenkhuyenmai)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 38, Short.MAX_VALUE))
                            .addComponent(txtmakhuyenmai))))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnersanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnresetchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton4))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txttimkiemkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(datebatdaukhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateketthuckhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jButton3)
                            .addGap(98, 98, 98))))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(1191, Short.MAX_VALUE)
                    .addComponent(btnresetkhuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(370, 370, 370)))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datebatdaukhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(txttimkiemkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateketthuckhuyenmaitimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(29, 29, 29)))))
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txttimkiemchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(spinnersanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnresetchitietkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(btnresetkhuyenmai1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(958, Short.MAX_VALUE)))
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
        Date bd=datebatdaukhuyenmaitimkiem.getDate();
        Date kt=dateketthuckhuyenmaitimkiem.getDate();
        
        veBangKhuyenMai(key,bd,kt);
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

                Object value = model.getValueAt(i, 7);

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
        sp.setTen(tensp);
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
        txttimkiemkhuyenmai.setText("");
        datebatdaukhuyenmaitimkiem.setDate(null);
        dateketthuckhuyenmaitimkiem.setDate(null);
        veBangKhuyenMai();
    }//GEN-LAST:event_btnresetkhuyenmai1ActionPerformed


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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
