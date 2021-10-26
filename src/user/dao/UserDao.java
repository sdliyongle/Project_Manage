package user.dao;


import db.DbConn;
import user.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        String sql = "INSERT INTO t_user(user_name,password,true_name,bz,remarks) VALUES(?,?,?,?,?)";
        boolean bool = false;
        Connection connection = DbConn.getconn();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getTrueName());
            ps.setString(4,user.getBz());
            ps.setString(5, user.getRemarks());
            int rs = ps.executeUpdate();
            if(rs > 0) {
                bool = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    /**
     * 根据用户id删除数据
     * @param id
     */
    public void deleteUser(int id) {
        String sql = "DELETE FROM t_user WHERE id=?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改用户
     * @param user
     */
    public void updateUser(User user) {
        String sql = "UPDATE t_user SET user_name=?,password=?,true_name=?,remarks=?,bz=?"+
                "WHERE id=?";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getTrueName());
            ps.setString(4,user.getRemarks());
            ps.setString(5,user.getBz());
            System.out.println("===================");
            String id = String.valueOf(user.getId());
            ps.setString(6,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 查看所有用户
     * @return
     */
    public List<User> userList() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM t_user";
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                int id = rs.getInt(1);
                String bz = rs.getString(2);
                String password = rs.getString(3);
                String trueName = rs.getString(4);
                String userName = rs.getString(5);
                String remarks = rs.getString(6);
                user.setId(id);
                user.setBz(bz);
                user.setPassword(password);
                user.setTrueName(trueName);
                user.setUserName(userName);
                user.setRemarks(remarks);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public User findUserById(Integer id) {
        String sql = "SELECT * FROM t_user WHERE id=?";
        User user = null;
        try {
            Connection connection = DbConn.getconn();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                user.setTrueName(rs.getString("true_name"));
                user.setBz(rs.getString("bz"));
                user.setRemarks(rs.getString("remarks"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
