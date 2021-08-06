package com.example.multipledb.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class WebConfiguration {

    // quito db configuration
    @Bean(name = "dbquito")
    @ConfigurationProperties(prefix = "spring.datasource.quito")
    public DataSource dataSourceQuito() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateQuito")
    public JdbcTemplate jdbcTemplateQuito(@Qualifier("dbquito") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // cuenca db configuration
    @Bean(name = "dbcuenca")
    @ConfigurationProperties(prefix = "spring.datasource.cuenca")
    public DataSource dataSourceCuenca() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateCuenca")
    public JdbcTemplate jdbcTemplateCuenca(@Qualifier("dbcuenca") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // guayaquil db configuration
    @Bean(name = "dbguayaquil")
    @ConfigurationProperties(prefix = "spring.datasource.guayaquil")
    public DataSource dataSourceGuayaquil() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateGuayaquil")
    public JdbcTemplate jdbcTemplateGuayaquil(@Qualifier("dbguayaquil") DataSource ds) {
        return new JdbcTemplate(ds);
    }

}
