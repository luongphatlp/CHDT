/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeSanPhamDAO;
import DTO.ThongKeDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamBUS {
    private static ArrayList<ThongKeDTO> ds=new ArrayList<>();
    
    public ArrayList<ThongKeDTO> getList(){
        return ds;
    }
    //thuc hien thong ke san pham
    public ArrayList<ThongKeDTO> thongKeSanPham(){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds=dao.thongKeSanPham();
        return ds;
    }
    public ArrayList<ThongKeDTO> thongKeSanPhamDieuKien(String key,Date tu,Date den){
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
}
