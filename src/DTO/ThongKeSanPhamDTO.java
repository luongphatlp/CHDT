/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamDTO {
    private String masp;
    private String ten;
    private int tongnhap;
    private int tongban;
    private int tonkho;

    // Constructor rỗng
    public ThongKeSanPhamDTO() {
    }

    // Constructor đầy đủ tham số
    public ThongKeSanPhamDTO(String masp, String ten, int tongnhap, int tongban, int tonkho) {
        this.masp = masp;
        this.ten = ten;
        this.tongnhap = tongnhap;
        this.tongban = tongban;
        this.tonkho = tonkho;
    }

    // Getter và Setter
    public String getMaSP() {
        return masp;
    }

    public void setMaSP(String masp) {
        this.masp = masp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTongNhap() {
        return tongnhap;
    }

    public void setTongNhap(int tongnhap) {
        this.tongnhap = tongnhap;
    }

    public int getTongBan() {
        return tongban;
    }

    public void setTongBan(int tongban) {
        this.tongban = tongban;
    }

    public int getTonKho() {
        return tonkho;
    }

    public void setTonKho(int tonkho) {
        this.tonkho = tonkho;
    }
}
