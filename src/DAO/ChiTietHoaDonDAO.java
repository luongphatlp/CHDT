/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Latitude E7470
 */
import DTO.ChiTietHoaDonDTO;
import DATABASE.Connect;

import java.sql.*;
import java.util.ArrayList;

public class ChiTietHoaDonDAO {

    public int insert(ChiTietHoaDonDTO ct) {
        int result = 0;
        String sql = "INSERT INTO chitiethoadon (MaHD, MaSP, SoLuong, DonGia) VALUES (?, ?, ?, ?)";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, ct.getMaHD());
            ps.setString(2, ct.getMaSP());
            ps.setInt(3, ct.getSoLuong());
            ps.setInt(4, ct.getDonGia());
            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ================== UPDATE ==================
    public int update(ChiTietHoaDonDTO ct) {
        int result = 0;
        String sql = "UPDATE chitiethoadon SET SoLuong = ?, DonGia = ? WHERE MaHD = ? AND MaSP = ?";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, ct.getSoLuong());
            ps.setInt(2, ct.getDonGia());
            ps.setString(3, ct.getMaHD());
            ps.setString(4, ct.getMaSP());

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ================== DELETE ==================
    public int delete(String maHD, String maSP) {
        int result = 0;
        String sql = "DELETE FROM chitiethoadon WHERE MaHD = ? AND MaSP = ?";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, maHD);
            ps.setString(2, maSP);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // ================== SELECT ALL ==================
    public ArrayList<ChiTietHoaDonDTO> selectAll() {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String sql = "SELECT ct.MaHD,ct.MaSP,dt.Ten,ct.SoLuong,ct.DonGia FROM chitiethoadon ct JOIN dienthoai dt ON ct.MaSP=dt.Ma  ";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                ct.setMaHD(rs.getString("MaHD"));
                ct.setMaSP(rs.getString("MaSP"));
                ct.setTenSP(rs.getString("Ten"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getInt("DonGia"));
                ct.setThanhTien(rs.getInt("SoLuong") * rs.getInt("DonGia"));

                ds.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    // ================== SELECT BY MAHD ==================
    public ArrayList<ChiTietHoaDonDTO> selectByMaHD(String maHD) {
        ArrayList<ChiTietHoaDonDTO> ds = new ArrayList<>();
        String sql = "SELECT * FROM chitiethoadon WHERE MaHD = ?";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, maHD);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChiTietHoaDonDTO ct = new ChiTietHoaDonDTO();
                ct.setMaHD(rs.getString("MaHD"));
                ct.setMaSP(rs.getString("MaSP"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getInt("DonGia"));
                ct.setThanhTien(rs.getInt("DonGia")*rs.getInt("SoLuong"));

                ds.add(ct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }


}
