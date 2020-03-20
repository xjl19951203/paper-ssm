package com.paper.ssm.mvc.service;

import com.paper.ssm.model.normalize.Link;
import com.paper.ssm.mvc.dao.normalize.LinkDao;
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
    LinkDao linkDao;

    @Override
    public Link insert(Link record) {
        this.linkDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Link> records) {
        return 0;
    }

    @Override
    public int delete(Link record) {
        return 0;
    }

    @Override
    public Link update(Link record) {
        return null;
    }

    @Override
    public List<Link> selectListByQuery(Link query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Link query) {
        return null;
    }

    @Override
    public Link selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Link selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
