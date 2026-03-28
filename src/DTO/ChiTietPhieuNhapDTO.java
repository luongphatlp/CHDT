/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapDTO {
    private String mapn, masp; 
    private int sl,dongia, tongtien;
    
    public ChiTietPhieuNhapDTO(){}
    public ChiTietPhieuNhapDTO(String mapn, String masp, int sl,int dongia ,int tongtien){
        this.mapn = mapn;
        this.masp = masp;
        this.sl = sl;
        this.dongia=dongia;
        this.tongtien = tongtien;
    }
    public ChiTietPhieuNhapDTO(ChiTietPhieuNhapDTO ctpn){
        this.mapn = ctpn.mapn;
        this.masp = ctpn.masp;
        this.sl = ctpn.sl;
        this.dongia=ctpn.dongia;
        this.tongtien = ctpn.tongtien;
    }
    public String getMapn() {return mapn;}
    public void setMapn(String mapn){this.mapn = mapn;}
    
    public String getMasp(){return masp;}
    public void setMasp(String masp){this.masp = masp;}
    
    public int getSl(){return sl;}
    public void setSl(int sl){this.sl = sl;}
    
    public int getTongtien(){return tongtien;}
    public void setTongtien(int tongtien){this.tongtien = tongtien;}
    
    public int getDonGia(){return dongia;}
    public void setDonGia(int dongia){this.dongia=dongia;}
    
}
