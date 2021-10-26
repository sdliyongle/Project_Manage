package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbClose {
    /**
     * 关闭 添加功能 
     * @param pstmt,rs,conn
     */
    public static void addClose(PreparedStatement pstmt, Connection conn)
    {
        /*
         * 多个 try-catch 出发点:安全
         */
        try {
            if(pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    /**
     * 关闭资源
     * @param pstmt,rs,conn
     */
    public static void queryClose(PreparedStatement pstmt, ResultSet rs, Connection conn)
    {
        try {
            if(pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
    }
}
