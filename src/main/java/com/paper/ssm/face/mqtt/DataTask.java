package com.paper.ssm.face.mqtt;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.data.DataService;

import javax.annotation.Resource;

/**
 * @className: DataTask
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 13:05
 * @version: 1.0
 */
public class DataTask implements Task {

    private Data data;
    @Resource
    DataService dataService;

    public DataTask(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        this.dataService.insert(data);
    }
}
