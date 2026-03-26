/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietSanPhamDAO;
import DTO.ChiTietSanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietSanPhamBUS {
    ArrayList<ChiTietSanPhamDTO> ds=new ArrayList<>();
    ChiTietSanPhamDAO dao=new ChiTietSanPhamDAO();
    public ChiTietSanPhamBUS(){}
    public void docDS(){
        ds=dao.selectAll();
    }
    public ArrayList<ChiTietSanPhamDTO> getDS(){return ds;}
    public ChiTietSanPhamDTO getCTSPByMaSP(String ma){
        for(ChiTietSanPhamDTO ct:ds)
            if(ct.getMaSP().equals(ma))
                return ct;
        return null;
    }
}
