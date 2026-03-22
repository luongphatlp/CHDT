/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeKhachHangDTO {
    private String ma;
    private String hoten;
    private int hoadon;
    private int tong;

    // Constructor không tham số
    public ThongKeKhachHangDTO() {
    }

    // Constructor đầy đủ
    public ThongKeKhachHangDTO(String ma, String hoten, int hoadon, int tong) {
        this.ma = ma;
        this.hoten = hoten;
        this.hoadon = hoadon;
        this.tong = tong;
    }

    // Getter và Setter
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getHoadon() {
        return hoadon;
    }

    public void setHoadon(int hoadon) {
        this.hoadon = hoadon;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

    // toString() tiện cho debug hoặc hiển thị
    @Override
    public String toString() {
        return "ThongKeKhachHangDTO{" +
                "ma='" + ma + '\'' +
                ", hoten='" + hoten + '\'' +
                ", hoadon=" + hoadon +
                ", tong=" + tong +
                '}';
    }
}