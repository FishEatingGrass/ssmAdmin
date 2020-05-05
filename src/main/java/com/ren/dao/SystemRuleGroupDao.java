package com.ren.dao;

import com.ren.mapper.SystemRuleGroupMapper;
import com.ren.model.SystemRuleGroup;
import com.ren.example.SystemRuleGroupExample;
import com.ren.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemRuleGroupDao {

    @Autowired
    private SystemRuleGroupMapper mapper;

    public boolean insert(SystemRuleGroup user) {
        return mapper.insert(user) > 0;
    }

    public boolean del(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(SystemRuleGroup user) {
        return mapper.updateByPrimaryKeySelective(user) > 0;
    }

    public SystemRuleGroup findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<SystemRuleGroup> queryGroupPage(int start, int length, String name, String orderBy, String search) {
        SystemRuleGroupExample example = new SystemRuleGroupExample();
        SystemRuleGroupExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andNameLike("%" + search + "%");
        }
        example.setPaging(true);
        example.setRowIndex(start);
        example.setPageSize(length);
        example.setOrderByClause(name + " " + orderBy);
        return mapper.selectByExample(example);
    }

    public long countByLimit(String name) {
        SystemRuleGroupExample example = new SystemRuleGroupExample();
        SystemRuleGroupExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return mapper.countByExample(example);
    }

    public List<SystemRuleGroup> listByLimit(String name) {
        SystemRuleGroupExample example = new SystemRuleGroupExample();
        SystemRuleGroupExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        return mapper.selectByExample(example);
    }


}
