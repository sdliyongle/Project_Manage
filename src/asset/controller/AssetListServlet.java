package asset.controller;

import asset.dao.AssetDao;
import asset.entity.Asset;
import org.json.JSONObject;

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
        List<Asset> listAsset = assetDao.assetList(request.getParameter("assetId"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("count",listAsset.size());
        jsonObject.put("data", listAsset);
        jsonObject.put("code","0");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
