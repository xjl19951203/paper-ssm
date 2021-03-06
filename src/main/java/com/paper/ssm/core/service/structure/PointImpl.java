package com.paper.ssm.core.service.structure;

import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.dao.structure.PointDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: PointImpl
 * @author: ZengYuan
 * @description:
 * @date 2020/3/18 19:58
 * @version: 1.0
 */
@Service("pointService")
public class PointImpl implements PointService {

    @Resource
    PointDao pointDao;

    @Override
    public Point insert(Point record) {
        this.pointDao.insert(record);
        return record;
    }

    @Override
    public int insert(List<Point> records) {
        return 0;
    }

    @Override
    public int delete(Point record) {
        return 0;
    }

    @Override
    public Point update(Point record) {
        this.pointDao.update(record);
        return record;
    }

    @Override
    public List<Point> selectListByQuery(Point query) {
        return this.pointDao.selectListByQuery(query);
    }

    @Override
    public Integer selectCountByQuery(Point query) {
        return null;
    }

    @Override
    public Point selectByPrimaryKey(Integer id) {
        return this.pointDao.selectByPrimaryKey(id);
    }

    @Override
    public Point selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
