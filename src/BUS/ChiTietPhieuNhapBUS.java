/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.ChiTietPhieuNhapDTO;
import DAO.ChiTietPhieuNhapDAO;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class ChiTietPhieuNhapBUS {
    public static ArrayList<ChiTietPhieuNhapDTO> dsct;
    public ChiTietPhieuNhapBUS(){
        if(dsct == null){
         dsct = new ArrayList<>();}
    }
    public void docDSPN() {
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        if(dsct == null) dsct = new ArrayList<ChiTietPhieuNhapDTO>();
        dsct = data.selectAll();
    }
    public ArrayList<ChiTietPhieuNhapDTO> getDS(){
        return dsct;
    }
    public void them(ChiTietPhieuNhapDTO pn){
        for (ChiTietPhieuNhapDTO p : dsct) {
            if (p.getMapn().equals((pn.getMapn()))) {
                return; //cái này phải làm thêm báo lỗi
            }
        }
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        data.insert(pn);
        dsct.add(pn);
    }
    public boolean sua(ChiTietPhieuNhapDTO pn) {
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        for (int i = 0; i < dsct.size(); i++) {
            if (dsct.get(i).getMapn().equals((pn.getMapn()))) {
                data.update(pn);       // Cập nhật database
                dsct.set(i, pn);       // Cập nhật ArrayList
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public boolean xoa(String mapn) {
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();

        for (int i = 0; i < dsct.size(); i++) {
            if (dsct.get(i).getMapn().equals((mapn))) {
                ChiTietPhieuNhapDTO ct = dsct.get(i);
                data.delete(ct);     // Xóa database
                dsct.remove(i);       // Xóa trong danh sách
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public boolean kiemTraMaPN(String mapn){

        for(ChiTietPhieuNhapDTO pn : dsct){
            if(pn.getMapn().equals(mapn)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<ChiTietPhieuNhapDTO> timKiem(int tuKhoa) {
        ArrayList<ChiTietPhieuNhapDTO> ketQua = new ArrayList<>();
        for (ChiTietPhieuNhapDTO pn : dsct) {
            if (pn.getMapn().equals(tuKhoa)
                || pn.getMasp().equals(tuKhoa)) {
                ketQua.add(pn);
            }
        }
        return ketQua;
    }
    public ArrayList<ChiTietPhieuNhapDTO> getByMaPN(String maPN){
        ChiTietPhieuNhapDAO data = new ChiTietPhieuNhapDAO();
        return data.getByMaPN(maPN);
    }
}
