package DAO;

import DTO.KhuyenMaiDTO;
import DATABASE.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhuyenMaiDAO implements InterfaceDAO<KhuyenMaiDTO> {

    public KhuyenMaiDAO() {
    }

    @Override
    public int insert(KhuyenMaiDTO km) {
        int result = 0;
        try (Connection conn = Connect.getConnection()) {
            String qry = "INSERT INTO khuyenmai(Ma,Ten,NgayBatDau,NgayKetThuc,GhiChu) VALUES (?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(qry);
            int index = 1;
            st.setString(index++, km.getMa());
            st.setString(index++, km.getTen());
            st.setDate(index++, java.sql.Date.valueOf(km.getNgayBD()));
            st.setDate(index++, java.sql.Date.valueOf(km.getNgayKT()));
            st.setString(index++, km.getGhiChu());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int delete(KhuyenMaiDTO km) {
        int result = 0;
        try (Connection conn = Connect.getConnection()) {
            String qry = "Delete from khuyenmai where Ma=?";
            PreparedStatement st = conn.prepareStatement(qry);
            st.setString(1, km.getMa());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int update(KhuyenMaiDTO km) {
        int result = 0;
        try (Connection conn = Connect.getConnection()) {
            String qry = "Update khuyenmai Set Ten=?,NgayBatDau=?,NgayKetThuc=?,GhiChu=? WHERE Ma=?";
            PreparedStatement st = conn.prepareStatement(qry);
            int index = 1;
            st.setString(index++, km.getTen());
            st.setDate(index++, java.sql.Date.valueOf(km.getNgayBD()));
            st.setDate(index++, java.sql.Date.valueOf(km.getNgayKT()));
            st.setString(index++, km.getGhiChu());
            st.setString(index++, km.getMa());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<KhuyenMaiDTO> selectAll() {
        ArrayList<KhuyenMaiDTO> ds = new ArrayList<>();
        String qry = "Select * from khuyenmai";
        try (Connection conn = Connect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                km.setMa(rs.getString(1));
                km.setTen(rs.getString(2));
                km.setNgayBD(rs.getDate(3).toLocalDate());
                km.setNgayKT(rs.getDate(4).toLocalDate());
                km.setGhiChu(rs.getString(5));
                ds.add(km);
            }
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }

    public ArrayList<KhuyenMaiDTO> selectActiveKM() {
        ArrayList<KhuyenMaiDTO> ds = new ArrayList<>();
        // Thử truy vấn tất cả trước để kiểm tra kết nối, sau đó mới thêm WHERE
        String qry = "SELECT * FROM khuyenmai WHERE TinhTrang = 1 OR TinhTrang = true";
        try (Connection conn = DATABASE.Connect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(qry);
            while (rs.next()) {
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                km.setMa(rs.getString("Ma")); // Sử dụng tên cột để tránh nhầm chỉ số
                km.setTen(rs.getString("Ten"));
                ds.add(km);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
}
