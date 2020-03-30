package com.paper.ssm.mvc.service.normalize;

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

    @Override
    public Rule insert(Rule record) {
        this.ruleDao.insert(record);
        return record;
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
        this.ruleDao.update(record);
        return record;
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
        return this.ruleDao.selectByPrimaryKey(id);
    }

    @Override
    public Rule selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
