package com.mbal.saleportal.spring_template.config.database.read;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariConfigReadData extends HikariConfig {
    protected final HikariReadDataProperties hikariReadDataWareHouseProperties;

    protected final String PERSISTENCE_UNIT_NAME = "secondary";

    protected final Properties JPA_READ_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        put("show-sql", "true");
    }};

    protected HikariConfigReadData(HikariReadDataProperties hikariReadDataWareHouseProperties) {
        this.hikariReadDataWareHouseProperties = hikariReadDataWareHouseProperties;
        setPoolName(this.hikariReadDataWareHouseProperties.getPoolName());
        setMinimumIdle(this.hikariReadDataWareHouseProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariReadDataWareHouseProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariReadDataWareHouseProperties.getIdleTimeout());
    }
}
