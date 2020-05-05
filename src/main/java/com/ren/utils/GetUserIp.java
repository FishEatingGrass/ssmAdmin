package com.ren.utils;

import javax.servlet.http.HttpServletRequest;
/**
 * 获取用户ip
 * @author 任振星
 * rzx_365880@163.com
 * 306524624
 * 2017年4月28日 下午3:38:52
 * com.xinxing.utils
 * XinxingWeb
 */
public class GetUserIp {
	/**
	 * 获取用户ip
	 * @param request 请求
	 * @return ip地址
	 */
	public static String getRealIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
