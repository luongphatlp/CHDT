/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import database.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DTO.PhieuNhapHangDTO;
/**
 *
 * @author Admin
 */
public class PhieuNhapHangDAO implements InterfaceDAO<PhieuNhapHangDTO>{
        public static PhieuNhapHangDAO getInstance() {
        return new PhieuNhapHangDAO();
    }
    @Override
    public int insert(PhieuNhapHangDTO pnh){
        int result = 0;
        try(Connection conn = Connect.getConnection()){
            String qry = "INSERT INTO phieunhap(MaPN, Ngay, MaNV, MaNCC, TongTien) VALUES ("
            + "'" + pnh.getMapn() + "',"
            + "'" + pnh.getNgay() + "',"
            + "'" + pnh.getManv() + "',"
            + "'" + pnh.getMancc() + "',"
            + "'" + pnh.getTongtien() + "')";
            Statement st = conn.createStatement();
            result = st.executeUpdate(qry);
        }catch (SQLException ex) {
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int update(PhieuNhapHangDTO pnh) {
        int result=0;
        String qry="Update phieunhap Set";
        qry+=" "+"Ngay="+"'"+pnh.getNgay()+"'";
        qry+=","+"MaNV="+"'"+pnh.getManv()+"'";
        qry+=","+"MaNCC="+"'"+pnh.getMancc()+"'";
        qry+=","+"TongTien="+"'"+pnh.getTongtien()+"'";
        qry+=" WHERE MaPN='"+pnh.getMapn()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(PhieuNhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int delete(PhieuNhapHangDTO pnh) {
        int result=0;
        String qry="Delete from phieunhap where MaPN='"+pnh.getMapn()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(PhieuNhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
        return result;    
    }
    @Override
    public ArrayList<PhieuNhapHangDTO> selectAll() {
        ArrayList<PhieuNhapHangDTO> ds=new ArrayList<>();
        String qry="Select * from phieunhap";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                PhieuNhapHangDTO pnh=new PhieuNhapHangDTO();
                pnh.setMapn(rs.getString(1));
                pnh.setNgay(rs.getString(2));
                pnh.setManv(rs.getString(3));
                pnh.setMancc(rs.getString(4));
                pnh.setTongtien(rs.getInt(5));
                ds.add(pnh);
            }
        }catch(SQLException ex) {
            System.getLogger(PhieuNhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }    
    public PhieuNhapHangDTO getByID(String maPN) {
        PhieuNhapHangDTO pn = null;
        String sql = "SELECT * FROM phieunhap WHERE MaPN = ?";

        try (Connection conn = Connect.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPN);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pn = new PhieuNhapHangDTO();
                pn.setMapn(rs.getString("MaPN"));
                pn.setManv(rs.getString("MaNV"));
                pn.setMancc(rs.getString("MaNCC"));
                pn.setNgay(rs.getString("Ngay"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pn;
    }
}
