package BUS;
import DAO.BaoHanhDAO;
import DTO.BaoHanhDTO;
import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BaoHanhBUS {
    private final BaoHanhDAO dao = new BaoHanhDAO();
    ArrayList<BaoHanhDTO> ds;
    public BaoHanhBUS(){ds=new ArrayList<>();}
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
    public ArrayList<BaoHanhDTO> selectAll(){
        ds=dao.selectAllForTable();
        return ds;
    }
    public String taoMaBH(){
        selectAll();
        if(ds.size()<10)
            return "BH0"+ds.size();
        else
            return "BH"+ds.size();
    }
    public ArrayList<BaoHanhDTO> getAll() { return dao.selectAllForTable(); }
    public KhachHangDTO getKHByMaKH(String makh){
        KhachHangBUS bus=new KhachHangBUS();
        for (KhachHangDTO kh: bus.getDSKH() ){
            if(kh.getMa().equals(makh))
                return kh;
        }
        return null;
    }
    public ChiTietSanPhamDTO layCTSPByMaSP(String masp){
        ChiTietSanPhamBUS bus =new  ChiTietSanPhamBUS();
        return bus.layCTSPByMaSP(masp);
    } 
}