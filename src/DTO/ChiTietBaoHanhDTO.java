/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietBaoHanhDTO {

    private String MaBH;
    private String IMEI;
    private Date Ngayhethan;

    // Constructor rỗng
    public ChiTietBaoHanhDTO() {
    }

    // Constructor có tham số
    public ChiTietBaoHanhDTO(String MaBH, String IMEI, Date Ngay) {
        this.MaBH = MaBH;
        this.IMEI = IMEI;
        this.Ngayhethan = Ngay;
    }

    // Getter và Setter

    public String getMaBH() {
        return MaBH;
    }

    public void setMaBH(String MaBH) {
        this.MaBH = MaBH;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public Date getNgay() {
        return Ngayhethan;
    }

    public void setNgay(Date Ngay) {
        this.Ngayhethan = Ngay;
    }
}
