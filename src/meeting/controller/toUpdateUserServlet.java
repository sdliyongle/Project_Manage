package meeting.controller;


import meeting.dao.UserDao;
import meeting.entity.Meeting;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转到更新页面的后端处理
 */
public class toUpdateUserServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public toUpdateUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserToUpdateServlet");
        Meeting user = userDao.findUserById(Integer.parseInt(request.getParameter("id")));
        System.out.println(user);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/view/user/user-update.jsp").forward(request,response);
    }
}
