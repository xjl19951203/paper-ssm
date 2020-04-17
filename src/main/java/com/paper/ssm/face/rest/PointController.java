package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.structure.Point;
import com.paper.ssm.core.service.structure.PointService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: PointController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 15:41
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/structure/points")
public class PointController extends AbstractController<Point>{

    @Resource
    PointService pointService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Point insert(@RequestBody Point record) {
        return this.pointService.insert(record);
    }

    @Override
    public int delete(Point record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Point update(@RequestBody Point record) {
        return this.pointService.update(record);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Point> selectListByQuery(Point query) {
        return this.pointService.selectListByQuery(query);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @Override
    public Point selectByPrimaryKey(@PathVariable Integer id) {
        return this.pointService.selectByPrimaryKey(id);
    }
}
