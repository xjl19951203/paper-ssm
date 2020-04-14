package com.paper.ssm.core.service.normalize;

import com.paper.ssm.core.dao.normalize.AttrRefDao;
import com.paper.ssm.core.model.normalize.AttrRef;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: AttrRefImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 15:52
 * @version: 1.0
 */
@Service("attrRefService")
public class AttrRefImpl implements AttrRefService {

    @Resource
    AttrRefDao attrRefDao;

    @Override
    public AttrRef insert(AttrRef record) {
        return null;
    }

    @Override
    public int insert(List<AttrRef> records) {
        return 0;
    }

    @Override
    public int delete(AttrRef record) {
        return 0;
    }

    @Override
    public AttrRef update(AttrRef record) {
        return null;
    }

    @Override
    public List<AttrRef> selectListByQuery(AttrRef query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(AttrRef query) {
        return null;
    }

    @Override
    public AttrRef selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public AttrRef selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
