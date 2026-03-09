

package BUS;

import DAO.ChiTietKhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.SanPhamDTO;
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
    public void delete(String makm,String masp){
        ChiTietKhuyenMaiDTO ctkm=new ChiTietKhuyenMaiDTO();
        ctkm.setMaKM(makm);
        SanPhamDTO sp=new SanPhamDTO();
        sp.setMaSP(masp);
        ctkm.setSanPham(sp);
        dao.delete(ctkm);
    }
    public void update(ChiTietKhuyenMaiDTO km){
        dao.update(km);
    }
    public void updatePhanTramGiam(int phantram,String makm){
        dao.updatePhanTramGiam(phantram, makm);
    }
}


