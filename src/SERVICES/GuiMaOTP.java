package SERVICES;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class GuiMaOTP {
 
    // 1. Hàm tạo mã OTP 6 số ngẫu nhiên
    public String generateOTP() {
        Random rand = new Random();
        int otp = 100000 + rand.nextInt(900000);
        return String.valueOf(otp);
    }

    // 2. Hàm gửi Mail (Sử dụng Jakarta Mail 2.0.2)
    public boolean sendOTP(String toEmail, String otpCode) {
        // Cấu hình Email gửi đi (Gmail)
        final String fromEmail = "singapothinh0711@gmail.com"; 
        final String appPassword = "vbxv chey ysok nruo"; // Mật khẩu ứng dụng 16 ký tự

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo phiên làm việc (Session)
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, appPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            
            // Nội dung email
            message.setSubject("Mã xác thực OTP - Quên mật khẩu");
            message.setText("Chào bạn,\n\nMã OTP để khôi phục mật khẩu của bạn là: " + otpCode 
                          + "\n\nMã này có hiệu lực trong 5 phút. Vui lòng không chia sẻ mã này cho bất kỳ ai.");

            Transport.send(message);
            System.out.println("Gửi mail thành công tới: " + toEmail);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        GuiMaOTP service = new GuiMaOTP();
        String code = service.generateOTP();
        
        // Thay bằng email thật của bạn để nhận thử nhé
        boolean check = service.sendOTP("Gmail", code);
        
        if(check) {
            System.out.println("Hãy kiểm tra hòm thư của bạn!");
        } else {
            System.out.println("Gửi mail thất bại, hãy kiểm tra lại cấu hình.");
        }
    }
}

