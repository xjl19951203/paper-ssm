package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.data.DataService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: DataController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 9:43
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/data")
public class DataController extends AbstractController<Data>{

    @Resource
    DataService dataService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Data insert(@RequestBody Data record) {
        return this.dataService.insert(record);
    }

    @Override
    public int delete(Data record) {
        return 0;
    }

    @Override
    public Data update(Data record) {
        return null;
    }

    @Override
    public Data selectByPrimaryKey(Integer id) {
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Data> selectListByQuery(Data query) {
        return this.dataService.selectListByQuery(query);
    }
}
