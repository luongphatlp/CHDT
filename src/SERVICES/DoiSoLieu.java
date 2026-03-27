package SERVICES;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */

    

import java.text.DecimalFormat;

public class DoiSoLieu {
    
    
    public static String doiTien(String soTien) {
        try {
            
            double amount = Double.parseDouble(soTien);
            
            
            DecimalFormat formatter = new DecimalFormat("#,###");
            
            return formatter.format(amount);
            
        } catch (Exception e) {
            
            return soTien; 
        }
    }
}