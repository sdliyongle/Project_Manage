package query;

/**
 * @ProjectName: [jxc-manager-par]
 * @Package: [com.lzj.admin.query]
 * @ClassName: [UserQuery]
 * @Description:
 * @Author: [ZengQi]
 * @CreateDate: [2021-08-06  11:40]
 * @UpdateUser: [ZengQi]
 * @UpdateDate: [2021-08-06  11:40]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 */
public class UserQuery extends BaseQuery{

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserQuery(int page, int limit, String userName) {
        super(page, limit);
        this.userName = userName;
    }
}
