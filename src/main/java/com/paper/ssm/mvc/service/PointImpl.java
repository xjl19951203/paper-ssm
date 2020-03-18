package com.paper.ssm.mvc.service;

import com.paper.ssm.model.structure.Point;
import com.paper.ssm.mvc.dao.structure.PointDao;
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
        return null;
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
        return null;
    }

    @Override
    public List<Point> selectListByQuery(Point query) {
        return null;
    }

    @Override
    public Integer selectCountByQuery(Point query) {
        return null;
    }

    @Override
    public Point selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Point selectSimpleByPrimaryKey(Integer id) {
        return null;
    }
}
