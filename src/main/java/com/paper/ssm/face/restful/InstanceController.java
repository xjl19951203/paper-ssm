package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.instantiate.Instance;
import com.paper.ssm.core.service.instantiate.InstanceService;
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
@RequestMapping("/api/instances")
public class InstanceController extends AbstractController<Instance> {

    @Resource
    InstanceService instanceService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Instance> selectListByQuery(Instance query) {
        return this.instanceService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Instance insert(@RequestBody Instance record) {
        return this.instanceService.insert(record);
    }

    @Override
    public int delete(Instance record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Instance update(@RequestBody Instance record) {
        return this.instanceService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Instance selectByPrimaryKey(@PathVariable Integer id) {
        return this.instanceService.selectByPrimaryKey(id);
    }
}
