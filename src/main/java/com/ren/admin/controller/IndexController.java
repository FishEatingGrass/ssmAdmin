package com.ren.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ren.service.SystemUserService;

@Controller
@RequestMapping("/admin/index/")
public class IndexController {
	
	@Autowired
	SystemUserService userService;
	
	/**
	 * 后台首页
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request,HttpServletResponse response,Map<String, Object> map) {
		int adminUserId = (int) request.getSession().getAttribute("admin_uid");
		SystemUser user = userService.findById(adminUserId);
		map.put("user", user);
		return "/admin/index/index";
	}
	
	/**
	 * 右侧欢迎页
	 * @return
	 */
	@RequestMapping("welcome")
	public String welcome() {
		return "/admin/index/welcome";
	}
}
