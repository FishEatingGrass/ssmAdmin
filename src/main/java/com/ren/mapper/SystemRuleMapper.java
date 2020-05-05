package com.ren.mapper;

import com.ren.model.SystemRule;
import com.ren.example.SystemRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemRuleMapper {
    int countByExample(SystemRuleExample example);

    int deleteByExample(SystemRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemRule record);

    int insertSelective(SystemRule record);

    List<SystemRule> selectByExample(SystemRuleExample example);

    SystemRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemRule record, @Param("example") SystemRuleExample example);

    int updateByExample(@Param("record") SystemRule record, @Param("example") SystemRuleExample example);

    int updateByPrimaryKeySelective(SystemRule record);

    int updateByPrimaryKey(SystemRule record);

    int countSearch(String search);

    List<SystemRule> queryRulePage(String name, String orderBy, int start, int length, String search);
}