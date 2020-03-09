package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Rule;
import com.paper.ssm.mvc.dao.normalize.RuleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: RuleImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/9 19:54
 * @version: 1.0
 */
@Service("ruleService")
public class RuleImpl implements RuleService{

    @Resource
    RuleDao ruleDao;

    @Override
    public Rule insert(Rule record) {
        return null;
    }

    @Override
    public int insert(List<Rule> records) {
        return 0;
    }

    @Override
    public int delete(Rule record) {
        return 0;
    }

    @Override
    public Rule update(Rule record) {
        return null;
    }

    @Override
    public List<Rule> selectListByQuery(Rule query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Rule query) {
        return null;
    }

    @Override
    public Rule selectByPrimaryKey(Integer id) {
        Rule rule = this.ruleDao.selectByPrimaryKey(id);
        if (rule.getChainList() == null) {
            rule.setChainList(new ArrayList<>());
        }
        if (rule.getRange() != null) {
            rule.getChainList().add(rule.getRange());
        }
        if (rule.getDefaultValue() != null) {
            rule.getChainList().add(rule.getDefaultValue());
        }
        if (rule.getType() != null) {
            rule.getChainList().add(rule.getType());
        }
        if (rule.getUnit() != null) {
            rule.getChainList().add(rule.getUnit());
        }
        return rule;
    }

    @Override
    public Rule selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
