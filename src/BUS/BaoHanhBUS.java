package BUS;
import DAO.BaoHanhDAO;
import DTO.BaoHanhDTO;
import DTO.ChiTietBaoHanhDTO;
import DTO.ChiTietSanPhamDTO;
import DTO.KhachHangDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class BaoHanhBUS {
    private final BaoHanhDAO dao = new BaoHanhDAO();
    ArrayList<BaoHanhDTO> ds;
    public BaoHanhBUS(){ds=new ArrayList<>();}
    public ArrayList<BaoHanhDTO> selectAll(){
        ds=dao.selectAll();
        return ds;
    }
    public void delete(String ma){
        if(dao.delete(ma)!=-1)
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaBH().equals(ma)){
                ds.remove(i);
                break;
            }
        
    }
    public void insert(BaoHanhDTO bh){
        if(dao.insert(bh) !=-1)
            ds.add(bh);
    }
    public void update(BaoHanhDTO bh){
        if(dao.update(bh)!=-1)
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaBH().equals(bh.getMaBH())){
                ds.set(i,bh);
                break;
            }
    }
    public String taoMaBH() {
       return dao.taoMaBH();
    }
    public KhachHangDTO getKHByMaKH(String makh){
        KhachHangBUS bus=new KhachHangBUS();
        for (KhachHangDTO kh: bus.getDSKH() ){
            if(kh.getMa().equals(makh))
                return kh;
        }
        return null;
    }
//    public ChiTietSanPhamDTO layCTSPByMaSP(String masp){
//        SanPhamBUS bus =new  SanPhamBUS();
//        return bus.layCTSPByMaSP(masp);
//    } 
    public void insertCTBH(ArrayList<ChiTietBaoHanhDTO> ds){
        ChiTietBaoHanhBUS bus=new ChiTietBaoHanhBUS();
        for(ChiTietBaoHanhDTO ctbh:ds)
            bus.insert(ctbh);
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaBH(String mabh){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(bh.getMaBH().equals(mabh))
                tam.add(bh);
        return tam;
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaKH(String makh){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(makh.equals(bh.getMaKH()))
                tam.add(bh);
        return tam;
    }
    public ArrayList<BaoHanhDTO> timKiemBHByMaNV(String manv){
        ArrayList<BaoHanhDTO> tam=new ArrayList<>();
        for(BaoHanhDTO bh:ds)
            if(manv.equals(bh.getMaNV()))
                tam.add(bh);
        return tam;
    }
    
    public ArrayList<ChiTietBaoHanhDTO> selectCTBHByMaBH(String mabh){
        ChiTietBaoHanhBUS bus=new ChiTietBaoHanhBUS();
        return bus.selectCTBHByMaBH(mabh);
    }
    public ArrayList<BaoHanhDTO> timKiemBHByDate(ArrayList<BaoHanhDTO> bd, LocalDate tu, LocalDate den){
        if(bd == null){
            selectAll();
            bd = ds;
        }

        ArrayList<BaoHanhDTO> tam = new ArrayList<>();

        for(BaoHanhDTO bh : bd){
            LocalDate ngay = bh.getNgayLap();

            if(!ngay.isBefore(tu) && !ngay.isAfter(den)){
                tam.add(bh);
            }
        }

        return tam;
    }
    public LocalDate chuyenDateThanhLocalDate(Date d){
        return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}