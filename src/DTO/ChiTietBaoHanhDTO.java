/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietBaoHanhDTO {

    private String MaBH;
    private String IMEI;
    private LocalDate Ngayhethan;
    private String tinhTrang , xuLy;

    // Constructor rỗng
    public ChiTietBaoHanhDTO() {
    }

    // Constructor có tham số
    public ChiTietBaoHanhDTO(String MaBH, String IMEI, LocalDate Ngay , String tinhString , String xuLy) {
        this.MaBH = MaBH;
        this.IMEI = IMEI;
        this.Ngayhethan = Ngay;
        this.tinhTrang = tinhTrang;
        this.xuLy = xuLy;
    }

    // Getter và Setter

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getXuLy() {
        return xuLy;
    }

    public void setXuLy(String xuLy) {
        this.xuLy = xuLy;
    }
    
    
    public String getMaBH() {
        return MaBH;
    }

    public void setMaBH(String MaBH) {
        this.MaBH = MaBH;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public LocalDate getNgay() {
        return Ngayhethan;
    }

    public void setNgay(LocalDate Ngay) {
        this.Ngayhethan = Ngay;
    }
}
