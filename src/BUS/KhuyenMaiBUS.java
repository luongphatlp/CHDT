package BUS;

import DAO.KhuyenMaiDAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KhuyenMaiBUS {

    private ArrayList<KhuyenMaiDTO> ds;
    KhuyenMaiDAO dao = new KhuyenMaiDAO();
    ChiTietKhuyenMaiBUS busct=new ChiTietKhuyenMaiBUS();
    
    private Map<String, KhuyenMaiDTO> kmMap;
    public KhuyenMaiBUS() {
        ds = new ArrayList<>();
        busct.docDS();
    }
    public void taoMap() {
        kmMap = new HashMap<>();
        for (KhuyenMaiDTO km : ds) {
            kmMap.put(km.getMa(), km);
        }
    }
    public String taoMaKM(){
        String max = dao.layMaKMMax();

        if(max == null){
            return "KM001";
        }

        int index = Integer.parseInt(max.substring(2));
        return String.format("KM%03d", index + 1);
    }
    public ArrayList<KhuyenMaiDTO> getDS() {
        return ds;
    }

    public ArrayList<KhuyenMaiDTO> docDS() {
        ds = dao.selectAll();
        taoMap();
        return ds;
    }
    public KhuyenMaiDTO getByMaKM(String maKM) {
        return kmMap.get(maKM);
    }
    public void add(KhuyenMaiDTO km) {
        dao.insert(km);
    }

    public boolean kiemTraMaKhuyenMaiTonTai(String ma) {
        for (KhuyenMaiDTO km : ds) {
            if (km.getMa().equals(ma)) {
                return true;
            }
        }
        return false;
    }

    public void update(KhuyenMaiDTO km) {
        
        dao.update(km);
    }
    
    public ArrayList<ChiTietKhuyenMaiDTO> getKMByMaSPConThoiHan(String masp) {
        ArrayList<ChiTietKhuyenMaiDTO> result = new ArrayList<>();

        ArrayList<ChiTietKhuyenMaiDTO> dsCTKM = busct.getKMByMaSP(masp);
        if (dsCTKM == null) return result;

        for (ChiTietKhuyenMaiDTO ctkm : dsCTKM) {
            KhuyenMaiDTO km = getByMaKM(ctkm.getMaKM());

            if (km != null && hoatDong(km.getNgayBD(), km.getNgayKT())) {
                result.add(ctkm);
            }
        }

        return result;
    }
    
    public boolean hoatDong(LocalDate tu,LocalDate den){
        LocalDate now=LocalDate.now();
        return !now.isAfter(den) && !now.isBefore(tu);
    }
    public ArrayList<KhuyenMaiDTO> getDSKMHoatDong() {
        ArrayList<KhuyenMaiDTO> dskm=new ArrayList<>();
        for(KhuyenMaiDTO km:ds){
            if(hoatDong(km.getNgayBD(),km.getNgayKT())){
                dskm.add(km);
            }
        }
        return dskm;
    }
    
}
