package com.mbal.saleportal.spring_template.config.database.write;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@ConfigurationProperties("spring.datasource-write-data")
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryWriteData",
        transactionManagerRef = "transactionManagerWriteData",
        basePackages = {"com.mbal.saleportal.spring_template.repository.primary"}
)
public class ConfigWriteDatabase extends HikariConfigWriteData {

    public final static String MODEL_PACKAGE = "com.mbal.saleportal.spring_template.entity";

    public ConfigWriteDatabase(HikariWriteDataProperties hikariWriteDataProperties) {
        super(hikariWriteDataProperties);
    }

    @Bean
    public HikariDataSource dataSourceWriteData() {
        return new HikariDataSource(this);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWriteData(
            final HikariDataSource dataSourceWriteData) {

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSourceWriteData);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_WRITE_PROPERTIES);
        }};
    }

    @Bean
    public PlatformTransactionManager transactionManagerWriteData(@Qualifier("entityManagerFactoryWriteData") EntityManagerFactory entityManagerFactoryWriteData) {
        return new JpaTransactionManager(entityManagerFactoryWriteData);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-write-data.liquibase")
    public LiquibaseProperties primaryLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase primaryLiquibase() {
        return springLiquibase(dataSourceWriteData(), primaryLiquibaseProperties());
    }

    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;
    }
}
