/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
import java.time.LocalDate;

public class LanBaoHanhDTO {
    private int maLanBH;
    private String IMEI;
    private LocalDate ngayNhan;
    private LocalDate ngayTra;
    private String tinhTrang;
    private String xuLy;
    private String trangThai;

    // Constructor rỗng
    public LanBaoHanhDTO() {}

    // Constructor đầy đủ
    public LanBaoHanhDTO(int maLanBH, String maCTBH, LocalDate ngayNhan,
                         LocalDate ngayTra, String tinhTrang,
                         String xuLy, String trangThai) {
        this.maLanBH = maLanBH;
        this.IMEI = maCTBH;
        this.ngayNhan = ngayNhan;
        this.ngayTra = ngayTra;
        this.tinhTrang = tinhTrang;
        this.xuLy = xuLy;
        this.trangThai = trangThai;
    }

    // Getter & Setter
    public int getMaLanBH() { return maLanBH; }
    public void setMaLanBH(int maLanBH) { this.maLanBH = maLanBH; }

    public String getIMEI() { return IMEI; }
    public void setIMEI(String maCTBH) { this.IMEI = maCTBH; }

    public LocalDate getNgayNhan() { return ngayNhan; }
    public void setNgayNhan(LocalDate ngayNhan) { this.ngayNhan = ngayNhan; }

    public LocalDate getNgayTra() { return ngayTra; }
    public void setNgayTra(LocalDate ngayTra) { this.ngayTra = ngayTra; }

    public String getTinhTrang() { return tinhTrang; }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang = tinhTrang; }

    public String getXuLy() { return xuLy; }
    public void setXuLy(String xuLy) { this.xuLy = xuLy; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }
}