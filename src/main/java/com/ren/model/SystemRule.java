package com.ren.model;

import java.util.List;

public class SystemRule {
    private Integer id;

    private String url;

    private String name;

    private String remark;

    private Integer groupId;

    private List<SystemRuleGroup> group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public List<SystemRuleGroup> getGroup() {
        return group;
    }

    public void setGroup(List<SystemRuleGroup> group) {
        this.group = group;
    }
}