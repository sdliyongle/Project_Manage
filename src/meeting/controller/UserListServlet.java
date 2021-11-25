package meeting.controller;

import meeting.dao.UserDao;
import meeting.entity.Meeting;
import org.json.JSONObject;
import query.UserQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户列表
 */
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
        //这里看前端是否传入参数，若没有则查询全部用户，否则进行条件查询
        int page =Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String userName = request.getParameter("userName");
        UserQuery userQuery = new UserQuery(page,limit,userName);
        List<Meeting> listUser = userDao.userList(userName, page, limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",userDao.queryAllUsers());
        jsonObject.put("data", listUser);
        //这里状态码需要返回0，因为是layui数据表格模板要求
        jsonObject.put("code","0");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
