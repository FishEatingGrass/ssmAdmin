package com.ren.admin.controller.authority;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemRole;
import com.ren.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ren.admin.controller.CommontController;
import com.ren.service.SystemRoleService;
import com.ren.service.SystemUserService;
import com.ren.utils.DateUtil;
import com.ren.utils.SavePhotoBase64;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.json.JSONUtil;

@Controller
@RequestMapping("/admin/user/")
public class UserController extends CommontController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	SystemUserService userService;
	
	@Autowired
	SystemRoleService roleService;
	
	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/admin/authority/user_list";
	}
	
	/**
	 * 添加用户
	 * @param map
	 * @param user
	 * @return
	 */
	@RequestMapping("add")
	@Transactional
	public String add(Map<String, Object> map,@ModelAttribute SystemUser user) {
		String url = "";
		if("GET".equals(M())) {
			url = "/admin/authority/user_add";
			List<SystemRole> roles = roleService.findAll();
			map.put("roles", roles);
		}else if("POST".equals(M())) {
			Digester sha256 = new Digester(DigestAlgorithm.SHA256);
			String password = sha256.digestHex(I("password"));
			String userName = I("userName");
			if(userService.findByUserName(userName)!=null) {
				map.put("msg", "该用户已经存在！");
				map.put("url", "/admin/user/add");
				url = "admin/public/Info_tip";
			}else {
				user.setPassword(password);
				userService.addUser(user);
				url = "redirect:/admin/user/index";
			}
		}
		return url;
	}
	
	/**
	 * 分页排序、搜索
	 * @param map
	 * @return
	 */
	@RequestMapping(value="page",produces="text/json;charset=utf-8;")
	@ResponseBody
	public String Page(Map<String, Object> map) {
		int draw = Integer.valueOf(I("draw"));
		int start = Integer.valueOf(I("start"));
		int length = Integer.valueOf(I("length"));
		String name = I("columns["+Integer.valueOf(I("order[0][column]"))+"][data]"); //排序字段
		String orderBy = I("order[0][dir]"); //排序方式
		String search = I("search[value]"); //搜索词
		List<SystemUser> rules = userService.findUserPage(name, orderBy, start, length, search);
		map.put("draw", draw);
		map.put("recordsTotal", userService.countAll());
		map.put("recordsFiltered",userService.countSearch(search));
		map.put("data", rules);
		return JSONUtil.toJsonStr(map);
	}
	
	/**
	 * 用户上传头像显示
	 * @return
	 */
	@GetMapping("photo")
	public String photo() {
		return "/admin/authority/user_photo";
	}
	
	/**
	 * 用户上传头像处理
	 * @param map
	 * @return
	 */
	@PostMapping("photoHandle")
	@ResponseBody
	@Transactional
	public String photoHandle(Map<String, String> map){
		String imgData = I("imgData");
		String realPath = request.getSession().getServletContext().getRealPath("");
		String filePath = "/upload/"+DateUtil.getMonthDay()+"/";
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")+".png";
		boolean isTrue = new SavePhotoBase64().save(imgData,realPath ,filePath, fileName);
		//数据库修改
		int id = (int) S("admin_uid");
		userService.updateUsePhoto(filePath+fileName, id);
		if(isTrue) {
			map.put("code", "200");
		}else {
			map.put("code", "400");
		}
		return JSONUtil.toJsonStr(map);
	}
	
	/**
	 * 管理员修改用户信息
	 * @param map
	 * @param user
	 * @return
	 */
	@RequestMapping("adminedit")
	@Transactional
	public String adminedit(Map<String, Object> map,@ModelAttribute SystemUser user) {
		String url = "";
		if("GET".equals(M())) {
			int id = Integer.valueOf(I("id"));
			SystemUser oneUser = userService.findById(id);
			List<SystemRole> roles = roleService.findAll();
			map.put("user",oneUser);
			map.put("roles", roles);
			url = "/admin/authority/user_adminedit";
		}else if("POST".equals(M())) {
			if(!K(user.getPassword())) {
				Digester digester = new Digester(DigestAlgorithm.SHA256);
				user.setPassword(digester.digestHex(user.getPassword()));
			}
			userService.updateUserFromAdmin(user);
			url = "redirect:/admin/user/index";
		}
		return url;
	}
	
	/**
	 * 用户资料修改页面
	 * @param map
	 * @return
	 */
	@RequestMapping("edit")
	@Transactional
	public String edit(Map<String, Object> map) {
		String method = M();
		String url = "";
		int id = (int) S("admin_uid");
		if("GET".equals(method)) {
			SystemUser user = userService.findById(id);
			map.put("user", user);
			url = "/admin/authority/user_edit";
		}else if("POST".equals(method)) {
			String trueName = I("trueName");
			String phone = I("phone");
			String password1 = I("password1");
			String password2 = I("password2");
			String password = "";
			if(!K(password1) && !K(password2)) {
				if(!password1.equals(password2)) {
					map.put("msg", "2次密码不一致！");
					map.put("url", "/admin/user/edit");
					return "admin/public/Info_tip";
				}
				Digester sha256 = new Digester(DigestAlgorithm.SHA256);
				password = sha256.digestHex(password1);
			}
			userService.updateUseInfo(trueName, phone, password, id);
			map.put("msg", "修改成功！");
			map.put("url", "/admin/user/edit");
			url = "admin/public/Info_tip";
		}
		return url;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("del")
	public String del() {
		int id = Integer.valueOf(I("id"));
		userService.deleteById(id);
		return "redirect:/admin/user/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
