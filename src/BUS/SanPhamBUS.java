package BUS;

import DAO.SanPhamDAO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

public class SanPhamBUS {
    private ArrayList<SanPhamDTO> ds;
    private SanPhamDAO dao = new SanPhamDAO();

    public SanPhamBUS() {
        docDS();
    }

    public void docDS() {
        ds = dao.selectAll();
        if (ds == null) ds = new ArrayList<>();
    }

    public ArrayList<SanPhamDTO> getDS() {
        return ds;
    }

    public boolean checkMaSP(String ma) {
        for (SanPhamDTO sp : ds) {
            if (sp.getMaSP().equalsIgnoreCase(ma)) return true;
        }
        return false;
    }

    public boolean them(SanPhamDTO sp) {
        if (checkMaSP(sp.getMaSP())) return false; 
        if (sp.getDonGia() < 0) return false;
        if (dao.insert(sp) > 0) {
            ds.add(sp);
            return true;
        }
        return false;
    }

    public boolean sua(SanPhamDTO sp) {
        if (dao.update(sp) > 0) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getMaSP().equals(sp.getMaSP())) {
                    ds.set(i, sp);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean xoa(String ma) {
        if (dao.delete(ma) > 0) {
            return ds.removeIf(sp -> sp.getMaSP().equals(ma));
        }
        return false;
    }

    public ArrayList<SanPhamDTO> selectSanPhamKhongTrongKhuyenMai(String ma) {
        return dao.selectSanPhamKhongTrongKhuyenMai(ma);
    }

    public ArrayList<SanPhamDTO> timKiem(String text, int giaTu, int giaDen) {
        ArrayList<SanPhamDTO> ketQua = new ArrayList<>();
        String searchLower = text.toLowerCase().trim();
        
        for (SanPhamDTO sp : ds) {
            boolean matchesText = sp.getTenSP().toLowerCase().contains(searchLower) 
                               || sp.getMaSP().toLowerCase().contains(searchLower);
            boolean matchesPrice = (giaTu <= 0 || sp.getDonGia() >= giaTu) 
                                && (giaDen <= 0 || sp.getDonGia() <= giaDen);          
            if (matchesText && matchesPrice) {
                ketQua.add(sp);
            }
        }
        return ketQua;
    }
}