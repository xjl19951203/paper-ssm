package com.paper.ssm.face.restful;

import com.paper.ssm.core.model.normalize.AttrRef;
import com.paper.ssm.core.service.normalize.AttrRefService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Override
    public AttrRef insert(AttrRef record) {
        return null;
    }

    @Override
    public int delete(AttrRef record) {
        return 0;
    }

    @Override
    public AttrRef update(AttrRef record) {
        return null;
    }

    @Override
    public AttrRef selectByPrimaryKey(Integer id) {
        return null;
    }
}
