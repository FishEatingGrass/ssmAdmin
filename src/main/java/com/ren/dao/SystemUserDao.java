package com.ren.dao;

import com.ren.example.SystemUserExample;
import com.ren.mapper.SystemUserMapper;
import com.ren.model.SystemUser;
import com.ren.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SystemUserDao {

    @Autowired
    private SystemUserMapper mapper;

    public boolean insert(SystemUser user) {
        return mapper.insert(user) > 0;
    }

    public boolean del(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean update(SystemUser user) {
        return mapper.updateByPrimaryKeySelective(user) > 0;
    }

    public SystemUser findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public List<SystemUser> listSystemUserByLimit(String name, String password) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(name)) {
            criteria.andUserNameEqualTo(name);
        }
        if (StringUtil.isnotNullorEmpty(password)) {
            criteria.andPasswordEqualTo(password);
        }
        return mapper.selectByExample(example);
    }

    public int updateUserLoginSuccessInfo(int loginTime, String loginIp, int id) {
        return mapper.updateUserLoginSuccessInfo(loginTime, loginIp, id);
    }

    public boolean updateUserLoginErrorInfo(int errorTime, int id) {
        return mapper.updateUserLoginErrorInfo(errorTime, id);
    }

    public int countSearch(String search) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andUserNameEqualTo(search);
        }
        return mapper.countByExample(example);
    }

    public List<SystemUser> queryUserPage(String name, String orderBy, int start, int length, String search) {
        SystemUserExample example = new SystemUserExample();
        SystemUserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isnotNullorEmpty(search)) {
            criteria.andUserNameLike("%" + search + "%");
        }
        example.setPaging(true);
        example.setRowIndex(start);
        example.setPageSize(length);
        example.setOrderByClause(name + " " + orderBy);
        return mapper.selectByExample(example);
    }
}
