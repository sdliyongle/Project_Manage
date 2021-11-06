package asset.controller;


import asset.dao.AssetDao;
import asset.entity.Asset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class toUpdateAssetServlet extends HttpServlet {
    private final AssetDao userDao = new AssetDao();
    private static final long serialVersionUID = 1;

    public toUpdateAssetServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("进入了AssetToUpdateServlet");
        Asset asset = userDao.findAssetById(request.getParameter("asset_id"));
        System.out.println(asset);
        request.setAttribute("asset",asset);
        request.getRequestDispatcher("/view/asset/asset-update.jsp").forward(request,response);
    }
}
