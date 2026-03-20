

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DTO.ChiTietHoaDonDTO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonBUS {
    HoaDonDAO dao=new HoaDonDAO();
    NhanVienBUS busnv=new NhanVienBUS();
    KhachHangBUS buskh=new KhachHangBUS();
    KhuyenMaiBUS buskm=new  KhuyenMaiBUS();
    ArrayList<HoaDonDTO> ds;
    public HoaDonBUS(){
        ds =new ArrayList<>();
        buskm.docDS();
        buskh.getDSKH();
        busnv.docDSNV();
    }
    public void dockm(){buskm.docDS();}
    
    public ArrayList<HoaDonDTO> getDS(){return ds;}
    public boolean checkSoLuong(int soLuongMua, int soLuongTon) {
        if (soLuongMua <= 0) {
            JOptionPane.showMessageDialog(null, "Số lượng phải lớn hơn 0!");
            return false;
        }
        if (soLuongMua > soLuongTon) {
            JOptionPane.showMessageDialog(null, "Số lượng trong kho không đủ!");
            return false;
        }
        return true;
    }

    public int tinhThanhTien(int soLuong, int donGia) {
        return soLuong * donGia;
    }

    
    public int getSoLuongTonTuBang(javax.swing.JTable table, String tenSP) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 1).toString().equals(tenSP)) {
                return Integer.parseInt(table.getValueAt(i, 2).toString());
            }
        }
        return 0;
    }
    public int insert(HoaDonDTO hd){
        return dao.insert(hd);
    }
    public int delete(HoaDonDTO hd){
        return dao.delete(hd);
    }
    public ArrayList<HoaDonDTO> selectAll(){
        ds=dao.selectAll();
        return ds;
    }
    public LocalDateTime chuyenDateThanhLocalDateTime(Date ngay){
        return ngay.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public NhanVienDTO getNVByMaNV(String manv){
        ArrayList<NhanVienDTO> ds =busnv.getDSNV();
        for(NhanVienDTO nv:ds){
            if(nv.getMaNV().equals(manv)){
                return nv;
            }
        }
        return null;
    }
    public KhachHangDTO getKHByMaKH(String makh){
        ArrayList<KhachHangDTO> ds =buskh.getDSKH();
            for(KhachHangDTO kh:ds){
                if(kh.getMa().equals(makh)){
                    return kh;
                }
            }
        return null;
    }
    public String taoMaHD(){
        return dao.taoMaHD();
    }
public ArrayList<HoaDonDTO> timKiem(String key,String pttt,String nv,
        Date tungay,Date denngay,int tugia,int dengia){

    ArrayList<HoaDonDTO> tam = new ArrayList<>();

    if(ds == null) selectAll();
    LocalDateTime tu=chuyenDateThanhLocalDateTime(tungay);
    LocalDateTime den=chuyenDateThanhLocalDateTime(denngay);
   
    for(HoaDonDTO hd : ds){
        
        boolean mahd = true;
        boolean ktpttt = true;
        boolean ktmanv = true;
        boolean ktngay = true;
        boolean ktgia = true;

        if(key != null && !key.equals(""))
            mahd = key.equals(hd.getMaHD());

        if(pttt != null && !pttt.equals(""))
            ktpttt = pttt.equals(hd.getPTTT());

        if(nv != null && !nv.equals("")){
            String manv=nv.split("-")[0];
            ktmanv = manv.equals(hd.getMaNV());
        }
        if(tungay != null && denngay != null)
            ktngay = !tu.isAfter(hd.getNgay()) && !den.isBefore(hd.getNgay());
        else if(tungay != null)
            ktngay = !tu.isAfter(hd.getNgay());
        else if(denngay != null)
            ktngay = !den.isBefore(hd.getNgay());

        if(tugia != 0 || dengia != Integer.MAX_VALUE)
            ktgia = hd.getTongTien() >= tugia && hd.getTongTien() <= dengia;

        if(mahd && ktpttt && ktmanv && ktngay && ktgia)
            tam.add(hd);
    }

    return tam;
}
    public ArrayList<NhanVienDTO> getDSNV(){
        NhanVienBUS bus=new NhanVienBUS();
        return bus.docDSNV();
    }
    public KhachHangDTO layKhachHangBySDT(String sdt){
        KhachHangBUS buskh= new KhachHangBUS();
        for(KhachHangDTO kh:buskh.getDSKH()){
            if(sdt.equals(kh.getDt())){
                return kh;
            }
        }
        return null;
    }
    public String taoMaKH(){
        KhachHangBUS bus=new KhachHangBUS();
        int size=bus.getDSKH().size();
        if(size <10)
            return "KH0"+size;
        else 
            return "KH"+size;
    }
    public void themKH(KhachHangDTO kh){
        KhachHangBUS bus=new KhachHangBUS();
        bus.insert(kh);
    }
    public void insertCTHD(ArrayList<ChiTietHoaDonDTO> ds){
        ChiTietHoaDonBUS bus=new ChiTietHoaDonBUS();
        for(ChiTietHoaDonDTO cthd:ds)
            bus.insert(cthd);
        
    }
    public void capNhatSoLuongSanPham(ArrayList<ChiTietHoaDonDTO> ds){
         SanPhamBUS bus=new SanPhamBUS();
        for(ChiTietHoaDonDTO cthd:ds)
         bus.capNhatSoLuongSanPham(cthd.getMaSP(),cthd.getSoLuong());
    }
    public ArrayList<SanPhamDTO> selectAllDienThoai(){
        return dao.selectAllDienThoai();
    }
    public int tinhTienSauKhuyenMai(ChiTietHoaDonDTO cthd) {
        int tongTien = cthd.getSoLuong() * cthd.getDonGia();
        ArrayList<ChiTietKhuyenMaiDTO> dsKM = buskm.getKMByMaSPConThoiHan(cthd.getMaSP());

        int maxGiam = 0;
        if (dsKM != null) {
                           
            for (ChiTietKhuyenMaiDTO km : dsKM) {
                int giam = tongTien * km.getPhanTram() / 100;
                
                if (giam > maxGiam) {
                    maxGiam = giam;
                }
            }
        }

        return maxGiam;
    }
}
