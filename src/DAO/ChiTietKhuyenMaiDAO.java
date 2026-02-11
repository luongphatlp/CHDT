/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietKhuyenMaiDTO;
import database.Connect;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietKhuyenMaiDAO implements InterfaceDAO<ChiTietKhuyenMaiDTO> {
    public ChiTietKhuyenMaiDAO(){}
    @Override
    public int insert(ChiTietKhuyenMaiDTO km){
        int result=0;
        String qty="INSERT INTO chitietkhuyenmai(makm,masp,phantram) VALUES ("
                + "'" + km.getMaKM() +"',"
                + "'" + km.getMaSP() +"',"
                + "'" + km.getPhanTram() +"')";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            result=st.executeUpdate(qty);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }       
        return result;
    }
    @Override 
    public ArrayList<ChiTietKhuyenMaiDTO> selectAll(){
        String qty="SELECT * FROM chitietkhuyenmai";
        ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qty);
            while(rs.next()){
                ChiTietKhuyenMaiDTO km=new ChiTietKhuyenMaiDTO();
                km.setMaKM(rs.getString(1));
                km.setMaSP(rs.getString(2));
                km.setPhanTram(Integer.parseInt(rs.getString(3)));
                ds.add(km);
            }
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return ds;
    }
    @Override
    public int delete(ChiTietKhuyenMaiDTO km){
        int result=0;
        String qry = "DELETE FROM chitietkhuyenmai "
                   + "WHERE MaKhuyenMai='" + km.getMaKM() + "' "
                   + "AND MaSanPham='" + km.getMaSP() + "'";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);   
        }
        return result;
    }
    @Override 
    public int update(ChiTietKhuyenMaiDTO km){
        int result=0;
        String qry="Update FROM chitietkhuyenmai "
                +"PhanTram='"+km.getPhanTram()+"'"
                +"WHERE MaKhuyenMai='"+km.getMaKM()+"' AND MaSanPham='"+km.getMaSP()+"'";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
           result= st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
        return result;
    }
}
