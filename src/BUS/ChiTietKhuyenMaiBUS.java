
package BUS;

import DAO.ChiTietKhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiBUS {
    private ArrayList<ChiTietKhuyenMaiDTO> ds;
    private ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
    public ChiTietKhuyenMaiBUS(){
        ds=new ArrayList<>();
    }
    public ArrayList<ChiTietKhuyenMaiDTO> getDS(){return ds;}
    
    public ArrayList<ChiTietKhuyenMaiDTO> docDS(){
        ds=dao.selectAll();
        return ds;
    }
    public ArrayList<ChiTietKhuyenMaiDTO> docDSTheoMaKM(String ma){
        ds=dao.selectByMaKM(ma);
        return ds;
    }
    public void add(ChiTietKhuyenMaiDTO km){
        dao.insert(km);
    }
}
