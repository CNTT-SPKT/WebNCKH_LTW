package Packages;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnecttion() {
        Connection cons = null;
        try {
        	String dbname="nhom15";
        	String dbuser="nhom15";
        	String dbpass="123456";
            Class.forName("com.mysql.jdbc.Driver");
            cons = DriverManager.getConnection(
            "jdbc:mysql://72.13.93.206:3307/"+dbname+"?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", dbuser, dbpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cons;
    }
 
    public static void main(String[] args) {
        System.out.println(getConnecttion());
    }

}

