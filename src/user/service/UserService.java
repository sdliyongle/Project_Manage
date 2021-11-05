package user.service;


import user.entity.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    List<User> userList(String username, int page, int limit);

    User findUserById(Integer id);

    User login(String userName, String password);

    User register(String userName, String trueName, String email, String password,int roleId);

}
