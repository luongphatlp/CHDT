/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class SanPhamDTO {
    private String masp,ten,dongia,donvitinh,mahang;
    private int soluong;
    public SanPhamDTO(){}
    public SanPhamDTO(String masp,String ten,int soluong,String dongia,String donvitinh,String mahang){
        this.masp=masp;
        this.ten=ten;
        this.soluong=soluong;
        this.dongia=dongia;
        this.donvitinh=donvitinh;
        this.mahang=mahang;
    }
    public SanPhamDTO(SanPhamDTO sp){
        this.masp=sp.masp;
        this.ten=sp.ten;
        this.soluong=sp.soluong;
        this.dongia=sp.dongia;
        this.donvitinh=sp.donvitinh;
        this.mahang=sp.mahang;
    }
    public String getMaSP(){return masp;}
    public void setMaSP(String masp){this.masp=masp;}
    
    public String getTen(){return ten;}
    public void setTen(String ten){this.ten=ten;}
    
    public int getSoLuong(){return soluong;}
    public void setSoLuong(int sl){this.soluong=sl;}
    
    public String getDonGia(){return dongia;}
    public void setDonGia(String dongia){this.dongia=dongia;}
    
    public String getDonViTinh(){return donvitinh;}
    public void setDonViTinh(String donvitinh){this.donvitinh=donvitinh;}
    
    public String getMaHang(){return mahang;}
    public void setMaHang(String mahang){this.mahang=mahang;}
}
