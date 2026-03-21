/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeSanPhamDAO;
import DTO.NhaCungCapDTO;
import DTO.SanPhamDTO;
import DTO.ThongKeSanPhamDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamBUS {
    private ArrayList<ThongKeSanPhamDTO> ds;
    NhaCungCapBUS busncc=new NhaCungCapBUS();
    public ThongKeSanPhamBUS(){
        ds=new ArrayList<>();
        busncc.docDS();
    }
    
    public ArrayList<ThongKeSanPhamDTO> getList(){
        return ds;
    }
    //thuc hien thong ke san pham
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPham(){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds=dao.thongKeSanPham();
        return ds;
    }
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPhamDieuKien(String key,Date tu,Date den){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds= dao.thongKeSanPhamDieuKien(key,tu,den);
        //thongKeSanPhamDieuKien(String key, Date tu, Date den)
        return ds;
    }
    public static void main(String[] agrs){
        ThongKeSanPhamBUS bus=new ThongKeSanPhamBUS();
        bus.thongKeSanPham();
        System.out.println(bus.getList().get(0).getMaSP());
    }
    public ArrayList<SanPhamDTO> getDSSP(){
        SanPhamBUS bus=new SanPhamBUS();
        bus.docDS();
        return bus.getDS();
    }
    public ArrayList<NhaCungCapDTO> getDSNCC(){
        return busncc.getDS();
    }
}
