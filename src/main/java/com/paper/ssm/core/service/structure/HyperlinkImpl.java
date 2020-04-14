package com.paper.ssm.core.service.structure;

import com.paper.ssm.core.dao.structure.HyperlinkDao;
import com.paper.ssm.core.model.structure.Hyperlink;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: HyperlinkImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 15:43
 * @version: 1.0
 */
@Service("hyperlinkService")
public class HyperlinkImpl implements HyperlinkService {

    @Resource
    HyperlinkDao hyperlinkDao;

    @Override
    public Hyperlink insert(Hyperlink record) {
        this.hyperlinkDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Hyperlink> records) {
        return 0;
    }

    @Override
    public int delete(Hyperlink record) {
        return 0;
    }

    @Override
    public Hyperlink update(Hyperlink record) {
        this.hyperlinkDao.update(record);
        return record;
    }

    @Override
    public List<Hyperlink> selectListByQuery(Hyperlink query) {
        return this.hyperlinkDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Hyperlink query) {
        return null;
    }

    @Override
    public Hyperlink selectByPrimaryKey(Integer id) {
        return this.hyperlinkDao.selectByPrimaryKey(id);
    }

    @Override
    public Hyperlink selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
