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
import java.util.ArrayList;

import DTO.NhapHangDTO;
/**
 *
 * @author Admin
 */
public class NhapHangDAO implements InterfaceDAO<NhapHangDTO>{
        public static NhapHangDAO getInstance() {
        return new NhapHangDAO();
    }
    @Override
    public int insert(NhapHangDTO nh){
        int result = 0;
        try(Connection conn = Connect.getConnection()){
            String qry = "INSERT INTO nhaphang(MaMay, TenMay, DonGia, MaSP, TenSP, SoLuong, Gia) VALUES ("
            + "'" + nh.getMamay() + "'"
            + "'" + nh.getTenmay() + "'"
            + "'" + nh.getDongia() + "'"
            + "'" + nh.getMasp() + "'"
            + "'" + nh.getTensp() + "'"
            + "'" + nh.getSoluong() + "'"
            + "'" + nh.getGia() + "'";        
            Statement st = conn.createStatement();
            result = st.executeUpdate(qry);
        }catch (SQLException ex) {
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int update(NhapHangDTO nh) {
        int result=0;
        String qry="Update nhaphang Set";
        qry+=" "+"TenMay="+"'"+nh.getTenmay()+"'";
        qry+=","+"DonGia="+"'"+nh.getDongia()+"'";
        qry+=","+"MaSP="+"'"+nh.getMasp()+"'";
        qry+=","+"TenSP="+"'"+nh.getTensp()+"'";
        qry+=","+"SoLuong="+"'"+nh.getSoluong()+"'";
        qry+=","+"Gia="+"'"+nh.getGia()+"'";
        qry+=" WHERE MaMay='"+nh.getMamay()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(NhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }

    @Override
    public int delete(NhapHangDTO nh) {
        int result=0;
        String qry="Delete from nhaphang where MaMay='"+nh.getMamay()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(NhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
        return result;    
    }
    @Override
    public ArrayList<NhapHangDTO> selectAll() {
        ArrayList<NhapHangDTO> ds=new ArrayList<>();
        String qry="Select * from nhaphang";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                NhapHangDTO nh=new NhapHangDTO();
                nh.setMamay(rs.getString(1));
                nh.setDongia(rs.getInt(2));
                nh.setMasp(rs.getString(3));
                nh.setTensp(rs.getString(4));
                nh.setSoluong(rs.getInt(5));
                nh.setGia(rs.getInt(6));
                ds.add(nh);
            }
        }catch(SQLException ex) {
            System.getLogger(NhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }    
}
