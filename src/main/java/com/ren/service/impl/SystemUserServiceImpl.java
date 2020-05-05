package com.ren.service.impl;


import com.ren.dao.SystemUserDao;
import com.ren.model.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ren.service.SystemUserService;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserDao userDao;

    @Override
    public SystemUser findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public SystemUser findByNameAndPassword(String name, String password) {
        List<SystemUser> systemUsers = userDao.listSystemUserByLimit(name, password);
        if (systemUsers == null || systemUsers.size() == 0) {
            return null;
        }
        return systemUsers.get(0);
    }

    @Override
    public int updateUserLoginSuccessInfo(int loginTime, String loginIp, int id) {
        return userDao.updateUserLoginSuccessInfo(loginTime, loginIp, id);
    }

    @Override
    public SystemUser findByUserName(String userName) {
		List<SystemUser> systemUsers = userDao.listSystemUserByLimit(userName, "");
		if (systemUsers == null || systemUsers.size() == 0) {
			return null;
		}
		return systemUsers.get(0);
    }

    @Override
    public boolean updateUserLoginErrorInfo(int errorTime, int id) {

        return userDao.updateUserLoginErrorInfo(errorTime, id);
    }

    @Override
    public boolean updateUsePhoto(String photo, int id) {
		SystemUser systemUser = userDao.findById(id);
		systemUser.setPhoto(photo);
		return userDao.update(systemUser);
    }

    @Override
    public boolean updateUseInfo(String trueName, String phone, String password, int id) {
        SystemUser systemUser = userDao.findById(id);
        systemUser.setTrueName(trueName);
        systemUser.setPhone(phone);
        systemUser.setPassword(password);
        return userDao.update(systemUser);
    }

    @Override
    public boolean addUser(SystemUser user) {
        return userDao.insert(user);
    }

    @Override
    public List<SystemUser> findUserPage(String name, String orderBy, int start, int length, String search) {
        return userDao.queryUserPage(name, orderBy, start, length, search);
    }

   	@Override
	public int countAll() {
		return userDao.countSearch("");
	}

	@Override
	public int countSearch(String search) {
		return userDao.countSearch(search);
	}

    @Override
    public boolean updateUserFromAdmin(SystemUser user) {
        return userDao.update(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userDao.del(id);
    }

}
