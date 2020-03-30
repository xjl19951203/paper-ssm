package com.paper.ssm.mvc.service.normalize;

import com.paper.ssm.model.normalize.Attribute;
import com.paper.ssm.mvc.dao.normalize.AttributeDao;
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
@Service("baseService")
public class AttributeImpl implements BaseService {

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
