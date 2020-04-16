package com.paper.ssm.face.mqtt;

import com.paper.ssm.core.model.data.Data;
import com.paper.ssm.core.service.data.DataService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @className: DataTask
 * @author: ZengYuan
 * @description:
 * @date 2020/4/2 13:05
 * @version: 1.0
 */
@Service("taskService")
public class TaskImpl implements TaskService {

    @Resource
    DataService dataService;

    @Override
    public void run(Data data) {
        store(data);
    }

    private void store(Data data) {
        this.dataService.insert(data);
    }
}
