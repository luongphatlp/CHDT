/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.BaoHanhDTO;
import DTO.ChiTietBaoHanhDTO;
import DATABASE.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietBaoHanhDAO {
    
    public boolean insert(ChiTietBaoHanhDTO ctbh) {
        // Cột trong DB của bạn là 'Ngay', không phải 'NgayBaoHanh'
        String sql = "INSERT INTO chitietbaohanh (MaBH, IMEI, NgayHetBaoHanh , TinhTrang , XuLy) VALUES (?, ?, ? ,? ,?)";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,ctbh.getMaBH());
            ps.setString(2,ctbh.getIMEI());
            ps.setDate(3,java.sql.Date.valueOf(ctbh.getNgay()));
            ps.setString(4, ctbh.getTinhTrang());
            ps.setString(5, ctbh.getXuLy());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi tai DAO: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<ChiTietBaoHanhDTO> selectAll(){
        ArrayList<ChiTietBaoHanhDTO> ds=new ArrayList<>();
        String qry="SELECT * FROM chitietbaohanh";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();) {
            while(rs.next()){
                ChiTietBaoHanhDTO ctbh=new ChiTietBaoHanhDTO();
                ctbh.setMaBH(rs.getString(1));
                ctbh.setIMEI(rs.getString(2));
                ctbh.setNgay(rs.getDate(3).toLocalDate());
                ds.add(ctbh);
            }
            
        } catch (SQLException e) {
            System.out.println("Loi tai DAO: " + e.getMessage());
        }
        return ds;
    }
    public void update(ChiTietBaoHanhDTO ctbh){
        String sql = "UPDATE chitietbaohanh SET IMEI=?,NgayHetBaoHanh=? , TinhTrang = ? , XuLy = ? WHERE MaBH=?";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,ctbh.getIMEI());
            ps.setDate(2,java.sql.Date.valueOf(ctbh.getNgay()));
            ps.setString(3,ctbh.getTinhTrang());
            ps.setString(4, ctbh.getXuLy());
            
            ps.setString(5,ctbh.getMaBH());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Loi tai DAO: " + e.getMessage());
        }return;
    }
    public void delete(String ma){
        String sql = "DELETE chitietbaohanh WHERE MaBH=?";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,ma);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Loi tai DAO: " + e.getMessage());
        }
    }
}
