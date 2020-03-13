package com.paper.ssm.influx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZengYuan
 */
@Configuration
public class InfluxConfig {

    @Value("${spring.influx.url:''}")
    private String influxUrl;

    @Value("${spring.influx.user:''}")
    private String userName;

    @Value("${spring.influx.password:''}")
    private String password;

    @Value("${spring.influx.database:''}")
    private String database;

    public InfluxDBUtils influxDbUtils() {
        return new InfluxDBUtils(userName, password, influxUrl, database, "");
    }
}
