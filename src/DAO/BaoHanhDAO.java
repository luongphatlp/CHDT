package DAO;

import DTO.BaoHanhDTO;
import DATABASE.Connect;
import java.sql.*;
import java.util.ArrayList;

public class BaoHanhDAO {
    
    public int insert(BaoHanhDTO bh) {
        int r=-1;
        String sql = "INSERT INTO baohanh (MaBH,MaNV,MaKH,NgayLap) VALUES (?, ?,?,?)";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bh.getMaBH());
            ps.setString(2, bh.getMaNV());
            ps.setString(3, bh.getMaKH());        
            ps.setDate(4, java.sql.Date.valueOf(bh.getNgayLap()));
            r= ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        return r;
    }

    public ArrayList<BaoHanhDTO> selectAll(){
        ArrayList<BaoHanhDTO> ds=new ArrayList<>();
        String qry="SELECT * FROM baohanh";
        try(Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();) 
        {
             while(rs.next()){
                 BaoHanhDTO bh=new BaoHanhDTO();
                 bh.setMaBH(rs.getString("MaBH"));
                 bh.setMaNV(rs.getString("MaNV"));
                 bh.setMaKH(rs.getString("MaKH"));
                 bh.setNgayLap(rs.getDate("NgayLap").toLocalDate());
                 ds.add(bh);
             }
        } catch (SQLException e) { e.printStackTrace(); }
        return ds;
    }
    public int update(BaoHanhDTO bh){
        int r=-1;
        String sql = "UPDATE  baohanh SET MaNV=?,MaKH=?,ThoiGian=? WHERE MaBH=? ";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bh.getMaNV());
            ps.setString(2, bh.getMaKH());        
            ps.setDate(3, java.sql.Date.valueOf(bh.getNgayLap()));
            ps.setString(4, bh.getMaBH());
            r= ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        return r;
    }
    public int delete(String mabh){
        int r=-1;
         String sql = "DELETE  baohanh WHERE MaBH=? ";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mabh);
            r= ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        return r;
    }
    public String layMaBHMax() {
        String sql = "SELECT MAX(MaBH) FROM baohanh";
        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}