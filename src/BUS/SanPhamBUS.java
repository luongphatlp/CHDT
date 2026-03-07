
package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {
    ArrayList<SanPhamDTO> ds;
    SanPhamDAO dao=new SanPhamDAO();
    public SanPhamBUS(){ds=new ArrayList<>();}
    public ArrayList<SanPhamDTO> getDS(){return ds;}
    
    public ArrayList<SanPhamDTO> selectSanPhamKhongTrongKhuyenMai(String ma){
        ds=dao.selectSanPhamKhongTrongKhuyenMai(ma);
        return ds;
    }
}
