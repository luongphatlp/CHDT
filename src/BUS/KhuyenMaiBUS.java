
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
    public ArrayList<String> getDSMaKMHoatDong() {
    ArrayList<String> dsMa = new ArrayList<>();
    ArrayList<KhuyenMaiDTO> dsAll = kmDAO.getList(); // Giả sử bạn đã có hàm getList() lấy tất cả
    
    for (KhuyenMaiDTO km : dsAll) {
        // Kiểm tra TinhTrang = 1 (Hoạt động)
        // Bạn có thể thêm điều kiện kiểm tra ngày hệ thống nằm trong khoảng NgayBatDau và NgayKetThuc
        if (km.getTinhTrang() == 1) { 
            dsMa.add(km.getMa());
        }
    }
    return dsMa;
}
}
