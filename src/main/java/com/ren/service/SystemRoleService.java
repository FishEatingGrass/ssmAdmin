package com.ren.service;

import com.ren.model.SystemRole;

import java.util.List;

public interface SystemRoleService {
	boolean addRole(SystemRole role);
	List<SystemRole> findRolePage(String name, String orderBy, int start, int length, String search);
	long countSearch(String search);
	long countAll();
	SystemRole findById(int id);
	boolean updateById(SystemRole role);
	boolean deleteById(int id);
	List<SystemRole> findAll();
	
}
