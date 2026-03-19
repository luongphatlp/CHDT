package BUS;

import DAO.ChiTietKhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ChiTietKhuyenMaiBUS {

    private ArrayList<ChiTietKhuyenMaiDTO> ds;
    private ChiTietKhuyenMaiDAO dao = new ChiTietKhuyenMaiDAO();
    private Map<String, ArrayList<ChiTietKhuyenMaiDTO>> kmMap;

    public ChiTietKhuyenMaiBUS() {
        ds = new ArrayList<>();
    }

    public ArrayList<ChiTietKhuyenMaiDTO> getDS() {
        return ds;
    }

    public ArrayList<ChiTietKhuyenMaiDTO> docDS() {
        ds = dao.selectAll();
        taoMap();
        return ds;
    }

    public ArrayList<ChiTietKhuyenMaiDTO> docDSTheoMaKM(String ma) {
        return  dao.selectByMaKM(ma);
    }

    public void add(ChiTietKhuyenMaiDTO km) {
        ds.add(km);
        dao.insert(km);
    }

    public void delete(String makm, String masp) {
        for(int i=0;i<ds.size();i++){
            if(ds.get(i).getMaKM().equals(makm) && ds.get(i).getSanPham().getMaSP().equals(masp)){
                ds.remove(i);
                break;
            }
        }
        ChiTietKhuyenMaiDTO ctkm = new ChiTietKhuyenMaiDTO();
        ctkm.setMaKM(makm);
        SanPhamDTO sp = new SanPhamDTO();
        sp.setMaSP(masp);
        ctkm.setSanPham(sp);
        dao.delete(ctkm);
    }

    public void update(ChiTietKhuyenMaiDTO km) {
        
        dao.update(km);
    }

    public void updatePhanTramGiam(int phantram, String makm) {
        dao.updatePhanTramGiam(phantram, makm);
    }
    public void taoMap() {
        kmMap = new HashMap<>();

        for (ChiTietKhuyenMaiDTO km : ds) {
            String masp = km.getSanPham().getMaSP();

            kmMap.computeIfAbsent(masp, k -> new ArrayList<>()).add(km);
        }
    }
    public int layPhanTramGiam(String maKM, String maSP) {
        ArrayList<ChiTietKhuyenMaiDTO> dsCT = dao.selectByMaKM(maKM.trim());
        if (dsCT != null) {
            for (ChiTietKhuyenMaiDTO ct : dsCT) {
                // So sánh mã SP trong DB với mã SP đang xét ở giỏ hàng
                if (ct.getSanPham().getMaSP().trim().equalsIgnoreCase(maSP.trim())) {
                    return ct.getPhanTram();
                }
            }
        }
        return 0;
    }

    public ArrayList<ChiTietKhuyenMaiDTO> getKMByMaSP(String masp) {
        return kmMap.getOrDefault(masp, new ArrayList<>());
    }
    
}
