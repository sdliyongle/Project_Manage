package user.dao;


import db.DbConn;
import exceptions.ParamsException;
import user.entity.User;
import utils.AssertUtil;
import utils.StringUtil;

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
        String sql = "INSERT INTO t_user(user_name,password,true_name,bz,remarks,role_id) VALUES(?,?,?,?,?,?)";
        boolean bool = false;
        Connection connection = DbConn.getconn("rbac");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getTrueName());
            ps.setString(4,user.getBz());
            ps.setString(5, user.getRemarks());
            ps.setInt(6,user.getRoleId());
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
            Connection connection = DbConn.getconn("rbac");
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
        String sql = "UPDATE t_user SET user_name=?,password=?,true_name=?,remarks=?,bz=?, role_id=?"+
                "WHERE id=?";
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getTrueName());
            ps.setString(4,user.getRemarks());
            ps.setString(5,user.getBz());
            ps.setInt(6,user.getRoleId());
            System.out.println("===================");
            String id = String.valueOf(user.getId());
            ps.setString(7,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 查看所有用户
     * 搜索模糊查询用户
     * @return
     */
    public List<User> userList(String username, int page, int limit) {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM t_user";
        if(username != null && (username.length()!=0)) {
            sql += " WHERE user_name like '%" + username + "%'";
        }
        int start = (page-1)*limit;
        int end = limit;
        sql = sql + " limit " + start + "," + end;
        System.out.println("构造的sql语句是："+sql);
        try {
            Connection connection = DbConn.getconn("rbac");
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

    public int queryAllUsers() {
        String sql = "SELECT count(*) as total FROM t_user";
        System.out.println("构造的sql语句是："+sql);
        int totalCount = 0;
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalCount = rs.getInt("total");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalCount;
    }
    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findUserById(Integer id) {
        String sql = "SELECT * FROM t_user WHERE id=?";
        User user = null;
        try {
            Connection connection = DbConn.getconn("rbac");
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
                user.setRoleId(rs.getInt("role_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    public User login(String userName, String password) {
        try {
            AssertUtil.isTrue(StringUtil.isEmpty(userName), "用户名不能为空");
            AssertUtil.isTrue(StringUtil.isEmpty(password), "密码不能为空");
            User user = this.findUserByUserName(userName);
            System.out.println(user);
            AssertUtil.isTrue(null == user, "该用户不存在");
            AssertUtil.isTrue(!(user.getPassword().equals(password)), "密码错误!");
            return user;
        } catch (ParamsException e) {
            return null;
        }
    }

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    private User findUserByUserName(String username) {
        User user = new User();
        String sql = "SELECT * FROM t_user WHERE user_name='"+username+"'";
        System.out.println("构造的sql语句是："+sql);
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                user = null;
            } else {
                String password = rs.getString(3);
                user.setPassword(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 注册用户
     * @param userName
     * @param email
     * @param password
     * @param roleId
     * @return
     */
    public User register(String userName, String trueName, String email, String password,int roleId) {
        User newUser = new User();
        User oldUser = this.findUserByUserName(userName);
        try {
            AssertUtil.isTrue(null != oldUser, "用户已存在");
        } catch (ParamsException e) {
            return null;
        }
        newUser.setUserName(userName);
        newUser.setTrueName(trueName);
        newUser.setPassword(password);
        newUser.setRoleId(roleId+1);
        String bz = "";
        String remarks = "";
        if(roleId==1) {
            bz="项目经理";
            remarks="产品经理，管理项目成员，管理项目";
        } else {
            bz="项目成员";
            remarks="项目普通成员，项目代码编写";
        }
        newUser.setBz(bz);
        newUser.setRemarks(remarks);
        this.addUser(newUser);
        return newUser;
    }
}
