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
public class DienThoaiBUS {
    public ArrayList<DienThoaiDTO> dsdt;

    public void docDS(){

        NhapHangDAO dao = new NhapHangDAO();
        dsdt = dao.getAll();

    }
}
