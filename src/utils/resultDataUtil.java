package utils;

/**
 * 返回结果的封装处理，
 */

public class resultDataUtil {
    //两个返回的状态
    private static final Boolean SUCCESS = true;
    private static final Boolean Fail = false;
    //成功与失败时的消息
    private static final String msg1 = "成功";
    private static final String msg2 = "失败";

    private static resultData resultdata;

    //成功
    public resultData getSuccessResult() {
        resultdata = new resultData();
        resultdata.setMessage(msg1);
        resultdata.setFlag(SUCCESS);
        return resultdata;

    }

    //成功，附带自定义数据
    public resultData getSuccessResult(String message) {
        resultdata = new resultData();
        resultdata.setMessage(message);
        resultdata.setFlag(SUCCESS);
        return resultdata;

    }

    //成功，附带额外数据
    public resultData getSuccessResult(Object data) {
        resultdata = new resultData();
        resultdata.setData(data);
        resultdata.setMessage(msg1);
        resultdata.setFlag(SUCCESS);
        return resultdata;
    }

    //成功，自定义消息及数据
    public resultData getSuccessResult(String message, Object data) {
        resultdata = new resultData();
        resultdata.setData(data);
        resultdata.setMessage(message);
        resultdata.setFlag(SUCCESS);
        return resultdata;

    }

    //失败
    public resultData getFailResult() {
        resultdata = new resultData();
        resultdata.setMessage(msg2);
        resultdata.setFlag(Fail);
        return resultdata;

    }

    //失败，附带消息
    public resultData getFailResult(String message) {
        resultdata = new resultData();
        resultdata.setMessage(message);
        resultdata.setFlag(Fail);
        return resultdata;

    }

    //失败，自定义消息及数据
    public resultData getFailResult(String message, Object data) {
        resultdata = new resultData();
        resultdata.setData(data);
        resultdata.setMessage(message);
        resultdata.setFlag(Fail);
        return resultdata;

    }

    //自定义创建
    public resultData getFreeResult(Boolean code, String message, Object data) {
        resultdata = new resultData();
        resultdata.setData(data);
        resultdata.setMessage(message);
        resultdata.setFlag(code);
        return resultdata;
    }
}
