
package BUS;

import DAO.ChiTietKhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import java.util.ArrayList;

public class ChiTietKhuyenMaiBUS {
    private ArrayList<ChiTietKhuyenMaiDTO> ds;
    public ChiTietKhuyenMaiBUS(){
        if(ds==null) ds=new ArrayList<>();
    }
    public ArrayList<ChiTietKhuyenMaiDTO> getDS(){return ds;}
    
    public ArrayList<ChiTietKhuyenMaiDTO> docDS(){
        ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
        ds=dao.selectAll();
        return ds;
    }
}
