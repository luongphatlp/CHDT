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
    private String hoTenNV, emailNV;
    private String gioiTinhNV;
    private java.sql.Date ngaySinhNV;
    private String chucVuNV;
    
    private boolean tinhTrangNV;
    private String luongNV;

    
    public NhanVienDTO(){}

    public NhanVienDTO(String maNV, String hoTenNV, String emailNV, String gioiTinhNV, Date ngaySinhNV, String chucVuNV, boolean tinhTrangNV, String luongNV) {
        this.maNV = maNV;
        this.hoTenNV = hoTenNV;
        this.emailNV = emailNV;
        this.gioiTinhNV = gioiTinhNV;
        this.ngaySinhNV = ngaySinhNV;
        this.chucVuNV = chucVuNV;
        this.tinhTrangNV = tinhTrangNV;
        this.luongNV = luongNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public String getEmailNV() {
        return emailNV;
    }

    public void setEmailNV(String emailNV) {
        this.emailNV = emailNV;
    }

    public String getGioiTinhNV() {
        return gioiTinhNV;
    }

    public void setGioiTinhNV(String gioiTinhNV) {
        this.gioiTinhNV = gioiTinhNV;
    }

    public Date getNgaySinhNV() {
        return ngaySinhNV;
    }

    public void setNgaySinhNV(Date ngaySinhNV) {
        this.ngaySinhNV = ngaySinhNV;
    }

    public String getChucVuNV() {
        return chucVuNV;
    }

    public void setChucVuNV(String chucVuNV) {
        this.chucVuNV = chucVuNV;
    }

    public boolean isTinhTrangNV() {
        return tinhTrangNV;
    }

    public void setTinhTrangNV(boolean tinhTrangNV) {
        this.tinhTrangNV = tinhTrangNV;
    }

    public String getLuongNV() {
        return luongNV;
    }

    public void setLuongNV(String luongNV) {
        this.luongNV = luongNV;
    }

    

}
