package com.paper.ssm.model.task;

import com.paper.ssm.model.Model;
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
public class Task extends Model {

    private Integer cubeId;
    private Cube cube;
    List<Bind> bindList;

}
