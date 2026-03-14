/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class NhapHangDTO {
    String mamay;
    String tenmay;
    int dongia;
    String masp;
    String tensp;
    int soluong;
    int gia;
    public NhapHangDTO() {
        this.mamay = null;
        this.tenmay = null;
        this.dongia = 0;
        this.masp = null;
        this.tensp = null;
        this.soluong = 0;
        this.gia = 0;
    }
    public NhapHangDTO(String mamay, String tenmay, int dongia, String masp, String tensp, int soluong, int gia) {
        this.mamay = mamay;
        this.tenmay = tenmay;
        this.dongia = dongia;
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
    }
    public NhapHangDTO(NhapHangDTO nh1){
        this.mamay = nh1.mamay;
        this.tenmay = nh1.tenmay;
        this.dongia = nh1.dongia;
        this.masp = nh1.masp;
        this.tensp = nh1.tensp;
        this.soluong = nh1.soluong;
        this.gia = nh1.gia;
    }
    public String getMamay() {return mamay;}
    public void setMamay(String mamay){this.mamay = mamay;}
    public String getTenmay() {return tenmay;}
    public void setTenmay(String tenmay){this.tenmay = tenmay;}
    public int getDongia(){return dongia;}
    public void setDongia(int dongia){this.dongia = dongia;}
    public String getMasp(){return masp;}
    public void setMasp(String masp){this.masp = masp;}
    public String getTensp(){return tensp;}
    public void setTensp(String tensp){this.tensp = tensp;}
    public int getSoluong(){return soluong;}
    public void setSoluong(int soluong){this.soluong = soluong;}
    public int getGia(){return gia;}
    public void setGia(int gia){this.gia = gia;}
}
