package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.model.normalize.InfoRef;
import com.paper.ssm.core.dao.normalize.ChainDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    AttributeService attributeService;

    @Override
    public Chain insert(Chain record) {
        this.chainDao.insert(record);
        return record;
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
        this.chainDao.update(record);
        return record;
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
//        chain.setAttributeList(new ArrayList<>());
//        for (InfoRef infoRef : chain.getLinkList()) {
//            chain.getAttributeList().add(this.attributeService.selectByPrimaryKey(infoRef.getAttributeId()));
//        }
        return chain;
    }

    @Override
    public Chain selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
