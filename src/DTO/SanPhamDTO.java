package DTO;

public class SanPhamDTO {
    private String masp, tenSP;
    private int soluong, dongia;
    private ChiTietSanPhamDTO chiTiet;

    public SanPhamDTO() {
        this.chiTiet = new ChiTietSanPhamDTO();
    }
    
    public SanPhamDTO(String masp, String tenSP, int soluong, int dongia) {
        this.masp = masp;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.chiTiet = new ChiTietSanPhamDTO();
    }

    public String getMaSP() { return masp; }
    public void setMaSP(String masp) { this.masp = masp; this.chiTiet.setMaSP(masp); }
    
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    
    public int getSoLuong() { return soluong; }
    public void setSoLuong(int sl) { this.soluong = sl; }
    
    public int getDonGia() { return dongia; }
    public void setDonGia(int dongia) { this.dongia = dongia; }
    

    public ChiTietSanPhamDTO getChiTiet() { return chiTiet; }
    public void setChiTiet(ChiTietSanPhamDTO chiTiet) { this.chiTiet = chiTiet; }
}