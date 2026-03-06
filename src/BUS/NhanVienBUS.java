/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.sql.SQLException;
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

        return String.format("NV%02d", somoi);
    }
        
     
    // kiem tra tinh hop le cua DTO 
    public boolean kiemTraHopLe(NhanVienDTO nvDTO){
       
        //kiem tra tren ho va ten trong
        if(nvDTO.getHotenNV().trim().isEmpty() || nvDTO.getHotenNV().isEmpty()){
            
            return false;
        }
        // kiem tra tai khoan trong
        if(nvDTO.getTaiKhoan().trim().isEmpty() || nvDTO.getTaiKhoan().isEmpty()){
           
            return false;
        }
        // kiem tra mat khau trong
        if(nvDTO.getMatKhau().trim().isEmpty() || nvDTO.getMatKhau().isEmpty()){
            
            return false;
        }   
        //kiem tra email trong
        if(nvDTO.getEmailNV().trim().isEmpty() || nvDTO.getEmailNV().isEmpty()){
            
            return false;
        }
        // kiem tra dinh dang email co phu hop khong
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$";
        
        if(!nvDTO.getEmailNV().matches(regexEmail)){
           
            return false;
        }   
        // kiem tra do tuoi hop le 
        java.util.Date ngaySinh = nvDTO.getNgaySinh();
        if(ngaySinh != null ){
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(ngaySinh);
            
            int namSinh = cal.get(java.util.Calendar.YEAR);
            
            if(namSinh > 2007) {
                
                return false;
            }
            if(namSinh < 1950){
                
                return false;   
            }
        }   
        return true;
    }
    
    
    public boolean them(NhanVienDTO nv){
        //o day can tao mot cai khuan nhanviendao
        //sau do dung phuong phap (them) de nhet vao khuan 
        //sap vao hop dsnv 
        
        boolean hople = kiemTraHopLe(nv);
     
        NhanVienDAO nvDAO = new NhanVienDAO();
        nvDAO.insert(nv);
        dsnv.add(nv);
        return true;
    }
    
    public boolean sua(NhanVienDTO nv){
        boolean hople = kiemTraHopLe(nv);
        if(hople == false){
            return false;
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
            }else if (nv.getHotenNV().contains(muctieu)){
                dstk.add(nv);
            }else if (nv.getChucVu().contains(muctieu)) {
                dstk.add(nv);
            }   
                
        }
        
        return dstk;
    }
    
    public void sapXep(String kieuSapXep){
        java.util.Collections.sort(dsnv, new java.util.Comparator<NhanVienDTO>(){
            @Override
            public int compare(NhanVienDTO nv1 , NhanVienDTO nv2){ 
                java.util.Date d1 = nv1.getNgaySinh();
                java.util.Date d2 = nv2.getNgaySinh();
                
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
    
    
    
    
    
   
    
     
    
}
