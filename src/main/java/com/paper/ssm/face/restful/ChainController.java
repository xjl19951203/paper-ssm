package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.core.service.normalize.ChainService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: ChainController
 * @author: ZengYuan
 * @description:
 * @date 2020/3/14 13:32
 * @version: 1.0
 */
@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping("/api/normalize/chains")
public class ChainController extends AbstractController<Chain> {

    @Resource
    ChainService chainService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @Override
    public List<Chain> selectListByQuery(Chain query) {
        return this.chainService.selectListByQuery(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Override
    public Chain insert(@RequestBody Chain record) {
        return this.chainService.insert(record);
    }

    @Override
    public int delete(Chain record) {
        return 0;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @Override
    public Chain update(@RequestBody Chain record) {
        return this.chainService.update(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Override
    public Chain selectByPrimaryKey(@PathVariable Integer id) {
        return this.chainService.selectByPrimaryKey(id);
    }
}
