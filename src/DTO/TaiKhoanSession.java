/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author admin
 */
import BUS.NhanVienBUS;


public class TaiKhoanSession {
    public static NhanVienDTO nvDangNhap ;
    
    public static void capnhat(){
        // --- THÊM NGƯỜI GÁC CỔNG Ở ĐÂY ---
        if (nvDangNhap == null) {
            System.out.println("Lỗi: Chưa có tài khoản đăng nhập để cập nhật!");
            return; // Dừng hàm ngay lập tức, không chạy phần code bên dưới nữa
        }
        // ---------------------------------

        NhanVienBUS nvBUS = new NhanVienBUS();
        nvBUS.docDSNV();
        for (NhanVienDTO nvDTO : nvBUS.getDSNV()){
            if(nvDTO.getMaNV().equals(nvDangNhap.getMaNV())){
                nvDangNhap = nvDTO;
                break; // Mẹo nhỏ: Tìm thấy rồi thì break luôn cho vòng lặp đỡ phải chạy tiếp
            }
        }
    }
    
    public static void dangxuat(){
        nvDangNhap = null;
    }
}
