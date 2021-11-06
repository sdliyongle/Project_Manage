package asset.controller;


import asset.dao.AssetDao;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssetDeleteServlet extends HttpServlet {
    private final AssetDao assetDao = new AssetDao();
    private static final long serialVersionUID = 1;

    public AssetDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了AssetDeleteServlet");
        String id = request.getParameter("asset_id");
        System.out.println("删除获取的id；"+id);
        assetDao.deleteAsset(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("message","用户信息删除成功");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
