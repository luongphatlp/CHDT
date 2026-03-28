
package BUS;

import DAO.ThongKeDoanhThuDAO;
import DTO.ThongKeDoanhThuDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ThongKeDoanhThuBUS {
    public static ArrayList<ThongKeDoanhThuDTO> ds=new ArrayList<>();
    
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNgay(Date tu,Date den){
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        LocalDate tuLocal;
        LocalDate denLocal;
        if(tu!=null)  tuLocal = tu.toInstant()
                         .atZone(ZoneId.systemDefault())
                         .toLocalDate();
        else tuLocal=LocalDate.MIN;
        if(den!=null) denLocal = den.toInstant()
                         .atZone(ZoneId.systemDefault())
                         .toLocalDate();
        else denLocal=LocalDate.MAX;
        if(tu != null && den != null){
            ds=dao.thongKeDoanhThuTheoNgay(tuLocal,denLocal);
            return ds;
        }
        return null;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoThang(int nam){
        if(nam == -1) return null;
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        ds=dao.thongKeDoanhThuTheoThang(nam);
        return ds;
    }
    public ArrayList<ThongKeDoanhThuDTO> thongKeDoanhThuTheoNam(int tu,int den){
        if(tu == -1 & den == -1) return null;
        if(tu==-1) tu=Integer.MIN_VALUE;
        if(den==-1) den=Integer.MAX_VALUE;
        ThongKeDoanhThuDAO dao=new ThongKeDoanhThuDAO();
        ds=dao.thongKeDoanhThuTheoNam(tu,den);
        return ds;
    }
}
