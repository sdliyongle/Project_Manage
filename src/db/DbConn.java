package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConn {
    public static Connection getconn(String dbName) {
        Connection conn = null;

        String user = "root";
        String passwd = "123456";
        String url = "jdbc:mysql://localhost:3306/"+dbName+"?serverTimezone=GMT%2B8&useSSL=false";
        //已加载完驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库加载成功");
            conn = DriverManager.getConnection(url,user,passwd);
            System.out.println("数据库连接成功");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
