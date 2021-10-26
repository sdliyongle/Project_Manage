package model;


/**
 * 公共返回对象
 *
 * @author zhoubin
 * @since 1.0.0
 */
public class RespBean {
	private long code;
	private String message;
	private Object obj;

	public RespBean(long code, String message, Object obj){
		this.code = code;
		this.message = message;
		this.obj = obj;
	}

	/**
	 * 成功返回结果
	 * @param message
	 * @return
	 */
	public static RespBean success(String message){
		return new RespBean(200,message,null);
	}

	/**
	 * 成功返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static RespBean success(String message,Object obj){
		return new RespBean(200,message,obj);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @return
	 */
	public static RespBean error(String message){
		return new RespBean(500,message,null);
	}

	/**
	 * 失败返回结果
	 * @param message
	 * @param obj
	 * @return
	 */
	public static RespBean error(String message,Object obj){
		return new RespBean(500,message,obj);
	}
}