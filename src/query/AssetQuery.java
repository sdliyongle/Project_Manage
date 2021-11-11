package query;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.query]
 * @ClassName: [UserQuery]
 * @Description:
 * @Author: [LiYongle]
 * @CreateDate: [2021-08-06  11:40]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-08-06  11:40]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
public class AssetQuery extends BaseQuery{

    private String asset_id;

    public String getUserName() {
        return asset_id;
    }

    public void setUserName(String assetId) {
        this.asset_id = assetId;
    }

    public AssetQuery(int page, int limit, String assetId) {
        super(page, limit);
        this.asset_id = assetId;
    }
}
