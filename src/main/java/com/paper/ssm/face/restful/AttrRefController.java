package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.AttrRef;
import com.paper.ssm.core.service.normalize.AttrRefService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: AttrRefController
 * @author: ZengYuan
 * @description:
 * @date 2020/4/14 15:54
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/normalize/attrrefs")
public class AttrRefController extends AbstractController<AttrRef> {

    @Resource
    AttrRefService attrRefService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public AttrRef insert(@RequestBody AttrRef record) {
        return this.attrRefService.insert(record);
    }

    @Override
    public int delete(AttrRef record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public AttrRef update(@RequestBody AttrRef record) {
        return this.attrRefService.update(record);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<AttrRef> selectListByQuery(AttrRef query) {
        return this.attrRefService.selectListByQuery(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public AttrRef selectByPrimaryKey(@PathVariable Integer id) {
        return this.attrRefService.selectByPrimaryKey(id);
    }
}
