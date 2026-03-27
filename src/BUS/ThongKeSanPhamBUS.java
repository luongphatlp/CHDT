/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeSanPhamDAO;
import DATABASE.Connect;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhaCungCapDTO;
import DTO.SanPhamDTO;
import DTO.ThongKeSanPhamDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.sql.ResultSet;

/**
 *
 * @author Latitude E7470
 */
public class ThongKeSanPhamBUS {
    private ArrayList<ThongKeSanPhamDTO> ds;
    NhaCungCapBUS busncc=new NhaCungCapBUS();
    SanPhamBUS busSP = new SanPhamBUS();
    HoaDonBUS busHD = new HoaDonBUS();
    ChiTietHoaDonBUS busCTHD = new ChiTietHoaDonBUS();
    public ThongKeSanPhamBUS(){
        ds=new ArrayList<>();
        busncc.docDS();
    }
    
    public ArrayList<ThongKeSanPhamDTO> getList(){
        return ds;
    }
    //thuc hien thong ke san pham
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPham(){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds=dao.thongKeSanPham();
        return ds;
    }
    public ArrayList<ThongKeSanPhamDTO> thongKeSanPhamDieuKien(String key,Date tu,Date den){
        ThongKeSanPhamDAO dao=new ThongKeSanPhamDAO();
        ds= dao.thongKeSanPhamDieuKien(key,tu,den);
        //thongKeSanPhamDieuKien(String key, Date tu, Date den)
        return ds;
    }
    public static void main(String[] agrs){
        ThongKeSanPhamBUS bus=new ThongKeSanPhamBUS();
        bus.thongKeSanPham();
        System.out.println(bus.getList().get(0).getMaSP());
    }
    public ArrayList<SanPhamDTO> getDSSP(){
        SanPhamBUS bus=new SanPhamBUS();
        bus.docDS();
        return bus.getDS();
    }
    public ArrayList<NhaCungCapDTO> getDSNCC(){
        return busncc.getDS();
    }
    public ArrayList<Object[]> thongKeSanPhamTheoQuy(int nam) {
        ArrayList<Object[]> ketqua = new ArrayList<>();
        int[] tongCotQuy = new int[4];
        int tongTatCa = 0;
        for (SanPhamDTO sp : busSP.getDSSP()) {
            Object[] row = new Object[7];
            row[1] = sp.getMaSP();
            int soluong = 0;
            long[] quy = new long[4];
            long tongNam = 0;
            for (HoaDonDTO hd : busHD.getDSHD()) {
                for (ChiTietHoaDonDTO cthd : busCTHD.getDSSP()) {
                    if (hd.getMaHD().equals(cthd.getMaHD()) && hd.getNgay().getYear() == nam) {
                        if (sp.getMaSP().equals(cthd.getMaSP())) {
                            int q = (hd.getNgay().getMonthValue() - 1) / 3;
                            quy[q] += cthd.getSoLuong();
                            tongNam += cthd.getSoLuong();
                        }
                    }
                }
            }
            row[2] = quy[0];
            row[3] = quy[1];
            row[4] = quy[2];
            row[5] = quy[3];
            row[6] = tongNam;

            for (int i = 0; i < 4; i++) {
                tongCotQuy[i] += quy[i];
            }
            tongTatCa += tongNam;
            ketqua.add(row);
        }
        if (!ketqua.isEmpty()) {
            Object[] finalRow = new Object[7];
            finalRow[1] = "Tổng cộng";
            finalRow[2] = tongCotQuy[0];
            finalRow[3] = tongCotQuy[1];
            finalRow[4] = tongCotQuy[2];
            finalRow[5] = tongCotQuy[3];
            finalRow[6] = tongTatCa;
            ketqua.add(finalRow);
        }
        return ketqua;
    }
}
