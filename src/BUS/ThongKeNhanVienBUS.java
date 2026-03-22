/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeNhanVienDAO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.ThongKeNhanVienDTO;
import java.time.LocalDate;

/**
 *
 * @author Latitude E7470
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class ThongKeNhanVienBUS {
    private ArrayList<ThongKeNhanVienDTO> ds;
    private ThongKeNhanVienDAO dao;
    HoaDonBUS bushd=new HoaDonBUS();
    NhanVienBUS busnv=new NhanVienBUS();
    public ThongKeNhanVienBUS() {
        dao = new ThongKeNhanVienDAO();
        ds = new ArrayList<>();
        bushd.selectAll();
        busnv.docDSNV();
    }
    public ArrayList<NhanVienDTO> getDSNV(){
        return busnv.getDSNV();
    }
    // Load dữ liệu từ DB
    public ArrayList<ThongKeNhanVienDTO> docDS() {
        ds = dao.docDS();
        return ds;
    }

    // Lấy danh sách
    public ArrayList<ThongKeNhanVienDTO> getDS() {
        return ds;
    }

    // Tìm theo mã NV
    public ThongKeNhanVienDTO timTheoMa(String ma) {
        for (ThongKeNhanVienDTO tk : ds) {
            if (tk.getMaNV().equalsIgnoreCase(ma)) {
                return tk;
            }
        }
        return null;
    }

    // Sắp xếp theo doanh thu giảm dần
    public void sortDoanhThuGiam() {
        Collections.sort(ds, new Comparator<ThongKeNhanVienDTO>() {
            @Override
            public int compare(ThongKeNhanVienDTO o1, ThongKeNhanVienDTO o2) {
                return o2.getDoanhThu() - o1.getDoanhThu();
            }
        });
    }

    // Sắp xếp theo số hóa đơn giảm dần
    public void sortSoHoaDonGiam() {
        Collections.sort(ds, new Comparator<ThongKeNhanVienDTO>() {
            @Override
            public int compare(ThongKeNhanVienDTO o1, ThongKeNhanVienDTO o2) {
                return o2.getSoHoaDon() - o1.getSoHoaDon();
            }
        });
    }

    // Lấy top N nhân viên doanh thu cao nhất
    public ArrayList<ThongKeNhanVienDTO> getTopDoanhThu(int n) {
        sortDoanhThuGiam();
        ArrayList<ThongKeNhanVienDTO> top = new ArrayList<>();
        for (int i = 0; i < Math.min(n, ds.size()); i++) {
            top.add(ds.get(i));
        }
        return top;
    }
    public boolean kTNgay(LocalDate ngayhd,LocalDate tu,LocalDate den){
        if(tu!=null && den!=null) return !ngayhd.isAfter(den) && !ngayhd.isBefore(tu);
        else if(tu!=null) return !ngayhd.isBefore(tu);
        else if(den!=null) return !ngayhd.isAfter(den);
        return true;
    }
    public ArrayList<ThongKeNhanVienDTO> locNhanVienTheoMa(ArrayList<String> key){
        ArrayList<ThongKeNhanVienDTO> tam=new ArrayList<>();
        for(NhanVienDTO nv:busnv.getDSNV()){
            boolean ktkey = (key == null || key.isEmpty()) || key.contains(nv.getMaNV());
            if(!ktkey) continue;
            ThongKeNhanVienDTO tk=new ThongKeNhanVienDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaNV(nv.getMaNV())){
                dem++;
                tong+=hd.getTongTien();
            }
            tk.setMaNV(nv.getMaNV());
            tk.setHoTen(nv.getHoTenNV());
            tk.setSoHoaDon(dem);
            tk.setDoanhThu(tong);
            tam.add(tk);
        }
        return tam;
        
    }
    public ArrayList<ThongKeNhanVienDTO> locNhanVienTheoNgay(ArrayList<String> key,LocalDate tu,LocalDate den){
        ArrayList<ThongKeNhanVienDTO> tam=new ArrayList<>();
        for(NhanVienDTO nv:busnv.getDSNV()){
            boolean ktkey = (key == null || key.isEmpty()) || key.contains(nv.getMaNV());
            if(!ktkey) continue;
            ThongKeNhanVienDTO tk=new ThongKeNhanVienDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaNV(nv.getMaNV())){
                boolean ktngay=kTNgay(hd.getNgay().toLocalDate(),tu,den);
                if(ktngay){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            tk.setMaNV(nv.getMaNV());
            tk.setHoTen(nv.getHoTenNV());
            tk.setSoHoaDon(dem);
            tk.setDoanhThu(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeNhanVienDTO> locNhanVienTheoThang(ArrayList<String> key,int nam){
        ArrayList<ThongKeNhanVienDTO> tam=new ArrayList<>();
        for(NhanVienDTO nv:busnv.getDSNV()){
            boolean ktkey = (key == null || key.isEmpty()) || key.contains(nv.getMaNV());
            if(!ktkey) continue;
            ThongKeNhanVienDTO tk=new ThongKeNhanVienDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaNV(nv.getMaNV())){
                boolean ktngay= hd.getNgay().getYear()==nam;
                if(ktngay){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            tk.setMaNV(nv.getMaNV());
            tk.setHoTen(nv.getHoTenNV());
            tk.setSoHoaDon(dem);
            tk.setDoanhThu(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeNhanVienDTO> locNhanVienTheoNam(ArrayList<String> key,int tunam,int dennam){
        ArrayList<ThongKeNhanVienDTO> tam=new ArrayList<>();
        for(NhanVienDTO nv:busnv.getDSNV()){
            boolean ktkey = (key == null || key.isEmpty()) || key.contains(nv.getMaNV());
            if(!ktkey) continue;
            ThongKeNhanVienDTO tk=new ThongKeNhanVienDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaNV(nv.getMaNV())){
                boolean ktngay;
                if(tunam!=0 && dennam!=0)
                    ktngay=hd.getNgay().getYear()>=tunam && hd.getNgay().getYear()<=dennam;
                else if(tunam!=0)
                    ktngay=hd.getNgay().getYear()>=tunam;
                else 
                    ktngay=hd.getNgay().getYear()<=dennam;
                if(ktngay){
                   dem++;
                   tong+=hd.getTongTien();
                }                      
            }
            tk.setMaNV(nv.getMaNV());
            tk.setHoTen(nv.getHoTenNV());
            tk.setSoHoaDon(dem);
            tk.setDoanhThu(tong);
            tam.add(tk);
        }
        return tam;
    }
}
