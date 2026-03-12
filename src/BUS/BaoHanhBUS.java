package BUS;
import DAO.BaoHanhDAO;
import DTO.BaoHanhDTO;
import java.util.ArrayList;
import java.util.Calendar;

public class BaoHanhBUS {
    private final BaoHanhDAO dao = new BaoHanhDAO();

    public boolean xuLyLuuBaoHanh(String maBH, int thoiHan, ArrayList<BaoHanhDTO> dsMay) {
        dao.insertBaoHanh(maBH, thoiHan);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, thoiHan);
        java.sql.Date ngayHetHan = new java.sql.Date(cal.getTimeInMillis());

        for (BaoHanhDTO bh : dsMay) {
            bh.setNgayBaoHanh(ngayHetHan);
            if (!dao.insertChiTietBaoHanh(maBH, bh)) return false;
        }
        return true;
    }

    public ArrayList<BaoHanhDTO> getAll() { return dao.selectAllForTable(); }
}