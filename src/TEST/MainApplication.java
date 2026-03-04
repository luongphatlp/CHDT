package TEST;

import GUI.Login;

public class MainApplication {

    public static void main(String[] args) {
        com.formdev.flatlaf.intellijthemes.FlatNordIJTheme.setup();
        
        Login login = new Login();
        
        login.setVisible(true);
    }
}
