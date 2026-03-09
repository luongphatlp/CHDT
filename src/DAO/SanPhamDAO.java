package DAO;

import database.Connect;
import DTO.SanPhamDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamDAO implements InterfaceDAO<SanPhamDTO>{
    
    public SanPhamDAO(){}
    @Override
    public int insert(SanPhamDTO sp){   
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry = "INSERT INTO dienthoai(Ma,Ten,SoLuong,DonGia,DonViTinh,MaHang) VALUES (?,?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(qry);
            int index=1;
            st.setString(index++,sp.getMaSP());
            st.setString(index++, sp.getTen());
            st.setInt(index++, sp.getSoLuong());
            st.setString(index++,sp.getDonGia());
            st.setString(index++, sp.getDonViTinh());
            st.setString(index++, sp.getMaHang());
            result= st.executeUpdate();
        }catch (SQLException ex) {
            System.getLogger(SanPhamDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    
    @Override
    public int delete(SanPhamDTO sp){
        int result=0;
        try(Connection conn=Connect.getConnection()) {
            String qry="Delete from dienthoai where Ma=?";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setString(1, sp.getMaSP());
            result=st.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(SanPhamDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
        return result;
    }
    @Override
    public int update(SanPhamDTO sp){
        int result=0; 
        try(Connection conn=Connect.getConnection()) {
            String qry="Update dienthoai Set Ten=?,DonGia=?,DonViTinh=?,MaHang=? WHERE Ma=?";
            PreparedStatement st=conn.prepareStatement(qry);
            int index=1;
            st.setString(index++, sp.getTen());
            st.setString(index++, sp.getDonGia());
            st.setString(index++, sp.getDonViTinh());
            st.setString(index++, sp.getMaHang());
            st.setString(index++, sp.getMaSP());
            result=st.executeUpdate();
        } catch (SQLException ex) {
            System.getLogger(SanPhamDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public ArrayList<SanPhamDTO> selectAll(){
        ArrayList<SanPhamDTO> ds=new ArrayList<>();
        String qry="Select * from dienthoai";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                SanPhamDTO sp=new SanPhamDTO();
                sp.setMaSP(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getString(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaHang(rs.getString(6));
                ds.add(sp);
            }
        }catch(SQLException ex) {
            System.getLogger(SanPhamDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
    public ArrayList<SanPhamDTO> selectSanPhamKhongTrongKhuyenMai(String ma){
        ArrayList<SanPhamDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry="Select * FROM dienthoai WHERE Ma NOT IN (SELECT MaSanPham FROM chitietkhuyenmai WHERE MaKhuyenMai=?)";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setString(1,ma);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                SanPhamDTO sp=new SanPhamDTO();
                sp.setMaSP(rs.getString(1));
                sp.setTen(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getString(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaHang(rs.getString(6));
                ds.add(sp);
            }
        }catch(SQLException ex) {
            System.getLogger(SanPhamDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
}

