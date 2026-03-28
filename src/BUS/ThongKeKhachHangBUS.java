/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.ThongKeKhachHangDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
            if(key != null && !key.isEmpty() && !key.equalsIgnoreCase(kh.getMa()) && kh.getHoten().toLowerCase().contains(key.toLowerCase())) continue;          
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                dem++;
                tong+=hd.getTongTien();
            }
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<ThongKeKhachHangDTO> locKhachHangTheoNgay(String key,LocalDate tungay,LocalDate denngay){
        ArrayList<ThongKeKhachHangDTO> tam=new ArrayList<>();
        LocalDateTime tu= tungay==null ? LocalDate.MIN.atStartOfDay() : tungay.atStartOfDay();
        LocalDateTime den =denngay==null ? LocalDate.MAX.atTime(LocalTime.MAX) : denngay.atTime(LocalTime.MAX);
        for(KhachHangDTO kh:buskh.getDSKH()){
            if(key != null && !key.isEmpty() && !key.equalsIgnoreCase(kh.getMa()) && kh.getHoten().toLowerCase().contains(key.toLowerCase())) continue;          
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                LocalDateTime ngay=hd.getNgay();
                if(!ngay.isAfter(den) && !ngay.isBefore(tu)){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
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
            if(key != null && !key.isEmpty() && !key.equalsIgnoreCase(kh.getMa()) && kh.getHoten().toLowerCase().contains(key.toLowerCase())) continue;                      
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                if(hd.getNgay().getYear()==nam){
                   dem++;
                   tong+=hd.getTongTien();
                }
            }
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
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
        int tu=tunam==-1 ? Integer.MIN_VALUE : tunam;
        int den =dennam==-1 ? Integer.MAX_VALUE : dennam;
        for(KhachHangDTO kh:buskh.getDSKH()){
            if(key != null && !key.isEmpty() && !key.equalsIgnoreCase(kh.getMa()) && kh.getHoten().toLowerCase().contains(key.toLowerCase())) continue;                      
            int dem=0;
            int tong=0;
            for(HoaDonDTO hd:bushd.getHDByMaKH(kh.getMa())){
                int nam=hd.getNgay().getYear();
                if(nam<=den && nam>=tu){
                   dem++;
                   tong+=hd.getTongTien();
                }                      
            }
            ThongKeKhachHangDTO tk=new ThongKeKhachHangDTO();
            tk.setMa(kh.getMa());
            tk.setHoten(kh.getHoten());
            tk.setHoadon(dem);
            tk.setTong(tong);
            tam.add(tk);
        }
        return tam;
    }
    public ArrayList<Object[]> thongKeKHtheoQuy(int nam){
        ArrayList<Object[]> ketqua = new ArrayList<>();
        long[] tongCotQuy = new long[4];
        long tongTatCa = 0;
        

       
        for (KhachHangDTO kh : bushd.getDSKH()) {
            Object[] row = new Object[7];
            row[1] = kh.getMa();
            
            long[] quy = new long[4];
            long tongNam = 0;
            int soHD = 0 ;
            for(HoaDonDTO hd : bushd.getDS()){
            if (hd.getNgay().getYear() == nam && kh.getMa().equals(hd.getMaKH())) {
                int q = (hd.getNgay().getMonthValue() - 1) / 3;
                quy[q] += hd.getTongTien();
                tongNam += hd.getTongTien();
               
            }
            }
            row[2] = quy[0];
            row[3] = quy[1];
            row[4] = quy[2];
            row[5] = quy[3];
            
            row[6] = tongNam;

            for (int i = 0; i < 4; i++) tongCotQuy[i] += quy[i];
            tongTatCa += tongNam;

            ketqua.add(row);
        }

        
        if (!ketqua.isEmpty()) {
            Object[] finalRow = new Object[7];
            finalRow[1] = "Tổng cộng";
            finalRow[2] = tongCotQuy[0];
            finalRow[3] = tongCotQuy[1];
            finalRow[4] = tongCotQuy[2];
            finalRow[5] = tongCotQuy[3];
            
            finalRow[6] = tongTatCa;
            ketqua.add(finalRow);
        }

        return ketqua;
    }
    
}
