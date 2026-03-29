/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DTO.DienThoaiDTO;
import DAO.NhapHangDAO;
/**
 *
 * @author Admin
 */
import java.util.ArrayList;
import java.util.Vector;
public class DienThoaiBUS {
    NhapHangDAO dao = new NhapHangDAO();
    public ArrayList<Vector> dsdt;

    public void docDS() {

        
        dsdt = dao.getAll();

    }
    public ArrayList<Vector> timKiem(String tuKhoa){

        ArrayList<Vector> ketQua = new ArrayList<>();

        for(Vector v : dsdt){

            String ma = v.get(0).toString().toLowerCase();
            String ten = v.get(1).toString().toLowerCase();

            if(ma.contains(tuKhoa.toLowerCase()) || ten.contains(tuKhoa.toLowerCase())){
                ketQua.add(v);
            }

        }

        return ketQua;
    }
}
