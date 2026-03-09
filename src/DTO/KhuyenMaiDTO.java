<<<<<<< HEAD
package DTO;
import java.util.ArrayList;
public class KhuyenMaiDTO {
    private String ma,ten,ngaybd,ngaykt,ghichu;
    private boolean tinhtrang;
    
    
    public KhuyenMaiDTO(){}
    
    public KhuyenMaiDTO(String ma,String ten,String ngaybd,String ngaykt,String ghichu,Boolean tinhtrang){
        this.ma=ma;
        this.ten=ten;
        this.ngaybd=ngaybd;
        this.ngaykt=ngaykt;
        this.ghichu=ghichu;
        this.tinhtrang=tinhtrang;
    }
    
    public KhuyenMaiDTO(KhuyenMaiDTO km){
        this.ma=km.ma;
        this.ten=km.ten;
        this.ngaybd=km.ngaybd;
        this.ngaykt=km.ngaykt;
        this.ghichu=km.ghichu;  
        this.tinhtrang=km.tinhtrang;
    }
    
    public String getMa() {return ma;}
    public void setMa(String ma) {this.ma = ma;}

    public String getTen() {return ten;}
    public void setTen(String ten) {this.ten = ten;}

    public String getNgayBD() {return ngaybd;}
    public void setNgayBD(String ngaybd) {this.ngaybd = ngaybd;}

    public String getNgayKT() {return ngaykt;}
    public void setNgayKT(String ngaykt) {this.ngaykt = ngaykt;}

    public String getGhiChu() {return ghichu;}
    public void setGhiChu(String ghichu) {this.ghichu = ghichu;}
    
    public boolean getTinhTrang(){return tinhtrang;}
    public void setTinhTrang(boolean tinhtrang){this.tinhtrang=tinhtrang;}
    
}
=======
package DTO;
import java.util.ArrayList;
public class KhuyenMaiDTO {
    private String ma,ten,ngaybd,ngaykt,ghichu;
    private boolean tinhtrang;
    
    
    public KhuyenMaiDTO(){}
    
    public KhuyenMaiDTO(String ma,String ten,String ngaybd,String ngaykt,String ghichu,Boolean tinhtrang){
        this.ma=ma;
        this.ten=ten;
        this.ngaybd=ngaybd;
        this.ngaykt=ngaykt;
        this.ghichu=ghichu;
        this.tinhtrang=tinhtrang;
    }
    
    public KhuyenMaiDTO(KhuyenMaiDTO km){
        this.ma=km.ma;
        this.ten=km.ten;
        this.ngaybd=km.ngaybd;
        this.ngaykt=km.ngaykt;
        this.ghichu=km.ghichu;  
        this.tinhtrang=km.tinhtrang;
    }
    
    public String getMa() {return ma;}
    public void setMa(String ma) {this.ma = ma;}

    public String getTen() {return ten;}
    public void setTen(String ten) {this.ten = ten;}

    public String getNgayBD() {return ngaybd;}
    public void setNgayBD(String ngaybd) {this.ngaybd = ngaybd;}

    public String getNgayKT() {return ngaykt;}
    public void setNgayKT(String ngaykt) {this.ngaykt = ngaykt;}

    public String getGhiChu() {return ghichu;}
    public void setGhiChu(String ghichu) {this.ghichu = ghichu;}
    
    public boolean getTinhTrang(){return tinhtrang;}
    public void setTinhTrang(boolean tinhtrang){this.tinhtrang=tinhtrang;}
    
}
>>>>>>> origin/main
