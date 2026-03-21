/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class PhieuNhapHangDTO {
    String mapn;
    String ngay;
    String manv;
    String mancc;
    int tongtien;
    String trangthai;
    public PhieuNhapHangDTO() {
        this.mapn = null;
        this.ngay = null;
        this.manv = null;
        this.mancc = null;
        this.tongtien = 0;
        this.trangthai = null;
    }
    public PhieuNhapHangDTO(String mapn, String ngay, String manv, String mancc, int tongtien, String trangthai) {
        this.mapn = mapn;
        this.ngay = ngay;
        this.manv = manv;
        this.mancc = mancc;
        this.tongtien = tongtien;
        this.trangthai = trangthai;
    }
    public PhieuNhapHangDTO(PhieuNhapHangDTO pnh1){
        this.mapn = pnh1.mapn;
        this.ngay = pnh1.ngay;
        this.manv = pnh1.manv;
        this.mancc = pnh1.mancc;
        this.tongtien = pnh1.tongtien;
        this.trangthai = pnh1.trangthai;
    }
    public String getMapn() {return mapn;}
    public void setMapn(String mapn){this.mapn = mapn;}
    public String getNgay() {return ngay;}
    public void setNgay(String ngay){this.ngay = ngay;}
    public String getManv(){return manv;}
    public void setManv(String manv){this.manv = manv;}
    public String getMancc(){return mancc;}
    public void setMancc(String mancc){this.mancc = mancc;}
    public int getTongtien(){return tongtien;}
    public void setTongtien(int tongtien){this.tongtien = tongtien;}

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
