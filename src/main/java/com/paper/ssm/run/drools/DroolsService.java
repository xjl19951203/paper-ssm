package com.paper.ssm.run.drools;

import com.paper.ssm.core.model.normalize.Chain;
import com.paper.ssm.run.data.Data;
import org.springframework.stereotype.Service;


/**
 * @author ZengYuan
 */
@Service
public interface DroolsService {

    /**
     * 驱动单一数据的规范化
     * @param data 目标数据
     * @param chain 用于实例化的规则链
     */
    void run(Data data, Chain chain);

}