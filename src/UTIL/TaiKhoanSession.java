/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTIL;

/**
 *
 * @author admin
 */
import BUS.NhanVienBUS;
import DTO.NhanVienDTO;

public class TaiKhoanSession {
    public static NhanVienDTO nvDangNhap ;
    
    public static void capnhat(){
        NhanVienBUS nvBUS = new NhanVienBUS();
        nvBUS.docDSNV();
        for (NhanVienDTO nvDTO : nvBUS.getDSNV()){
            if(nvDTO.getMaNV().equals(nvDangNhap.getMaNV())){
                nvDangNhap = nvDTO;
            }
        }
    }
    
    public static void dangxuat(){
        nvDangNhap = null;
    }
}
