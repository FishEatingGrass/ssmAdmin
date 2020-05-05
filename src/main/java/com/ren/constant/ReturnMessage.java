package com.ren.constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 返回结果
 * 
 * @author JBH
 *
 */
public class ReturnMessage extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public ReturnMessage() {
		this.put("succeed", false);
		this.put("message", "");
		this.put("code", 0);
		this.put("result", null);
		this.put("ispage", "0");
	}

	@Deprecated
	@Override
	public Object get(Object key) {
		return super.get(key);
	}

	@Deprecated
	@Override
	public Object put(String key, Object value) {
		return super.put(key, value);
	}

	@Deprecated
	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		super.putAll(m);
	}

	public boolean succeed() {
		return (boolean) this.get("succeed");
	}

	public void setSucceed() {
		this.put("succeed", true);
	}

	@SuppressWarnings("rawtypes")
	public void setResult(Page page) {
		this.put("succeed", true);
		this.put("result", page);
		this.put("message", "");
		this.put("code", 0);
		this.put("ispage", "1");
	}
	public void setResult(Object obj) {
		this.put("succeed", true);
		this.put("result", obj);
		this.put("message", "");
		this.put("code", 0);
	}
	
	public void setException(Exception e) {
		this.put("succeed", false);
		this.put("code", -1);
		this.put("message", "服务异常");
	}

	public ReturnMessage setError(int code, String message) {
		this.put("succeed", false);
		this.put("code", code);
		this.put("message", message);
		return this;
	}

	/**
	 * 错误代码 负值：异常，0：无效，正值：错误
	 */
	public int getCode() {
		return (int) this.get("code");
	}

	/**
	 * 信息
	 */
	public String getMessage() {
		return (String) this.get("message");
	}

	/**
	 * 获取结果集
	 * 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Page getPage() {
		Object obj = this.get("result");
		if (obj != null) {
			Map<String, Object> map = (Map<String, Object>) obj;
			return new Page(map);
		}
		return null;
	}
	@SuppressWarnings({ "unchecked" })
	public <T> Page<T> getPage(Class<T> clazz) {
		Object obj = this.get("result");
		if (obj != null) {
			Map<String, Object> map = (Map<String, Object>) obj;
			return new Page<T>(map);
		}
		return null;
	}
	public Object getObj() {
		Object obj = this.get("result");
		if (obj != null) {
			return obj;
		}
		return null;
	}
	@SuppressWarnings("rawtypes")
	public void setAttribute(String key, Object value) {
		if (value instanceof List) {
			this.put(key, ((List) value).toArray());
		} else {
			this.put(key, value);
		}
	}
	/**
	 * 返回JSON格式字符串
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
