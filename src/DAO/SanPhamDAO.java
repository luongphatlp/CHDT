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
            st.setString(index++, sp.getMaSP());
            st.setString(index++, sp.getTenSP()); 
            st.setInt(index++, sp.getSoLuong());
            st.setInt(index++, sp.getDonGia());
            st.setString(index++, sp.getDonViTinh());
            st.setString(index++, sp.getMaHang());
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
        String qry="UPDATE dienthoai SET Ten=?, SoLuong=?, DonGia=?, DonViTinh=?, MaHang=? WHERE Ma=?";
        PreparedStatement st=conn.prepareStatement(qry);
        int index=1;
        st.setString(index++, sp.getTenSP()); 
        st.setInt(index++, sp.getSoLuong());
        st.setInt(index++, sp.getDonGia());  
        st.setString(index++, sp.getDonViTinh());
        st.setString(index++, sp.getMaHang());
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
            sp = new SanPhamDTO();

            sp.setMaSP(rs.getString("Ma"));
            sp.setTenSP(rs.getString("Ten"));
            sp.setDonGia(rs.getInt("DonGia"));
            sp.setMaHang(rs.getString("MaHang"));
            sp.setMau(rs.getString("Mau"));
            sp.setManHinh(rs.getString("ManHinh"));
            sp.setKichThuoc(rs.getString("KichThuocManHinh"));
            sp.setChip(rs.getString("TenChip"));
            sp.setRam(rs.getString("BoNhoTrong"));
            sp.setBoNhoNgoai(rs.getInt("BoNhoNgoai"));
            sp.setCamTruoc(rs.getInt("CameraTruoc"));
            sp.setCamSau(rs.getInt("CameraSau"));
            sp.setPin(rs.getInt("Pin"));
            sp.setHeDieuHanh(rs.getString("HeDieuHanh"));
            sp.setBaoHanh(rs.getInt("ThoiHanBaoHanh"));
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
             st.setString(1, sp.getMaSP());
             st.setString(2, sp.getMau());
             st.setString(3, sp.getManHinh());
             st.setString(4, sp.getKichThuoc());
             st.setString(5, sp.getChip());
             st.setString(6, sp.getRam());
             st.setInt(7, sp.getBoNhoNgoai());
             st.setInt(8, sp.getCamTruoc());
             st.setInt(9, sp.getCamSau());
             st.setInt(10, sp.getPin());
             st.setString(11, sp.getHeDieuHanh());
             st.setInt(12, sp.getBaoHanh());
             result = st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
        return result;
    }
    public int updateChiTiet(SanPhamDTO sp) {
       int result = 0;
       String qry = "UPDATE chitietdienthoai SET Mau=?, ManHinh=?, KichThuocManHInh=?, TenChip=?, BoNhoTrong=?, BoNhoNgoai=?, CameraTruoc=?, CameraSau=?, Pin=?, HeDieuHanh=?, ThoiHanBaoHanh=? WHERE Ma=?";
       try (Connection conn = Connect.getConnection();
            PreparedStatement st = conn.prepareStatement(qry)) {
            st.setString(1, sp.getMau());
            st.setString(2, sp.getManHinh());
            st.setString(3, sp.getKichThuoc());
            st.setString(4, sp.getChip());
            st.setString(5, sp.getRam());
            st.setInt(6, sp.getBoNhoNgoai());
            st.setInt(7, sp.getCamTruoc());
            st.setInt(8, sp.getCamSau());
            st.setInt(9, sp.getPin());
            st.setString(10, sp.getHeDieuHanh());
            st.setInt(11, sp.getBaoHanh());
            st.setString(12, sp.getMaSP());
            result = st.executeUpdate();
        } catch (SQLException ex) { ex.printStackTrace(); }
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