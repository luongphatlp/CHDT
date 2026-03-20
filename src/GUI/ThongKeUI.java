
package GUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import BUS.ThongKeDoanhThuBUS;
import BUS.ThongKeNhanVienBUS;
import BUS.ThongKeSanPhamBUS;
import DTO.ThongKeDoanhThuDTO;
import DTO.ThongKeNhanVienDTO;
import DTO.ThongKeSanPhamDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.lang.Object;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

public class ThongKeUI extends javax.swing.JPanel {
    ThongKeNhanVienBUS busnv=new ThongKeNhanVienBUS();
    public ThongKeUI() {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        initComponents();
        veBangThongKeSanPhamDayDu();
        chucNang();
        filechooseexcel.setVisible(false);
    }
    //3 bảng hiển thị tổng số 
    /*
    public void bangDienThoai(){
        int sum=0;
        DienThoaiBUS bus=new DienThoaiBUS();
        for(DienThoaiDTO dt:bus.getList())
            sum+=dt.getSoLuong();
        lbdienthoai.setText("Điện thoại:"+sum);
    }
    public void bangNCC(){
        NhaCungCapBUS bus=new NhaCungCapBUS();
        lbNhaCungCap.setText("Nhà cung cấp:"+bus.getLst().size());
    }
    public void bangNhanVien(){
        NhanVienBUS bus=new NhanVienBUS();
        lbNhanVien.setText("Nhân viên:"+bus.getList().size());
    }
    */
    public void chucNang(){
        pngay.setVisible(false);
        pthang.setVisible(false);
        pnam.setVisible(false);
        String key=cbthoigian.getSelectedItem().toString();
        if(key.equals("Ngày")){
            pngay.setVisible(true);
        }else if(key.equals("Tháng")){
            pthang.setVisible(true);
        }else{
            pnam.setVisible(true);
        }
    }
    public void veBieuDo(int i,ArrayList<ThongKeDoanhThuDTO> ds) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ThongKeDoanhThuBUS bus=new ThongKeDoanhThuBUS();
        String ngay;
        if(i==1){
            ngay="Ngày";  
        }else if(i==2){
            ngay="Tháng";
        }else{
            ngay="Năm";
        }
        for(ThongKeDoanhThuDTO tk:ds){
            dataset.setValue(tk.getDoanhThu(),"Đồng",tk.getNgay());
        } 
        
        JFreeChart chart = ChartFactory.createLineChart(
                "Thống kê doanh thu",
                ngay,
                "Doanh thu",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);

        pnbieudo.removeAll();

        CategoryPlot plot = chart.getCategoryPlot();

        chart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlinePaint(null);

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setDefaultItemLabelsVisible(true);
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickUnit(new NumberTickUnit(5000000));

        pnbieudo.setLayout(new java.awt.BorderLayout());
        pnbieudo.add(chartPanel, java.awt.BorderLayout.CENTER);
        pnbieudo.validate();

        renderer.setSeriesPaint(0, new Color(79,129,189)); // màu cột
        renderer.setSeriesPaint(1, new Color(192,80,77));
    }
    public void veBangThongKeDoanhThu(String ngay,ArrayList<ThongKeDoanhThuDTO> ds){
        Vector header =new Vector();
        header.add("STT");
        header.add(ngay);
        header.add("Số hóa đơn");
        header.add("Doanh thu");
        DefaultTableModel model=new DefaultTableModel(header,0);
        int i=0;
        for(ThongKeDoanhThuDTO tk:ds){
            Vector row=new Vector();
            i++;
            row.add(i);
            row.add(tk.getNgay());
            row.add(tk.getHoaDon());
            row.add(tk.getDoanhThu());
            model.addRow(row);
        }
        bangdoanhthu.setModel(model);
        bangdoanhthu.setFont(new Font("Arial", Font.PLAIN, 16));
    }
    public void veBangThongKeSanPhamDayDu(){
        ThongKeSanPhamBUS bus=new ThongKeSanPhamBUS();
        veBangThongKeSanPham(bus.thongKeSanPham());
    }
    
    public void veBangThongKeSanPham(ArrayList<ThongKeSanPhamDTO> ds){
        Vector header=new Vector();
        header.add("STT");
        header.add("Mã sản phẩm");
        header.add("Tên sản phẩm");
        header.add("Tổng số nhập");
        header.add("Tổng số bán");
        header.add("Tồn kho");
        DefaultTableModel model =new DefaultTableModel(header,0);
        int i=0;
        for(ThongKeSanPhamDTO tk:ds){
            Vector row =new Vector();
            i++;
            row.add(i);
            row.add(tk.getMaSP());
            row.add(tk.getTen());
            row.add(tk.getTongNhap());
            row.add(tk.getTongBan());
            row.add(tk.getTonKho());
            model.addRow(row); 
        }
        BangThongKe.setModel(model);
        
        BangThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
    }
    public void xuatExcel(String path,String ngay) throws FileNotFoundException, IOException {

    try (Workbook workbook = new XSSFWorkbook()) {

        
        
        Sheet sheet = workbook.createSheet("Thống kê doanh thu");
        org.apache.poi.ss.usermodel.Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("STT");
        row0.createCell(1).setCellValue(ngay);
        row0.createCell(2).setCellValue("Số hóa đơn");
        row0.createCell(3).setCellValue("Doanh thu");
        for (int i = 0; i < bangdoanhthu.getRowCount(); i++) {

            org.apache.poi.ss.usermodel.Row row = sheet.createRow(i+1);
            for (int j = 0; j < bangdoanhthu.getColumnCount(); j++) {
                
                Object value = bangdoanhthu.getValueAt(i, j);
                row.createCell(j).setCellValue(
                        value == null ? "" : value.toString()
                );
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
            }
        }
    }
    public void veBangNhanVien(){
        DefaultTableModel model = (DefaultTableModel) bangnhanvien.getModel();
        model.setRowCount(0);
        ArrayList<ThongKeNhanVienDTO> ds= busnv.docDS();
        int i=1;
        for(ThongKeNhanVienDTO tk:ds){
            Vector row=new Vector();
            row.add(i++);
            row.add(tk.getMaNV());
            row.add(tk.getHoTen());
            row.add(tk.getSoHoaDon());
            row.add(tk.getDoanhThu());
            model.addRow(row);
        }
        bangnhanvien.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bieudodialog = new javax.swing.JDialog();
        a = new javax.swing.JScrollPane();
        pnbieudo = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        filechoosepdf = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        lbdienthoai = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txttimkiem = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        chtungay = new com.toedter.calendar.JDateChooser();
        chdenngay = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnreset1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BangThongKe = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        cbthoigian = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        pngay = new javax.swing.JPanel();
        lbtungay = new javax.swing.JLabel();
        chtungaydoanhthu = new com.toedter.calendar.JDateChooser();
        lbdenngay = new javax.swing.JLabel();
        chdenngaydoanhthu = new com.toedter.calendar.JDateChooser();
        pthang = new javax.swing.JPanel();
        lbnam = new javax.swing.JLabel();
        txtnam = new javax.swing.JTextField();
        pnam = new javax.swing.JPanel();
        txttunam = new javax.swing.JTextField();
        lbtunam = new javax.swing.JLabel();
        lbdennam = new javax.swing.JLabel();
        txtdennam = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        bangdoanhthu = new javax.swing.JTable();
        btnbieudo = new javax.swing.JButton();
        btnthongke = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        filechooseexcel = new javax.swing.JFileChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        bangnhanvien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        chdenngaynhanvien = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        chtungaynhanvien = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        btthongkenhanvien = new javax.swing.JButton();

        javax.swing.GroupLayout pnbieudoLayout = new javax.swing.GroupLayout(pnbieudo);
        pnbieudo.setLayout(pnbieudoLayout);
        pnbieudoLayout.setHorizontalGroup(
            pnbieudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1306, Short.MAX_VALUE)
        );
        pnbieudoLayout.setVerticalGroup(
            pnbieudoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );

        a.setViewportView(pnbieudo);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pdf (1).png"))); // NOI18N
        jButton4.setText("Xuất PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bieudodialogLayout = new javax.swing.GroupLayout(bieudodialog.getContentPane());
        bieudodialog.getContentPane().setLayout(bieudodialogLayout);
        bieudodialogLayout.setHorizontalGroup(
            bieudodialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bieudodialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 1292, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(bieudodialogLayout.createSequentialGroup()
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(filechoosepdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bieudodialogLayout.setVerticalGroup(
            bieudodialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bieudodialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bieudodialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(filechoosepdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(1710, 180));

        jPanel9.setBackground(new java.awt.Color(69, 66, 158));
        jPanel9.setForeground(new java.awt.Color(18, 77, 122));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 60));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 41)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addContainerGap(2592, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(221, 221, 239));
        kGradientPanel1.setkStartColor(new java.awt.Color(82, 162, 228));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N

        lbdienthoai.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        lbdienthoai.setForeground(new java.awt.Color(255, 255, 255));
        lbdienthoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-interface.png"))); // NOI18N
        lbdienthoai.setText("Điện thoại:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(117, 117, 117))))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbdienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(268, Short.MAX_VALUE)))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lbdienthoai)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        kGradientPanel2.setkEndColor(new java.awt.Color(184, 233, 233));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 204, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delivery-courier.png"))); // NOI18N
        jLabel8.setText("Nhà cung cấp:");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(310, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        kGradientPanel3.setkEndColor(new java.awt.Color(245, 245, 193));
        kGradientPanel3.setkStartColor(new java.awt.Color(211, 211, 134));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        jLabel9.setText("Nhân viên");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eye.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(298, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 2830, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1160, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 18))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(820, 90));

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo ngày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 16))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(601, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel4.setText("Từ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Đến:");

        btnreset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnreset1.setText("Làm mới");
        btnreset1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset1ActionPerformed(evt);
            }
        });

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Biểu đồ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chtungay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnreset1)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(chdenngay, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(chtungay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnreset1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        BangThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã máy ", "Tên máy", "Số lượng còn", "Đã bán"
            }
        ));
        jScrollPane1.setViewportView(BangThongKe);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)))
                .addContainerGap(1184, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel6);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        cbthoigian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng", "Năm" }));
        cbthoigian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbthoigianActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Chọn kỳ thống kê: ");

        lbtungay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbtungay.setText("Từ ngày");

        lbdenngay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbdenngay.setText("Đến ngày");

        javax.swing.GroupLayout pngayLayout = new javax.swing.GroupLayout(pngay);
        pngay.setLayout(pngayLayout);
        pngayLayout.setHorizontalGroup(
            pngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtungay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chtungaydoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbdenngay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chdenngaydoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pngayLayout.setVerticalGroup(
            pngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pngayLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pngayLayout.createSequentialGroup()
                        .addGroup(pngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbtungay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chtungaydoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pngayLayout.createSequentialGroup()
                        .addGroup(pngayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbdenngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chdenngaydoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                        .addGap(49, 49, 49))))
        );

        lbnam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbnam.setText("Năm");

        txtnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pthangLayout = new javax.swing.GroupLayout(pthang);
        pthang.setLayout(pthangLayout);
        pthangLayout.setHorizontalGroup(
            pthangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pthangLayout.createSequentialGroup()
                .addComponent(lbnam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pthangLayout.setVerticalGroup(
            pthangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pthangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pthangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lbtunam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbtunam.setText("Từ năm");

        lbdennam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbdennam.setText("Đến năm");

        javax.swing.GroupLayout pnamLayout = new javax.swing.GroupLayout(pnam);
        pnam.setLayout(pnamLayout);
        pnamLayout.setHorizontalGroup(
            pnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnamLayout.createSequentialGroup()
                .addComponent(lbtunam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttunam, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbdennam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdennam)
                .addContainerGap())
        );
        pnamLayout.setVerticalGroup(
            pnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbtunam)
                    .addComponent(txttunam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdennam)
                    .addComponent(txtdennam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangdoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bangdoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Ngày", "Số hóa đơn", "Doanh thu"
            }
        ));
        jScrollPane2.setViewportView(bangdoanhthu);

        btnbieudo.setText("Biểu đồ");
        btnbieudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbieudoActionPerformed(evt);
            }
        });

        btnthongke.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnthongke.setText("Thống kê");
        btnthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongkeActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel (2).png"))); // NOI18N
        jButton3.setText("Xuất Excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnbieudo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filechooseexcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1410, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbthoigian, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pngay, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnthongke)
                            .addComponent(pnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnbieudo)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filechooseexcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1220, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Doanh thu", jPanel11);

        jLabel10.setText("Chọn kỳ thống kê");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Tháng ", "Năm" }));

        bangnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên", "Số hóa đơn", "Doanh thu"
            }
        ));
        jScrollPane4.setViewportView(bangnhanvien);

        jLabel11.setText("Từ ngày");

        jLabel13.setText("Đến ngày");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(272, 272, 272)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chdenngaynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(chtungaynhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel11))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel13)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chdenngaynhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chtungaynhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );

        jLabel14.setText("Năm");

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jLabel15.setText("Từ năm");

        jLabel16.setText("Đến năm");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        btthongkenhanvien.setText("Thống kê");
        btthongkenhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthongkenhanvienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel10)
                        .addGap(112, 112, 112)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btthongkenhanvien))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1629, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btthongkenhanvien)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhân viên", jPanel4);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1162, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnreset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset1ActionPerformed
        // TODO add your handling code here:
        txttimkiem.setText(null);
        chtungay.setDate(null);
        chdenngay.setDate(null);
        veBangThongKeSanPhamDayDu();
    }//GEN-LAST:event_btnreset1ActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ThongKeSanPhamBUS bus=new ThongKeSanPhamBUS();
        
        String key=txttimkiem.getText();
        //JOptionPane.showMessageDialog(null,key);
        Date datetu=chtungay.getDate();
        Date dateden=chdenngay.getDate();
        //chuyen date thanh localdat
        
        veBangThongKeSanPham(bus.thongKeSanPhamDieuKien(key, datetu, dateden));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongkeActionPerformed
        // TODO add your handling code here:
        chtungaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        chdenngaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        chtungaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        chdenngaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        txtnam.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        ThongKeDoanhThuBUS bus=new ThongKeDoanhThuBUS();
        String ngay=cbthoigian.getSelectedItem().toString();
        if(ngay.equals("Ngày")){
            Date datetu=chtungaydoanhthu.getDate();
            Date dateden=chdenngaydoanhthu.getDate();
            if(datetu == null || dateden==null ){
                JOptionPane.showMessageDialog(null,"Vui lòng chọn đủ từ ngày đến ngày");
                chtungaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                chdenngaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            ArrayList<ThongKeDoanhThuDTO> ds=bus.thongKeDoanhThuTheoNgay(datetu, dateden);
            veBangThongKeDoanhThu("Ngày",ds);
            veBieuDo(1,ds);
        }else if(ngay.equals("Tháng")){
            int nam=Integer.parseInt(txtnam.getText().trim());
            if(txtnam.getText() == null){
                txtnam.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            ArrayList<ThongKeDoanhThuDTO> ds=bus.thongKeDoanhThuTheoThang(nam);
            veBangThongKeDoanhThu("Tháng",bus.thongKeDoanhThuTheoThang(nam));
            veBieuDo(2,ds);
        }else{
            int tunam=Integer.parseInt(txttunam.getText());
            int dennam=Integer.parseInt(txtdennam.getText());
            if(txttunam.getText() ==null || txtdennam.getText() ==null){
                chtungaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                chdenngaydoanhthu.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }
            ArrayList<ThongKeDoanhThuDTO> ds=bus.thongKeDoanhThuTheoNam(tunam,dennam);
            veBangThongKeDoanhThu("Năm",bus.thongKeDoanhThuTheoNam(tunam,dennam));
            veBieuDo(3,ds);
        }
    }//GEN-LAST:event_btnthongkeActionPerformed

    private void cbthoigianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbthoigianActionPerformed
        // TODO add your handling code here:
        chucNang();
    }//GEN-LAST:event_cbthoigianActionPerformed

    private void txtnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnbieudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbieudoActionPerformed
        // TODO add your handling code here:
        filechoosepdf.setVisible(false);
        bieudodialog.setSize(1300,1000);
        bieudodialog.setVisible(true);
    }//GEN-LAST:event_btnbieudoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    if (bangdoanhthu.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Không có dữ liệu để xuất");
        return;
    }
    String ngay=cbthoigian.getSelectedItem().toString();
    filechooseexcel.setVisible(true);
    int kq = filechooseexcel.showSaveDialog(null);
    if(kq == JFileChooser.APPROVE_OPTION){

        File file = filechooseexcel.getSelectedFile();

        String path = file.getAbsolutePath() + ".xlsx";
        try {
            xuatExcel(path,ngay);
        } catch (IOException ex) {
            System.getLogger(ThongKeUI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        JOptionPane.showMessageDialog(
            null,
            "Xuất file Excel thành công!",
            "Thông báo",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void xuatPDFBieuDo(JFreeChart chart, String path){

        try{

            Document document = new Document(com.itextpdf.text.PageSize.A1);
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            BufferedImage chartImage = chart.createBufferedImage(1000,800);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(chartImage,"png",baos);

            Image img = Image.getInstance(baos.toByteArray());

            document.add(img);

            document.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ChartPanel chartPanel = (ChartPanel) pnbieudo.getComponent(0);
        JFreeChart chart = chartPanel.getChart();
        filechoosepdf.setVisible(true);
        int result = filechoosepdf.showSaveDialog(null);

    if(result == JFileChooser.APPROVE_OPTION){

        File file = filechoosepdf.getSelectedFile();

        String path = file.getAbsolutePath() + ".pdf";

        xuatPDFBieuDo(chart,path);

        JOptionPane.showMessageDialog(null,"Xuất PDF thành công");
    }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btthongkenhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthongkenhanvienActionPerformed
        // TODO add your handling code here:
        veBangNhanVien();
    }//GEN-LAST:event_btthongkenhanvienActionPerformed

    
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ThongKeUI().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BangThongKe;
    private javax.swing.JScrollPane a;
    private javax.swing.JTable bangdoanhthu;
    private javax.swing.JTable bangnhanvien;
    private javax.swing.JDialog bieudodialog;
    private javax.swing.JButton btnbieudo;
    private javax.swing.JButton btnreset1;
    private javax.swing.JButton btnthongke;
    private javax.swing.JButton btthongkenhanvien;
    private javax.swing.JComboBox<String> cbthoigian;
    private com.toedter.calendar.JDateChooser chdenngay;
    private com.toedter.calendar.JDateChooser chdenngaydoanhthu;
    private com.toedter.calendar.JDateChooser chdenngaynhanvien;
    private com.toedter.calendar.JDateChooser chtungay;
    private com.toedter.calendar.JDateChooser chtungaydoanhthu;
    private com.toedter.calendar.JDateChooser chtungaynhanvien;
    private javax.swing.JFileChooser filechooseexcel;
    private javax.swing.JFileChooser filechoosepdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JLabel lbdennam;
    private javax.swing.JLabel lbdenngay;
    private javax.swing.JLabel lbdienthoai;
    private javax.swing.JLabel lbnam;
    private javax.swing.JLabel lbtunam;
    private javax.swing.JLabel lbtungay;
    private javax.swing.JPanel pnam;
    private javax.swing.JPanel pnbieudo;
    private javax.swing.JPanel pngay;
    private javax.swing.JPanel pthang;
    private javax.swing.JTextField txtdennam;
    private javax.swing.JTextField txtnam;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttunam;
    // End of variables declaration//GEN-END:variables
}
