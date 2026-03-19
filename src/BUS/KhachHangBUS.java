/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Latitude E7470
 */
package BUS;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

public class KhachHangBUS {

    private KhachHangDAO khDAO = new KhachHangDAO();
    private ArrayList<KhachHangDTO> listKH;

    // Lấy danh sách khách hàng
    public ArrayList<KhachHangDTO> getDSKH() {
        if (listKH == null) {
            listKH = khDAO.selectAll();
        }
        return listKH;
    }

    // Thêm khách hàng
    public boolean insert(KhachHangDTO kh) {
        boolean check = khDAO.insert(kh);
        if (check) {
            listKH.add(kh);
        }
        return check;
    }

    // Sửa khách hàng
    public boolean update(KhachHangDTO kh) {
        boolean check = khDAO.update(kh);

        if (check) {
            for (KhachHangDTO k : listKH) {
                if (k.getMa().equals(kh.getMa())) {
                    k.setHoten(kh.getHoten());
                    k.setDt(kh.getDt());
                    k.setEmail(kh.getEmail());
                }
            }
        }

        return check;
    }

    // Xóa khách hàng
    public boolean delete(String ma) {
        boolean check = khDAO.delete(ma);

        if (check) {
            listKH.removeIf(k -> k.getMa().equals(ma));
        }

        return check;
    }

}
