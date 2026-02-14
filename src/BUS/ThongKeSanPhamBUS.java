/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeSanPhamDAO;
import DTO.ThongKeSanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamBUS {
    private static ArrayList<ThongKeSanPhamDTO> ds=new ArrayList<>();
    
    public ArrayList<ThongKeSanPhamDTO> getList(){
        return ds;
    }
    //thuc hien thong ke san pham
    public ArrayList<ThongKeSanPhamDTO> calculate_Product_Statistics(){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds=dao.thongKe();
        return ds;
    }
}
