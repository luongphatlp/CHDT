package DTO;
public class ChiTietKhuyenMaiDTO {
    private String makm;
    private SanPhamDTO sanpham;
    private int phantram;

    
    public ChiTietKhuyenMaiDTO(){}
    public ChiTietKhuyenMaiDTO(String makm,SanPhamDTO sanpham,int phantram){
        this.makm=makm;
        this.sanpham=sanpham;
        this.phantram=phantram;
    }
    public ChiTietKhuyenMaiDTO(ChiTietKhuyenMaiDTO ctkm){
        this.makm=ctkm.makm;
        this.sanpham=ctkm.sanpham;
        this.phantram=ctkm.phantram;
    }
    public SanPhamDTO getSanPham(){return sanpham;}
    public void setSanPham(SanPhamDTO sanpham){this.sanpham=sanpham;}
    
    public String getMaKM(){return makm;}
    public void setMaKM(String makm){this.makm=makm;}
    
    public int getPhanTram(){return phantram;}
    public void setPhanTram(int phantram){this.phantram=phantram;}
    

}
