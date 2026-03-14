package BUS;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {
    private ArrayList<SanPhamDTO> ds;
    private SanPhamDAO dao = new SanPhamDAO();

    public SanPhamBUS() {
        docDS();
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
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaSP().equals(sp.getMaSP())) {
                    ds.set(i, sp);
                    return true;
                }
            }
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

    public ArrayList<SanPhamDTO> timKiem(String text, int giaTu, int giaDen) {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<>();
        String searchLower = text.toLowerCase().trim();
        
        for (SanPhamDTO sp : ds) {
            boolean matchesText = sp.getTenSP().toLowerCase().contains(searchLower) 
                               || sp.getMaSP().toLowerCase().contains(searchLower);
            boolean matchesPrice = (giaTu <= 0 || sp.getDonGia() >= giaTu) 
                                && (giaDen <= 0 || sp.getDonGia() <= giaDen);          
            if (matchesText && matchesPrice) {
                ketQua.add(sp);
            }
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
        row.createCell(4).setCellValue(sp.getDonViTinh());
        row.createCell(5).setCellValue(sp.getMaHang());
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
                sp.setDonViTinh(row.getCell(4).getStringCellValue());
                sp.setMaHang(row.getCell(5).getStringCellValue());
                
                if (them(sp)) {
                count++;
                }
            }
        }
        return count;
    }
}