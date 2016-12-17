package com.yiwg.plp.po;

public class AjaxPo {
	
	private boolean success;
	private Integer code = 0;  //成功为0
 	private String msg;
	private Object obj;
	private long total = 0;
	/**
	 * @Description:翻页设置成功信息 
	 * @param @param msg
	 * @param @param obj
	 * @param @param total
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author Panyk
	 * @date 2016年10月24日
	 */
	public void setSuccess(String msg, Object obj, long total){
		this.success = true;
		this.code = 0;
		this.msg = msg;
		this.obj = obj;
		this.total = total;
	}
	/**
	 * @Description:设置成功信息 
	 * @param @param msg   
	 * @return void  
	 * @throws
	 * @author Panyk
	 * @date 2016年10月26日
	 */
	public void setSuccess(String msg){
		this.success = true;
		this.code = 0;
		this.msg = msg;
	}

	public void setSuccess(int code,String msg){
		this.success = true;
		this.code =code;
		this.msg = msg;
	}

	public void setFailed(int code,String msg){
		this.success = false;
		this.code =code;
		this.msg = msg;
	}
	/**
	 * @Description:设置失败信息 
	 * @param @param msg
	 * @param @param code
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author Panyk
	 * @date 2016年10月24日
	 */
	public void setFailed(String msg, int code){
		this.success = false;
		this.msg = msg;
		this.code = code;
	}
	
	public AjaxPo(){}
	
	public AjaxPo(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}
	
	public AjaxPo(boolean success, long total, Object obj) {
		this.success = success;
		this.total = total;
		this.obj = obj;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
}
