package com.ren.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class CommontController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	/**
	 * 获取传参
	 * @param para
	 * @return
	 */
	public String I(String para) {
		return K(request.getParameter(para)) ? "" : request.getParameter(para);
	}
	/**
	 * 获取session
	 * @param name
	 * @return
	 */
	public Object S(String name) {
		return request.getSession().getAttribute(name);
	}
	
	/**
	 * 判断是否为空
	 * @param para
	 * @return true 是空 | false 非空
	 */
	public boolean K(String para) {
		if("".equals(para) || para == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 获取请求方式
	 * @return
	 */
	public String M() {
		return request.getMethod();
	}
}
