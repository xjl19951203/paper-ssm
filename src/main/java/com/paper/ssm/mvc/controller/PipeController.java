package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.mvc.service.structure.PipeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: PipeController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/15 16:47
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/pipes")
public class PipeController extends AbstractController<Pipe>{

    @Resource
    PipeService pipeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Pipe> selectListByQuery(Pipe query) {
        return this.pipeService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Pipe insert(@RequestBody Pipe record) {
        return this.pipeService.insert(record);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @Override
    public int insert(@RequestBody List<Pipe> records) {
        if (records == null || records.size() == 0) {
            return 0;
        }
        return this.pipeService.insert(records);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @Override
    public int delete(@RequestBody Pipe record) {
        return this.pipeService.delete(record);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Pipe update(@RequestBody Pipe record) {
        return this.pipeService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Pipe selectByPrimaryKey(@PathVariable Integer id) {
        return this.pipeService.selectByPrimaryKey(id);
    }
}
