package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.model.normalize.InfoRef;
import com.paper.ssm.core.dao.normalize.InfoRefDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: LinkImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/16 17:13
 * @version: 1.0
 */
@Service("linkService")
public class LinkImpl implements LinkService {

    @Resource
    InfoRefDao infoRefDao;

    @Override
    public InfoRef insert(InfoRef record) {
        this.infoRefDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<InfoRef> records) {
        return 0;
    }

    @Override
    public int delete(InfoRef record) {
        return 0;
    }

    @Override
    public InfoRef update(InfoRef record) {
        return null;
    }

    @Override
    public List<InfoRef> selectListByQuery(InfoRef query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(InfoRef query) {
        return null;
    }

    @Override
    public InfoRef selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public InfoRef selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
