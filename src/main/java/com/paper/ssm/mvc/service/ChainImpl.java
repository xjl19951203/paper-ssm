package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Chain;
import com.paper.ssm.mvc.dao.ChainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        return null;
    }

    @Override
    public Integer selectCountByQuery(Chain query) {
        return null;
    }

    @Override
    public Chain selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Chain selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
