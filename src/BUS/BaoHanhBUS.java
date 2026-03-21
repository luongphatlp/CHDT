package BUS;
import DAO.BaoHanhDAO;
import DTO.BaoHanhDTO;
import DTO.ChiTietBaoHanhDTO;
import DTO.ChiTietSanPhamDTO;
import DTO.KhachHangDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BaoHanhBUS {
    private final BaoHanhDAO dao = new BaoHanhDAO();
    ArrayList<BaoHanhDTO> ds;
    ChiTietBaoHanhBUS busct=new ChiTietBaoHanhBUS();
    public BaoHanhBUS(){
        ds=new ArrayList<>();
        busct.selectAll();
    }
    public ArrayList<BaoHanhDTO> selectAll(){
        ds=dao.selectAll();
        return ds;
    }
    public void delete(String ma){
        if(dao.delete(ma)!=-1)
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaBH().equals(ma)){
                ds.remove(i);
                break;
            }
        
    }
    public void insert(BaoHanhDTO bh){
        if(dao.insert(bh) !=-1)
            ds.add(bh);
    }
    public void update(BaoHanhDTO bh){
        if(dao.update(bh)!=-1)
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaBH().equals(bh.getMaBH())){
                ds.set(i,bh);
                break;
            }
    }
    public String taoMaBH() {
       return dao.taoMaBH();
    }
    public KhachHangDTO getKHByMaKH(String makh){
        KhachHangBUS bus=new KhachHangBUS();
        for (KhachHangDTO kh: bus.getDSKH() ){
            if(kh.getMa().equals(makh))
                return kh;
        }
        return null;
    }
    public ChiTietSanPhamDTO layCTSPByMaSP(String masp){
        SanPhamBUS bus =new  SanPhamBUS();
        return bus.layCTSPByMaSP(masp);
    } 
    public void insertCTBH(ArrayList<ChiTietBaoHanhDTO> ds){
        ChiTietBaoHanhBUS bus=new ChiTietBaoHanhBUS();
        for(ChiTietBaoHanhDTO ctbh:ds)
            bus.insert(ctbh);
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaBH(String mabh){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(bh.getMaBH().equals(mabh))
                tam.add(bh);
        return tam;
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaKH(String makh){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(makh.equals(bh.getMaKH()))
                tam.add(bh);
        return tam;
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaNV(String manv){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(manv.equals(bh.getMaNV()))
                tam.add(bh);
        return tam;
    }
    
    public ArrayList<ChiTietBaoHanhDTO> selectCTBHByMaBH(String mabh){
        ChiTietBaoHanhBUS bus=new ChiTietBaoHanhBUS();
        return bus.selectCTBHByMaBH(mabh);
    }
    public ArrayList<BaoHanhDTO> timKiemBHByDate(ArrayList<BaoHanhDTO> bd, LocalDate tu, LocalDate den){
        if(bd == null){
            selectAll();
            bd = ds;
        }

        ArrayList<BaoHanhDTO> tam = new ArrayList<>();

        for(BaoHanhDTO bh : bd){
            LocalDate ngay = bh.getNgayLap();

            if(!ngay.isBefore(tu) && !ngay.isAfter(den)){
                tam.add(bh);
            }
        }

        return tam;
    }
    public LocalDate chuyenDateThanhLocalDate(Date d){
        return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    public ArrayList<ChiTietBaoHanhDTO> getCTBHByMaBH(String mabh){
        return busct.selectCTBHByMaBH(mabh);
    }
    
    public void xuatPDF(String path,String mabh,String manv,String makh,String ngay) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("Cua hang dien thoai"));
            document.add(new Paragraph("Phieu bao hanh"));

            document.add(new Paragraph("Ma bao hanh: "+mabh));
            document.add(new Paragraph("Ma nhan vien: "+manv));
            document.add(new Paragraph("Ma khach hang: "+makh));
            document.add(new Paragraph("Ngay lap phieu: "+ngay));

            PdfPTable table = new PdfPTable(3);

            table.addCell("STT");
            table.addCell("IMEI");
            table.addCell("Ngay het bao hanh");
            ArrayList<ChiTietBaoHanhDTO> tam=getCTBHByMaBH(mabh);
            int i=1;
            for(ChiTietBaoHanhDTO ct:tam){
                table.addCell(String.valueOf(i++));
                table.addCell(ct.getIMEI());
                table.addCell(ct.getNgay().toString());
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

            Sheet sheet = workbook.createSheet("Thong ke bao hanh");
            int rownum = 0;

            for (int i = 0; i < model.getRowCount(); i++) {

                String mabh = model.getValueAt(i, 1).toString();
                String manv = model.getValueAt(i, 3).toString();
                String makh = model.getValueAt(i, 2).toString();
                String ngay = model.getValueAt(i, 4).toString(); // ✅ sửa luôn

                // 🔹 reset STT cho mỗi bảo hành
                int stt = 1;

                // 🔹 Info
                Row r0 = sheet.createRow(rownum++);
                r0.createCell(0).setCellValue("Mã bảo hành:");
                r0.createCell(1).setCellValue(mabh);

                Row r1 = sheet.createRow(rownum++);
                r1.createCell(0).setCellValue("Mã nhân viên:");
                r1.createCell(1).setCellValue(manv);

                Row r2 = sheet.createRow(rownum++);
                r2.createCell(0).setCellValue("Mã khách hàng:");
                r2.createCell(1).setCellValue(makh);

                Row r3 = sheet.createRow(rownum++);
                r3.createCell(0).setCellValue("Ngày lập:");
                r3.createCell(1).setCellValue(ngay);

                rownum++; // 🔥 dòng trống cho đẹp

                // 🔹 Header
                Row header = sheet.createRow(rownum++);
                header.createCell(0).setCellValue("STT");
                header.createCell(1).setCellValue("IMEI");
                header.createCell(2).setCellValue("Ngày hết bảo hành");

                // 🔹 Data
                ArrayList<ChiTietBaoHanhDTO> tam = getCTBHByMaBH(mabh);

                for (ChiTietBaoHanhDTO ct : tam) {
                    Row row = sheet.createRow(rownum++);

                    row.createCell(0).setCellValue(stt++);
                    row.createCell(1).setCellValue(ct.getIMEI());
                    row.createCell(2).setCellValue(ct.getNgay().toString());
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
    
    public void xuatExcel(String path,String manv,String makh,String mabh,LocalDate ngay,DefaultTableModel model) throws FileNotFoundException, IOException {

    try (Workbook workbook = new XSSFWorkbook()) {

        
        int rownum=0;
        Sheet sheet = workbook.createSheet("Thống kê doanh thu");
        org.apache.poi.ss.usermodel.Row row0 = sheet.createRow(rownum++);
        row0.createCell(0).setCellValue("Mã Bảo hành:");
        row0.createCell(1).setCellValue(mabh);
        org.apache.poi.ss.usermodel.Row row1 = sheet.createRow(rownum++);
        row1.createCell(0).setCellValue("Mã nhân viên:");
        row1.createCell(1).setCellValue(manv);
        org.apache.poi.ss.usermodel.Row row2 = sheet.createRow(rownum++);
        row2.createCell(0).setCellValue("Mã khách hang:");
        row2.createCell(1).setCellValue(makh);
        org.apache.poi.ss.usermodel.Row row3 = sheet.createRow(rownum++);
        row3.createCell(0).setCellValue("Ngày lập:");
        row3.createCell(1).setCellValue(ngay);
        org.apache.poi.ss.usermodel.Row row5 = sheet.createRow(rownum++);
        row5.createCell(0).setCellValue("STT");
        row5.createCell(1).setCellValue("IMEI");
        row5.createCell(2).setCellValue("Ngày hết bảo hành");
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