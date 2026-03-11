/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author admin
 */
public class NhanVienDTO {
    private String maNV;
    private String hotenNV, emailNV;
    private java.sql.Date ngaySinh;
    private String chucVu;
    private String taiKhoan, matKhau;
    private boolean tinhTrang;

    
    public NhanVienDTO(){}

    public NhanVienDTO(String maNV, String hotenNV, String emailNV, Date ngaySinh, String chucVu, String taiKhoan, String matKhau, boolean tinhTrang) {
        this.maNV = maNV;
        this.hotenNV = hotenNV;
        this.emailNV = emailNV;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.tinhTrang = tinhTrang;
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

   
    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }



    public String getHotenNV() {
        return hotenNV;
    }


    public void setHotenNV(String hotenNV) {
        this.hotenNV = hotenNV;
    }


    public String getEmailNV() {
        return emailNV;
    }


    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }


    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public java.sql.Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(java.sql.Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
}
