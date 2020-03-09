package com.paper.ssm.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Model是模型的父类：分为结构化和规范化两个支线
 * a. Component: 组件，结构化的父类
 * b. Rule：规则，规范化的父类
 * 其中，Component 与 Rule 是 M:1的关系，即一个Rule可以被多个Component复用，
 * 将Rule与Component构建关系，可以实现对模型结构的不同层级，不同模块，不同粒度的嵌入规则
 */
// 返回的json中去掉值为null的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model {

    //    @JsonIgnore  //返回时排除掉这个字段
    protected Integer id;
    protected String title;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    protected Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
