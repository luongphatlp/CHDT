/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ThongKeNhanVienDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.Connect;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeNhanVienDAO {
    
    public ArrayList<ThongKeNhanVienDTO> docDS(){
        ArrayList<ThongKeNhanVienDTO> ds=new ArrayList<>();
        String qry="SELECT nv.Ma AS ma,nv.hoten AS hoten ,COUNT(hd.MaHD) AS hoadon, IFNULL(SUM(hd.TongTien),0) AS tongtien "
                + "FROM nhanvien nv "
                + "LEFT JOIN  hoadon hd ON nv.MA=hd.MaNV "
                + "GROUP BY nv.Ma, nv.hoten " ;
        try(Connection conn=Connect.getConnection();
            PreparedStatement ps=conn.prepareStatement(qry);
                ResultSet rs=ps.executeQuery();){
            while(rs.next()){
                ThongKeNhanVienDTO tk=new ThongKeNhanVienDTO();
                tk.setMaNV(rs.getString("ma"));
                tk.setHoTen(rs.getString("hoten"));
                tk.setSoHoaDon(rs.getInt("hoadon"));
                tk.setDoanhThu(rs.getInt("tongtien"));
                ds.add(tk);
            }
            
        }catch(SQLException e){
                e.printStackTrace();
        }
        return ds;
    }
}
