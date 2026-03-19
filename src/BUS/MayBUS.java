package BUS;

import DAO.MayDAO;
import DTO.MayDTO;
import java.util.ArrayList;

public class MayBUS {
    private ArrayList<MayDTO> ds;
    private MayDAO mayDAO = new MayDAO();

    // Lấy toàn bộ danh sách máy
    public ArrayList<MayDTO> getAll() {
        if (ds == null) {
            ds = mayDAO.selectAll();
        }
        return ds;
    }

    // Thêm máy
    public boolean insert(MayDTO m) {
        if (mayDAO.insert(m) > 0) {
            ds.add(m);
            return true;
        }
        return false;
    }

    // Xóa máy
    public boolean delete(String imei) {
        if (mayDAO.delete(imei) > 0) {
            for (int i = 0; i < ds.size(); i++) {
                if (ds.get(i).getImei().equals(imei)) {
                    ds.remove(i);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    // Tìm máy theo IMEI
    public MayDTO timTheoIMEI(String imei) {
        for (MayDTO m : ds) {
            if (m.getImei().equalsIgnoreCase(imei)) {
                return m;
            }
        }
        return null;
    }
}