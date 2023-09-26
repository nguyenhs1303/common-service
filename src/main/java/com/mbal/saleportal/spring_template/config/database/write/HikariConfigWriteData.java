package com.mbal.saleportal.spring_template.config.database.write;

import com.zaxxer.hikari.HikariConfig;

import java.util.Properties;

public class HikariConfigWriteData extends HikariConfig {
    protected final HikariWriteDataProperties hikariWriteDataProperties;

    protected final String PERSISTENCE_UNIT_NAME = "primary";

    protected final Properties JPA_WRITE_PROPERTIES = new Properties() {{
        put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        put("show-sql", "true");
    }};

    protected HikariConfigWriteData(HikariWriteDataProperties hikariReadDataWareHouseProperties) {
        this.hikariWriteDataProperties = hikariReadDataWareHouseProperties;
        setPoolName(this.hikariWriteDataProperties.getPoolName());
        setMinimumIdle(this.hikariWriteDataProperties.getMinimumIdle());
        setMaximumPoolSize(this.hikariWriteDataProperties.getMaximumPoolSize());
        setIdleTimeout(this.hikariWriteDataProperties.getIdleTimeout());
    }
}
