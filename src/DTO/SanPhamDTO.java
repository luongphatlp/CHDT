package DTO;

public class SanPhamDTO {
    private String masp, tenSP, donvitinh, mahang;
    private int soluong, dongia;

    public SanPhamDTO(){}
    public SanPhamDTO(String masp, String tenSP, int soluong, int dongia, String donvitinh, String mahang){
        this.masp = masp;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.donvitinh = donvitinh;
        this.mahang = mahang;
    }
    public SanPhamDTO(SanPhamDTO sp){
        this.masp = sp.masp;
        this.tenSP = sp.tenSP;
        this.soluong = sp.soluong;
        this.dongia = sp.dongia;
        this.donvitinh = sp.donvitinh;
        this.mahang = sp.mahang;
    }
    public String getMaSP(){ return masp; }
    public void setMaSP(String masp){ this.masp = masp; }
    public String getTenSP(){ return tenSP; } 
    public void setTenSP(String tenSP){ this.tenSP = tenSP; }
    public int getSoLuong(){ return soluong; }
    public void setSoLuong(int sl){ this.soluong = sl; }
    public int getDonGia(){ return dongia; }
    public void setDonGia(int dongia){ this.dongia = dongia; }  
    public String getDonViTinh(){ return donvitinh; }
    public void setDonViTinh(String donvitinh){ this.donvitinh = donvitinh; }  
    public String getMaHang(){ return mahang; }
    public void setMaHang(String mahang){ this.mahang = mahang; }
}