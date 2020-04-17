package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.integration.Graph;
import com.paper.ssm.core.model.integration.Process;
import com.paper.ssm.core.service.integration.ProcessService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: TaskController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:53
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/integration/processs")
public class ProcessController extends AbstractController<Process> {

    @Resource
    ProcessService processService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Process> selectListByQuery(Process query) {
        return this.processService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Process insert(@RequestBody Process record) {
        return this.processService.insert(record);
    }

    @Override
    public int delete(Process record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Process update(@RequestBody Process record) {
        return this.processService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Process selectByPrimaryKey(@PathVariable Integer id) {
        return this.processService.selectByPrimaryKey(id);
    }


    @RequestMapping(value = "/{id}/graph", method = RequestMethod.GET)
    public Graph getGraph(@PathVariable Integer id) {
        return this.processService.get(id);
    }
}
