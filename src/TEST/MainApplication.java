package TEST;

import GUI.Login;

/**
 *
 * @author THANH NHAN
 */
public class MainApplication {

    public static void main(String[] args) {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        
        Login login = new Login();
        
        login.setVisible(true);
    }
}
