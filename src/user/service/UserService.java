package user.service;


import user.dao.UserDao;
import user.entity.User;

import java.util.List;

public class UserService {
    //Dao层
    UserDao userDao = new UserDao();

    /**
     * 添加用户
     * @param userName
     * @param password
     * @return
     */
    public boolean addUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userDao.addUser(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 修改用户
     * @param id
     * @param userName
     * @param password
     * @param trueName
     */
    public void updateUser(int id, String userName, String password, String trueName) {
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setPassword(password);
        user.setTrueName(trueName);
        userDao.updateUser(user);
    }

    /**
     * 查看所有用户
     * @return
     */
    public List<User> userList(String userName) {
        return userDao.userList(userName);
    }

}
