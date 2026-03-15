/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.HoaDonDAO;
import DAO.NhanVienDAO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
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
    ArrayList<HoaDonDTO> ds;
    public HoaDonBUS(){ ds =new ArrayList<>();}
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
        if(ds.size()<10)
            return "HD0"+ds.size();
        else
            return "HD"+ds.size();
    }
public ArrayList<HoaDonDTO> timKiem(String key,String pttt,String nv,
        Date tungay,Date denngay,int tugia,int dengia){

    ArrayList<HoaDonDTO> tam = new ArrayList<>();

    if(ds == null) selectAll();

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
            ktngay = !tungay.after(hd.getNgay()) && !denngay.before(hd.getNgay());
        else if(tungay != null)
            ktngay = !tungay.after(hd.getNgay());
        else if(denngay != null)
            ktngay = !denngay.before(hd.getNgay());

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
}
