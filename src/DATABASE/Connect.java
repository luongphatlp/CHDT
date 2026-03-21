package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection getConnection() {
        Connection con = null;
        try {
<<<<<<< HEAD

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chdt", "root", "");
=======
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dienthoai", "root", "");
>>>>>>> 5ff258580ce91f3f77beb0d5a68105e6499010ac
        } catch (Exception ex) {
             ex.printStackTrace();

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
