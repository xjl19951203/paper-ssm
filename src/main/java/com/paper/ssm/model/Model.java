package com.paper.ssm.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Model是模型的父类：分为结构化和规范化两个支线
 * a. Component: 组件，结构化的父类
 * b. Rule：规则，规范化的父类
 * 其中，Component 与 Rule 是 M:1的关系，即一个Rule可以被多个Component复用，
 * 将Rule与Component构建关系，可以实现对模型结构的不同层级，不同模块，不同粒度的嵌入规则
 */
/** 返回的json中去掉值为null的属性
 * @author ZengYuan*/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Model {

    protected Integer id;
    protected String title;
    protected String label;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    /** @JsonFormat(pattern = "yyyy-MM-dd HH:mm") */
    protected Date updatedAt;

}
