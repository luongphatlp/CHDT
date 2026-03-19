package BUS;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

public class NhaCungCapBUS {
    private ArrayList<NhaCungCapDTO> ds;
    private NhaCungCapDAO dao = new NhaCungCapDAO();

    public NhaCungCapBUS() {
        docDS();
    }

    public void docDS() {
        ds = dao.selectAll();
        if (ds == null) ds = new ArrayList<>();
    }

    public ArrayList<NhaCungCapDTO> getDS() {
        return ds;
    }

    public boolean checkMaNCC(String ma) {
        for (NhaCungCapDTO ncc : ds) {
            if (ncc.getMaNCC().equalsIgnoreCase(ma)) return true;
        }
        return false;
    }

    public boolean them(NhaCungCapDTO ncc) {
        if (checkMaNCC(ncc.getMaNCC())) return false;
        if (dao.insert(ncc) > 0) {
            ds.add(ncc);
            return true;
        }
        return false;
    }

    public boolean sua(NhaCungCapDTO ncc) {
        if (dao.update(ncc) > 0) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaNCC().equals(ncc.getMaNCC())) {
                    ds.set(i, ncc);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean xoa(String ma) {
        if (dao.delete(ma) > 0) {
            return ds.removeIf(ncc -> ncc.getMaNCC().equals(ma));
        }
        return false;
    }

 
// Sửa tham số thứ 2 từ String sang int
public ArrayList<NhaCungCapDTO> timKiem(String text, int index) {
    ArrayList<NhaCungCapDTO> ketQua = new ArrayList<>();
    String search = text.toLowerCase().trim();

    for (NhaCungCapDTO ncc : ds) {
        boolean match = false;
        switch (index) {
            case 0: 
                match = ncc.getMaNCC().toLowerCase().contains(search) || 
                        ncc.getTenNCC().toLowerCase().contains(search) ||
                        ncc.getSoDienThoai().contains(search) ||
                        ncc.getDiaChi().toLowerCase().contains(search);
                break;
            case 1: 
                match = ncc.getMaNCC().toLowerCase().contains(search);
                break;
            case 2: 
                match = ncc.getTenNCC().toLowerCase().contains(search);
                break;
            case 3: 
                match = ncc.getDiaChi().toLowerCase().contains(search);
                break;
            case 4: 
                match = ncc.getSoDienThoai().contains(search);
                break;
        }
        if (match) ketQua.add(ncc);
    }
    return ketQua;
}
    
    public void xuatExcel(File file) throws IOException {
       Workbook workbook = new XSSFWorkbook();
       Sheet sheet = workbook.createSheet("Nhà Cung Cấp");
       Row headerRow = sheet.createRow(0);
       String[] columns = {"Mã NCC", "Tên NCC", "Địa chỉ", "Số điện thoại"};
       for (int i = 0; i < columns.length; i++) {
           headerRow.createCell(i).setCellValue(columns[i]);
       }
       int rowNum = 1;
       for (NhaCungCapDTO ncc : ds) {
          Row row = sheet.createRow(rowNum++);
          row.createCell(0).setCellValue(ncc.getMaNCC());
          row.createCell(1).setCellValue(ncc.getTenNCC());
          row.createCell(2).setCellValue(ncc.getDiaChi());
          row.createCell(3).setCellValue(ncc.getSoDienThoai());
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

                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(row.getCell(0).getStringCellValue());
                ncc.setTenNCC(row.getCell(1).getStringCellValue());
                ncc.setDiaChi(row.getCell(2).getStringCellValue());
                Cell sdtCell = row.getCell(3);
                if (sdtCell.getCellType() == CellType.NUMERIC) {
                    ncc.setSoDienThoai(String.valueOf((long)sdtCell.getNumericCellValue()));
                } else {
                   ncc.setSoDienThoai(sdtCell.getStringCellValue());
                }

               if (them(ncc)) { 
                   count++;
                }
            }
        } 
         return count;
    } 
}