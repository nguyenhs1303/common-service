package com.mbal.saleportal.spring_template.config.database.write;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Getter
@Configuration
@PropertySource("classpath:application.yaml")
@ConfigurationProperties("spring.datasource-write-data.hikari")
public class HikariWriteDataProperties {

    private String poolName;
    private int minimumIdle;
    private int maximumPoolSize;
    private int idleTimeout;
}
