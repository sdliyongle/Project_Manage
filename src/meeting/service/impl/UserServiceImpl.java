package meeting.service.impl;


import meeting.dao.UserDao;
import meeting.entity.Meeting;
import meeting.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();

    @Override
    public boolean addUser(Meeting user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(Meeting user) {
        userDao.updateUser(user);
    }

    @Override
    public List<Meeting> userList(String username, int page, int limit) {
        return userDao.userList(username, page, limit);
    }

    @Override
    public Meeting findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public Meeting login(String userName, String password) {
        return userDao.login(userName, password);
    }

    @Override
    public Meeting register(String userName, String trueName, String email, String password, int roleId) {
        return userDao.register(userName,trueName,email,password,roleId);
    }
}
