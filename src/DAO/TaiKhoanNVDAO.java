/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.Connect;

import DTO.TaiKhoanNVDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author admin
 */
public class TaiKhoanNVDAO {
   public int Insert(TaiKhoanNVDTO tk) {
        int result = 0;
       
        String qry = "INSERT INTO taikhoan (ma, taikhoan, matkhau) VALUES (?, ?, ?)";
        
        try (Connection con = Connect.getConnection();
             PreparedStatement st = con.prepareStatement(qry)) {
            
            st.setString(1, tk.getMaNV());
            st.setString(2, tk.getTaiKhoan());
            st.setString(3, tk.getMatKhau());
            
            result = st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
    public int Update(TaiKhoanNVDTO tk) {
        int result = 0;
        String qry = "UPDATE taikhoan SET taikhoan = ? , matkhau = ? WHERE ma = ?";
        
        try (Connection con = Connect.getConnection();
             PreparedStatement st = con.prepareStatement(qry)) {
            
            st.setString(1, tk.getTaiKhoan());
            st.setString(2, tk.getMatKhau());
            st.setString(3, tk.getMaNV());
            
            result = st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    // 3. Hàm Xóa (Delete)
    public int Delete(String maTK) {
        int result = 0;
        String qry = "DELETE FROM taikhoan WHERE ma = ?";
        
        try (Connection con = Connect.getConnection();
             PreparedStatement st = con.prepareStatement(qry)) {
            
            st.setString(1, maTK);
            
            result = st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    // Thêm hàm này vào class TaiKhoanNVDAO
public ArrayList<TaiKhoanNVDTO> SelectAll() {
    ArrayList<TaiKhoanNVDTO> ds = new ArrayList<>();
    String qry = "SELECT * FROM taikhoan";
    
    try (Connection con = Connect.getConnection();
         PreparedStatement st = con.prepareStatement(qry);
         ResultSet rs = st.executeQuery()) {
        
        while (rs.next()) {
            TaiKhoanNVDTO tk = new TaiKhoanNVDTO();
           
            tk.setMaNV(rs.getString("ma"));
            tk.setTaiKhoan(rs.getString("taikhoan"));
            tk.setMatKhau(rs.getString("matkhau"));
            
            ds.add(tk);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return ds;
}   
  public boolean updatePassword(String matkhau , String ma) {
        String sql = "UPDATE taikhoan SET matkhau = ? WHERE ma = ?";
        try (Connection conn = Connect.getConnection(); java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matkhau);
            ps.setString(2, ma);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
