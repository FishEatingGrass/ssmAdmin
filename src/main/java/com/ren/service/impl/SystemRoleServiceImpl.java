package com.ren.service.impl;

import java.util.List;

import com.ren.dao.SystemRoleDao;
import com.ren.model.SystemRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ren.service.SystemRoleService;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Autowired
    SystemRoleDao roleDao;

    @Override
    public boolean addRole(SystemRole role) {
        return roleDao.insert(role);
    }

    @Override
    public List<SystemRole> findRolePage(String name, String orderBy, int start, int length, String search) {
        return roleDao.queryRolePage(name, orderBy, start, length, search);
    }

    @Override
    public long countSearch(String search) {
        return roleDao.countRoleBySearch(search);
    }

    @Override
    public long countAll() {
        return roleDao.countRoleBySearch("");
    }

    @Override
    public SystemRole findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public boolean updateById(SystemRole role) {
        return roleDao.update(role);
    }

    @Override
    public boolean deleteById(int id) {
        return roleDao.del(id);
    }

    @Override
    public List<SystemRole> findAll() {
        return roleDao.queryAll();
    }


}
