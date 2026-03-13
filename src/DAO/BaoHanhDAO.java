package DAO;

import DTO.BaoHanhDTO;
import database.Connect;
import java.sql.*;
import java.util.ArrayList;

public class BaoHanhDAO {
    
    public void insertBaoHanh(String ma, int thoiGian) {
        String sql = "INSERT IGNORE INTO baohanh (Ma, ThoiGian) VALUES (?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            ps.setInt(2, thoiGian);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public boolean insertChiTietBaoHanh(String maBH, BaoHanhDTO bh) {
        // Cột trong DB của bạn là 'Ngay', không phải 'NgayBaoHanh'
        String sql = "INSERT INTO chitietbaohanh (MaBH, IMEI, Ngay) VALUES (?, ?, ?)";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maBH);
            ps.setString(2, bh.getImei());
            ps.setDate(3, bh.getNgayBaoHanh()); 
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi tai DAO: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<BaoHanhDTO> selectAllForTable() {
        ArrayList<BaoHanhDTO> list = new ArrayList<>();
        // JOIN bảng 'chitietbaohanh' (ct) và 'dienthoai' (dt) qua IMEI và Ma
        String sql = "SELECT ct.IMEI, dt.Ten, ct.Ngay FROM chitietbaohanh ct JOIN dienthoai dt ON ct.IMEI = dt.Ma";
        try (Connection con = Connect.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new BaoHanhDTO(rs.getString("IMEI"), rs.getString("Ten"), rs.getDate("Ngay")));
            }
        } catch (SQLException e) { System.out.println("Loi SQL selectAll: " + e.getMessage()); }
        return list;
    }
}