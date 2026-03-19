/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author THANH NHAN
 */

public class DienThoaiDTO {
    private String Ma;
    private String Ten;
    private int SoLuong;
    private int DonGia;

    public DienThoaiDTO() {}

    public DienThoaiDTO(String Ma, String Ten, int SoLuong, int DonGia) {
        this.Ma = Ma;
        this.Ten = Ten;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
}
