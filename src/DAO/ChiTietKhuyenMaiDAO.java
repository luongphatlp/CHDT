package DAO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.KhuyenMaiDTO;
import DTO.SanPhamDTO;
import DATABASE.Connect;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietKhuyenMaiDAO {
    public ChiTietKhuyenMaiDAO(){}
    public int insert(ChiTietKhuyenMaiDTO km){
        int result=0;
        try(Connection conn=Connect.getConnection()){
            String qry="INSERT INTO chitietkhuyenmai(MaKM,MaSP,PhanTram) VALUES (?,?,?)";
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
    public ArrayList<ChiTietKhuyenMaiDTO> selectAll(){
        ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qty="SELECT km.MaKhuyenMai, km.MaSanPham, sp.Ten, sp.DonGia, km.PhanTram  FROM chitietkhuyenmai km JOIN dienthoai sp ON km.MaSanPham=sp.Ma";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qty);
            while(rs.next()){
                ChiTietKhuyenMaiDTO km=new ChiTietKhuyenMaiDTO();
                km.setMaKM(rs.getString("MaKhuyenMai"));
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("Ten"));
                sp.setDonGia(rs.getInt("DonGia"));
                km.setSanPham(sp);
                km.setPhanTram(rs.getInt("PhanTram"));
                ds.add(km);
            }
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return ds;
    }
    public ArrayList<ChiTietKhuyenMaiDTO> selectByMaKM(String ma){
        ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry="SELECT km.MaKhuyenMai, km.MaSanPham, sp.Ten, sp.DonGia, km.PhanTram  FROM chitietkhuyenmai km JOIN dienthoai sp ON km.MaSanPham=sp.Ma WHERE km.MaKhuyenMai=?";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setString(1,ma);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                ChiTietKhuyenMaiDTO km=new ChiTietKhuyenMaiDTO();
                km.setMaKM(rs.getString("MaKhuyenMai"));
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("Ten"));
                sp.setDonGia(rs.getInt("DonGia"));
                km.setSanPham(sp);
                km.setPhanTram(rs.getInt("PhanTram"));
                ds.add(km);
            }
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return ds;
    }
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
    public int update(ChiTietKhuyenMaiDTO km){
        int result=0;
        try(Connection conn=Connect.getConnection()){
        String qry="Update chitietkhuyenmai SET PhanTram=? WHERE MaKhuyenMai=? AND MaSanPham=? ";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setInt(1,km.getPhanTram());
            st.setString(2,km.getMaKM());
            st.setString(3,km.getSanPham().getMaSP());
           result= st.executeUpdate();
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
        return result;
    }
    public void updatePhanTramGiam(int phantram,String makm){
        try(Connection conn=Connect.getConnection()){
            String qry="UPDATE chitietkhuyenmai SET PhanTram=? WHERE MaKhuyenMai=?";
            PreparedStatement pt=conn.prepareStatement(qry);
            pt.setInt(1,phantram);
            pt.setString(2,makm);
            pt.executeUpdate();
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
