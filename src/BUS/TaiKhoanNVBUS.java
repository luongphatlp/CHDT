/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TaiKhoanNVDAO;
import DTO.TaiKhoanNVDTO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TaiKhoanNVBUS {
    ArrayList<TaiKhoanNVDTO> ds;
    public boolean them(TaiKhoanNVDTO tk) {
    // 1. Gọi DAO để lưu xuống Cơ sở dữ liệu trước
    TaiKhoanNVDAO tkDAO = new TaiKhoanNVDAO();
    int check = tkDAO.Insert(tk); 
    
    // 2. Nếu lưu xuống SQL thành công thì mới cập nhật lại mảng ArrayList trên RAM
    if (check > 0) {
        
        // BƯỚC QUAN TRỌNG NHẤT ĐỂ FIX LỖI: Kiểm tra xem mảng đã được tạo chưa
        if (this.ds == null) { 
            this.ds = new ArrayList<>(); // Nếu mảng chưa có, tạo mới cái "hộp"
            // Hoặc bạn có thể gọi: this.docDSTK(); để load lại toàn bộ từ SQL lên
        }
        
        // Bây giờ mảng chắc chắn không bị null nữa, thoải mái add
        this.ds.add(tk);
        return true;
    }
    return false;
}
    public boolean sua(TaiKhoanNVDTO dto){
        TaiKhoanNVDAO dao = new TaiKhoanNVDAO();
        dao.Update(dto);
        for(int i = 0 ; i < ds.size(); i++){
            if (dto.getMaNV().equals(ds.get(i).getMaNV())){
                ds.set(i,dto);
                return true;
            }
        }
        return false;
    }

   
     public ArrayList<TaiKhoanNVDTO> getDSTK(){
        return ds;
    }
     public void docDSTK(){
        TaiKhoanNVDAO data = new TaiKhoanNVDAO();
        ds = data.SelectAll();
    }
     
    public boolean doiMatKhau(String ma, String matkhau) {
    // Chỉ cần kiểm tra mật khẩu mới không trống
   
    TaiKhoanNVDAO tkDAO = new TaiKhoanNVDAO();
    return tkDAO.updatePassword(matkhau, ma);
}
}
