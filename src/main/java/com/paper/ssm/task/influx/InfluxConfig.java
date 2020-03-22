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

    @Value("${spring.influx.url:''}")
    private String influxUrl;

    @Value("${spring.influx.user:''}")
    private String userName;

    @Value("${spring.influx.password:''}")
    private String password;

    @Value("${spring.influx.database:''}")
    private String database;

    public InfluxDbUtils influxDbUtils() {
        return new InfluxDbUtils(userName, password, influxUrl, database, "");
    }
}
