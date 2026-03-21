

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietBaoHanhDTO;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonBUS {
    HoaDonDAO dao=new HoaDonDAO();
    NhanVienBUS busnv=new NhanVienBUS();
    KhachHangBUS buskh=new KhachHangBUS();
    KhuyenMaiBUS buskm=new  KhuyenMaiBUS();
    ChiTietHoaDonBUS busct=new ChiTietHoaDonBUS();
    ArrayList<HoaDonDTO> ds;
    public HoaDonBUS(){
        ds =new ArrayList<>();
        buskm.docDS();
        buskh.getDSKH();
        busnv.docDSNV();
    }
    public void dockm(){buskm.docDS();}
    
    public ArrayList<HoaDonDTO> getDS(){return ds;}
    public boolean checkSoLuong(int soLuongMua, int soLuongTon) {
        if (soLuongMua <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!");
            return false;
        }
        if (soLuongMua > soLuongTon) {
            JOptionPane.showMessageDialog(null, "Số lượng trong kho không đủ!");
            return false;
        }
        return true;
    }

    public int tinhThanhTien(int soLuong, int donGia) {
        return soLuong * donGia;
    }

    
    public int getSoLuongTonTuBang(javax.swing.JTable table, String tenSP) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 1).toString().equals(tenSP)) {
                return Integer.parseInt(table.getValueAt(i, 2).toString());
            }
        }
        return 0;
    }
    public int insert(HoaDonDTO hd){
        return dao.insert(hd);
    }
    public int delete(HoaDonDTO hd){
        return dao.delete(hd);
    }
    public ArrayList<HoaDonDTO> selectAll(){
        ds=dao.selectAll();
        return ds;
    }
    public LocalDateTime chuyenDateThanhLocalDateTime(Date ngay){
        return ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public NhanVienDTO getNVByMaNV(String manv){
        ArrayList<NhanVienDTO> ds =busnv.getDSNV();
        for(NhanVienDTO nv:ds){
            if(nv.getMaNV().equals(manv)){
                return nv;
            }
        }
        return null;
    }
    public ArrayList<ChiTietHoaDonDTO> getCTHDByMaHD(String mahd){
        return busct.getCTHDByMaHD(mahd);
    }
    public KhachHangDTO getKHByMaKH(String makh){
        ArrayList<KhachHangDTO> ds =buskh.getDSKH();
            for(KhachHangDTO kh:ds){
                if(kh.getMa().equals(makh)){
                    return kh;
                }
            }
        return null;
    }
    public String taoMaHD(){
        return dao.taoMaHD();
    }
public ArrayList<HoaDonDTO> timKiem(String key,String pttt,String nv,
        LocalDate tungay,LocalDate denngay,int tugia,int dengia){

    ArrayList<HoaDonDTO> tam = new ArrayList<>();

    if(ds == null) selectAll();
    if(tungay==null) tungay=LocalDate.MIN;
    if(denngay==null) denngay=LocalDate.MAX;
    LocalDateTime tu=tungay.atStartOfDay();
    LocalDateTime den=denngay.atTime(23, 59, 59);
    if(tugia==0) tugia=0;
    if(dengia ==0 )dengia=Integer.MAX_VALUE;
    for(HoaDonDTO hd : ds){
        
        boolean mahd = true;
        boolean ktpttt = true;
        boolean ktmanv = true;
        boolean ktngay = true;
        boolean ktgia = true;

        if(key != null && !key.equals(""))
            mahd = key.equals(hd.getMaHD());

        if(pttt != null && !pttt.equals(""))
            ktpttt = pttt.equals(hd.getPTTT());

        if(nv != null && !nv.equals("")){
            String manv=nv.split("-")[0];
            ktmanv = manv.equals(hd.getMaNV());
        }
        ktngay = !tu.isAfter(hd.getNgay()) && !den.isBefore(hd.getNgay());
        ktgia = hd.getTongTien() >= tugia && hd.getTongTien() <= dengia;

        if(mahd && ktpttt && ktmanv && ktngay && ktgia)
            tam.add(hd);
    }

    return tam;
}
    public ArrayList<NhanVienDTO> getDSNV(){
        NhanVienBUS bus=new NhanVienBUS();
        return bus.docDSNV();
    }
    public KhachHangDTO layKhachHangBySDT(String sdt){
        KhachHangBUS buskh= new KhachHangBUS();
        for(KhachHangDTO kh:buskh.getDSKH()){
            if(sdt.equals(kh.getDt())){
                return kh;
            }
        }
        return null;
    }
    public ArrayList<HoaDonDTO> getHDByMaNV(String manv){
        ArrayList<HoaDonDTO> tam=new ArrayList<>();
        for(HoaDonDTO hd:ds)
            if(hd.getMaNV().equals(manv))
                tam.add(hd);
        return tam;
    }
    public ArrayList<HoaDonDTO> getHDByMaKH(String makh){
        ArrayList<HoaDonDTO> tam=new ArrayList<>();
        for(HoaDonDTO hd:ds)
            if(hd.getMaKH().equals(makh))
                tam.add(hd);
        return tam;
    }
    
    public String taoMaKH(){
        KhachHangBUS bus=new KhachHangBUS();
        int size=bus.getDSKH().size();
        if(size <10)
            return "KH0"+size;
        else 
            return "KH"+size;
    }
    public void themKH(KhachHangDTO kh){
        KhachHangBUS bus=new KhachHangBUS();
        bus.insert(kh);
    }
    public void insertCTHD(ArrayList<ChiTietHoaDonDTO> ds){
        ChiTietHoaDonBUS bus=new ChiTietHoaDonBUS();
        for(ChiTietHoaDonDTO cthd:ds)
            bus.insert(cthd);
        
    }
    public void capNhatSoLuongSanPham(ArrayList<ChiTietHoaDonDTO> ds){
         SanPhamBUS bus=new SanPhamBUS();
        for(ChiTietHoaDonDTO cthd:ds)
         bus.capNhatSoLuongSanPham(cthd.getMaSP(),cthd.getSoLuong());
    }
    public ArrayList<SanPhamDTO> selectAllDienThoai(){
        return dao.selectAllDienThoai();
    }
    public int tinhTienSauKhuyenMai(ChiTietHoaDonDTO cthd) {
        int tongTien = cthd.getSoLuong() * cthd.getDonGia();
        ArrayList<ChiTietKhuyenMaiDTO> dsKM = buskm.getKMByMaSPConThoiHan(cthd.getMaSP());

        int maxGiam = 0;
        if (dsKM != null) {
                           
            for (ChiTietKhuyenMaiDTO km : dsKM) {
                int giam = tongTien * km.getPhanTram() / 100;
                
                if (giam > maxGiam) {
                    maxGiam = giam;
                }
            }
        }

        return maxGiam;
    }
    public ArrayList<ChiTietHoaDonDTO> getCTBHByMaBH(String mahd){
        return busct.getCTHDByMaHD(mahd);
    }
    public void xuatPDF(String path,String mahd,String manv,String makh,String ngay,String tongtien,String pttt) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("Cua hang dien thoai"));
            document.add(new Paragraph("Phieu bao hanh"));

            document.add(new Paragraph("Ma hoa don: "+mahd));
            document.add(new Paragraph("Ma nhan vien: "+manv));
            document.add(new Paragraph("Ma khach hang: "+makh));
            document.add(new Paragraph("Tong tien "+ngay));
            document.add(new Paragraph("Ngay lap phieu: "+ngay));
            document.add(new Paragraph("Phuong thuc thanh toan: "+pttt));

            PdfPTable table = new PdfPTable(3);

            table.addCell("STT");
            table.addCell("Ma san pham");
            table.addCell("Ten san pham");
            table.addCell("Đon gia");
            table.addCell("So luong");
            table.addCell("Thanh tien");
            ArrayList<ChiTietHoaDonDTO> tam=getCTHDByMaHD(mahd);
            int i=1;
            for(ChiTietHoaDonDTO ct:tam){
                table.addCell(String.valueOf(i++));
                table.addCell(ct.getMaSP());
                table.addCell(ct.getTenSP());
                table.addCell(String.valueOf(ct.getDonGia()));
                table.addCell(String.valueOf(ct.getSoLuong()));
                table.addCell(String.valueOf(ct.getThanhTien()));
            }

            document.add(table);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void xuatExcelTatCa(String path, DefaultTableModel model) 
            throws FileNotFoundException, IOException {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Hóa đơn");
            int rownum = 0;

            for (int i = 0; i < model.getRowCount(); i++) {

                String mabh = model.getValueAt(i, 0).toString();
                String manv = model.getValueAt(i, 1).toString();
                String makh = model.getValueAt(i, 3).toString();
                String ngay = model.getValueAt(i, 2).toString();
                String tongtien = model.getValueAt(i, 4).toString();
                String pttt = model.getValueAt(i, 5).toString();
                // ✅ sửa luôn

                // 🔹 reset STT cho mỗi bảo hành
                int stt = 1;

                // 🔹 Info
                Row r0 = sheet.createRow(rownum++);
                r0.createCell(0).setCellValue("Mã hóa đơn:");
                r0.createCell(1).setCellValue(mabh);

                Row r1 = sheet.createRow(rownum++);
                r1.createCell(0).setCellValue("Mã nhân viên:");
                r1.createCell(1).setCellValue(manv);

                Row r4 = sheet.createRow(rownum++);
                r4.createCell(0).setCellValue("Mã khách hàng:");
                r4.createCell(1).setCellValue(manv);
                
                Row r2 = sheet.createRow(rownum++);
                r2.createCell(0).setCellValue("Tổng tiền:");
                r2.createCell(1).setCellValue(tongtien);

                Row r3 = sheet.createRow(rownum++);
                r3.createCell(0).setCellValue("Ngày lập:");
                r3.createCell(1).setCellValue(ngay);
                
                Row r5 = sheet.createRow(rownum++);
                r5.createCell(0).setCellValue("Phương thức thanh toán:");
                r5.createCell(1).setCellValue(pttt);

                rownum++; // 🔥 dòng trống cho đẹp

                // 🔹 Header
                Row header = sheet.createRow(rownum++);
                header.createCell(0).setCellValue("STT");
                header.createCell(1).setCellValue("Mã sản phẩm");
                header.createCell(2).setCellValue("Tên sản phẩm");
                header.createCell(3).setCellValue("Số lượng");
                header.createCell(4).setCellValue("Đơn giá");
                header.createCell(5).setCellValue("Thành tiền");
                // 🔹 Data
                ArrayList<ChiTietHoaDonDTO> tam = getCTBHByMaBH(mabh);

                for (ChiTietHoaDonDTO ct : tam) {
                    Row row = sheet.createRow(rownum++);

                    row.createCell(0).setCellValue(stt++);
                    row.createCell(1).setCellValue(ct.getMaSP());
                    row.createCell(2).setCellValue(ct.getTenSP());
                    row.createCell(3).setCellValue(ct.getSoLuong());
                    row.createCell(4).setCellValue(ct.getDonGia());
                    row.createCell(5).setCellValue(ct.getThanhTien());
                }

                rownum += 2; // 🔥 cách giữa các block
            }

            // 🔹 Auto size
            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            // 🔹 Ghi file
            try (FileOutputStream fileOut = new FileOutputStream(path)) {
                workbook.write(fileOut);
            }

            System.out.println("Xuất Excel tất cả thành công!");
        }
    }
    
    public void xuatExcel(String path,String manv,String makh,String mahd,String ngay,String pttt,String tongtien,DefaultTableModel model) throws FileNotFoundException, IOException {

    try (Workbook workbook = new XSSFWorkbook()) {

        
        int rownum=0;
        Sheet sheet = workbook.createSheet("Hóa đơn");
        org.apache.poi.ss.usermodel.Row row0 = sheet.createRow(rownum++);
        row0.createCell(0).setCellValue("Mã hóa đơn:");
        row0.createCell(1).setCellValue(mahd);
        org.apache.poi.ss.usermodel.Row row1 = sheet.createRow(rownum++);
        row1.createCell(0).setCellValue("Mã nhân viên:");
        row1.createCell(1).setCellValue(manv);
        org.apache.poi.ss.usermodel.Row row2 = sheet.createRow(rownum++);
        row2.createCell(0).setCellValue("Mã khách hang:");
        row2.createCell(1).setCellValue(makh);
        org.apache.poi.ss.usermodel.Row row4 = sheet.createRow(rownum++);
        row4.createCell(0).setCellValue("Tổng tiền:");
        row4.createCell(1).setCellValue(tongtien);
        org.apache.poi.ss.usermodel.Row row3 = sheet.createRow(rownum++);
        row3.createCell(0).setCellValue("Ngày lập:");
        row3.createCell(1).setCellValue(ngay);
        org.apache.poi.ss.usermodel.Row row5 = sheet.createRow(rownum++);
        row5.createCell(0).setCellValue("Phương thức thanh toán:");
        row5.createCell(1).setCellValue(pttt);
        org.apache.poi.ss.usermodel.Row row6 = sheet.createRow(rownum++);
        row6.createCell(0).setCellValue("Mã sản phẩm");
        row6.createCell(1).setCellValue("Tên sản phẩm");
        row6.createCell(2).setCellValue("Số lượng");
        row6.createCell(3).setCellValue("Đơn giá");
        row6.createCell(4).setCellValue("Thành tiền");
        for (int i = 0; i < model.getRowCount(); i++) {

            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rownum++);
            for (int j = 0; j < model.getColumnCount(); j++) {
                
                Object value = model.getValueAt(i, j);
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
}
