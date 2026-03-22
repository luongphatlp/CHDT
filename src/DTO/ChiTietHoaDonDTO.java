/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietHoaDonDTO {
    private String maHD;
    private String maSP;
    private String tensp;
    private int soLuong;
    private int donGia;
    private int thanhTien;

    // Constructor rỗng
    public ChiTietHoaDonDTO() {
    }

    // Constructor đầy đủ
    public ChiTietHoaDonDTO(String maHD, String maSP,String tensp, int soLuong, int donGia, int thanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tensp = tensp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    // Getter & Setter
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }
    
    public String getTenSP(){
        return tensp;
    }

    public void setTenSP(String tensp){
        this.tensp=tensp;
    }
    
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    // Tự động tính thành tiền (gợi ý nên dùng)
    public void tinhThanhTien() {
        this.thanhTien = this.soLuong * this.donGia;
    }

    // toString (debug)
    @Override
    public String toString() {
        return "ChiTietHoaDonDTO{" +
                "maHD='" + maHD + '\'' +
                ", maSP='" + maSP + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                '}';
    }
}