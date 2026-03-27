package BUS;

import DAO.LanBaoHanhDAO;
import DTO.LanBaoHanhDTO;
import java.time.LocalDate;
import java.util.ArrayList;

public class LanBaoHanhBUS {

    private LanBaoHanhDAO dao = new LanBaoHanhDAO();

    // ================= LẤY LỊCH SỬ =================
    public ArrayList<LanBaoHanhDTO> getByIMEI(String maCTBH) {
        return dao.getByMaCTBH(maCTBH);
    }

    // ================= THÊM LẦN BẢO HÀNH =================
    public boolean themLanBaoHanh(String imei, String tinhTrang) {

        // check dữ liệu
        if (imei == null || imei.trim().isEmpty()) {
            System.out.println("Thiếu mã CTBH");
            return false;
        }

        if (tinhTrang == null || tinhTrang.trim().isEmpty()) {
            System.out.println("Chưa nhập tình trạng");
            return false;
        }

        // tạo DTO
        LanBaoHanhDTO lbh = new LanBaoHanhDTO();
        lbh.setIMEI(imei);
        lbh.setNgayNhan(LocalDate.now());
        lbh.setTinhTrang(tinhTrang);
        lbh.setXuLy(""); // chưa xử lý
        lbh.setTrangThai("Đang sửa");

        return dao.them(lbh);
    }

    // ================= HOÀN THÀNH BẢO HÀNH =================
    public boolean hoanThanhBaoHanh(int maLanBH, String xuLy) {

        if (xuLy == null || xuLy.trim().isEmpty()) {
            System.out.println("Chưa nhập xử lý");
            return false;
        }

        return dao.capNhatTrangThai(maLanBH, xuLy, "Hoàn thành");
    }

    // ================= CHECK CÓ LỊCH SỬ =================
    public boolean hasHistory(String maCTBH) {
        ArrayList<LanBaoHanhDTO> list = dao.getByMaCTBH(maCTBH);
        return !list.isEmpty();
    }

    // ================= ĐẾM SỐ LẦN BẢO HÀNH =================
    public int soLanBaoHanh(String imei) {
        return dao.getByMaCTBH(imei).size();
    }
}