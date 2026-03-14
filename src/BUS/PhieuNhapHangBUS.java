/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;
import DTO.PhieuNhapHangDTO;
import DAO.PhieuNhapHangDAO;
/**
 *
 * @author Admin
 */
public class PhieuNhapHangBUS {
    public static ArrayList<PhieuNhapHangDTO> dspn;
    public PhieuNhapHangBUS(){
        if(dspn == null){
         dspn = new ArrayList<>();}
    }
    public void docDSPN() {
        PhieuNhapHangDAO data = new PhieuNhapHangDAO();
        if(dspn == null) dspn = new ArrayList<PhieuNhapHangDTO>();
        dspn = data.selectAll();
    }
    public void them(PhieuNhapHangDTO pn){
        for (PhieuNhapHangDTO p : dspn) {
            if (p.getMapn().equals((pn.getMapn()))) {
                return; //cái này phải làm thêm báo lỗi
            }
        }
        PhieuNhapHangDAO data = new PhieuNhapHangDAO();
        data.insert(pn);
        dspn.add(pn);
    }
    public boolean sua(PhieuNhapHangDTO pn) {
        PhieuNhapHangDAO data = new PhieuNhapHangDAO();
        for (int i = 0; i < dspn.size(); i++) {
            if (dspn.get(i).getMapn().equals((pn.getMapn()))) {
                data.update(pn);       // Cập nhật database
                dspn.set(i, pn);       // Cập nhật ArrayList
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public boolean xoa(String mapn) {
        PhieuNhapHangDAO data = new PhieuNhapHangDAO();

        for (int i = 0; i < dspn.size(); i++) {
            if (dspn.get(i).getMapn().equals((mapn))) {
                PhieuNhapHangDTO pn = dspn.get(i);
                data.delete(pn);     // Xóa database
                dspn.remove(i);       // Xóa trong danh sách
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public boolean kiemTraMaPN(String mapn){

        for(PhieuNhapHangDTO pn : dspn){
            if(pn.getMapn().equals(mapn)){
                return true;
            }
        }
        return false;
    }
    public ArrayList<PhieuNhapHangDTO> timKiem(int tuKhoa) {
        ArrayList<PhieuNhapHangDTO> ketQua = new ArrayList<>();
        for (PhieuNhapHangDTO pn : dspn) {
            if (pn.getMapn().equals(tuKhoa)
                || pn.getMancc().equals(tuKhoa)
                || pn.getManv().equals(tuKhoa)) {
                ketQua.add(pn);
            }
        }
        return ketQua;
    }
}
