package com.paper.ssm.core.service.integration;

import com.paper.ssm.core.model.integration.Graph;
import com.paper.ssm.core.model.integration.Process;
import com.paper.ssm.core.service.Service;

import javax.annotation.Resource;

/**
 * @className: TaskService
 * @author: ZengYuan
 * @description:
 * @date 2020/3/10 0:49
 * @version: 1.0
 */
@Resource
public interface ProcessService extends Service<Process> {

    /**
     * 获取融合的流图
     * @param id processId
     * @return 流图
     */
    Graph get(Integer id);

}
