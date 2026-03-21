package DAO;

import database.Connect;
import DTO.SanPhamDTO;
import DTO.ChiTietSanPhamDTO;
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
            String qry = "INSERT INTO dienthoai(Ma,Ten,SoLuong,DonGia,DonViTinh,MaHang,BoNho) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(qry);
            int index=1;
            st.setString(index++, sp.getMaSP());
            st.setString(index++, sp.getTenSP()); 
            st.setInt(index++, sp.getSoLuong());
            st.setInt(index++, sp.getDonGia());
            st.setString(index++, sp.getDonViTinh());
            st.setString(index++, sp.getMaHang());
            st.setString(index++, sp.getBoNho());
            
            result= st.executeUpdate();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int delete(String ma){
        int result=0;
        try(Connection conn=Connect.getConnection()) {
            String qryChiTiet = "DELETE FROM chitietdienthoai WHERE Ma=?";
            PreparedStatement st1 = conn.prepareStatement(qryChiTiet);
            st1.setString(1, ma);
            st1.executeUpdate();
            String qryChinh = "DELETE FROM dienthoai WHERE Ma=?";
            PreparedStatement st2 = conn.prepareStatement(qryChinh);
            st2.setString(1, ma);
            result = st2.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }      
        return result;
    }

    @Override
    public int delete(SanPhamDTO sp) {
        return delete(sp.getMaSP());
    }

@Override
    public int update(SanPhamDTO sp){
        int result=0; 
        try(Connection conn=Connect.getConnection()) {
            String qry="UPDATE dienthoai SET Ten=?, SoLuong=?, DonGia=?, DonViTinh=?, MaHang=?, BoNho=? WHERE Ma=?";
            PreparedStatement st=conn.prepareStatement(qry);
            int index=1;
            st.setString(index++, sp.getTenSP()); 
            st.setInt(index++, sp.getSoLuong());
            st.setInt(index++, sp.getDonGia());  
            st.setString(index++, sp.getDonViTinh());
            st.setString(index++, sp.getMaHang());
            st.setString(index++, sp.getBoNho());
            
            st.setString(index++, sp.getMaSP());
            result=st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
                sp.setMaSP(rs.getString("Ma"));
                sp.setTenSP(rs.getString("Ten"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonGia(rs.getInt("DonGia")); 
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setMaHang(rs.getString("MaHang"));
                sp.setBoNho(rs.getString("BoNho"));
                ds.add(sp);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
     
    public ArrayList<SanPhamDTO> selectSanPhamKhongTrongKhuyenMai(String maKM){
        ArrayList<SanPhamDTO> ds=new ArrayList<>();
        try(Connection conn=Connect.getConnection()){
            String qry="Select * FROM dienthoai WHERE Ma NOT IN (SELECT MaSanPham FROM chitietkhuyenmai WHERE MaKhuyenMai=?)";
            PreparedStatement st=conn.prepareStatement(qry);
            st.setString(1, maKM);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                SanPhamDTO sp=new SanPhamDTO();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setDonGia(rs.getInt(4));
                sp.setDonViTinh(rs.getString(5));
                sp.setMaHang(rs.getString(6));
                ds.add(sp);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return ds;
    }
    public SanPhamDTO selectChiTietByMa(String ma) {
    SanPhamDTO sp = null;
    String qry = "SELECT dt.*, ct.* FROM dienthoai dt " +
                 "JOIN chitietdienthoai ct ON dt.Ma = ct.Ma " +
                 "WHERE dt.Ma = ?";
    try (Connection conn = Connect.getConnection();
         PreparedStatement st = conn.prepareStatement(qry)) {
        st.setString(1, ma);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            sp = new SanPhamDTO(rs.getString("Ma"), rs.getString("Ten"), rs.getInt("SoLuong"), rs.getInt("DonGia"), rs.getString("DonViTinh"), rs.getString("MaHang"));
            ChiTietSanPhamDTO ct = sp.getChiTiet();
            ct.setMau(rs.getString("Mau"));
            ct.setManHinh(rs.getString("ManHinh"));
            ct.setKichThuoc(rs.getString("KichThuocManHInh"));
            ct.setChip(rs.getString("TenChip"));
            ct.setRam(rs.getString("BoNhoTrong"));
            ct.setBoNhoNgoai(rs.getInt("BoNhoNgoai"));
            ct.setCamTruoc(rs.getInt("CameraTruoc"));
            ct.setCamSau(rs.getInt("CameraSau"));
            ct.setPin(rs.getInt("Pin"));
            ct.setHeDieuHanh(rs.getString("HeDieuHanh"));
            ct.setBaoHanh(rs.getInt("ThoiHanBaoHanh"));
        }
    } catch (SQLException ex) { ex.printStackTrace(); }
    return sp;
    }
    public int insertChiTiet(SanPhamDTO sp) {
       int result = 0;
       String qry = "INSERT INTO chitietdienthoai (Ma, Mau, ManHinh, KichThuocManHInh, TenChip, BoNhoTrong, BoNhoNgoai, CameraTruoc, CameraSau, Pin, HeDieuHanh, ThoiHanBaoHanh) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       try (Connection conn = Connect.getConnection();
           PreparedStatement st = conn.prepareStatement(qry)) {
           DTO.ChiTietSanPhamDTO ct = sp.getChiTiet();

           st.setString(1, sp.getMaSP());
           st.setString(2, ct.getMau());
           st.setString(3, ct.getManHinh());
           st.setString(4, ct.getKichThuoc());
           st.setString(5, ct.getChip());
           st.setString(6, ct.getRam());
           st.setInt(7, ct.getBoNhoNgoai());
           st.setInt(8, ct.getCamTruoc());
           st.setInt(9, ct.getCamSau());
           st.setInt(10, ct.getPin());
           st.setString(11, ct.getHeDieuHanh());
           st.setInt(12, ct.getBaoHanh());
           result = st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
        return result;
    }
    public int updateChiTiet(SanPhamDTO sp) {
        int result = 0;
        String qry = "UPDATE chitietdienthoai SET Mau=?, ManHinh=?, KichThuocManHInh=?, TenChip=?, BoNhoTrong=?, BoNhoNgoai=?, CameraTruoc=?, CameraSau=?, Pin=?, HeDieuHanh=?, ThoiHanBaoHanh=? WHERE Ma=?";
        try (Connection conn = Connect.getConnection();
        PreparedStatement st = conn.prepareStatement(qry)) {
        
            DTO.ChiTietSanPhamDTO ct = sp.getChiTiet();

            st.setString(1, ct.getMau());
            st.setString(2, ct.getManHinh());
            st.setString(3, ct.getKichThuoc());
            st.setString(4, ct.getChip());
            st.setString(5, ct.getRam());
            st.setInt(6, ct.getBoNhoNgoai());
            st.setInt(7, ct.getCamTruoc());
            st.setInt(8, ct.getCamSau());
            st.setInt(9, ct.getPin());
            st.setString(10, ct.getHeDieuHanh());
            st.setInt(11, ct.getBaoHanh());
            st.setString(12, sp.getMaSP()); 
        
            result = st.executeUpdate();
         } catch (SQLException ex) { ex.printStackTrace(); }
         return result;
}
    public int truSoLuongSanPham(String maSP, int soLuong) {
        int result = 0;
        String sql = "UPDATE dienthoai SET SoLuong = SoLuong - ? WHERE Ma = ? AND SoLuong >= ?";

        try (
            Connection con = Connect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, soLuong);
            ps.setString(2, maSP);
            ps.setInt(3, soLuong);

            result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public void updateSoLuong(String masp, int soluongThem){

        String sql = "UPDATE dienthoai SET SoLuong = SoLuong + ? WHERE Ma = ?";

        try{Connection conn = Connect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soluongThem);
            ps.setString(2, masp);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}