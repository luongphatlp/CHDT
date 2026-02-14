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
/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamDAO implements InterfaceDAO<ThongKeSanPhamDTO>{
    @Override
    public int insert(ThongKeSanPhamDTO tk){
        
    }
    @Override
    public int delete(ThongKeSanPhamDTO tk){
        
    }
    @Override
    public int update(ThongKeSanPhamDTO tk){
        
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
                tk.setMasp(rt.getString(1));
                tk.setTen(rt.getString(2));
                tk.setTongNhap(Integer.parseInt(rt.getString(3)));
                tk.setTongBan(Integer.parseInt(rt.getString(4)));
                tk.setTonKho(Integer.parseInt(rt.getString(5)));
                ds.add(tk);
            }
            return ds;
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
