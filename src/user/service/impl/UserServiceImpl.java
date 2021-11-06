package user.service.impl;


import user.dao.UserDao;
import user.entity.User;
import user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> userList(String username, int page, int limit) {
        return userDao.userList(username, page, limit);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public User login(String userName, String password) {
        return userDao.login(userName, password);
    }

    @Override
    public User register(String userName, String trueName, String email, String password, int roleId) {
        return userDao.register(userName,trueName,email,password,roleId);
    }
}
