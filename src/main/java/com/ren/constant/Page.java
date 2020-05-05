package com.ren.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 返回结果
 * 
 * @author JBH
 * @param <T>
 *
 */
public class Page<T> extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public Page() {
		this.put("recordCount", 0);
		this.put("pageCount", 0);
		this.put("pageSize", 0);
		this.put("pageNum", 0);
		this.put("list",new ArrayList<T>());// 当前页数据对象
	}

	public Page(Map<String, Object> map) {
		super(map);
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

	/**
	 * 创建分页
	 * 
	 * @param recordCount
	 *            总记录数
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            每页显示数量
	 * @return
	 */
	public int createPage(int recordCount, int pageNum, int pageSize) {
		this.put("recordCount", recordCount);
		this.put("pageSize", pageSize);
		this.put("pageNum", pageNum);
		this.put("pageCount", recordCount % pageSize > 0 ? recordCount / pageSize + 1 : recordCount / pageSize);
		int rowIndex = (pageNum - 1) * pageSize;
		return rowIndex;
	}

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public int getRecordCount() {
		return (int) this.get("recordCount");
	}

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public int getPageCount() {
		return (int) this.get("pageCount");
	}

	/**
	 * 每页显示数量
	 * 
	 * @return
	 */
	public int getPageSize() {
		return (int) this.get("pageSize");
	}

	/**
	 * 当前页码
	 * 
	 * @return
	 */
	public int getPageNum() {
		return (int) this.get("pageNum");
	}

	/**
	 * 信息
	 */
	public String getMessage() {
		return (String) this.get("message");
	}

	@SuppressWarnings("rawtypes")
	public void setData(String key,Object value) {
		if (value instanceof List) {
			this.put(key, ((List) value).toArray());
		} else {
			this.put(key, value);
		}
	}

	public String getString(String key) {
		return (String) this.get(key);
	}

	public int getInteger(String key) {
		return (int) this.get(key);
	}

	public long getLong(String key) {
		return (long) this.get(key);
	}

	public double getDouble(String key) {
		return (double) this.get(key);
	}

	public float getFloat(String key) {
		return (float) this.get(key);
	}

	@SuppressWarnings("hiding")
	public <T> T getEntity(String key, Class<T> clazz) {
		Object value = this.get(key);
		if (value != null) {
			return clazz.cast(value);
		}
		return null;
	}

	@SuppressWarnings("hiding")
	public <T> List<T> getList(String key, Class<T> clazz) {
		Object values = this.get(key);
		if (values != null) {
			Object[] arr = (Object[]) values;
			List<T> list = new ArrayList<T>();
			for (Object obj : arr) {
				list.add(clazz.cast(obj));
			}
			return list;
		}
		return null;
	}

	public Object getObject(String key) {
		return this.get(key);
	}

	/**
	 * 返回JSON格式字符串
	 */
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
