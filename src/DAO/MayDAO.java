package DAO;

import DTO.MayDTO;
import database.Connect;
import java.sql.*;
import java.util.ArrayList;

public class MayDAO {

    // Lấy toàn bộ máy
    public ArrayList<MayDTO> selectAll() {
        ArrayList<MayDTO> ds = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT * FROM may";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MayDTO m = new MayDTO();
                m.setMasp(rs.getString("MaSP"));
                m.setImei(rs.getString("IMEI"));
                ds.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    // Thêm máy
    public int insert(MayDTO m) {
        int result = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "INSERT INTO may(IMEI, MaSP) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, m.getMasp());
            ps.setString(1, m.getImei());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Xóa máy theo IMEI
    public int delete(String imei) {
        int result = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "DELETE FROM may WHERE IMEI = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, imei);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Tìm máy theo IMEI
    public MayDTO selectByIMEI(String imei) {
        MayDTO m = null;
        try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT * FROM may WHERE IMEI = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, imei);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new MayDTO();
                m.setMasp(rs.getString("MaSP"));
                m.setImei(rs.getString("IMEI"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }
}