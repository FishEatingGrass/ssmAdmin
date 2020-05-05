package com.ren.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemRole;
import com.ren.model.SystemRule;
import com.ren.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ren.service.SystemRoleService;
import com.ren.service.SystemRuleService;
import com.ren.service.SystemUserService;
import com.ren.utils.CaptchaUtil;
import com.ren.utils.GetUserIp;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

@Controller
@RequestMapping("/admin/login")
public class LoginController {
	
	@Autowired
	SystemUserService systemUserService;
	
	@Autowired
	SystemRoleService roleService;
	
	@Autowired
	SystemRuleService ruleService;
	
	/**
	 * 登录首页
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "admin/login/index";
	}
	
	/**
	 * 登录处理
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("login")
	@Transactional
	public String login(HttpServletRequest request, HttpServletResponse response,Map<String, Object> map) throws IOException {
		boolean isTrue = CaptchaUtil.verify(request, response, request.getParameter("code"));
		if(isTrue) { //验证码正确
			Digester sha256 = new Digester(DigestAlgorithm.SHA256);
			String password = sha256.digestHex(request.getParameter("password"));
			String userName = request.getParameter("name");
			//判断用户名是否存在、是否超过错误次数
			SystemUser systemUser = systemUserService.findByUserName(userName);
			int thisTime = (int) (System.currentTimeMillis() / 1000);
			if(systemUser != null) {
				if(systemUser.getErrorNum() >= 3 && systemUser.getErrorTime()+15*60 > thisTime) {
					map.put("msg", "该帐号输入密码次数过多已被锁定，请稍后再用！");
					map.put("url", "/admin/login/index");
					return "admin/public/Info_tip";
				}
			}else {
				map.put("msg", "没有该用户名！");
				map.put("url", "/admin/login/index");
				return "admin/public/Info_tip";
			}
			SystemUser user = systemUserService.findByNameAndPassword(userName, password);
			if(user == null) {
				//增加错误次数，更新错误时间
				systemUserService.updateUserLoginErrorInfo(thisTime, systemUser.getId());
				map.put("msg", "用户名密码错误！");
				map.put("url", "/admin/login/index");
				return "admin/public/Info_tip";
			}else {
				//获取用户权限
				SystemRole role = roleService.findById(user.getRoleId());
				List<SystemRule> list = ruleService.ruleListByIds(role.getRules());
				List<String> rules = new ArrayList<String>();
				for(SystemRule rule : list) {
					rules.add(rule.getUrl());
				}
				request.getSession().setAttribute("admin_uid", user.getId());
				request.getSession().setAttribute("rules", rules);
				String loginIp = GetUserIp.getRealIp(request);
				systemUserService.updateUserLoginSuccessInfo(thisTime, loginIp, user.getId());
			}
		}else {
			map.put("msg", "验证码错误！");
			map.put("url", "/admin/login/index");
			return "admin/public/Info_tip";
		}
		return "redirect:/admin/index/index";
	}
	
	/**
	 * 验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("verifica")
	public ModelAndView verificaCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CaptchaUtil.outputCaptcha(request, response,100,34);
		return null;
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/out")
	public String out(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("admin_uid", null);
		return "redirect:/admin/login/index";
	}
	
}
