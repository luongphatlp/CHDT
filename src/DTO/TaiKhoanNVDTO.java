/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
public class TaiKhoanNVDTO {
    private String maNV;
    private String taiKhoan , matKhau;

    public TaiKhoanNVDTO(String maNV, String taiKhoan, String matKhau) {
        this.maNV = maNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }


    public TaiKhoanNVDTO(){}

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    private int docVaLuuTaiKhoan(java.io.File fileOpen) throws Exception {
    int count = 0;
    java.io.FileInputStream fis = new java.io.FileInputStream(fileOpen);
    org.apache.poi.xssf.usermodel.XSSFWorkbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook(fis);
    org.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(0); 

    // Gọi đến lớp DAO hoặc BUS quản lý Tài Khoản của em
    DAO.TaiKhoanNVDAO tkDAO = new DAO.TaiKhoanNVDAO(); 

    // Bắt đầu đọc từ dòng số 1 (bỏ qua dòng tiêu đề STT, Mã, Tài Khoản, Mật Khẩu)
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        org.apache.poi.xssf.usermodel.XSSFRow row = sheet.getRow(i);
        if (row != null) {
            DTO.TaiKhoanNVDTO tk = new DTO.TaiKhoanNVDTO();
            
            // Cột 1: Lấy Mã 
            if (row.getCell(1) != null) tk.setMaNV(row.getCell(1).getStringCellValue());
            
            // Cột 2: Lấy Tên tài khoản
            if (row.getCell(2) != null) tk.setTaiKhoan(row.getCell(2).getStringCellValue());
            
            // Cột 3: Lấy Mật khẩu
            if (row.getCell(3) != null) {
                // Xử lý đề phòng trường hợp Excel tự hiểu mật khẩu toàn số (vd: 123456) là kiểu Numeric
                if (row.getCell(3).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
                    tk.setMatKhau(String.valueOf((long) row.getCell(3).getNumericCellValue()));
                } else {
                    tk.setMatKhau(row.getCell(3).getStringCellValue());
                }
            }

            // Gọi lệnh lưu vào Database (Lưu ý: trong tkDAO nên dùng INSERT IGNORE)
            if (tkDAO.themTuExcel(tk) > 0) {
                count++;
            }
        }
    }
    workbook.close();
    fis.close();
    return count;
}
}
