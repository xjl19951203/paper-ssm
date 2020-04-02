package com.paper.ssm.run.data;

import lombok.Data;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

/**
 * 操作日志记录
 * @author ZengYuan
 */
@Measurement(name = "log")
@Data
public class Log {

    private static final long serialVersionUID = 1L;

    /** Log是属于某个采集任务的 */
    @Column(name = "taskId")
    private Integer taskId;
}
