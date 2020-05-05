package com.ren.admin.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ren.admin.controller.CommontController;

import net.sf.ehcache.search.expression.And;

public class AuthInterceptor extends CommontController implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		int id = Integer.valueOf(S("admin_uid").toString());
		List<String> rules = (List<String>) S("rules");
		String url = request.getServletPath();
		if(rules.contains(url)) {
			return true;
		}else {
			PrintWriter writer = response.getWriter();
			String html = "<script>alert('没有访问权限')</script>";
			writer.print(html);
			writer.flush();
			writer.close();
			return false;
		}
		
		
		
	}

}
