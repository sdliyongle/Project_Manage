package meeting.controller;


import meeting.dao.UserDao;
import meeting.entity.Meeting;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 增加用户
 */
public class UserAddServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserAddServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserAddServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Meeting user = new Meeting();
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setTrueName(request.getParameter("trueName"));
        user.setBz(request.getParameter("bz"));
        user.setRemarks(request.getParameter("remarks"));
        String[] roleIds = request.getParameterValues("role");
        user.setRoleId(Integer.parseInt(roleIds[0]));
        userDao.addUser(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("message","用户信息添加成功");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
