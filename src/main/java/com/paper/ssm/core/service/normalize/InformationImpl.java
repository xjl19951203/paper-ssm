package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.dao.normalize.InformationDao;
import com.paper.ssm.core.model.normalize.Information;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: InformationImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/12 23:59
 * @version: 1.0
 */
@Service("informationService")
public class InformationImpl implements InformationService{

    @Resource
    InformationDao informationDao;

    @Override
    public Information insert(Information record) {
        return null;
    }

    @Override
    public int insert(List<Information> records) {
        return 0;
    }

    @Override
    public int delete(Information record) {
        return 0;
    }

    @Override
    public Information update(Information record) {
        return null;
    }

    @Override
    public List<Information> selectListByQuery(Information query) {
        return this.informationDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Information query) {
        return null;
    }

    @Override
    public Information selectByPrimaryKey(Integer id) {
        return this.informationDao.selectByPrimaryKey(id);
    }

    @Override
    public Information selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
