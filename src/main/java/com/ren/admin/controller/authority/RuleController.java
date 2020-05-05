package com.ren.admin.controller.authority;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ren.model.SystemRule;
import com.ren.model.SystemRuleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ren.admin.controller.CommontController;
import com.ren.service.SystemRuleGroupService;
import com.ren.service.SystemRuleService;

import cn.hutool.json.JSONUtil;

@Controller
@RequestMapping("/admin/rule/")
public class RuleController extends CommontController{
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	SystemRuleGroupService ruleGroupService;
	
	@Autowired
	SystemRuleService ruleService;
	
	/**
	 * 规则列表
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "/admin/authority/rule_list";
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
		List<SystemRule> rules = ruleService.findRulePage(name, orderBy, start, length, search);
		map.put("draw", draw);
		map.put("recordsTotal", ruleService.countAll());
		map.put("recordsFiltered",ruleService.countSearch(search));
		map.put("data", rules);
		return JSONUtil.toJsonStr(map);
	}
	
	/**
	 * 添加规则
	 * @param map
	 * @param rule
	 * @return
	 */
	@RequestMapping("add")
	@Transactional
	public String add(Map<String, List<SystemRuleGroup>> map, @ModelAttribute SystemRule rule) {
		String url = "";
		if("GET".equals(M())) {
			url = "/admin/authority/rule_add";
			List<SystemRuleGroup> groups = ruleGroupService.findAll();
			map.put("groups", groups);
		}else if("POST".equals(M())) {
			ruleService.addRule(rule);
			url = "redirect:/admin/rule/index";
		}
		return url;
	}
	
	/**
	 * 编辑规则
	 * @return
	 */
	@RequestMapping("edit")
	@Transactional
	public String edit(Map<String, Object> map,@ModelAttribute SystemRule rule) {
		String url = "";
		int id = Integer.valueOf(I("id"));
		if("GET".equals(M())) {
			url = "/admin/authority/rule_edit";
			List<SystemRuleGroup> groups = ruleGroupService.findAll();
			SystemRule oneRule = ruleService.findById(id);
			map.put("groups", groups);
			map.put("rule", oneRule);
		}else if("POST".equals(M())) {
			ruleService.updateById(rule, id);
			url = "redirect:/admin/rule/index";
		}
		return url;
	}
	
	/**
	 * 删除规则
	 * @return
	 */
	@RequestMapping("del")
	public String del() {
		int id = Integer.valueOf(I("id"));
		ruleService.deleteById(id);
		return "redirect:/admin/rule/index";
	}
	
	
	
	
	
	
	
	
	
}
