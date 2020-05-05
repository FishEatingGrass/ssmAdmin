package com.ren.service;

import java.util.List;

import com.ren.model.SystemUser;

public interface SystemUserService {
	
	SystemUser findById(int id);
	
	SystemUser findByNameAndPassword(String name,String password);
	
	int updateUserLoginSuccessInfo(int loginTime,String loginIp,int id);
	
	SystemUser findByUserName(String userName);

	boolean updateUserLoginErrorInfo(int errorTime,int id);

	boolean updateUsePhoto(String photo,int id);

	boolean updateUseInfo(String trueName,String phone,String password,int id);

	boolean addUser(SystemUser user);
	
	List<SystemUser> findUserPage(String name,String orderBy,int start,int length,String search);
	int countAll();
	int countSearch(String search);
	boolean updateUserFromAdmin(SystemUser user);
	boolean deleteById(int id);
}
