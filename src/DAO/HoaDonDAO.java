/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import DATABASE.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
/**
 *
 * @author THANH NHAN
 */
public class HoaDonDAO implements InterfaceDAO<HoaDonDTO> {

    @Override
    public int insert(HoaDonDTO hd) {
        int result = 0;
        String sql = "INSERT INTO hoadon (MaHD, Ngay ,MaNV, MaKH, TongTien,PTTT) VALUES (?, ?, ?, ?, ?,?)";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, hd.getMaHD());
            if(hd.getNgay() != null )
            ps.setTimestamp(2, Timestamp.valueOf(hd.getNgay()));
            ps.setString(3, hd.getMaNV());
            ps.setString(4, hd.getMaKH());
            ps.setInt(5, hd.getTongTien());
            ps.setString(6, hd.getPTTT());

            result = ps.executeUpdate(); // trả về số dòng bị ảnh hưởng (1 = thành công)

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(HoaDonDTO hd) {
        int result = 0;
        String sql = "UPDATE hoadon SET Ngay = ?, MaNV = ?, MaKH = ?, TongTien = ?, PTTT = ? WHERE MaHD = ?";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setTimestamp(1, Timestamp.valueOf(hd.getNgay()));
            ps.setString(2, hd.getMaNV());
            ps.setString(3, hd.getMaKH());
            ps.setInt(4, hd.getTongTien());
            ps.setString(5, hd.getPTTT());
            ps.setString(6, hd.getMaHD()); // điều kiện WHERE

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }   

    @Override
    public int delete(HoaDonDTO hd) {

        return 0;
    }
    
    public ArrayList<HoaDonDTO> selectAll (HoaDonDTO hd) {

        return null;
    }
    
    public ArrayList<SanPhamDTO> selectAllDienThoai() {
        ArrayList<SanPhamDTO> ds = new ArrayList<>();
        String sql = "SELECT Ma, Ten, SoLuong, DonGia FROM dienthoai";
        //System.out.println("Connection: " + con);
        try(Connection con = new Connect().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamDTO dt = new SanPhamDTO();
                dt.setMaSP(rs.getString("Ma"));
                dt.setTenSP(rs.getString("Ten"));
                dt.setSoLuong(rs.getInt("SoLuong"));
                dt.setDonGia(rs.getInt("DonGia"));
                ds.add(dt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ds;
    }

    @Override
    public ArrayList<HoaDonDTO> selectAll() {
        ArrayList<HoaDonDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry="SELECT MaHD, Ngay, MaNV, MaKH, TongTien, PTTT FROM hoadon";
            PreparedStatement ps=conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                HoaDonDTO hd=new HoaDonDTO();
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgay(rs.getTimestamp("Ngay").toLocalDateTime());
                hd.setMaNV(rs.getString("MaNV"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setTongTien(rs.getInt("TongTien"));
                hd.setPTTT(rs.getString("PTTT"));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
        public String taoMaHD() {
        String sql = "SELECT MAX(MaHD) FROM hoadon";
        String maMax = null;

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if (rs.next()) {
                maMax = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (maMax == null) {
            return "HD01";
        }

        int so = Integer.parseInt(maMax.substring(2));
        return String.format("HD%02d", so + 1);
}
}
