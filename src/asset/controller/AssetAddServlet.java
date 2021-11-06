package asset.controller;


import asset.dao.AssetDao;
import asset.entity.Asset;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AssetAddServlet extends HttpServlet {
    private final AssetDao assetDao = new AssetDao();
    private static final long serialVersionUID = 1;

    public AssetAddServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了AssetAddServlet");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Asset asset = new Asset();
        asset.setAssetId(request.getParameter("asset_id"));
        asset.setAssetName(request.getParameter("asset_name"));
        asset.setAssetType(request.getParameter("asset_type"));
        asset.setAssetStatus(request.getParameter("asset_status"));
        asset.setAssetValue(request.getParameter("asset_value"));
        asset.setAssetRentalStatus(request.getParameter("asset_rental_status"));
        assetDao.addAsset(asset);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("message","用户信息添加成功");
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
    }
}
