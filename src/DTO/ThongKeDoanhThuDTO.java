/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeDoanhThuDTO {
    private String ngay;
    private int hoadon;
    private int doanhthu;
    
    public void setNgay(String ngay){this.ngay=ngay;}
    public void setHoaDon(int hoadon){this.hoadon=hoadon;}
    public void setDoanhThu(int doanhthu){this.doanhthu=doanhthu;}
    
    public String getNgay(){return ngay;}
    public int getHoaDon(){return hoadon;}
    public int getDoanhThu(){return doanhthu;}
}
