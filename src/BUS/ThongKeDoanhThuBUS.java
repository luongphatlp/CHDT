/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeDoanhThuDAO;
import DTO.ThongKeDoanhThuDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeDoanhThuBUS {
    public static ArrayList<ThongKeDoanhThuDTO> ds=new ArrayList<>();
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNgay(Date tu,Date den){
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        if(tu != null && den != null){
            ds=dao.thongKeDoanhThuTheoNgay(tu,den);
            return ds;
        }
        return null;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoThang(int nam){
        if(nam == 0) return null;
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        ds=dao.thongKeDoanhThuTheoThang(nam);
        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNam(int tu,int den){
        if(tu == 0 & den == 0) return null;
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        ds=dao.thongKeDoanhThuTheoNam(tu,den);
        return ds;
    }
}
