/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThongKeNhanVienDAO;
import DTO.ThongKeNhanVienDTO;

/**
 *
 * @author Latitude E7470
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ThongKeNhanVienBUS {
    private ArrayList<ThongKeNhanVienDTO> ds;
    private ThongKeNhanVienDAO dao;

    public ThongKeNhanVienBUS() {
        dao = new ThongKeNhanVienDAO();
        ds = new ArrayList<>();
    }

    // Load dữ liệu từ DB
    public ArrayList<ThongKeNhanVienDTO> docDS() {
        ds = dao.docDS();
        return ds;
    }

    // Lấy danh sách
    public ArrayList<ThongKeNhanVienDTO> getDS() {
        return ds;
    }

    // Tìm theo mã NV
    public ThongKeNhanVienDTO timTheoMa(String ma) {
        for (ThongKeNhanVienDTO tk : ds) {
            if (tk.getMaNV().equalsIgnoreCase(ma)) {
                return tk;
            }
        }
        return null;
    }

    // Sắp xếp theo doanh thu giảm dần
    public void sortDoanhThuGiam() {
        Collections.sort(ds, new Comparator<ThongKeNhanVienDTO>() {
            @Override
            public int compare(ThongKeNhanVienDTO o1, ThongKeNhanVienDTO o2) {
                return o2.getDoanhThu() - o1.getDoanhThu();
            }
        });
    }

    // Sắp xếp theo số hóa đơn giảm dần
    public void sortSoHoaDonGiam() {
        Collections.sort(ds, new Comparator<ThongKeNhanVienDTO>() {
            @Override
            public int compare(ThongKeNhanVienDTO o1, ThongKeNhanVienDTO o2) {
                return o2.getSoHoaDon() - o1.getSoHoaDon();
            }
        });
    }

    // Lấy top N nhân viên doanh thu cao nhất
    public ArrayList<ThongKeNhanVienDTO> getTopDoanhThu(int n) {
        sortDoanhThuGiam();
        ArrayList<ThongKeNhanVienDTO> top = new ArrayList<>();
        for (int i = 0; i < Math.min(n, ds.size()); i++) {
            top.add(ds.get(i));
        }
        return top;
    }
}
