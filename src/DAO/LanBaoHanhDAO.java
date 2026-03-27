package DAO;

import DATABASE.Connect;
import DTO.LanBaoHanhDTO;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class LanBaoHanhDAO {

    // ================= THÊM LẦN BẢO HÀNH =================
    public boolean them(LanBaoHanhDTO lbh) {
        String sql = "INSERT INTO lan_baohanh(IMEI, ngayNhan, tinhTrang, xuLy, trangThai) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, lbh.getIMEI());
            ps.setDate(2, Date.valueOf(lbh.getNgayNhan()));
            ps.setString(3, lbh.getTinhTrang());

            // tránh null
            ps.setString(4, lbh.getXuLy() == null ? "" : lbh.getXuLy());
            ps.setString(5, lbh.getTrangThai());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ================= LẤY DANH SÁCH =================
    public ArrayList<LanBaoHanhDTO> getByMaCTBH(String imei) {
        ArrayList<LanBaoHanhDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM lan_baohanh WHERE IMEI = ? ORDER BY ngayNhan DESC";

        try (Connection conn = Connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, imei);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LanBaoHanhDTO lbh = new LanBaoHanhDTO();

                lbh.setMaLanBH(rs.getInt("maLanBH"));
                lbh.setIMEI(rs.getString("IMEI"));

                // Ngày nhận
                Date ngayNhan = rs.getDate("ngayNhan");
                if (ngayNhan != null) {
                    lbh.setNgayNhan(ngayNhan.toLocalDate());
                }

                // Ngày trả (có thể NULL)
                Date ngayTra = rs.getDate("ngayTra");
                if (ngayTra != null) {
                    lbh.setNgayTra(ngayTra.toLocalDate());
                }

                lbh.setTinhTrang(rs.getString("tinhTrang"));
                lbh.setXuLy(rs.getString("xuLy"));
                lbh.setTrangThai(rs.getString("trangThai"));

                list.add(lbh);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================= CẬP NHẬT (HOÀN THÀNH) =================
    public boolean capNhatTrangThai(int maLanBH, String xuLy, String trangThai) {
        String sql = "UPDATE lan_baohanh SET xuLy = ?, trangThai = ?, ngayTra = ? WHERE maLanBH = ?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, xuLy);
            ps.setString(2, trangThai);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setInt(4, maLanBH);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // ================= (OPTIONAL) LẤY THEO ID =================
    public LanBaoHanhDTO getById(int maLanBH) {
        String sql = "SELECT * FROM lan_baohanh WHERE maLanBH = ?";

        try (Connection conn = Connect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, maLanBH);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                LanBaoHanhDTO lbh = new LanBaoHanhDTO();

                lbh.setMaLanBH(rs.getInt("maLanBH"));
                lbh.setIMEI(rs.getString("IMEI"));

                Date ngayNhan = rs.getDate("ngayNhan");
                if (ngayNhan != null) lbh.setNgayNhan(ngayNhan.toLocalDate());

                Date ngayTra = rs.getDate("ngayTra");
                if (ngayTra != null) lbh.setNgayTra(ngayTra.toLocalDate());

                lbh.setTinhTrang(rs.getString("tinhTrang"));
                lbh.setXuLy(rs.getString("xuLy"));
                lbh.setTrangThai(rs.getString("trangThai"));

                return lbh;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}