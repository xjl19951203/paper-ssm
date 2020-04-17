package com.paper.ssm.face.rest;

import com.paper.ssm.core.model.integration.Bind;
import com.paper.ssm.core.service.integration.BindService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BindController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 23:13
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/integration/binds")
public class BindController extends AbstractController<Bind> {

    @Resource
    BindService bindService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Bind insert(@RequestBody Bind record) {
        return this.bindService.insert(record);
    }

    @Override
    public int delete(Bind record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Bind update(@RequestBody Bind record) {
        return this.bindService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Bind> selectListByQuery(Bind query) {
        return this.bindService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Bind selectByPrimaryKey(@PathVariable Integer id) {
        return this.bindService.selectByPrimaryKey(id);
    }
}
