package com.ibm.mybatis.mybatis.entity;

public class HelpCategory {
    private Short helpCategoryId;
    private String name;
    private Short parentCategoryId;
    private String url;

    public Short getHelpCategoryId() {
        return helpCategoryId;
    }

    public void setHelpCategoryId(Short helpCategoryId) {
        this.helpCategoryId = helpCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Short parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
