/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class ThongKeNhapHangDTO {
    private String tenSP;
    private double quy1, quy2, quy3, quy4;
    
    public ThongKeNhapHangDTO() {}
    
    public ThongKeNhapHangDTO(String tenSP, double quy1, double quy2, double quy3, double quy4) {
        this.tenSP = tenSP;
        this.quy1 = quy1;
        this.quy2 = quy2;
        this.quy3 = quy3;
        this.quy4 = quy4;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getQuy1() {
        return quy1;
    }

    public void setQuy1(double quy1) {
        this.quy1 = quy1;
    }

    public double getQuy2() {
        return quy2;
    }

    public void setQuy2(double quy2) {
        this.quy2 = quy2;
    }

    public double getQuy3() {
        return quy3;
    }

    public void setQuy3(double quy3) {
        this.quy3 = quy3;
    }

    public double getQuy4() {
        return quy4;
    }

    public void setQuy4(double quy4) {
        this.quy4 = quy4;
    }
    
}
