package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chdt", "root", "");
        } catch (Exception ex) {

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
