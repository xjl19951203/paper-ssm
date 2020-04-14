package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.InfoRef;
import com.paper.ssm.core.service.normalize.InfoRefService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @className: LinkController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/20 19:06
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/normalize/inforefs")
public class InfoRefController extends AbstractController<InfoRef> {

    @Resource
    InfoRefService linkService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public InfoRef insert(@RequestBody InfoRef record) {
        return this.linkService.insert(record);
    }

    @Override
    public int delete(InfoRef record) {
        return 0;
    }

    @Override
    public InfoRef update(InfoRef record) {
        return null;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @Override
    public InfoRef selectByPrimaryKey(@PathVariable Integer id) {
        return this.linkService.selectByPrimaryKey(id);
    }
}
