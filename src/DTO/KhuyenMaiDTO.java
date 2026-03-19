
package DTO;
import java.time.LocalDate;
public class KhuyenMaiDTO {
    private String ma,ten,ghichu;
    LocalDate ngaybd,ngaykt;
    
    
    public KhuyenMaiDTO(){}
    
    public KhuyenMaiDTO(String ma,String ten,LocalDate ngaybd,LocalDate ngaykt,String ghichu){
        this.ma=ma;
        this.ten=ten;
        this.ngaybd=ngaybd;
        this.ngaykt=ngaykt;
        this.ghichu=ghichu;
    }
    
    public KhuyenMaiDTO(KhuyenMaiDTO km){
        this.ma=km.ma;
        this.ten=km.ten;
        this.ngaybd=km.ngaybd;
        this.ngaykt=km.ngaykt;
        this.ghichu=km.ghichu;  
    }
    
    public String getMa() {return ma;}
    public void setMa(String ma) {this.ma = ma;}

    public String getTen() {return ten;}
    public void setTen(String ten) {this.ten = ten;}

    public LocalDate getNgayBD() {return ngaybd;}
    public void setNgayBD(LocalDate ngaybd) {this.ngaybd = ngaybd;}

    public LocalDate getNgayKT() {return ngaykt;}
    public void setNgayKT(LocalDate ngaykt) {this.ngaykt = ngaykt;}

    public String getGhiChu() {return ghichu;}
    public void setGhiChu(String ghichu) {this.ghichu = ghichu;}
    
    
}
