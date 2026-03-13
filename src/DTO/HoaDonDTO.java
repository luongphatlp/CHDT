/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonDTO {
    private String MaHD;
    private Date Ngay;
    private String MaNV;
    private String MaKH;
    private int TongTien;
    private String PTTT;

    public HoaDonDTO(String MaHD, Date Ngay, String MaNV,String MaKH, int TongTien, String PTTT) {
        this.MaHD = MaHD;
        this.Ngay = Ngay;
        this.MaNV = MaNV;
        this.MaKH=MaKH;
        this.TongTien = TongTien;
        this.PTTT = PTTT;
    }

    public HoaDonDTO() {
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date Ngay) {
        this.Ngay = Ngay;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public String getPTTT() {
        return PTTT;
    }

    public void setPTTT(String PTTT) {
        this.PTTT = PTTT;
    }
    
    public String    getMaKH(){return MaKH;} 
    public void setMaKH(String makh){this.MaKH=makh;}
}
