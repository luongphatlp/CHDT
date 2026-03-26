package BUS;

import DAO.NhanVienDAO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import DTO.ChiTietSanPhamDTO;
import DTO.NhanVienDTO;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.util.ArrayList;

public class SanPhamBUS {
    private ArrayList<SanPhamDTO> ds;
    private SanPhamDAO dao = new SanPhamDAO();
    private ChiTietSanPhamBUS busct=new ChiTietSanPhamBUS();
   public SanPhamBUS(){
        try {
            busct.docDS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void docDS() {
        ds = dao.selectAll();
        if (ds == null) ds = new ArrayList<>();
    }

    public ArrayList<SanPhamDTO> getDS() {
        return ds;
    }

    public boolean checkMaSP(String ma) {
        for (SanPhamDTO sp : ds) {
            if (sp.getMaSP().equalsIgnoreCase(ma)) return true;
        }
        return false;
    }

    public boolean them(SanPhamDTO sp) {
        if (checkMaSP(sp.getMaSP())) return false; 
        if (sp.getDonGia() < 0) return false;
        if (dao.insert(sp) > 0) {
            ds.add(sp);
            return true;
        }
        return false;
    }

    public boolean sua(SanPhamDTO sp) {
    if (dao.update(sp) > 0) { 
        dao.updateChiTiet(sp); 
        docDS(); 
        return true;
    }
    return false;
}

    public boolean xoa(String ma) {
        if (dao.delete(ma) > 0) {
            return ds.removeIf(sp -> sp.getMaSP().equals(ma));
        }
        return false;
    }

    public ArrayList<SanPhamDTO> selectSanPhamKhongTrongKhuyenMai(String ma) {
        return dao.selectSanPhamKhongTrongKhuyenMai(ma);
    }

    public ArrayList<SanPhamDTO> timKiem(String text, int index) {
       ArrayList<SanPhamDTO> ketQua = new ArrayList<>();
       String search = text.toLowerCase().trim();
       for (SanPhamDTO sp : ds) {
            boolean match = false;
            switch (index) {
                case 0: match = sp.getTenSP().toLowerCase().contains(search) || sp.getMaSP().toLowerCase().contains(search); break;
                case 1: match = sp.getMaSP().toLowerCase().contains(search); break;
                case 2: match = sp.getTenSP().toLowerCase().contains(search); break;
            }
            if (match) ketQua.add(sp);
        }
        return ketQua;
        }
    public void xuatExcel(File file) throws IOException {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Danh sách điện thoại");

    Row headerRow = sheet.createRow(0);
    String[] columns = {"Mã máy", "Tên máy", "Số lượng", "Đơn giá", "Đơn vị tính", "Mã hãng"};
    for (int i = 0; i < columns.length; i++) {
        Cell cell = headerRow.createCell(i);
        cell.setCellValue(columns[i]);
    }

    int rowNum = 1;
    for (SanPhamDTO sp : ds) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(sp.getMaSP());
        row.createCell(1).setCellValue(sp.getTenSP());
        row.createCell(2).setCellValue(sp.getSoLuong());
        row.createCell(3).setCellValue(sp.getDonGia());
//        row.createCell(4).setCellValue(sp.getDonViTinh());
//        row.createCell(5).setCellValue(sp.getMaHang());
    }

    try (FileOutputStream fileOut = new FileOutputStream(file)) {
        workbook.write(fileOut);
    }
    workbook.close();
}

    public int nhapExcel(File file) throws Exception {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(row.getCell(0).getStringCellValue());
                sp.setTenSP(row.getCell(1).getStringCellValue());
                sp.setSoLuong((int) row.getCell(2).getNumericCellValue());
                sp.setDonGia((int) row.getCell(3).getNumericCellValue());
//                sp.setDonViTinh(row.getCell(4).getStringCellValue());
//                sp.setMaHang(row.getCell(5).getStringCellValue());
                DTO.ChiTietSanPhamDTO ct = sp.getChiTiet();
                ct.setMau("Chưa xác định");
                ct.setManHinh("Chưa xác định");
                ct.setChip("Chưa xác định");
                ct.setRam("N/A");
                ct.setHeDieuHanh("Android");
                
                if (themChiTiet(sp)) {
                count++;
                }
            }
        }
        return count;
    }
    public SanPhamDTO getChiTiet(String ma) {
        return dao.selectChiTietByMa(ma);
    }

    public boolean themChiTiet(SanPhamDTO sp) {
       if (checkMaSP(sp.getMaSP())) return false;
       if (dao.insert(sp) > 0) {
           dao.insertChiTiet(sp); 
           ds.add(sp);
          return true;
        }
        return false;
    }
    public void tangSoLuong(String masp, int soluong){
        dao.updateSoLuong(masp, soluong);
        
    }
    public ChiTietSanPhamDTO getCTSPByMaSP(String ma){
        return busct.getCTSPByMaSP(ma);
    }
    public ChiTietSanPhamDTO layCTSPByMaSP(String masp){
        if(ds==null) docDS();
        for(SanPhamDTO sp:ds){
            if(sp.getMaSP().equals(masp)){
                return sp.getChiTiet();
            }
        }
        return null;
    }

    public int capNhatSoLuongSanPham(String masp, int soluongtru) {
        return dao.truSoLuongSanPham(masp, soluongtru);
    }
    
    public boolean them1(SanPhamDTO spDTO){
        
        SanPhamDAO dao = new SanPhamDAO();
        dao.insert(spDTO);
        ds.add(spDTO);
        return true;
    }
    public boolean sua1 (SanPhamDTO spDTO){
        SanPhamDAO dao = new SanPhamDAO();
        dao.update(spDTO);
        for (int i = 0 ; i < ds.size(); i++){
            if (spDTO.getMaSP().equals(ds.get(i).getMaSP())){
                ds.set(i, spDTO);
                return true;
            }
        }
        return false;
    }
    public boolean xoa1 (SanPhamDTO spDTO){
         SanPhamDAO dao = new SanPhamDAO();
         dao.delete(spDTO);
         for (int i = 0 ; i < ds.size(); i++){
             if (spDTO.getMaSP().equals(ds.get(i).getMaSP())){
                 ds.remove(i);
                 return true;
             }
         }
         return false;
    }
    public ArrayList<SanPhamDTO> timkiem (String muctieu){
        String target = muctieu.toLowerCase().trim();
        ArrayList<SanPhamDTO> dstk = new ArrayList<>();
        for (SanPhamDTO sp : ds){
            if (target.contains(sp.getMaSP().toLowerCase().trim())){
                dstk.add(sp);
            }else{
                return null;
            }
        }
        return dstk;
    }
    
    public void thu(){
       SanPhamDTO sp = new SanPhamDTO();
       sp.getMaSP();
       sp.getTenSP();
       sp.getSoLuong();
       sp.getDonGia();
       sp.getBoNho();
               
     
    }
    
    public boolean them2 (SanPhamDTO sp){
        SanPhamDAO dao = new SanPhamDAO();
        dao.insert(sp);
        ds.add(sp);
        return true;
    }
    public boolean sua2 (SanPhamDTO sp){
        SanPhamDAO dao = new SanPhamDAO();
        dao.update(sp);
        for (int i = 0 ; i < ds.size(); i++){
            if (sp.getMaSP().equals(ds.get(i).getMaSP())){
                ds.set(i, sp);
                return true;
            }
        }
        return false;
    }
    public boolean xoa2 (SanPhamDTO sp){
        SanPhamDAO dao = new SanPhamDAO();
        dao.delete(sp);
        for(int i = 0 ; i < ds.size() ; i++){
            if (sp.getMaSP().equals(ds.get(i).getMaSP())){
                ds.remove(i);
                return true;
            }
        }
        return true;
    }
    public ArrayList<SanPhamDTO> timkiem2 (String muctieu){
        SanPhamBUS bus = new SanPhamBUS();
        ArrayList<SanPhamDTO> dstk = new ArrayList<>();
        for (SanPhamDTO sp :  bus.getDS()){
            if(muctieu.contains(sp.getMaSP())){
                dstk.add(sp);
            }else{
                return null;
            }
        }
        return dstk;
    }
    
}

