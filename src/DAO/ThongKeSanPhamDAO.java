/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhuyenMaiDTO;
import DTO.ThongKeSanPhamDTO;
import database.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 
import java.sql.PreparedStatement;
/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamDAO implements InterfaceDAO<ThongKeSanPhamDTO>{
    @Override
    public int insert(ThongKeSanPhamDTO tk){
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
            System.getLogger(ThongKeSanPhamDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public int delete(ThongKeSanPhamDTO tk){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="Delete from thongkesanpham where ma='"+tk.getMaSP()+"'";
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(ThongKeSanPhamDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public int update(ThongKeSanPhamDTO tk){
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
            System.getLogger(ThongKeSanPhamDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
        return result;
    }
    @Override
    public ArrayList<ThongKeSanPhamDTO> selectAll(){
        ArrayList<ThongKeSanPhamDTO> ds=new ArrayList<>();
        String qry="Select * from thongkesanpham";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rt= st.executeQuery(qry);
            while(rt.next()){
                ThongKeSanPhamDTO tk=new ThongKeSanPhamDTO();
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
    public ArrayList<ThongKeSanPhamDTO> thongKe(){
        ArrayList<ThongKeSanPhamDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry =    
                    "SELECT " +
                    "sp.Ma, " +
                    "sp.Ten, " +
                    "(SELECT COALESCE(SUM(soLuong),0) FROM chitietphieunhap WHERE MaSP = sp.Ma) AS tongNhap, " +
                    "(SELECT COALESCE(SUM(soLuong),0) FROM chitiethoadon WHERE MaSP = sp.Ma) AS tongBan, " +
                    "(SELECT COALESCE(SUM(soLuong),0) FROM chitietphieunhap WHERE MaSP = sp.Ma) - " +
                    "(SELECT COALESCE(SUM(soLuong),0) FROM chitiethoadon WHERE MaSP = sp.Ma) AS tonKho " +
                    "FROM dienthoai sp";
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
}
