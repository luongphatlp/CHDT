
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class KhachHangBUS {

    private KhachHangDAO khDAO = new KhachHangDAO();
    private ArrayList<KhachHangDTO> listKH;
    public KhachHangBUS() {
        listKH = khDAO.selectAll();
    }

    public ArrayList<KhachHangDTO> getDSKH() {
        if (listKH == null) {
            listKH = khDAO.selectAll();
        }
        return listKH;
    }
    public ArrayList<KhachHangDTO> docDSKH(){
        KhachHangDAO data = new KhachHangDAO();
       
        listKH = data.selectAll();      
        return listKH;
    }

    // Thêm khách hàng
    public boolean insert(KhachHangDTO kh) {
        boolean check = khDAO.insert(kh);
        if (check) {
            if (listKH != null) {
               listKH.add(kh);
            }
        }
        return check;
    }

    // Sửa khách hàng
    public boolean update(KhachHangDTO kh) {
        boolean check = khDAO.update(kh);
        if (check) {
             for (int i = 0; i < listKH.size(); i++) {
                 if (listKH.get(i).getMa().equals(kh.getMa())) {
                    listKH.set(i, kh);
                   break;
               }
             } 
         }
         return check;
    }

    // Xóa khách hàng
    public boolean delete(String ma) {
        boolean check = khDAO.delete(ma);

        if (check) {
            listKH.removeIf(k -> k.getMa().equals(ma));
        }

        return check;
    }
    public String taoMaKH(){
        String max = khDAO.layMaKHMax();

        if(max == null){
            return "KH001";
        }

        int index = Integer.parseInt(max.substring(2));
        return String.format("KH%03d", index + 1);
    }
    public void xuatExcel(File file) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Danh Sách Khách Hàng");

            Row headerRow = sheet.createRow(0);
            String[] columns = {"Mã Khách", "Tên Khách", "SĐT", "Email"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

             int rowNum = 1;
            for (KhachHangDTO kh : getDSKH()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(kh.getMa());
                row.createCell(1).setCellValue(kh.getHoten());
                row.createCell(2).setCellValue(kh.getDt());
                row.createCell(3).setCellValue(kh.getEmail());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fileOut = new FileOutputStream(file)) {
                workbook.write(fileOut);
            }
        }
    }

    public int nhapExcel(File file) throws Exception {
         int count = 0;
         try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {
        
             Sheet sheet = workbook.getSheetAt(0);
             for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                  Row row = sheet.getRow(i);
                  if (row == null) continue;

                  String ten = row.getCell(1).getStringCellValue();
                  String sdt = "";
                  if (row.getCell(2).getCellType() == CellType.NUMERIC) {
                      sdt = "0" + (long)row.getCell(2).getNumericCellValue();
                  } else {
                      sdt = row.getCell(2).getStringCellValue();
                  }
                  String email = row.getCell(3).getStringCellValue();

                  String maMoi = taoMaKH();
                  KhachHangDTO kh = new KhachHangDTO(maMoi, ten, sdt, email);
                  if (insert(kh)) {
                      count++;
                   }
              }
        }
         return count;
    }
}
