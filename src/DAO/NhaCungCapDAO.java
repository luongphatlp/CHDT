package DAO;

import DATABASE.Connect;
import DTO.NhaCungCapDTO;
import java.sql.*;
import java.util.ArrayList;

public class NhaCungCapDAO {
    
    public int insert(NhaCungCapDTO ncc) {
        int result = 0;
        String qry = "INSERT INTO nhacungcap (Ma, Ten, DiaChi, SDT) VALUES (?, ?, ?, ?)";
        try (Connection conn = Connect.getConnection();
             PreparedStatement st = conn.prepareStatement(qry)) {
            st.setString(1, ncc.getMaNCC());
            st.setString(2, ncc.getTenNCC());
            st.setString(3, ncc.getDiaChi());
            st.setString(4, ncc.getSoDienThoai());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int update(NhaCungCapDTO ncc) {
        int result = 0;
        String qry = "UPDATE nhacungcap SET Ten=?, DiaChi=?, SDT=? WHERE Ma=?";
        try (Connection conn = Connect.getConnection();
             PreparedStatement st = conn.prepareStatement(qry)) {
            st.setString(1, ncc.getTenNCC());
            st.setString(2, ncc.getDiaChi());
            st.setString(3, ncc.getSoDienThoai());
            st.setString(4, ncc.getMaNCC());
            result = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int delete(String ma) {
        int result = 0;
        String qry = "DELETE FROM nhacungcap WHERE Ma=?";
        try (Connection conn = Connect.getConnection();
             PreparedStatement st = conn.prepareStatement(qry)) {
            st.setString(1, ma);
            result = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> selectAll() {
        ArrayList<NhaCungCapDTO> ds = new ArrayList<>();
        String qry = "SELECT * FROM nhacungcap";
        try (Connection conn = Connect.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(qry)) {
            while (rs.next()) {
                ds.add(new NhaCungCapDTO(
                    rs.getString("Ma"),
                    rs.getString("Ten"),
                    rs.getString("DiaChi"),
                    rs.getString("SDT")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
}