/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.ThongKeSanPhamDTO;
import DATABASE.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.sql.PreparedStatement;
import java.util.Date;
/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamDAO{

    // 
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPham(){
        ArrayList<ThongKeSanPhamDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry =    
                    "SELECT " +
                    "sp.Ma, " +
                    "sp.Ten, " +
                    "COALESCE(nhap.tongnhap,0) AS tongnhap, "+
                    "COALESCE(ban.tongban,0) AS tongban, "+
                    "COALESCE(nhap.tongnhap,0) - COALESCE(ban.tongban,0) AS tonkho "+
                    
                    "FROM dienthoai sp "+
                    
                    "LEFT JOIN( "+
                    "SELECT MaSP, SUM(SoLuong) tongnhap "+
                    "FROM chitietphieunhap "+
                    "GROUP BY MaSP "+
                    ") nhap ON sp.Ma=nhap.MaSP "+
                    
                    "LEFT JOIN( "+
                    "SELECT MaSP,SUM(SoLuong) tongban "+
                    "FROM chitiethoadon "+
                    "GROUP BY MaSP "+
                    ") ban ON sp.Ma=ban.MaSP ";
            
            PreparedStatement  st=conn.prepareStatement(qry);
            ResultSet rt=st.executeQuery();
            while(rt.next()){
                ThongKeSanPhamDTO tk=new ThongKeSanPhamDTO();
                tk.setMaSP(rt.getString(1));
                tk.setTen(rt.getString(2));
                tk.setTongNhap(rt.getInt(3));
                tk.setTongBan(rt.getInt(4));
                tk.setTonKho(rt.getInt(5));
                ds.add(tk);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return ds;
    }
    //thong ke san pham theo masp,trong khoang 2 ngay
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPhamDieuKien(String key,java.util.Date tuUtil,java.util.Date denUtil) {

        ArrayList<ThongKeSanPhamDTO> ds = new ArrayList<>();

        try (Connection conn = Connect.getConnection()) {

            StringBuilder sql = new StringBuilder();

            sql.append(
                "SELECT sp.Ma, sp.Ten, " +
                "COALESCE(nhap.TongNhap, 0) AS TongNhap, " +
                "COALESCE(ban.TongBan, 0) AS TongBan, " );

            if(tuUtil != null)
                sql.append("COALESCE(nhaptruoc.TongNhapTruoc,0) - COALESCE(bantruoc.TongBanTruoc,0) + COALESCE(nhap.TongNhap, 0) - COALESCE(ban.TongBan, 0) AS TonKho ");
            else
                sql.append("COALESCE(nhap.TongNhap, 0) - COALESCE(ban.TongBan, 0) AS TonKho ");       

            sql.append(
                "FROM dienthoai sp " +

                "LEFT JOIN ( " +
                "   SELECT ctpn.MaSP, SUM(ctpn.SoLuong) AS TongNhap " +
                "   FROM chitietphieunhap ctpn " +
                "   JOIN phieunhap pn ON pn.MaPN = ctpn.MaPN " +
                "   WHERE 1=1 "
            );

            // ===== Điều kiện ngày nhập =====
            if (tuUtil != null) {
                sql.append(" AND pn.Ngay >= ? ");
            }
            if (denUtil != null) {
                sql.append(" AND pn.Ngay <= ? ");
            }

            sql.append(
                " GROUP BY ctpn.MaSP " +
                ") nhap ON sp.Ma = nhap.MaSP " +

                "LEFT JOIN ( " +
                "   SELECT cthd.MaSP, SUM(cthd.SoLuong) AS TongBan " +
                "   FROM chitiethoadon cthd " +
                "   JOIN hoadon hd ON hd.MaHD = cthd.MaHD " +
                "   WHERE 1=1 "
            );

            // ===== Điều kiện ngày bán =====
            if (tuUtil != null) {
                sql.append(" AND hd.Ngay >= ? ");
            }
            if (denUtil != null) {
                sql.append(" AND hd.Ngay <= ? ");
            }

            sql.append(
                " GROUP BY cthd.MaSP " +
                ") ban ON sp.Ma = ban.MaSP " 
            );

            // ===== Tính tồn kho =====
            if(tuUtil != null){
                sql.append(
                    " LEFT JOIN ( "+
                    " SELECT ctpn.MaSP, SUM(ctpn.SoLuong) AS TongNhapTruoc"+
                    " FROM chitietphieunhap AS ctpn "+
                    " JOIN phieunhap AS pn ON pn.MaPN=ctpn.MaPN "+
                    " WHERE pn.Ngay < ? "+
                    " GROUP BY ctpn.MaSP "+
                    " ) nhaptruoc ON sp.Ma = nhaptruoc.MaSP "+
                    " LEFT JOIN ( "+
                    " SELECT cthd.MaSP, SUM(cthd.SoLuong) AS TongBanTruoc"+
                    " FROM chitiethoadon AS cthd "+
                    " JOIN hoadon AS hd ON hd.MaHD=cthd.MaHD "+
                    " WHERE hd.Ngay < ? "+
                    " GROUP BY cthd.MaSP "+
                    " ) bantruoc ON sp.Ma = bantruoc.MaSP "
                );
            }

            sql.append(" WHERE 1=1 ");

            // ===== Điều kiện mã sản phẩm =====
            if (key != null && !key.trim().isEmpty()) {
                sql.append(" AND ( sp.Ma = ? OR sp.Ten LIKE ? )");
            }

            PreparedStatement ps = conn.prepareStatement(sql.toString());

            int index = 1;

            // ===== Set tham số ngày nhập =====
            if (tuUtil != null) {
                ps.setDate(index++, new java.sql.Date(tuUtil.getTime()));
            }
            if (denUtil != null) {
                ps.setDate(index++, new java.sql.Date(denUtil.getTime()));
            }

            // ===== Set tham số ngày bán =====
            if (tuUtil != null) {
                ps.setDate(index++, new java.sql.Date(tuUtil.getTime()));
            }
            if (denUtil != null) {
                ps.setDate(index++, new java.sql.Date(denUtil.getTime()));
            }

            // ===== Set tham số ngày nhập bán trước =====
            if (tuUtil != null) {
                ps.setDate(index++, new java.sql.Date(tuUtil.getTime()));
                ps.setDate(index++, new java.sql.Date(tuUtil.getTime()));
            }

            // ===== Set mã sản phẩm =====
            if (key != null && !key.trim().isEmpty()) {
                ps.setString(index++, key);
                ps.setString(index++,"%" + key + "%");
            }
            ResultSet rt = ps.executeQuery();

            while (rt.next()) {
                ThongKeSanPhamDTO tk = new ThongKeSanPhamDTO();
                tk.setMaSP(rt.getString("Ma"));
                tk.setTen(rt.getString("Ten"));
                tk.setTongNhap(rt.getInt("TongNhap"));
                tk.setTongBan(rt.getInt("TongBan"));
                tk.setTonKho(rt.getInt("TonKho"));
                ds.add(tk);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ds;
        }
    }
