package com.mbal.saleportal.spring_template.config.database.read;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;


@Configuration
@ConfigurationProperties("spring.datasource-read-data")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryReadData",
        transactionManagerRef = "transactionManagerReadData",
        basePackages = {"com.mbal.saleportal.spring_template.repository.secondary"}
)
public class ConfigReadDatabase extends HikariConfigReadData {

    public final static String MODEL_PACKAGE = "com.mbal.saleportal.spring_template.entity";

    public ConfigReadDatabase(HikariReadDataProperties hikariReadDataWareHouseProperties) {
        super(hikariReadDataWareHouseProperties);
    }

    @Bean
    public HikariDataSource dataSourceReadData() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryReadData(
            final HikariDataSource dataSourceReadData) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceReadData);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_READ_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerReadData(@Qualifier("entityManagerFactoryReadData") EntityManagerFactory entityManagerFactoryRead) {
        return new JpaTransactionManager(entityManagerFactoryRead);
    }
}
