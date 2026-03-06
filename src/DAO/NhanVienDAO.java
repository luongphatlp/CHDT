package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.ArrayList;

import DATABASE.Connect;
import DTO.NhanVienDTO;

public class NhanVienDAO implements InterfaceDAO<NhanVienDTO> {

    @Override
   public int insert(NhanVienDTO nv) {
    int result = 0;
    // Liệt kê rõ ràng 8 cột và dùng 8 dấu hỏi
    String qry = "INSERT INTO nhanvien(ma, hoten, email, ngaysinh, chucvu, taikhoan, matkhau, tinhTrang) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = Connect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(qry)) {
        
        pst.setString(1, nv.getMaNV());
        pst.setString(2, nv.getHotenNV());
        pst.setString(3, nv.getEmailNV());
        pst.setDate(4, (java.sql.Date) nv.getNgaySinh());
        pst.setString(5, nv.getChucVu());
        pst.setString(6, nv.getTaiKhoan());
        pst.setString(7, nv.getMatKhau());
        pst.setBoolean(8, nv.isTinhTrang());

        result = pst.executeUpdate();     
    } catch (SQLException ex) {
        ex.printStackTrace(); // Luôn dùng cái này để thấy lỗi SQL thật sự là gì
    }
    return result;
}

    @Override
    public int update(NhanVienDTO nv) {
       int result =0;
       
       String qry = "UPDATE nhanvien SET hoten=? , Email=? , NgaySinh=?, ChucVu=?, TaiKhoan=? ,Matkhau=?, TinhTrang=? Where Ma=?";
       
       try(Connection conn = Connect.getConnection()){ 
           
        java.sql.PreparedStatement pst = conn.prepareStatement(qry);
        
        pst.setString(1, nv.getHotenNV());
        pst.setString(2, nv.getEmailNV());
        java.sql.Date sqlDate = new java.sql.Date(nv.getNgaySinh().getTime());
        pst.setDate(3, sqlDate);
        pst.setString(4, nv.getChucVu());
        pst.setString(5, nv.getTaiKhoan());
        pst.setString(6, nv.getMatKhau());
        pst.setBoolean(7, nv.isTinhTrang());
        pst.setString(8, nv.getMaNV());
        
        result = pst.executeUpdate();
      
       }catch(SQLException ex){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
       return result;
    }

    @Override
    public int delete(NhanVienDTO ma) {
        int result = 0 ;
         String qry = "Delete from nhanvien where Ma='"+ma.getMaNV()+"'";
       try(Connection conn = Connect.getConnection()){
            Statement st = conn.createStatement();
            result = st.executeUpdate(qry);
       }catch(SQLException ex){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR,(String) null , ex);
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
                nv.setHotenNV(rs.getString(2));
                nv.setEmailNV(rs.getString(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setChucVu(rs.getString(5));
                nv.setTaiKhoan(rs.getString(6));
                nv.setMatKhau(rs.getString(7));
                nv.setTinhTrang(rs.getBoolean(8));
                ds.add(nv);
            }
        }catch(SQLException ex ){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
    
}
