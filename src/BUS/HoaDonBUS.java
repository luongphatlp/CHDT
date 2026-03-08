/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import javax.swing.JOptionPane;

/**
 *
 * @author THANH NHAN
 */
public class HoaDonBUS {

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
}
