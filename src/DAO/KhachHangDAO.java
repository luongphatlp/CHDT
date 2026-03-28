
package DAO;

import DTO.KhachHangDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DTO.KhachHangDTO;
import DATABASE.Connect;
import java.util.ArrayList;

public class KhachHangDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Lấy tất cả khách hàng
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> list = new ArrayList<>();

        String sql = "SELECT * FROM khachhang";

        try {
            conn = Connect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                KhachHangDTO kh = new KhachHangDTO();

                kh.setMa(rs.getString("Ma"));
                kh.setHoten(rs.getString("HoTen"));
                kh.setDt(rs.getString("SDT"));
                kh.setEmail(rs.getString("Email"));

                list.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Thêm khách hàng
        public boolean insert(KhachHangDTO kh) {

            String sql = "INSERT INTO khachhang(Ma, HoTen, SDT, Email)  VALUES (?,?,?,?)";

            try {
                conn = Connect.getConnection();
                ps = conn.prepareStatement(sql);

                ps.setString(1, kh.getMa());
                ps.setString(2, kh.getHoten());
                ps.setString(3, kh.getDt());
                ps.setString(4, kh.getEmail());

                return ps.executeUpdate() > 0;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

    // Sửa khách hàng
    public boolean update(KhachHangDTO kh) {

        String sql = "UPDATE khachhang SET HoTen=?, SDT=?, Email=? WHERE Ma=?";

        try {
            conn = Connect.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, kh.getHoten());
            ps.setString(2, kh.getDt());
            ps.setString(3, kh.getEmail());
            ps.setString(4, kh.getMa());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Xóa khách hàng
    public boolean delete(String ma) {

        String sql = "DELETE FROM khachhang WHERE Ma=?";

        try {
            conn = Connect.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, ma);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public String layMaKHMax(){
        String sql = "SELECT MAX(Ma) FROM khachhang";

        try (
            Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
