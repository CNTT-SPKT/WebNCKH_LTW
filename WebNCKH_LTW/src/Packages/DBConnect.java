package Packages;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnecttion() {
        Connection cons = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
                    "jdbc:mysql://72.13.93.206:3307/nhom15", "nhom15", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
 
    public static void main(String[] args) {
        System.out.println(getConnecttion());
    }

}

