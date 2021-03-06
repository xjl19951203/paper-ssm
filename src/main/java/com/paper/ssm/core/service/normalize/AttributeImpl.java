package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.model.normalize.Attribute;
import com.paper.ssm.core.dao.normalize.AttributeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BaseImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 13:50
 * @version: 1.0
 */
@Service("attributeService")
public class AttributeImpl implements AttributeService {

    @Resource
    AttributeDao attributeDao;

    @Override
    public Attribute insert(Attribute record) {
        this.attributeDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Attribute> records) {
        return 0;
    }

    @Override
    public int delete(Attribute record) {
        return 0;
    }

    @Override
    public Attribute update(Attribute record) {
        this.attributeDao.update(record);
        return record;
    }

    @Override
    public List<Attribute> selectListByQuery(Attribute query) {
        return this.attributeDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Attribute query) {
        return null;
    }

    @Override
    public Attribute selectByPrimaryKey(Integer id) {
        return this.attributeDao.selectByPrimaryKey(id);
    }

    @Override
    public Attribute selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
