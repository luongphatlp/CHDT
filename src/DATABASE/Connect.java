package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection getConnection() {
        Connection con = null;
        try {
<<<<<<< HEAD
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chdt", "root", "");
        } catch (Exception ex) {
             ex.printStackTrace();
=======
            con = DriverManager.getConnection("jdbc:mysql://localhost:3309/dienthoai", "root", "");
        } catch (Exception ex) {

>>>>>>> 84acbee953880661b889efa6a293bbfaeffdaa7a
        }
        return con;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
