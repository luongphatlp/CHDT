/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class KhachHangDTO {

    private String ma;
    private String hoten;
    private String dt;
    private String email;

    // Constructor rỗng
    public KhachHangDTO() {
    }

    // Constructor có tham số
    public KhachHangDTO(String ma, String hoten, String dt, String email) {
        this.ma = ma;
        this.hoten = hoten;
        this.dt = dt;
        this.email = email;
    }

    // Getter và Setter

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
