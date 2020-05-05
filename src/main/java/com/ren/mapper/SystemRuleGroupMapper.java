package com.ren.mapper;

import com.ren.model.SystemRuleGroup;
import com.ren.example.SystemRuleGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemRuleGroupMapper {
    int countByExample(SystemRuleGroupExample example);

    int deleteByExample(SystemRuleGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemRuleGroup record);

    int insertSelective(SystemRuleGroup record);

    List<SystemRuleGroup> selectByExample(SystemRuleGroupExample example);

    SystemRuleGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemRuleGroup record, @Param("example") SystemRuleGroupExample example);

    int updateByExample(@Param("record") SystemRuleGroup record, @Param("example") SystemRuleGroupExample example);

    int updateByPrimaryKeySelective(SystemRuleGroup record);

    int updateByPrimaryKey(SystemRuleGroup record);
}