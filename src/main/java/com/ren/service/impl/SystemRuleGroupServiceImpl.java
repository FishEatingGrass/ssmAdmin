package com.ren.service.impl;


import com.ren.dao.SystemRuleGroupDao;
import com.ren.model.SystemRuleGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ren.service.SystemRuleGroupService;

import java.util.List;

@Service
public class SystemRuleGroupServiceImpl implements SystemRuleGroupService {

    @Autowired
    SystemRuleGroupDao ruleGroupDao;

    @Override
    public List<SystemRuleGroup> findGroupPage(int start, int length, String name, String orderBy, String search) {
        return ruleGroupDao.queryGroupPage(start, length, name, orderBy, search);
    }

    @Override
    public long countAll() {
        return ruleGroupDao.countByLimit("");
    }

    @Override
    public void addRuleGroup(String name) {
		SystemRuleGroup ruleGroup = new SystemRuleGroup();
		ruleGroup.setName(name);
        ruleGroupDao.insert(ruleGroup);
    }

    @Override
    public long countSearch(String search) {
        return ruleGroupDao.countByLimit(search);
    }

    @Override
    public SystemRuleGroup findById(int id) {
        return ruleGroupDao.findById(id);
    }

    @Override
    public boolean updateNameById(String name, int id) {
        SystemRuleGroup ruleGroup = ruleGroupDao.findById(id);
        ruleGroup.setName(name);
        return ruleGroupDao.update(ruleGroup);
    }

    @Override
    public boolean deleteById(int id) {
        return ruleGroupDao.del(id);
    }

    @Override
    public List<SystemRuleGroup> findAll() {
        return ruleGroupDao.listByLimit("");
    }

    @Override
    public List<SystemRuleGroup> findAllRules() {
        return ruleGroupDao.listByLimit("");
    }

}
