
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;


public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> ds;
    public KhuyenMaiBUS(){
        if(ds==null) ds=new ArrayList<>();
    }
    public ArrayList<KhuyenMaiDTO> getDS(){return ds;}
    
    public ArrayList<KhuyenMaiDTO> docDS(){
        KhuyenMaiDAO dao=new KhuyenMaiDAO();
        ds=dao.selectAll();
        return ds;
    }
}
