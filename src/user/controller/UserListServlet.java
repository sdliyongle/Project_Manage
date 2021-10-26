package user.controller;

import org.json.JSONObject;
import user.dao.UserDao;
import user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserListServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<User> listUser = userDao.userList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",listUser.size());
        jsonObject.put("data", listUser);
        jsonObject.put("code","0");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
