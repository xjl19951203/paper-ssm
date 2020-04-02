package com.paper.ssm.core.service.data;


import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.model.normalize.Chain;

import javax.annotation.Resource;

/**
 * @author ZengYuan
 */
@Resource
public interface DataService {

    /**
     * 对目标数据结合规则链实现规范化
     * @param data 目标数据
     * @return 返回规范后的data
     */
    Data insert(Data data);

}
