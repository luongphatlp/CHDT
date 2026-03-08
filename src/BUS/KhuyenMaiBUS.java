
package BUS;

import DAO.KhuyenMaiDAO;
import DTO.KhuyenMaiDTO;
import java.util.ArrayList;


public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> ds;
    KhuyenMaiDAO dao=new KhuyenMaiDAO();
    public KhuyenMaiBUS(){
        if(ds==null) ds=new ArrayList<>();
    }
    public ArrayList<KhuyenMaiDTO> getDS(){return ds;}
    
    public ArrayList<KhuyenMaiDTO> docDS(){
        ds=dao.selectAll();
        return ds;
    }
    public void add(KhuyenMaiDTO km){
        dao.insert(km);
    }
    public boolean kiemTraMaKhuyenMaiTonTai(String ma){
        for(KhuyenMaiDTO km:ds){
            if(km.getMa().equals(ma)){
                return true;
            }
        }
        return false;
    }
    public void update(KhuyenMaiDTO km){
        dao.update(km);
    }
}
