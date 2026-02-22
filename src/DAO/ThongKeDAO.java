/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhuyenMaiDTO;
import DTO.ThongKeDTO;
import database.Connect;
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
public class ThongKeDAO implements InterfaceDAO<ThongKeDTO>{
    @Override
    public int insert(ThongKeDTO tk){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="INSERT INTO thongkesanpham(Ma,Ten,TongNhap,TongBan,TonKho) VALUES ("
                +"'"+tk.getMaSP()+"'"
                +",'"+tk.getTen()+"'"
                +",'"+tk.getTongNhap()+"'"
                +",'"+tk.getTongBan()+"'"
                +",'"+tk.getTonKho()+"')";
            Statement st=conn.createStatement();
            result= st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(ThongKeDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public int delete(ThongKeDTO tk){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="Delete from thongkesanpham where ma='"+tk.getMaSP()+"'";
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(ThongKeDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public int update(ThongKeDTO tk){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="Update thongkekhuyenmai Set";
                    qry+=" "+"Ten="+"'"+tk.getTen()+"'";
                    qry+=","+"TongNhap="+"'"+tk.getTongNhap()+"'";
                    qry+=","+"TongBan="+"'"+tk.getTongBan()+"'";
                    qry+=","+"TonKho="+"'"+tk.getTonKho()+"'";
                    qry+=" WHERE Ma='"+tk.getMaSP()+"'";
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(ThongKeDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
        return result;
    }
    @Override
    public ArrayList<ThongKeDTO> selectAll(){
        ArrayList<ThongKeDTO> ds=new ArrayList<>();
        String qry="Select * from thongkesanpham";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rt= st.executeQuery(qry);
            while(rt.next()){
                ThongKeDTO tk=new ThongKeDTO();
                tk.setMaSP(rt.getString(1));
                tk.setTen(rt.getString(2));
                tk.setTongNhap(Integer.parseInt(rt.getString(3)));
                tk.setTongBan(Integer.parseInt(rt.getString(4)));
                tk.setTonKho(Integer.parseInt(rt.getString(5)));
                ds.add(tk);
            }
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
    // 
    public ArrayList<ThongKeDTO> thongKeSanPham(){
        ArrayList<ThongKeDTO> ds=new ArrayList<>();
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
                ThongKeDTO tk=new ThongKeDTO();
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
public ArrayList<ThongKeDTO> thongKeSanPhamDieuKien(String key,
                                                    java.util.Date tuUtil,
                                                    java.util.Date denUtil) {

    ArrayList<ThongKeDTO> ds = new ArrayList<>();

    try (Connection conn = Connect.getConnection()) {

        StringBuilder sql = new StringBuilder();

        sql.append(
            "SELECT sp.Ma, sp.Ten, " +
            "COALESCE(nhap.TongNhap, 0) AS TongNhap, " +
            "COALESCE(ban.TongBan, 0) AS TongBan, " +
            "COALESCE(nhap.TongNhap, 0) - COALESCE(ban.TongBan, 0) AS TonKho " +
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
            ") ban ON sp.Ma = ban.MaSP " +
            "WHERE 1=1 "
        );

        // ===== Điều kiện mã sản phẩm =====
        if (key != null && !key.trim().isEmpty()) {
            sql.append(" AND sp.Ma = ? ");
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

        // ===== Set mã sản phẩm =====
        if (key != null && !key.trim().isEmpty()) {
            ps.setString(index++, key);
        }

        ResultSet rt = ps.executeQuery();

        while (rt.next()) {
            ThongKeDTO tk = new ThongKeDTO();
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
