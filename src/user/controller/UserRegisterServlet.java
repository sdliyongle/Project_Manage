package user.controller;


import org.json.JSONObject;
import user.dao.UserDao;
import user.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserRegisterServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserRegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserRegisterServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String trueName = request.getParameter("trueName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int roleId = Integer.parseInt(request.getParameter("role"));
        User user = userDao.register(userName,trueName,email,password,roleId);
        JSONObject jsonObject = new JSONObject();
        //下面逻辑同登录
        if(user == null) {
            jsonObject.put("code", 500);
            jsonObject.put("message", "用户注册失败");
        } else {
            jsonObject.put("code", 200);
            jsonObject.put("message", "用户注册成功");
        }
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }

}
