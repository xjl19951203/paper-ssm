package com.paper.ssm.task;

import com.paper.ssm.model.structure.node.Cube;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 开启一次采集任务
 * @author ZengYuan
 */
@Getter
@Setter
public class Task{

    private List<Log> logList;
    private Integer cubeId;
    private Cube cube;

}
