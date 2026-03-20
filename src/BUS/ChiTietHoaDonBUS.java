/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietHoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
class ChiTietHoaDonBUS {
    ArrayList<ChiTietHoaDonDTO>ds;
    
    ChiTietHoaDonDAO dao =new ChiTietHoaDonDAO();
    
    public ChiTietHoaDonBUS(){
        if(ds==null) ds=dao.selectAll();
    }
    public int insert(ChiTietHoaDonDTO cthd){
        ds.add(cthd);
       return dao.insert(cthd);
    }
    public ArrayList<ChiTietHoaDonDTO> selectAll(){
        ds=dao.selectAll();
        return ds;
    }
    public int kiemTraMaSP(String masp){
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaSP().equals(masp))
                return i;
        return -1;
    }
    public int delete (String masp,String mahd){
       ds.remove(kiemTraMaSP(masp));
       return dao.delete(mahd, masp);    
    }

}
