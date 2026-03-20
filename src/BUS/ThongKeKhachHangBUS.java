/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.ThongKeKhachHangDTO;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeKhachHangBUS {
    ArrayList<ThongKeKhachHangDTO> ds;
    KhachHangBUS buskh=new KhachHangBUS();
    HoaDonBUS bushd=new HoaDonBUS();
    public ThongKeKhachHangBUS(){
        ds=new ArrayList<>();
        buskh.getDSKH();
        bushd.selectAll();
    }
    public boolean kTNgay(LocalDate ngayhd,LocalDate tu,LocalDate den){
        if(tu!=null && den!=null) return !ngayhd.isAfter(den) && !ngayhd.isBefore(tu);
        else if(tu!=null) return !ngayhd.isBefore(tu);
        else if(den!=null) return !ngayhd.isAfter(den);
        return true;
    }
    public ArrayList<ThongKeKhachHangDTO> locKhachHangTheoMa(String key){
        ArrayList<ThongKeKhachHangDTO> tam=new ArrayList<>();
        for(KhachHangDTO kh:buskh.getDSKH()){
            boolean ktkey = (key == null || key.isEmpty()) || key.equalsIgnoreCase(kh.getMa()) ||key.contains(kh.getHoten().toLowerCase());
            if(!ktkey) continue;
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                dem++;
                tong+=hd.getTongTien();
            }
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeKhachHangDTO> locKhachHangTheoNgay(String key,LocalDate tu,LocalDate den){
        ArrayList<ThongKeKhachHangDTO> tam=new ArrayList<>();
        for(KhachHangDTO kh:buskh.getDSKH()){
            boolean ktkey = (key == null || key.isEmpty()) || key.equalsIgnoreCase(kh.getMa()) ||key.contains(kh.getHoten().toLowerCase());
            if(!ktkey) continue;
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                boolean ktngay=kTNgay(hd.getNgay().toLocalDate(),tu,den);
                if(ktngay){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeKhachHangDTO> locKhachHangTheoThang(String key,int nam){
        ArrayList<ThongKeKhachHangDTO> tam=new ArrayList<>();
        for(KhachHangDTO kh:buskh.getDSKH()){
            boolean ktkey = (key == null || key.isEmpty()) || key.equalsIgnoreCase(kh.getMa()) ||key.contains(kh.getHoten().toLowerCase());
            if(!ktkey) continue;
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                boolean ktngay= hd.getNgay().getYear()==nam;
                if(ktngay){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeKhachHangDTO> locKhachHangTheoNam(String key,int tunam,int dennam){
        ArrayList<ThongKeKhachHangDTO> tam=new ArrayList<>();
        for(KhachHangDTO kh:buskh.getDSKH()){
            boolean ktkey = (key == null || key.isEmpty()) || key.equalsIgnoreCase(kh.getMa()) ||key.contains(kh.getHoten().toLowerCase());
            if(!ktkey) continue;
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
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
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
}
