package com.ren.admin.controller.authority;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemRuleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ren.admin.controller.CommontController;
import com.ren.service.SystemRuleGroupService;

import cn.hutool.json.JSONUtil;

/**
 * @ClassName: RuleGroupController 
 * @Description: TODO(权限分组) 
 * @author 306524624@qq.com 
 * @date 2018年3月13日 下午1:21:29
 */
@Controller
@RequestMapping("/admin/rulegroup/")
public class RuleGroupController extends CommontController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	SystemRuleGroupService ruleGroupService;
	
	/**
	 * 权限分组列表
	 * @return
	 */
	@GetMapping("index")
	public String index() {
		return "/admin/authority/group_list";
	}
	
	/**
	 * 获取分页数据
	 * @return
	 */
	@GetMapping(value="page",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String page(Map<String,Object> map) {
		int draw = Integer.valueOf(I("draw"));
		int start = Integer.valueOf(I("start"));
		int length = Integer.valueOf(I("length"));
		String name = I("columns["+Integer.valueOf(I("order[0][column]"))+"][data]"); //排序字段
		String orderBy = I("order[0][dir]"); //排序方式
		String search = I("search[value]"); //搜索词
		List<SystemRuleGroup> groups = ruleGroupService.findGroupPage(start, length,name,orderBy,search);
		map.put("draw", draw);
		map.put("recordsTotal", ruleGroupService.countAll());
		map.put("recordsFiltered",ruleGroupService.countSearch(search));
		map.put("data", groups);
		return JSONUtil.toJsonStr(map);
	}
	
	/**
	 * 添加分组
	 * @return
	 */
	@RequestMapping("add")
	@Transactional
	public String add() {
		String url = "";
		if("GET".equals(M())) {
			url = "/admin/authority/group_add";
		}else if("POST".equals(M())) {
			String name = I("name");
			ruleGroupService.addRuleGroup(name);
			url = "redirect:/admin/rulegroup/index";
		}
		return url;
	}
	
	/**
	 * 修改分组
	 * @param map
	 * @return
	 */
	@RequestMapping("edit")
	@Transactional
	public String edit(Map map) {
		String url = "";
		int id = Integer.valueOf(I("id"));
		if("GET".equals(M())) {
			map.put("group", ruleGroupService.findById(id));
			url = "/admin/authority/group_edit";
		}else if("POST".equals(M())) {
			String name = I("name");
			ruleGroupService.updateNameById(name, id);
			url = "redirect:/admin/rulegroup/index";
		}
		return url;
	}
	
	/**
	 * 删除分组
	 * @return
	 */
	@RequestMapping("del")
	public String del() {
		int id = Integer.valueOf(I("id"));
		ruleGroupService.deleteById(id);
		return "redirect:/admin/rulegroup/index";
	}
	
}
