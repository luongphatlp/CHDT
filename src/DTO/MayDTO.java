/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class MayDTO {
    private String masp;
    private String imei;

    // Constructor rỗng
    public MayDTO() {
    }

    // Constructor có tham số
    public MayDTO(String masp, String imei) {
        this.masp = masp;
        this.imei = imei;
    }

    // Getter
    public String getMasp() {
        return masp;
    }

    public String getImei() {
        return imei;
    }

    // Setter
    public void setMasp(String masp) {
        this.masp = masp;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
