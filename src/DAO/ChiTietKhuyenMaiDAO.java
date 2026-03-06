
package DAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.SanPhamDTO;
import database.Connect;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietKhuyenMaiDAO implements InterfaceDAO<ChiTietKhuyenMaiDTO> {
    public ChiTietKhuyenMaiDAO(){}
    @Override
    public int insert(ChiTietKhuyenMaiDTO km){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="INSERT INTO chitietkhuyenmai(makm,masp,phantram) VALUES (?,?,?)";
            PreparedStatement st=conn.prepareStatement(qry);
            int index=1;
            st.setString(index++,km.getMaKM());
            st.setString(index++,km.getSanPham().getMaSP());
            st.setInt(index++,km.getPhanTram());
            result=st.executeUpdate();
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }       
        return result;
    }
    @Override 
    public ArrayList<ChiTietKhuyenMaiDTO> selectAll(){
        ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qty="SELECT MaKhuyenMai MaSanPham sp.Ten km.PhanTram  FROM chitietkhuyenmai km JOIN dienthoai sp ON km.MaSP=sp.Ma";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qty);
            while(rs.next()){
                ChiTietKhuyenMaiDTO km=new ChiTietKhuyenMaiDTO();
                km.setMaKM(rs.getString(1));
                SanPhamDTO sp=new SanPhamDTO(rs.getString(2),rs.getString(3),0,"","","");
                km.setSanPham(sp);
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
        try(Connection conn=Connect.getConnection()){
            String qry = "DELETE FROM chitietkhuyenmai "
                   + "WHERE MaKhuyenMai=? AND MaSanPham=?";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setString(1,km.getMaKM());
            st.setString(2,km.getSanPham().getMaSP());
            result=st.executeUpdate();
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);   
        }
        return result;
    }
    @Override 
    public int update(ChiTietKhuyenMaiDTO km){
        int result=0;
        try(Connection conn=Connect.getConnection()){
        String qry="Update FROM chitietkhuyenmai SET"
                +"PhanTram=? WHERE MaKhuyenMai=? AND MaSanPham=?";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setInt(1,km.getPhanTram());
            st.setString(2,km.getMaKM());
            st.setString(3,km.getSanPham().getMaSP());
           result= st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
        return result;
    }
}
