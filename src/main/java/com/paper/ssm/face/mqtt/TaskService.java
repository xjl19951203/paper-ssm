package com.paper.ssm.face.mqtt;

import com.paper.ssm.core.model.data.Data;

/**
 * @author ZengYuan
 */
public interface TaskService{

    /**
     * 时序数据
     * @param data 时序数据
     */
    void run(Data data);

}
