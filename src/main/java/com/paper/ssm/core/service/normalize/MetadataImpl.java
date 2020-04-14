package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.dao.normalize.MetadataDao;
import com.paper.ssm.core.model.normalize.Metadata;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: MetadataImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/12 23:58
 * @version: 1.0
 */
@Service("metadataService")
public class MetadataImpl implements MetadataService {

    @Resource
    MetadataDao metadataDao;

    @Override
    public Metadata insert(Metadata record) {
        this.metadataDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Metadata> records) {
        return 0;
    }

    @Override
    public int delete(Metadata record) {
        return 0;
    }

    @Override
    public Metadata update(Metadata record) {
        this.metadataDao.update(record);
        return record;
    }

    @Override
    public List<Metadata> selectListByQuery(Metadata query) {
        return this.metadataDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Metadata query) {
        return null;
    }

    @Override
    public Metadata selectByPrimaryKey(Integer id) {
        return this.metadataDao.selectByPrimaryKey(id);
    }

    @Override
    public Metadata selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
