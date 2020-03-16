package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Rule;
import com.paper.ssm.mvc.dao.normalize.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    InitialDao initialDao;
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
        return this.ruleDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Rule query) {
        return null;
    }

    @Override
    public Rule selectByPrimaryKey(Integer id) {
        Rule res;
        Rule rule = this.ruleDao.selectByPrimaryKey(id);
        switch (rule.getStyle()) {
            case Rule.INITIAL_STYLE:
                res = this.initialDao.selectByPrimaryKey(rule.getInitialId());
                if (res != null) {
                    res.setStyle(Rule.INITIAL_STYLE);
                }
                return res;
            case Rule.RANGE_STYLE:
                res = this.rangeDao.selectByPrimaryKey(rule.getRangeId());
                if (res != null) {
                    res.setStyle(Rule.RANGE_STYLE);
                }
                return res;
            case Rule.TYPE_STYLE:
                res = this.typeDao.selectByPrimaryKey(rule.getTypeId());
                if (res != null) {
                    res.setStyle(Rule.TYPE_STYLE);
                }
                return res;
            case Rule.UNIT_STYLE:
                res = this.unitDao.selectByPrimaryKey(rule.getUnitId());
                if (res != null) {
                    res.setStyle(Rule.RANGE_STYLE);
                }
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
