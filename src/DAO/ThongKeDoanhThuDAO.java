/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKeDoanhThuDTO;
import DATABASE.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeDoanhThuDAO {
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNgay(LocalDate tuUtil,LocalDate denUtil){
        ArrayList<ThongKeDoanhThuDTO> ds= new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            StringBuilder qry = new StringBuilder();
            qry.append(
                "SELECT tl.Ngay, COALESCE(tl.doanhthu,0) AS doanhthu, " +
                "COALESCE(tc.chiphi,0) AS chiphi, " +
                "(COALESCE(tl.doanhthu,0) - COALESCE(tc.chiphi,0)) AS loinhuan " +
                "FROM (SELECT DATE(hd.Ngay) AS Ngay, SUM(hd.TongTien) AS doanhthu " +
                "      FROM hoadon hd WHERE 1=1 "
            );

            if (tuUtil != null && denUtil != null) {
                qry.append("AND DATE(hd.Ngay) BETWEEN ? AND ? ");
            }

            qry.append(
                "GROUP BY DATE(hd.Ngay)) tl " +
                "LEFT JOIN (SELECT DATE(pn.Ngay) AS Ngay, SUM(pn.TongTien) AS chiphi " +
                "      FROM phieunhap pn WHERE 1=1 "
            );

            if (tuUtil != null && denUtil != null) {
                qry.append("AND DATE(pn.Ngay) BETWEEN ? AND ? ");
            }

            qry.append(
                "GROUP BY DATE(pn.Ngay)) tc " +
                "ON tl.Ngay = tc.Ngay " +
                "ORDER BY tl.Ngay ASC"
            );
            PreparedStatement ps=conn.prepareStatement(qry.toString());
            int index=1;
            if (tuUtil != null && denUtil != null) {
                ps.setDate(index++,  java.sql.Date.valueOf(tuUtil));
                ps.setDate(index++,  java.sql.Date.valueOf(denUtil));
                ps.setDate(index++,  java.sql.Date.valueOf(tuUtil));
                ps.setDate(index++,  java.sql.Date.valueOf(denUtil));
            }
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ThongKeDoanhThuDTO tk=new ThongKeDoanhThuDTO();
                tk.setNgay(rs.getString("Ngay"));
                tk.setLoiNhuan(rs.getInt("loinhuan"));
                tk.setChiPhi(rs.getInt("chiphi"));
                tk.setDoanhThu(rs.getInt("doanhthu"));
                ds.add(tk);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoThang(int nam){
        ArrayList<ThongKeDoanhThuDTO> ds = new ArrayList<>();

        try(Connection conn = Connect.getConnection()){
            StringBuilder qry = new StringBuilder();

            qry.append(
                "SELECT tl.thang, COALESCE(tl.doanhthu,0) AS doanhthu, " +
                "COALESCE(tc.chiphi,0) AS chiphi, " +
                "(COALESCE(tl.doanhthu,0) - COALESCE(tc.chiphi,0)) AS loinhuan " +
                "FROM (SELECT MONTH(hd.Ngay) AS thang, SUM(hd.TongTien) AS doanhthu " +
                "      FROM hoadon hd WHERE YEAR(hd.Ngay) = ? " +
                "      GROUP BY MONTH(hd.Ngay)) tl " +
                "LEFT JOIN (SELECT MONTH(pn.Ngay) AS thang, SUM(pn.TongTien) AS chiphi " +
                "           FROM phieunhap pn WHERE YEAR(pn.Ngay) = ? " +
                "           GROUP BY MONTH(pn.Ngay)) tc " +
                "ON tl.thang = tc.thang " +
                "ORDER BY tl.thang ASC"
            );

            PreparedStatement ps = conn.prepareStatement(qry.toString());

            ps.setInt(1, nam);
            ps.setInt(2, nam);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                ThongKeDoanhThuDTO tk = new ThongKeDoanhThuDTO();

                tk.setNgay(rs.getString("thang"));
                tk.setDoanhThu(rs.getInt("doanhthu"));
                tk.setChiPhi(rs.getInt("chiphi"));
                tk.setLoiNhuan(rs.getInt("loinhuan"));

                ds.add(tk);
            }

        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNam(int tu, int den){
        ArrayList<ThongKeDoanhThuDTO> ds = new ArrayList<>();
        
        try(Connection conn = Connect.getConnection()){
            StringBuilder qry = new StringBuilder();

            qry.append(
                "SELECT tl.nam, COALESCE(tl.doanhthu,0) AS doanhthu, " +
                "COALESCE(tc.chiphi,0) AS chiphi, " +
                "(COALESCE(tl.doanhthu,0) - COALESCE(tc.chiphi,0)) AS loinhuan " +
                "FROM (SELECT YEAR(hd.Ngay) AS nam, SUM(hd.TongTien) AS doanhthu " +
                "      FROM hoadon hd WHERE YEAR(hd.Ngay) BETWEEN ? AND ? " +
                "      GROUP BY YEAR(hd.Ngay)) tl " +
                "LEFT JOIN (SELECT YEAR(pn.Ngay) AS nam, SUM(pn.TongTien) AS chiphi " +
                "           FROM phieunhap pn WHERE YEAR(pn.Ngay) BETWEEN ? AND ? " +
                "           GROUP BY YEAR(pn.Ngay)) tc " +
                "ON tl.nam = tc.nam " +
                "ORDER BY tl.nam ASC"
            );

            PreparedStatement ps = conn.prepareStatement(qry.toString());

            ps.setInt(1, tu);
            ps.setInt(2, den);
            ps.setInt(3, tu);
            ps.setInt(4, den);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                ThongKeDoanhThuDTO tk = new ThongKeDoanhThuDTO();

                tk.setNgay(rs.getString("nam"));         // nên có field riêng
                tk.setDoanhThu(rs.getInt("doanhthu"));
                tk.setChiPhi(rs.getInt("chiphi"));
                tk.setLoiNhuan(rs.getInt("loinhuan"));

                ds.add(tk);
            }

        } catch(SQLException ex){
            ex.printStackTrace();
        }

        return ds;
    }
}
