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
 * 用户登录
 */
public class UserLoginServlet extends HttpServlet {

    private final UserDao userDao = new UserDao();
    private static final long serialVersionUID = 1;

    public UserLoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了UserLoginServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Meeting user = userDao.login(userName,password);
        JSONObject jsonObject = new JSONObject();
        //这里是为了给前端返回信息，好提示用户，进行良好的交互，否则后端出错后，前端无响应，交互性不强。
        if(user != null) {
            jsonObject.put("code", 200);
            jsonObject.put("message", "用户登录成功");
            request.getSession().setAttribute("userName",userName);
        } else {
            jsonObject.put("code",500);//500表示服务器出错
            jsonObject.put("message","用户不存在或密码错误");
        }
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
