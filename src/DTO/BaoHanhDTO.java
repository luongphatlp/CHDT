package DTO;
import java.time.LocalDate;

public class BaoHanhDTO {

    private String mabh;
    private String manv;
    private String makh;
    private LocalDate ngaylap;

    // Constructor rỗng
    public BaoHanhDTO() {
    }

    // Constructor có tham số
    public BaoHanhDTO(String mabh, String manv, String makh, LocalDate ngaylap) {
        this.mabh = mabh;
        this.manv = manv;
        this.makh = makh;
        this.ngaylap = ngaylap;
    }

    // Getter và Setter

    public String getMaBH() {
        return mabh;
    }

    public void setMaBH(String mabh) {
        this.mabh = mabh;
    }

    public String getMaNV() {
        return manv;
    }

    public void setMaNV(String manv) {
        this.manv = manv;
    }

    public String getMaKH() {
        return makh;
    }

    public void setMaKH(String makh) {
        this.makh = makh;
    }

    public LocalDate getNgayLap() {
        return ngaylap;
    }

    public void setNgayLap(LocalDate ngaylap) {
        this.ngaylap = ngaylap;
    }
}