package DAO;

import DTO.BaoHanhDTO;
import DATABASE.Connect;
import java.sql.*;
import java.util.ArrayList;

public class BaoHanhDAO {
    
    public int insert(BaoHanhDTO bh) {
        int r=-1;
        String sql = "INSERT INTO baohanh (Ma,MaNV,MaKH,ThoiGian) VALUES (?, ?,?,?)";
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
                 bh.setMaBH(rs.getString(1));
                 bh.setMaNV(rs.getString(2));
                 bh.setMaKH(rs.getString(3));
                 bh.setNgayLap(rs.getDate(4).toLocalDate());
                 ds.add(bh);
             }
        } catch (SQLException e) { e.printStackTrace(); }
        return ds;
    }
    public int update(BaoHanhDTO bh){
        int r=-1;
        String sql = "UPDATE  baohanh SET MaNV=?,MaKH=?,ThoiGian=? WHERE Ma=? ";
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
         String sql = "DELETE  baohanh WHERE Ma=? ";
        try (Connection con = Connect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mabh);
            r= ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
        return r;
    }
    public String taoMaBH() {
        String sql = "SELECT MAX(Ma) FROM baohanh";
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
            return "BH01";
        }

        int so = Integer.parseInt(maMax.substring(2));
        return String.format("BH%02d", so + 1);
}

   /* public ArrayList<BaoHanhDTO> selectAll() {
        ArrayList<BaoHanhDTO> list = new ArrayList<>();
        // JOIN bảng 'chitietbaohanh' (ct) và 'dienthoai' (dt) qua IMEI và Ma
        String sql = "SELECT ct.IMEI, dt.Ten, ct.Ngay FROM chitietbaohanh ct JOIN dienthoai dt ON ct.IMEI = dt.Ma";
        try (Connection con = Connect.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                
            }
        } catch (SQLException e) { System.out.println("Loi SQL selectAll: " + e.getMessage()); }
        return list;
    }*/
}