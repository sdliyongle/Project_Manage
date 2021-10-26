package utils;


public class resultData {
    private Boolean flag;  //布尔值类型标志
    private String message;  //响应前端的信息
    private Object data;     //响应对象

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
