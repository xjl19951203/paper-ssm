package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.instantiate.Bind;
import com.paper.ssm.core.service.instantiate.BindService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@RequestMapping("/api/binds")
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

    @Override
    public Bind selectByPrimaryKey(Integer id) {
        return null;
    }
}
