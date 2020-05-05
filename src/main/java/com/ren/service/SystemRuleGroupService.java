package com.ren.service;

import com.ren.model.SystemRuleGroup;

import java.util.List;

public interface SystemRuleGroupService {
	
	List<SystemRuleGroup> findGroupPage(int start, int length, String name, String orderBy, String search);

	long countAll();
	
	void addRuleGroup(String name);

	long countSearch(String search);
	
	SystemRuleGroup findById(int id);

	boolean updateNameById(String name,int id);

	boolean deleteById(int id);
	
	List<SystemRuleGroup> findAll();

	List<SystemRuleGroup> findAllRules();
}
