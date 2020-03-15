package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.structure.Pipe;
import com.paper.ssm.mvc.service.PipeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Pipe insert(@RequestBody Pipe record) {
        return this.pipeService.insert(record);
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

    @Override
    public Pipe selectByPrimaryKey(Integer id) {
        return null;
    }
}
