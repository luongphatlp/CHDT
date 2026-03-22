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
    String qry = "INSERT INTO nhanvien(ma, hoten, email, gioitinh , ngaysinh, chucvu, luong , tinhtrang ) "
               + "VALUES (?, ?, ?, ?, ?,?,?,?)";

    try (Connection conn = Connect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(qry)) {
        
        pst.setString(1, nv.getMaNV());
        pst.setString(2, nv.getHoTenNV());
        pst.setString(3, nv.getEmailNV());
        pst.setString(4, nv.getGioiTinhNV());
        pst.setDate(5, (java.sql.Date) nv.getNgaySinhNV());
        pst.setString(6, nv.getChucVuNV());
        pst.setString(7, nv.getLuongNV());
        pst.setBoolean(8, nv.isTinhTrangNV());
        
       

        result = pst.executeUpdate();     
    } catch (SQLException ex) {
        ex.printStackTrace(); // Luôn dùng cái này để thấy lỗi SQL thật sự là gì
    }
    return result;
}

    @Override
    public int update(NhanVienDTO nv) {
       int result =0;
       
       String qry = "UPDATE nhanvien SET hoten=? , email=? , gioitinh = ? , ngaysinh=?, chucVu=? , luong = ? , tinhtrang = ?   Where ma=?";
       
       try(Connection conn = Connect.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(qry)){
        
        pst.setString(1, nv.getHoTenNV());
        pst.setString(2, nv.getEmailNV());
        pst.setString(3, nv.getGioiTinhNV());
        java.sql.Date sqlDate = new java.sql.Date(nv.getNgaySinhNV().getTime());
        pst.setDate(4, sqlDate);
        
        pst.setString(5, nv.getChucVuNV());
        pst.setString(6, nv.getLuongNV());
        pst.setBoolean(7, nv.isTinhTrangNV());
        
        pst.setString(8, nv.getMaNV());
        
        result = pst.executeUpdate();
      
       }catch(SQLException ex){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
       }
       return result;
    }

    @Override
    public int delete(NhanVienDTO ma) {
        int result = 0;
        String qry = "Delete from nhanvien where ma='" + ma.getMaNV() + "'";
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
                nv.setGioiTinhNV(rs.getString(4));
                nv.setNgaySinhNV(rs.getDate(5));
                nv.setChucVuNV(rs.getString(6));
                nv.setLuongNV(rs.getString(7));
                nv.setTinhTrangNV(rs.getBoolean(8));
               
               
                ds.add(nv);
            }
        }catch(SQLException ex ){
            System.getLogger(NhanVienDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
    public int themTuExcel(NhanVienDTO nv) {
        int result = 0;
        // Liệt kê rõ ràng 8 cột và dùng 8 dấu hỏi
        String qry = "INSERT INTO nhanvien(ma, hoten, email, gioitinh, ngaysinh, chucvu, luong, tinhtrang) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection(); java.sql.PreparedStatement pst = conn.prepareStatement(qry)) {

            pst.setString(1, nv.getMaNV());
            pst.setString(2, nv.getHoTenNV());
            pst.setString(3, nv.getEmailNV());
            pst.setString(4, nv.getGioiTinhNV());
            pst.setDate(5, (java.sql.Date) nv.getNgaySinhNV());
            pst.setString(6, nv.getChucVuNV());
            pst.setString(7, nv.getLuongNV());
            pst.setBoolean(8, nv.isTinhTrangNV());

            result = pst.executeUpdate();
        } catch (java.sql.SQLException ex) {
            ex.printStackTrace(); // Luôn dùng cái này để thấy lỗi SQL thật sự là gì
        }
        return result;
    }

}
