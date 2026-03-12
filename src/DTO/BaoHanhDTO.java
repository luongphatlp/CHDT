package DTO;
import java.sql.Date;

public class BaoHanhDTO {
    private String imei;
    private String ten;
    private Date ngayBaoHanh;

    public BaoHanhDTO() {}
    public BaoHanhDTO(String imei, String ten, Date ngayBaoHanh) {
        this.imei = imei;
        this.ten = ten;
        this.ngayBaoHanh = ngayBaoHanh;
    }
    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public Date getNgayBaoHanh() { return ngayBaoHanh; }
    public void setNgayBaoHanh(Date ngayBaoHanh) { this.ngayBaoHanh = ngayBaoHanh; }
}