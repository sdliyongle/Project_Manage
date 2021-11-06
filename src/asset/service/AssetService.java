package asset.service;


import asset.dao.AssetDao;
import asset.entity.Asset;

import java.util.List;

public class AssetService {
    //Dao层
    AssetDao assetDao = new AssetDao();

    /**
     * 添加资产
     * @param asset_id
     * @param asset_name
     * @param asset_type
     * @param asset_status
     * @param asset_value
     * @param asset_rental_status
     * @return
     */
    public boolean addAsset(String asset_id, String asset_name, String asset_type, String asset_status, String asset_value, String asset_rental_status) {
        Asset asset = new Asset();
        asset.setAssetId(asset_id);
        asset.setAssetName(asset_name);
        asset.setAssetType(asset_type);
        asset.setAssetStatus(asset_status);
        asset.setAssetValue(asset_value);
        asset.setAssetRentalStatus(asset_rental_status);
        return assetDao.addAsset(asset);
    }

    /**
     * 删除资产
     * @param asset_id
     */
    public void deleteAsset(String asset_id) {
        assetDao.deleteAsset(asset_id);
    }

    /**
     * 修改资产
     * @param asset_id
     * @param asset_name
     * @param asset_type
     * @param asset_status
     * @param asset_value
     * @param asset_rental_status
     */
    public void updateAsset(String asset_id, String asset_name, String asset_type, String asset_status, String asset_value, String asset_rental_status) {
        Asset asset = new Asset();
        asset.setAssetId(asset_id);
        asset.setAssetName(asset_name);
        asset.setAssetType(asset_type);
        asset.setAssetStatus(asset_status);
        asset.setAssetValue(asset_value);
        asset.setAssetRentalStatus(asset_rental_status);
        assetDao.updateAsset(asset);
    }

    /**
     * 查看所有用户
     * @return
     */
    public List<Asset> assetList(String assetName) {
        return assetDao.assetList(assetName);
    }

}
