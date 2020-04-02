package com.paper.ssm.core.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Model是模型的父类：分为结构化、规范化、实例化等三个支线
 * a. 结构化:
 * b. 规范化：
 * c. 实例化：
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
