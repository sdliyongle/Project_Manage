package meeting.entity;



public class Meeting {

    //数据库t_user表主键
    private int id;

    private String bz;

    private String password;

    private String trueName;

    private String userName;

    private String remarks;

    private Integer isDel;

    private Integer roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bz='" + bz + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", userName='" + userName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isDel=" + isDel +
                ", roleId=" + roleId +
                '}';
    }
}
