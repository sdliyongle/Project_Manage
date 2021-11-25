package meeting.service;


import meeting.entity.Meeting;

import java.util.List;

public interface UserService {

    boolean addUser(Meeting user);

    void deleteUser(int id);

    void updateUser(Meeting user);

    List<Meeting> userList(String username, int page, int limit);

    Meeting findUserById(Integer id);

    Meeting login(String userName, String password);

    Meeting register(String userName, String trueName, String email, String password, int roleId);

}
