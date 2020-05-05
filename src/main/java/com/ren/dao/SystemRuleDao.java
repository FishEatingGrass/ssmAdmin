package com.ren.dao;

import com.ren.example.SystemRuleExample;
import com.ren.mapper.SystemRuleMapper;
import com.ren.model.SystemRule;
import com.ren.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemRuleDao {

    @Autowired
    private SystemRuleMapper mapper;

    public boolean insert(SystemRule user) {
        return mapper.insert(user) > 0;
    }

    public boolean del(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(SystemRule user) {
        return mapper.updateByPrimaryKeySelective(user) > 0;
    }

    public SystemRule findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int countSearch(String search) {
        SystemRuleExample example = new SystemRuleExample();
        SystemRuleExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andNameLike("%" + search + "%");
        }
        return mapper.countByExample(example);
    }

    public List<SystemRule> listSystemRule(List<Integer> ids, Integer groupId) {
        SystemRuleExample example = new SystemRuleExample();
        SystemRuleExample.Criteria criteria = example.createCriteria();
        if (groupId != null) {
            criteria.andGroupIdEqualTo(groupId);
        }
        if (ids != null && ids.size() > 0) {
            criteria.andIdIn(ids);
        }
        return mapper.selectByExample(example);
    }


    public List<SystemRule> queryRulePage(String name, String orderBy, int start, int length, String search) {
        return mapper.queryRulePage(name, orderBy, start, length, search);
    }
}
