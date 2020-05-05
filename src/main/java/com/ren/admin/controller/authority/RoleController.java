package com.ren.admin.controller.authority;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemRole;
import com.ren.model.SystemRuleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ren.admin.controller.CommontController;
import com.ren.service.SystemRoleService;
import com.ren.service.SystemRuleGroupService;
import com.ren.service.SystemRuleService;

import cn.hutool.json.JSONUtil;

@Controller
@RequestMapping("/admin/role/")
public class RoleController extends CommontController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	SystemRoleService roleService;
	
	@Autowired
	SystemRuleService ruleService;
	
	@Autowired
	SystemRuleGroupService groupService;
	
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/admin/authority/role_list";
	}
	
	/**
	 * 分页获取
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
		List<SystemRole> rules = roleService.findRolePage(name, orderBy, start, length, search);
		map.put("draw", draw);
		map.put("recordsTotal", roleService.countAll());
		map.put("recordsFiltered",roleService.countSearch(search));
		map.put("data", rules);
		return JSONUtil.toJsonStr(map);
	}
	
	
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("add")
	@Transactional
	public String add(@ModelAttribute SystemRole role) {
		String url = "";
		if("GET".equals(M())) {
			url = "/admin/authority/role_add";
		}else if("POST".equals(M())) {
			roleService.addRole(role);
			url = "redirect:/admin/role/index";
		}
		return url;
	}
	
	/**
	 * 编辑角色
	 * @return
	 */
	@RequestMapping("edit")
	@Transactional
	public String edit(Map<String, Object> map,@ModelAttribute SystemRole role) {
		String url = "";
		int id = Integer.valueOf(I("id"));
		if("GET".equals(M())) {
			SystemRole oneRole = roleService.findById(id);
			map.put("role", oneRole);
			url = "/admin/authority/role_edit";
		}else if("POST".equals(M())) {
			roleService.updateById(role);
			url = "redirect:/admin/role/index";
		}
		return url;
	}
	
	/**
	 * 删除角色
	 * @return
	 */
	@RequestMapping("del")
	public String del() {
		int id = Integer.valueOf(I("id"));
		roleService.deleteById(id);
		return "redirect:/admin/role/index";
	}
	
	/**
	 * 修改角色权限
	 * @param role
	 * @return
	 */
	@RequestMapping("rules")
	public String rules(Map<String,Object>map,@ModelAttribute SystemRole role) {
		String url = "";
		if("GET".equals(M())) {
			int id = Integer.valueOf(I("id"));
			SystemRole oneRole = roleService.findById(id);
			List<SystemRuleGroup> groups = groupService.findAllRules();
			map.put("groups", groups);
			map.put("role", oneRole);
			url = "/admin/authority/rules";
		}else if("POST".equals(M())) {
			String[] ids = request.getParameterValues("ruleId");
			StringBuffer idStringBuffer = new StringBuffer();
			for(String id : ids) {
				idStringBuffer.append(id+",");
			}
			role.setRules(idStringBuffer.substring(0, idStringBuffer.length()-1));
			roleService.updateById(role);
			url = "redirect:/admin/role/index";
		}
		return url;
	}
	
	
	
	
	
	
	
	
}
