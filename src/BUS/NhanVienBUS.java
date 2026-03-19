/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class NhanVienBUS {
    static ArrayList<NhanVienDTO> dsnv ;
    
    public ArrayList<NhanVienDTO> getDSNV(){
        return dsnv;
    }
    //constructer
    public NhanVienBUS(){
        NhanVienDAO data;
        
            data = new NhanVienDAO();
            if(dsnv == null ){
                dsnv = new ArrayList<>();
                dsnv = data.selectAll();
            }
    }
    
    public void docDSNV(){
        NhanVienDAO data;
        data = new NhanVienDAO();
        dsnv = data.selectAll();      
    }
    
    public String maTuDong(){      
        int soLonNhat = 0;
        for (NhanVienDTO nv : dsnv) {
            String ma = nv.getMaNV();
            if (ma != null && ma.toUpperCase().startsWith("NV")) {
                try {
                    int so = Integer.parseInt((ma.substring(2)));
                    if (so > soLonNhat) {
                        soLonNhat = so;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        int somoi = soLonNhat + 1;

        return String.format("NV%03d", somoi);
    }
        
     
    // kiem tra tinh hop le cua DTO 
    public String kiemTraHopLe(NhanVienDTO nvDTO){
       
        //kiem tra tren ho va ten trong
        if(nvDTO.getHoTenNV().trim().isEmpty() || nvDTO.getHoTenNV().isEmpty()){
            
            return "Họ tên không được để trống !";
        }
        
       
        //kiem tra email trong
        for (NhanVienDTO nv : dsnv) {
            
            if (nv.getEmailNV().equals(nvDTO.getEmailNV()) && !nv.getMaNV().equals(nvDTO.getMaNV())) {
                return "Email này đã tồn tại trong hệ thống, vui lòng dùng email khác!";
            }
        }
        // kiem tra dinh dang email co phu hop khong
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$";
        
        if(!nvDTO.getEmailNV().matches(regexEmail)){
           
            return "Email phải quy chuẩn (ví dụ: nguyentrannamthinh@gmail.com)";
        }   
        
       

        // kiem tra do tuoi hop le 
        java.util.Date ngaySinh = nvDTO.getNgaySinhNV();
        if(ngaySinh != null ){
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(ngaySinh);
            
            int namSinh = cal.get(java.util.Calendar.YEAR);
            
            if(namSinh > 2007) {
                
                return "Nhân viên hiện đang quá non";
            }
            if(namSinh < 1950){
                
                return "Nhân viên hiện đang quá giá";   
            }
        }   
        return "OK";
    }
    
    
    public boolean them(NhanVienDTO nv){
        //o day can tao mot cai khuan nhanviendao
        //sau do dung phuong phap (them) de nhet vao khuan 
        //sap vao hop dsnv 
        
        if (kiemTraHopLe(nv) == "OK"){
            boolean hople = true;
        }else{
            boolean hople = false;
        }
        
     
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.insert(nv);
        dsnv.add(nv);
        return true;
    }
    
    public boolean sua(NhanVienDTO nv){
         
        if (kiemTraHopLe(nv) == "OK"){
            boolean hople = true;
        }else{
            boolean hople = false;
        }
        
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.update(nv);
        
        for(int i = 0 ; i < dsnv.size(); i++){
            if (nv.getMaNV().equals(dsnv.get(i).getMaNV())){
                dsnv.set(i,nv);
                return true;    
            }   
        }
        return false;
    }
    
    public boolean xoa(NhanVienDTO nv){
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.delete(nv);
        for(int i = 0 ; i < dsnv.size(); i++){
            if(nv.getMaNV().equals(dsnv.get(i).getMaNV())){
                dsnv.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<NhanVienDTO> timkiem(String muctieu){
        ArrayList<NhanVienDTO> dstk = new ArrayList<>();
        
        if(muctieu.trim().isEmpty()){
            return dsnv;
        }
        for(NhanVienDTO nv : dsnv){
            if(nv.getMaNV().contains(muctieu)){
                dstk.add(nv);
            }else if (nv.getHoTenNV().contains(muctieu)){
                dstk.add(nv);
            }else if (nv.getChucVuNV().contains(muctieu)) {
                dstk.add(nv);
            }   
                
        }
        
        return dstk;
    }
 public ArrayList<NhanVienDTO> timKiemNangCao(String chucVu, String doTuoi, String kieu , String sapXep) {
        ArrayList<NhanVienDTO> dstknc = new ArrayList<>();

        if (this.dsnv == null) {
            docDSNV();
        }

        if (this.dsnv == null) {
            return dstknc;
        }

        for (NhanVienDTO nv : dsnv) {
            boolean matchChucVu = false;
            boolean matchTuoi = false;

            // 1. Lọc theo chức vụ
            if (chucVu.equalsIgnoreCase("Chọn chức vụ") || chucVu.trim().isEmpty()) {
                matchChucVu = true;
            } else if (nv.getChucVuNV() != null && nv.getChucVuNV().toLowerCase().contains(chucVu.toLowerCase())) {
                matchChucVu = true;
            }

           
            int tuoiNhanVien = -1;
            if (nv.getNgaySinhNV() != null) {
                int namSinh = nv.getNgaySinhNV().getYear() + 1900;
                tuoiNhanVien = 2026 - namSinh;
            }

            if (doTuoi.equalsIgnoreCase("Chọn độ tuổi") || doTuoi.trim().isEmpty()) {
                matchTuoi = true;
            } else if (doTuoi.equals("18-25") && tuoiNhanVien >= 18 && tuoiNhanVien <= 25) {
                matchTuoi = true;
            } else if (doTuoi.equals("26-30") && tuoiNhanVien >= 26 && tuoiNhanVien <= 30) {
                matchTuoi = true;
            } else if (doTuoi.equals("31-45") && tuoiNhanVien >= 31 && tuoiNhanVien <= 45) {
                matchTuoi = true;
            } else if (doTuoi.equals("46-60") && tuoiNhanVien >= 46 && tuoiNhanVien <= 60) {
                matchTuoi = true;
            }

            
            if (matchChucVu && matchTuoi) {
                dstknc.add(nv);
            }
        } 


      
        if (!kieu.equalsIgnoreCase("Chọn kiểu") && dstknc.size() > 1) {
            
            java.util.Collections.sort(dstknc, new java.util.Comparator<NhanVienDTO>() {
                @Override
                public int compare(NhanVienDTO nv1, NhanVienDTO nv2) {
                    int kqSoSanh = 0;

                    try {
                        if (kieu.equals("Mã Nhân Viên")) {
                            kqSoSanh = nv1.getMaNV().compareTo(nv2.getMaNV());
                        } else if (kieu.equals("Họ Tên")) {
                            kqSoSanh = nv1.getHoTenNV().compareTo(nv2.getHoTenNV());
                        } else if (kieu.equals("Ngày Sinh")) {
                            if (nv1.getNgaySinhNV() != null && nv2.getNgaySinhNV() != null) {
                                kqSoSanh = nv1.getNgaySinhNV().compareTo(nv2.getNgaySinhNV());
                            }
                        } else if (kieu.equals("Lương")) {
                            
                           
                            String strLuong1 = nv1.getLuongNV().replace(",", "").trim();
                            String strLuong2 = nv2.getLuongNV().replace(",", "").trim();
                            
                            
                            double luong1 = Double.parseDouble(strLuong1);
                            double luong2 = Double.parseDouble(strLuong2);
                            
                            kqSoSanh = Double.compare(luong1, luong2);
                        }
                    } catch (Exception e) {
                        kqSoSanh = 0; 
                    }

                    
                    if (sapXep.equals("Giảm dần")) {
                        return -kqSoSanh; 
                    }
                    return kqSoSanh;
                }
            });
        }

        return dstknc;
    }
    public void sapXep(String kieuSapXep){
        java.util.Collections.sort(dsnv, new java.util.Comparator<NhanVienDTO>(){
            @Override
            public int compare(NhanVienDTO nv1 , NhanVienDTO nv2){ 
                java.util.Date d1 = nv1.getNgaySinhNV();
                java.util.Date d2 = nv2.getNgaySinhNV();
                
                if (d1 == null && d2 == null) return 0;
                if (d1 == null) return 1;
                if (d2 == null) return -1;
                
                if(kieuSapXep.equalsIgnoreCase("Tăng dần")){
                    return d1.compareTo(d2);
                } else {
                    return d2.compareTo(d1); 
                }
            }
        });
    }
    
   
    
    public boolean kiemtraEmail(String hoten, String email) {
        for (NhanVienDTO nv : dsnv) {
            if (!hoten.equals(nv.getHoTenNV()) && email.equals(nv.getEmailNV())) 
                return false;
           }
        return true;
    }
    public String layMaNhanVien(String hoten, String email){
        String ma = "";
        for(int i = 0 ; i < dsnv.size() ; i++){
            if(hoten.equals(dsnv.get(i).getHoTenNV()) && email.equals(dsnv.get(i).getEmailNV())){
                ma = dsnv.get(i).getMaNV();
            }
        }
        return ma;
    }
}
