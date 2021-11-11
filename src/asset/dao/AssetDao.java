package asset.dao;


import asset.entity.Asset;
import db.DbConn;
import utils.AssertUtil;
import utils.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssetDao {

    /**
     * 添加用户
     * @param asset
     * @return
     */
    public boolean addAsset(Asset asset) {
        String sql = "INSERT INTO asset_table(asset_id,asset_name,asset_type,asset_status,asset_value,asset_rental_status) VALUES(?,?,?,?,?,?)";
        boolean bool = false;
        Connection connection = DbConn.getconn("rbac");
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,asset.getAssetId());
            ps.setString(2,asset.getAssetName());
            ps.setString(3,asset.getAssetType());
            ps.setString(4,asset.getAssetStatus());
            ps.setString(5, asset.getAssetValue());
            ps.setString(6, asset.getAssetRentalStatus());
            System.out.println("执行的sql:"+sql);
            int rs = ps.executeUpdate();
            if(rs > 0) {
                bool = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bool;
    }

    /**
     * 根据资产id删除数据
     * @param asset_id
     */
    public void deleteAsset(String asset_id) {
        String sql = "DELETE FROM asset_table WHERE asset_id=?";
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,asset_id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 修改资产
     * @param asset
     */
    public void updateAsset(Asset asset) {
        String sql = "UPDATE asset_table SET asset_id=?,asset_name=?,asset_type=?,asset_status=?,asset_value=?,asset_rental_status=?"+
                "WHERE asset_id=?";
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,asset.getAssetId());
            ps.setString(2,asset.getAssetName());
            ps.setString(3,asset.getAssetType());
            ps.setString(4,asset.getAssetStatus());
            ps.setString(5,asset.getAssetValue());
            ps.setString(6,asset.getAssetRentalStatus());
            ps.setString(7,asset.getAssetId());
            System.out.println("===================");
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 查看所有资产
     * 搜索模糊查询
     * @return
     */
    public List<Asset> assetList(String assetId, int page, int limit) {
        List<Asset> assetList = new ArrayList<>();
        String sql = "SELECT * FROM asset_table";
        if(assetId != null && (assetId.length()!=0)) {
            sql += " WHERE asset_id like '%" + assetId + "%'";
        }
        int start = (page-1)*limit;
        int end = limit;
        sql = sql + " limit " + start + "," + end;
        System.out.println("构造的sql语句是："+sql);
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asset asset = new Asset();
                String asset_id = rs.getString("asset_id");
                String asset_name = rs.getString("asset_name");
                String asset_type = rs.getString("asset_type");
                String asset_status = rs.getString("asset_status");
                String asset_value = rs.getString("asset_value");
                String asset_rental_status = rs.getString("asset_rental_status");
                asset.setAssetId(asset_id);
                asset.setAssetName(asset_name);
                asset.setAssetType(asset_type);
                asset.setAssetStatus(asset_status);
                asset.setAssetValue(asset_value);
                asset.setAssetRentalStatus(asset_rental_status);
                assetList.add(asset);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return assetList;
    }
    public int queryAllAssets() {
        String sql = "SELECT count(*) as total FROM asset_table";
        System.out.println("构造的sql语句是："+sql);
        int totalCount = 0;
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                totalCount = rs.getInt("total");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return totalCount;
    }
    /**
     * 根据用户id查询用户
     * @param asset_id
     * @return
     */
    public Asset findAssetById(String asset_id) {
        String sql = "SELECT * FROM asset_table WHERE asset_id=?";
        Asset asset = null;
        try {
            Connection connection = DbConn.getconn("rbac");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,asset_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                asset = new Asset();
                asset.setAssetId(rs.getString("asset_id"));
                asset.setAssetName(rs.getString("asset_name"));
                asset.setAssetType(rs.getString("asset_type"));
                asset.setAssetStatus(rs.getString("asset_status"));
                asset.setAssetValue(rs.getString("asset_value"));
                asset.setAssetRentalStatus(rs.getString("asset_rental_status"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return asset;
    }
}
