/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ChiTietBaoHanhDAO;
import DTO.ChiTietBaoHanhDTO;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietBaoHanhBUS {

    ChiTietBaoHanhDAO dao = new ChiTietBaoHanhDAO();
    ArrayList<ChiTietBaoHanhDTO> ds = new ArrayList<>();

    public void delete(String ma){
        dao.delete(ma);
        ds.removeIf(ctbh -> ctbh.getMaBH().equals(ma));
    }

    public void insert(ChiTietBaoHanhDTO ctbh){
        dao.insert(ctbh);
        ds.add(ctbh);
    }

    public void update(ChiTietBaoHanhDTO ctbh){
        dao.update(ctbh);
    }

    public ArrayList<ChiTietBaoHanhDTO> selectAll(){
        ds = dao.selectAll();
        return ds;
    }

    public ArrayList<ChiTietBaoHanhDTO> selectCTBHByMaBH(String mabh){
        if(ds.isEmpty()) selectAll();

        ArrayList<ChiTietBaoHanhDTO> tam = new ArrayList<>();

        for(ChiTietBaoHanhDTO ctbh : ds){
            if(ctbh.getMaBH().equals(mabh)){
                tam.add(ctbh);
            }
        }

        return tam;
    }
    public boolean kTIMEI(String imei){
        for(ChiTietBaoHanhDTO ct:ds)
            if(ct.getIMEI().equals(imei))
                return false;
        return true;
    }
}
    /*
    public boolean xuLyLuuBaoHanh( int thoiHan) {
        dao.insertBaoHanh(maBH, thoiHan);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, thoiHan);
        java.sql.Date ngayHetHan = new java.sql.Date(cal.getTimeInMillis());

        for (BaoHanhDTO bh : dsMay) {
            bh.setNgayBaoHanh(ngayHetHan);
            if (!dao.insertChiTietBaoHanh(maBH, bh)) return false;
        }
        return true;
    }
    */

