package com.ren.dao;

import com.ren.mapper.SystemRoleMapper;
import com.ren.model.SystemRole;
import com.ren.example.SystemRoleExample;
import com.ren.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemRoleDao {

    @Autowired
    private SystemRoleMapper mapper;

    public boolean insert(SystemRole user) {
        return mapper.insert(user) > 0;
    }

    public boolean del(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(SystemRole user) {
        return mapper.updateByPrimaryKeySelective(user) > 0;
    }

    public SystemRole findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<SystemRole> queryRolePage(String name, String orderBy, int start, int length, String search) {
        SystemRoleExample example = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andNameLike("%" + search + "%");
        }
        example.setPaging(true);
        example.setRowIndex(start);
        example.setPageSize(length);
        example.setOrderByClause(name + " " + orderBy);
        return mapper.selectByExample(example);
    }

    public long countRoleBySearch(String search) {
        SystemRoleExample example = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andNameLike("%" + search + "%");
        }
        return mapper.countByExample(example);
    }

    public List<SystemRole> queryAll() {
        SystemRoleExample example = new SystemRoleExample();
        return mapper.selectByExample(example);
    }

}
