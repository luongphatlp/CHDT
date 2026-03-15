package DTO;

public class SanPhamDTO {
    private String masp, tenSP, donvitinh, mahang;
    private int soluong, dongia;
    private String mau, manHinh, kichThuoc, chip, ram, heDieuHanh;
    private int boNhoNgoai, camTruoc, camSau, pin, baoHanh;

    public SanPhamDTO() {}
    public SanPhamDTO(String masp, String tenSP, int soluong, int dongia, String donvitinh, String mahang) {
        this.masp = masp;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.donvitinh = donvitinh;
        this.mahang = mahang;
    }
    public String getMaSP() { return masp; }
    public void setMaSP(String masp) { this.masp = masp; }
    public String getTenSP() { return tenSP; }
    public void setTenSP(String tenSP) { this.tenSP = tenSP; }
    public int getSoLuong() { return soluong; }
    public void setSoLuong(int sl) { this.soluong = sl; }
    public int getDonGia() { return dongia; }
    public void setDonGia(int dongia) { this.dongia = dongia; }
    public String getDonViTinh() { return donvitinh; }
    public void setDonViTinh(String donvitinh) { this.donvitinh = donvitinh; }
    public String getMaHang() { return mahang; }
    public void setMaHang(String mahang) { this.mahang = mahang; }

    public String getMau() { return mau; }
    public void setMau(String mau) { this.mau = mau; }
    public String getManHinh() { return manHinh; }
    public void setManHinh(String manHinh) { this.manHinh = manHinh; }
    public String getKichThuoc() { return kichThuoc; }
    public void setKichThuoc(String kichThuoc) { this.kichThuoc = kichThuoc; }
    public String getChip() { return chip; }
    public void setChip(String chip) { this.chip = chip; }
    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }
    public int getBoNhoNgoai() { return boNhoNgoai; }
    public void setBoNhoNgoai(int boNhoNgoai) { this.boNhoNgoai = boNhoNgoai; }
    public int getCamTruoc() { return camTruoc; }
    public void setCamTruoc(int camTruoc) { this.camTruoc = camTruoc; }
    public int getCamSau() { return camSau; }
    public void setCamSau(int camSau) { this.camSau = camSau; }
    public int getPin() { return pin; }
    public void setPin(int pin) { this.pin = pin; }
    public String getHeDieuHanh() { return heDieuHanh; }
    public void setHeDieuHanh(String heDieuHanh) { this.heDieuHanh = heDieuHanh; }
    public int getBaoHanh() { return baoHanh; }
    public void setBaoHanh(int baoHanh) { this.baoHanh = baoHanh; }
}