/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.Random;

/**
 *
 * @author THANH NHAN
 */
public class ImeiGeneratorBUS {
    public static String generateImei() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < 10) {
            result.append(characters.charAt(rnd.nextInt(characters.length())));
        }
        return result.toString();
    }
}
