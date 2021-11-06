package asset.entity;



public class Asset {

    //数据库t_user表主键
    private String asset_id;

    private String asset_name;

    private String asset_type;

    private String asset_status;

    private String asset_value;

    private String asset_rental_status;


    public String getAssetId() {
        return asset_id;
    }

    public void setAssetId(String id) {
        this.asset_id = id;
    }

    public String getAssetName() {
        return asset_name;
    }

    public void setAssetName(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAssetType() {
        return asset_type;
    }

    public void setAssetType(String asset_type) {
        this.asset_type = asset_type;
    }

    public String getAssetStatus() {
        return asset_status;
    }

    public void setAssetStatus(String asset_status) {
        this.asset_status = asset_status;
    }

    public String getAssetValue() {
        return asset_value;
    }

    public void setAssetValue(String asset_value) {
        this.asset_value = asset_value;
    }

    public String getAssetRentalStatus() {
        return asset_rental_status;
    }

    public void setAssetRentalStatus(String asset_rental_status) {
        this.asset_rental_status = asset_rental_status;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "asset_id=" + asset_id +
                ", asset_name='" + asset_name + '\'' +
                ", asset_type='" + asset_type + '\'' +
                ", asset_status='" + asset_status + '\'' +
                ", asset_value='" + asset_value + '\'' +
                ", asset_rental_status='" + asset_rental_status + '\'' +
                '}';
    }
}
