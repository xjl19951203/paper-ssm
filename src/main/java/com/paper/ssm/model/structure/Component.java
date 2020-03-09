package com.paper.ssm.model.structure;

import com.paper.ssm.model.Model;
import com.paper.ssm.model.normalize.config.Config;
import com.paper.ssm.model.normalize.method.Method;
import com.paper.ssm.model.normalize.Rule;

import java.util.List;

/**
 *  模型的元素的公共父类：
 * （1）子类：
 *  a. Node：点
 *  b. Link: 线
 *  c: Graph：面
 *
 *  a. 数据结点；Data，最小粒度、不可拆分，承载数据能力
 *  b. 管道结点；Pipe，有向的连接两个Data结点，作为数据桥梁，解决数据规范、转换等
 *  c. 图结点；Graph，基于DAG的邻接表实现，可以作为子节点构造更大的graph
 *  d. 边界结点：Edge，通过构建Graph与Data之间的联系，约束Graph的边界
 *
 *  Pipe和Edge的区别：
 *  前者是与Data一个层面，着力于打通数据结点的通道，后者与Graph一个层面只用来界定边界，不具备数据能力
 *
 * 1. DAG基于邻接表实现
 * 2. 与常规DAG不同，Graph有可能是更大的Graph的组成结点
 * 3. XML <=> DAG，二者互相转换
 * @author ZengYuan
 */
public abstract class Component extends Model {

    protected Integer ruleId;
    /** 结点规范化*/
    protected Rule rule;
    /** 结点配置*/
    protected List<Config> configList;
    /** 结点赋能*/
    protected List<Method> methodList;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public List<Config> getConfigList() {
        return configList;
    }

    public void setConfigList(List<Config> configList) {
        this.configList = configList;
    }

    public List<Method> getMethodList() {
        return methodList;
    }

    public void setMethodList(List<Method> methodList) {
        this.methodList = methodList;
    }


}
