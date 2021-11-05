package user.controller;


import user.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这个文件是设想集中处理user的各种请求
 * 通过action指定操作
 * 相当于合并
 * 逻辑见device下file中的ServletAction
 */
public class UserServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println(request.getParameter("action"));
    }
}
