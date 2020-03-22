package com.paper.ssm.task.influx;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZengYuan
 */
@Getter
@Setter
@Configuration
public class InfluxConfig {

//    private String username = "admin";
//    private String password = "admin";
//    private String url = "http://39.108.132.71:8086";
//    private String database = "collection";
//    private String measurement = "property";

    @Value("${spring.influx.url:''}")
    private String influxUrl;

    @Value("${spring.influx.user:''}")
    private String userName;

    @Value("${spring.influx.password:''}")
    private String password;

    @Value("${spring.influx.database:''}")
    private String database;

}
