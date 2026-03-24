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

/**
 *
 * @author Latitude E7470
 */
public class ThongKeDoanhThuDAO {
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNgay(java.util.Date tuUtil,java.util.Date denUtil){
        ArrayList<ThongKeDoanhThuDTO> ds= new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            StringBuilder qry=new StringBuilder();
                qry.append(
                    "SELECT hd.Ngay AS ngay, COUNT(*) AS hoadon, SUM(hd.TongTien) AS doanhthu "+
                    "FROM hoadon hd "+ 
                    "WHERE 1=1 ");
            
            
            if (tuUtil != null && denUtil != null) {
                qry.append("AND hd.Ngay BETWEEN ? AND ? ");
            }
            
            qry.append(
                    "GROUP BY hd.Ngay "+
                    "ORDER BY hd.Ngay ASC");
            
            PreparedStatement ps=conn.prepareStatement(qry.toString());
            int index=1;
            if (tuUtil != null && denUtil != null) {
                ps.setDate(index++, new java.sql.Date(tuUtil.getTime()));
                ps.setDate(index++, new java.sql.Date(denUtil.getTime()));
            }
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ThongKeDoanhThuDTO tk=new ThongKeDoanhThuDTO();
                tk.setNgay(rs.getString("ngay"));
                tk.setHoaDon(rs.getInt("hoadon"));
                tk.setDoanhThu(rs.getInt("doanhthu"));
                ds.add(tk);
            }
        }catch(SQLException ex){}
        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoThang(int nam){
        ArrayList<ThongKeDoanhThuDTO> ds= new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            StringBuilder qry=new StringBuilder();
                qry.append(
                    "SELECT MONTH(hd.Ngay) AS thang, COUNT(*) AS hoadon, SUM(hd.TongTien) AS doanhthu "+
                    "FROM hoadon hd ");
            
            
            if (nam!=0) {
                qry.append("WHERE YEAR(hd.Ngay) = ? ");
            }
            
            qry.append(
                    "GROUP BY MONTH(hd.Ngay) "+
                    "ORDER BY MONTH(hd.Ngay) ASC");
            
            PreparedStatement ps=conn.prepareStatement(qry.toString());
            
            int index=1;
            if (nam!=0) {
                ps.setInt(index++, nam);
            }
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ThongKeDoanhThuDTO tk=new ThongKeDoanhThuDTO();
                tk.setNgay(rs.getString("thang"));
                tk.setHoaDon(rs.getInt("hoadon"));
                tk.setDoanhThu(rs.getInt("doanhthu"));
                ds.add(tk);
            }
        }catch(SQLException ex){}
        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNam(int tu,int den){
        ArrayList<ThongKeDoanhThuDTO> ds= new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            StringBuilder qry=new StringBuilder();
                qry.append(
                    "SELECT YEAR(hd.Ngay) AS nam, COUNT(*) AS hoadon, SUM(hd.TongTien) AS doanhthu "+
                    "FROM hoadon hd "+ 
                    "WHERE 1=1 ");
            
            
            if (tu != 0 && den != 0) {
                qry.append("AND YEAR(hd.Ngay) BETWEEN ? AND ? ");
            }
            
            qry.append(
                    "GROUP BY YEAR(hd.Ngay) "+
                    "ORDER BY YEAR(hd.Ngay) ASC");
            
            PreparedStatement ps=conn.prepareStatement(qry.toString());
            int index=1;
            if (tu != 0 && den != 0) {
                ps.setInt(index++, tu);
                ps.setInt(index++, den);
            }
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ThongKeDoanhThuDTO tk=new ThongKeDoanhThuDTO();
                tk.setNgay(rs.getString("nam"));
                tk.setHoaDon(rs.getInt("hoadon"));
                tk.setDoanhThu(rs.getInt("doanhthu"));
                ds.add(tk);
            }
        }catch(SQLException ex){}
        return ds;
    }
}
