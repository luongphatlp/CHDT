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

import DTO.NhapHangDTO;
import DTO.DienThoaiDTO;
import java.util.Vector;
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
            String qry = "INSERT INTO hang(Ma, Ten) VALUES ("
            + "'" + nh.getMamay() + "',"
            + "'" + nh.getTenmay() + "')";        
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
        String qry="Update hang Set";
        qry+=" "+"Ten="+"'"+nh.getTenmay()+"'";
        qry+=" WHERE Ma='"+nh.getMamay()+"'";
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
        String qry="Delete from hang where MaMay='"+nh.getMamay()+"'";
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
        String qry="Select * from hang";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                NhapHangDTO nh=new NhapHangDTO();
                nh.setMamay(rs.getString(1));
                nh.setTenmay(rs.getString(2));
                ds.add(nh);
            }
        }catch(SQLException ex) {
            System.getLogger(NhapHangDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
    public ArrayList<Vector> getAll(){

        ArrayList<Vector> list = new ArrayList<>();

        try{
            Connection con = Connect.getConnection();
            String sql = "SELECT Ma, Ten, DonGia FROM dienthoai";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Vector vector = new Vector();
                DienThoaiDTO dt = new DienThoaiDTO();

                dt.setMa(rs.getString("Ma"));
                dt.setTen(rs.getString("Ten"));
                dt.setDonGia(rs.getInt("DonGia"));
                vector.add(dt.getMa());
                vector.add(dt.getTen());
                vector.add(dt.getDonGia());
                
                list.add(vector);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }    
}
