package user.controller;


import org.json.JSONObject;
import user.dao.UserDao;
import user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserUpdateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserUpdateServlet");
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setTrueName(request.getParameter("trueName"));
        user.setBz(request.getParameter("bz"));
        user.setRemarks(request.getParameter("remarks"));
        System.out.println(user);
        userDao.updateUser(user);
        System.out.println("执行了用户更新!");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("message","用户信息更新成功");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
