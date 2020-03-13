package com.paper.ssm.model.task;

import com.paper.ssm.influx.data.Data;
import lombok.Getter;
import lombok.Setter;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZengYuan
 */
@Measurement(name = "message")
@Getter
@Setter
public class Message implements Serializable {

    public static final Integer MESSAGE_ATTRIBUTE = 0;
    public static final Integer MESSAGE_METHOD = 1;
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    private Long id;
    @Column(name = "deviceId")
    private Integer deviceId;
    @Column(name = "messageType")
    private Integer messageType;
    @Column(name = "methodId")
    private Integer methodId;
    @Column(name = "dataList")
    private List<Data> dataList;

}
