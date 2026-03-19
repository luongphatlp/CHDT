/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeNhanVienDTO {
    private String manv;
    private String hoten;
    private int sohoadon;
    private int doanhthu;

    // Constructor rỗng
    public ThongKeNhanVienDTO() {}

    // Constructor đầy đủ
    public ThongKeNhanVienDTO(String manv, String hoten, int sohoadon, int doanhthu) {
        this.manv = manv;
        this.hoten = hoten;
        this.sohoadon = sohoadon;
        this.doanhthu = doanhthu;
    }

    // Getter
    public String getMaNV() {
        return manv;
    }

    public String getHoTen() {
        return hoten;
    }

    public int getSoHoaDon() {
        return sohoadon;
    }

    public int getDoanhThu() {
        return doanhthu;
    }

    // Setter
    public void setMaNV(String manv) {
        this.manv = manv;
    }

    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }

    public void setSoHoaDon(int sohoadon) {
        this.sohoadon = sohoadon;
    }

    public void setDoanhThu(int doanhthu) {
        this.doanhthu = doanhthu;
    }

    // toString (debug cho dễ)
    @Override
    public String toString() {
        return "ThongKeNhanVienDTO{" +
                "manv='" + manv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", sohoadon=" + sohoadon +
                ", doanhthu=" + doanhthu +
                '}';
    }
}
