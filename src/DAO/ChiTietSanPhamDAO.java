/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ChiTietSanPhamDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import DATABASE.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietSanPhamDAO {
    public ArrayList<ChiTietSanPhamDTO> selectAll(){
        ArrayList<ChiTietSanPhamDTO> ds=new ArrayList<>();
        String qry="SELECT * FROM chitietdienthoai";
        try(
            Connection conn=Connect.getConnection();
            PreparedStatement ps=conn.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
        ){
            while(rs.next()){
                ChiTietSanPhamDTO ct=new ChiTietSanPhamDTO();
                ct.setMaSP(rs.getString("Ma"));
                ct.setMau(rs.getString("Mau"));
                ct.setManHinh(rs.getString("ManHinh"));
                ct.setKichThuoc(rs.getString("KichThuocManHInh"));
                ct.setChip(rs.getString("TenChip"));
                ct.setRam(rs.getString("BoNhoTrong"));
                ct.setBoNhoNgoai(rs.getInt("BoNhoNgoai"));
                ct.setCamTruoc(rs.getInt("CameraTruoc"));
                ct.setCamSau(rs.getInt("CameraSau"));
                ct.setPin(rs.getInt("Pin"));
                ct.setHeDieuHanh(rs.getString("HeDieuHanh"));
                ct.setBaoHanh(rs.getInt("ThoiHanBaoHanh"));
                ds.add(ct);
            }
            
        }catch(SQLException e){
            
        }
        return ds;
    } 
}
