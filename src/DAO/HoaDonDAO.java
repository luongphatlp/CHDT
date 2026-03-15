/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DienThoaiDTO;
import DTO.HoaDonDTO;
import database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static database.Connect.getConnection;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonDAO implements InterfaceDAO<HoaDonDTO> {

    @Override
    public int insert(HoaDonDTO hd) {
        return 0;
    }

    @Override
    public int update(HoaDonDTO hd) {
        return 0;
    }

    @Override
    public int delete(HoaDonDTO hd) {

        return 0;
    }
    
    public ArrayList<HoaDonDTO> selectAll (HoaDonDTO hd) {

        return null;
    }
    
    public ArrayList<DienThoaiDTO> selectAllDienThoai() {
        ArrayList<DienThoaiDTO> ds = new ArrayList<>();
        String sql = "SELECT Ma, Ten, SoLuong, DonGia FROM dienthoai";
        //System.out.println("Connection: " + con);
        try(Connection con = new Connect().getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DienThoaiDTO dt = new DienThoaiDTO(
                        rs.getString("Ma"),
                        rs.getString("Ten"),
                        rs.getInt("SoLuong"),
                        rs.getInt("DonGia")
                );
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
                hd.setNgay(rs.getDate("Ngay"));
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

}
