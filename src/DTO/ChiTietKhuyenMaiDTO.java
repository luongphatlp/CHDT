/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietKhuyenMaiDTO {
    private String makm,masp;
    private int phantram;
    
    public ChiTietKhuyenMaiDTO(){}
    public ChiTietKhuyenMaiDTO(String makm,String masp,int phantram){
        this.makm=makm;
        this.masp=masp;
        this.phantram=phantram;
    }
    public ChiTietKhuyenMaiDTO(ChiTietKhuyenMaiDTO ctkm){
        this.makm=ctkm.makm;
        this.masp=ctkm.masp;
        this.phantram=ctkm.phantram;
    }
    public String getMaSP(){return masp;}
    public void setMaSP(String masp){this.masp=masp;}
    
    public String getMaKM(){return makm;}
    public void setMaKM(String makm){this.makm=makm;}
    
    public int getPhanTram(){return phantram;}
    public void setPhanTram(int phantram){this.phantram=phantram;}
}
