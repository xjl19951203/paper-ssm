package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.model.normalize.Link;
import com.paper.ssm.model.normalize.Rule;
import com.paper.ssm.mvc.dao.normalize.ChainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @className: ChainImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 11:30
 * @version: 1.0
 */
@Service("chainService")
public class ChainImpl implements ChainService {

    @Resource
    ChainDao chainDao;
    @Resource
    RuleService ruleService;

    @Override
    public Chain insert(Chain record) {
        return null;
    }

    @Override
    public int insert(List<Chain> records) {
        return 0;
    }

    @Override
    public int delete(Chain record) {
        return 0;
    }

    @Override
    public Chain update(Chain record) {
        return null;
    }

    @Override
    public List<Chain> selectListByQuery(Chain query) {
        return this.chainDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Chain query) {
        return null;
    }

    @Override
    public Chain selectByPrimaryKey(Integer id) {
        Chain chain = this.chainDao.selectByPrimaryKey(id);
        if (chain.getLinkList() != null) {
            HashMap<Integer, Rule> ruleHashMap = new HashMap<>(10);
            for (Link link : chain.getLinkList()) {
                if (!ruleHashMap.containsKey(link.getLeftId())) {
                    ruleHashMap.put(link.getLeftId(), link.getLeft());
                }
                if (!ruleHashMap.containsKey(link.getRightId())) {
                    ruleHashMap.put(link.getRightId(), link.getRight());
                }
            }
            chain.setRuleList(new ArrayList<>());
            for (Integer key : ruleHashMap.keySet()) {
                chain.getRuleList().add(ruleHashMap.get(key));
            }
        }
        return chain;
    }

    @Override
    public Chain selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
