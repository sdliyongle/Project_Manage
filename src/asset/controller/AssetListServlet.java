package asset.controller;

import asset.dao.AssetDao;
import asset.entity.Asset;
import org.json.JSONObject;
import query.AssetQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AssetListServlet extends HttpServlet {
    private final AssetDao assetDao = new AssetDao();
    private static final long serialVersionUID = 1;

    public AssetListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了AssetListServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //这里看前端是否传入参数，若没有则查询全部用户，否则进行条件查询
        int page =Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        String assetId = request.getParameter("assetId");
        AssetQuery userQuery = new AssetQuery(page,limit,assetId);
        List<Asset> listAsset = assetDao.assetList(assetId, page, limit);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",assetDao.queryAllAssets());
        jsonObject.put("data", listAsset);
        jsonObject.put("code","0");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
