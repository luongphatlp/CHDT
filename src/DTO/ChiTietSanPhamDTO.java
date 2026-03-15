package DTO;

public class ChiTietSanPhamDTO {
    private String masp, mau, manHinh, kichThuoc, chip, ram, heDieuHanh;
    private int boNhoNgoai, camTruoc, camSau, pin, baoHanh;

    public ChiTietSanPhamDTO() {}
    public String getMaSP() { return masp; }
    public void setMaSP(String masp) { this.masp = masp; }
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