/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import DTO.NhapHangDTO;
import DAO.NhapHangDAO;

public class NhapHangBUS {
    public static ArrayList<NhapHangDTO> dsnh;
    public NhapHangBUS(){}
    public void docDSNH() {
        NhapHangDAO data = new NhapHangDAO();
        if(dsnh == null) dsnh = new ArrayList<NhapHangDTO>();
        dsnh = data.selectAll();
    }
    public void them(NhapHangDTO nh){
        for (NhapHangDTO p : dsnh) {
            if (p.getMamay().equals((nh.getMamay()))) {
                return; //cái này phải làm thêm báo lỗi
            }
        }
        NhapHangDAO data = new NhapHangDAO();
        data.insert(nh);
        dsnh.add(nh);
    }
    public boolean sua(NhapHangDTO nh) {
        NhapHangDAO data = new NhapHangDAO();
        for (int i = 0; i < dsnh.size(); i++) {
            if (dsnh.get(i).getMamay().equals((nh.getMamay()))) {
                data.update(nh);       // Cập nhật database
                dsnh.set(i, nh);       // Cập nhật ArrayList
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public boolean xoa(String mamay) {
        NhapHangDAO data = new NhapHangDAO();

        for (int i = 0; i < dsnh.size(); i++) {
            if (dsnh.get(i).getMamay().equals((mamay))) {
                NhapHangDTO nh = dsnh.get(i);
                data.delete(nh);     // Xóa database
                dsnh.remove(i);       // Xóa trong danh sách
                return true;
            }
        }
        return false; // Không tìm thấy
    }
    public ArrayList<NhapHangDTO> timKiem(String tuKhoa) {
        ArrayList<NhapHangDTO> ketQua = new ArrayList<>();
        for (NhapHangDTO pn : dsnh) {
            if (pn.getMamay().equals(tuKhoa)
                || pn.getTenmay().equals(tuKhoa)) {
                ketQua.add(pn);
            }
        }
        return ketQua;
    }
}
