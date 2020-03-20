package com.paper.ssm.mvc.controller;

import com.paper.ssm.model.normalize.Base;
import com.paper.ssm.mvc.service.BaseService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: BaseController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 14:02
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/bases")
public class BaseController extends AbstractController<Base> {

    @Resource
    BaseService baseService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Base insert(@RequestBody Base record) {
        return this.baseService.insert(record);
    }

    @Override
    public int delete(Base record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Base update(@RequestBody Base record) {
        return this.baseService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Base> selectListByQuery(Base query) {
        return this.baseService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Base selectByPrimaryKey(@PathVariable Integer id) {
        return this.baseService.selectByPrimaryKey(id);
    }
}
