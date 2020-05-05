package com.ren.service.impl;

import com.ren.dao.SystemRuleDao;
import com.ren.mapper.SystemRuleMapper;
import com.ren.model.SystemRule;
import com.ren.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ren.service.SystemRuleService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemRuleServiceImpl implements SystemRuleService {

    @Autowired
    SystemRuleDao ruleDao;

    @Override
    public boolean addRule(SystemRule rule) {
        return ruleDao.insert(rule);
    }

    @Override
    public List<SystemRule> findRulePage(String name, String orderBy, int start, int length, String search) {
        return ruleDao.queryRulePage(name, orderBy, start, length, search);
    }

    @Override
    public int countAll() {
        return ruleDao.countSearch("");
    }

    @Override
    public int countSearch(String search) {
        return ruleDao.countSearch(search);
    }

    @Override
    public SystemRule findById(int id) {
        return ruleDao.findById(id);
    }

    @Override
    public boolean updateById(SystemRule rule, int id) {
        rule.setId(id);
        return ruleDao.update(rule);
    }

    @Override
    public boolean deleteById(int id) {
        return ruleDao.del(id);
    }

    @Override
    public List<SystemRule> findByGroupId(int groupId) {
        return ruleDao.listSystemRule(null, groupId);
    }

    @Override
    public List<SystemRule> ruleListByIds(String ids) {
        String[] split = StringUtils.split(ids, ",");
        if (split.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (String id : split) {
            list.add(Integer.parseInt(id));
        }
        return ruleDao.listSystemRule(list, null);
    }

}
