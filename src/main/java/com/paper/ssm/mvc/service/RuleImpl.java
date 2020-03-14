package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.rules.Default;
import com.paper.ssm.model.normalize.rules.Rule;
import com.paper.ssm.mvc.dao.normalize.*;
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
    @Resource
    DefaultDao defaultDao;
    @Resource
    RangeDao rangeDao;
    @Resource
    UnitDao unitDao;
    @Resource
    TypeDao typeDao;

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
        Rule res;
        Rule rule = this.ruleDao.selectByPrimaryKey(id);
        switch (rule.getType()) {
            case Rule.DEFAULT_TYPE:
                res = this.defaultDao.selectByPrimaryKey(rule.getDefaultId());
                res.setType(Rule.DEFAULT_TYPE);
                return res;
            case Rule.RANGE_TYPE:
                res = this.rangeDao.selectByPrimaryKey(rule.getRangeId());
                res.setType(Rule.RANGE_TYPE);
                return res;
            case Rule.TYPE_TYPE:
                res = this.typeDao.selectByPrimaryKey(rule.getTypeId());
                res.setType(Rule.TYPE_TYPE);
                return res;
            case Rule.UNIT_TYPE:
                res = this.unitDao.selectByPrimaryKey(rule.getUnitId());
                res.setType(Rule.UNIT_TYPE);
                return res;
            default:
                return rule;
        }
    }

    @Override
    public Rule selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
