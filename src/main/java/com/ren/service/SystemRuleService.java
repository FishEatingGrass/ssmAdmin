package com.ren.service;

import java.util.List;

import com.ren.model.SystemRule;

public interface SystemRuleService {
	boolean addRule(SystemRule rule);
	List<SystemRule> findRulePage(String name,String orderBy,int start,int length,String search);
	int countAll();
	int countSearch(String search);
	SystemRule findById(int id);
	boolean updateById(SystemRule rule,int id);
	boolean deleteById(int id);
	List<SystemRule> findByGroupId(int groupId);
	List<SystemRule> ruleListByIds(String ids);
}
