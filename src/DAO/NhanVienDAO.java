package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import DTO.NhanVienDTO;

public class NhanVienDAO implements InterfaceDAO<NhanVienDTO> {

    @Override
   public int insert(NhanVienDTO nv) {
    int result = 0;
    // Liệt kê rõ ràng 8 cột và dùng 8 dấu hỏi
    String qry = "INSERT INTO nhanvien(Ma, HoTen, Email, NgaySinh, ChucVu, TinhTrang ) "
               + "VALUES (?, ?, ?, ?, ?,?)";

    try (Connection conn = Connect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(qry)) {
        
        pst.setString(1, nv.getMaNV());
        pst.setString(2, nv.getHoTenNV());
        pst.setString(3, nv.getEmailNV());
        pst.setDate(4, (java.sql.Date) nv.getNgaySinh());
        pst.setString(5, nv.getChucVu());
        pst.setBoolean(6, nv.isTinhTrang());
       

        result = pst.executeUpdate();     
    } catch (SQLException ex) {
        ex.printStackTrace(); // Luôn dùng cái này để thấy lỗi SQL thật sự là gì
    }
    return result;
}

    @Override
    public int update(NhanVienDTO nv) {
       int result =0;
       
       String qry = "UPDATE nhanvien SET HoTen=? , Email=? , NgaySinh=?, ChucVu=?, TinhTrang = ?  Where Ma=?";
       
       try(Connection conn = Connect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(qry)){
        
        pst.setString(1, nv.getHoTenNV());
        pst.setString(2, nv.getEmailNV());
        java.sql.Date sqlDate = new java.sql.Date(nv.getNgaySinh().getTime());
        pst.setDate(3, sqlDate);
        pst.setString(4, nv.getChucVu());
        pst.setBoolean(5, nv.isTinhTrang());
        
        pst.setString(6, nv.getMaNV());
        
        result = pst.executeUpdate();
      
       }catch(SQLException ex){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
       return result;
    }

    @Override
    public int delete(NhanVienDTO ma) {
        int result = 0;
        String qry = "Delete from nhanvien where Ma='" + ma.getMaNV() + "'";
        try (Connection conn = Connect.getConnection()) {
            Statement st = conn.createStatement();
            result = st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> ds = new ArrayList<>();
        String qry = "Select * from nhanvien";
        try(Connection conn = Connect.getConnection()){
            Statement st  = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNV(rs.getString(1));
                nv.setHoTenNV(rs.getString(2));
                nv.setEmailNV(rs.getString(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setChucVu(rs.getString(5));
                nv.setTinhTrang(rs.getBoolean(6));
               
                ds.add(nv);
            }
        }catch(SQLException ex ){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
//    public boolean updatePassword(String email, String newPass) {
//        String sql = "UPDATE nhanvien SET MatKhau = ? WHERE Email = ?";
//        try (Connection conn = Connect.getConnection(); java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
//            ps.setString(1, newPass);
//            ps.setString(2, email);
//            return ps.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    
}