/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DATABASE.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import DTO.ChiTietPhieuNhapDTO;
/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapDAO implements InterfaceDAO<ChiTietPhieuNhapDTO>{
    public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }
    @Override
    public int insert(ChiTietPhieuNhapDTO pnh){
        int result = 0;
        try(Connection conn = Connect.getConnection()){
            String qry = "INSERT INTO chitietphieunhap(MaPN, MaSP, SoLuong, TongTien) VALUES ("
            + "'" + pnh.getMapn() + "',"
            + "'" + pnh.getMasp() + "',"
            + "'" + pnh.getSl() + "',"
            + "'" + pnh.getTongtien() + "')";
            Statement st = conn.createStatement();
            result = st.executeUpdate(qry);
        }catch (SQLException ex) {
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int update(ChiTietPhieuNhapDTO pnh) {
        int result=0;
        String qry="Update chitietphieunhap Set";
        qry+=" "+"MaSP="+"'"+pnh.getMasp()+"'";
        qry+=","+"SoLuong="+"'"+pnh.getSl()+"'";
        qry+=","+"TongTien="+"'"+pnh.getTongtien()+"'";
        qry+=" WHERE MaPN='"+pnh.getMapn()+"' AND MaSP= '"+pnh.getMasp()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(ChiTietPhieuNhapDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int delete(ChiTietPhieuNhapDTO pnh) {
        int result=0;
        String qry="Delete from chitietphieunhap where MaPN='"+pnh.getMapn()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(ChiTietPhieuNhapDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
        return result;    
    }
    @Override
    public ArrayList<ChiTietPhieuNhapDTO> selectAll() {
        ArrayList<ChiTietPhieuNhapDTO> ds=new ArrayList<>();
        String qry="Select * from chitietphieunhap";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                ChiTietPhieuNhapDTO pnh=new ChiTietPhieuNhapDTO();
                pnh.setMapn(rs.getString(1));
                pnh.setMasp(rs.getString(2));
                pnh.setSl(rs.getInt(3));
                pnh.setTongtien(rs.getInt(4));
                ds.add(pnh);
            }
        }catch(SQLException ex) {
            System.getLogger(ChiTietPhieuNhapDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }    
    public ArrayList<ChiTietPhieuNhapDTO> getByMaPN(String maPN){
        ArrayList<ChiTietPhieuNhapDTO> list = new ArrayList<>();
        String qry = "SELECT * FROM chitietphieunhap WHERE MaPN = ?";

        try (Connection conn = Connect.getConnection()){
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setString(1, maPN);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                ChiTietPhieuNhapDTO ct = new ChiTietPhieuNhapDTO();
                ct.setMapn(rs.getString("MaPN"));
                ct.setMasp(rs.getString("MaSP"));
                ct.setSl(rs.getInt("SoLuong"));
                ct.setTongtien(rs.getLong("TongTien"));
                list.add(ct);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
