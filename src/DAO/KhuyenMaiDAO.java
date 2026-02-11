/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.KhuyenMaiDTO;
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
public class KhuyenMaiDAO implements InterfaceDAO<KhuyenMaiDTO>{
    
    public KhuyenMaiDAO(){}
    @Override
    public int insert(KhuyenMaiDTO km){   
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry = "INSERT INTO khuyenmai(Ma,Ten,NgayBatDau,NgayKetThuc,GhiChu) VALUES ("
            + "'"+km.getMa()+"'"
            + ",'"+km.getTen()+"'"
            + ",'"+km.getNgayBD()+"'"
            + ",'"+km.getNgayKT()+"'"
            + ",'"+km.getGhiChu()+"')";
            Statement st=conn.createStatement();
            result= st.executeUpdate(qry);
        }catch (SQLException ex) {
                System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    
    @Override
    public int delete(KhuyenMaiDTO ma){
        int result=0;
        String qry="Delete from khuyenmai where Ma='"+ma+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
        return result;
    }
    @Override
    public int update(KhuyenMaiDTO km){
        int result=0;
        String qry="Update khuyenmai Set";
        qry+=" "+"Ten="+"'"+km.getTen()+"'";
        qry+=","+"NgayBatDau="+"'"+km.getNgayBD()+"'";
        qry+=","+"NgayKetThuc="+"'"+km.getNgayKT()+"'";
        qry+=","+"Ghichu="+"'"+km.getGhiChu()+"'";
        qry+=" WHERE Ma='"+km.getMa()+"'";
        try(Connection conn=Connect.getConnection()) {
            Statement st=conn.createStatement();
            result=st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return result;
    }
    @Override
    public ArrayList<KhuyenMaiDTO>  selectAll(){
        ArrayList<KhuyenMaiDTO> ds=new ArrayList<>();
        String qry="Select * from sinhvien";
        try(Connection conn=Connect.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                KhuyenMaiDTO km=new KhuyenMaiDTO();
                km.setMa(rs.getString(1));
                km.setTen(rs.getString(2));
                km.setNgayBD(rs.getString(3));
                km.setNgayKT(rs.getString(4));
                km.setGhiChu(rs.getString(5));
                ds.add(km);
            }
        }catch(SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
}
