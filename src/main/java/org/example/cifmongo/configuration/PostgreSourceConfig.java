package org.example.cifmongo.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;

@Configuration
public class PostgreSourceConfig {

    @Value("${spring.datasource.query-timeout}")
    private int queryTimeout;

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriver;

    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String databaseName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.configuration.maximum-pool-size}")
    private int userPropertyMaxConnection;

    @Value("${spring.datasource.driverClassName}")
    private String expertPropertyNameDatabaseDriver;


    @Bean
    @Qualifier("userDataSource")
    DataSource DataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(databaseUrl);
        config.setUsername(databaseName);
        config.setPassword(password);
        config.setDriverClassName(databaseDriver);
        config.setMaximumPoolSize(userPropertyMaxConnection);
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource;
    }

    @Bean
    JdbcTemplate userJdbcTemplate(@Qualifier("DataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setQueryTimeout(queryTimeout);
        return jdbcTemplate;
    }


    @Bean
    public JdbcTransactionManager transactionManagerUser(@Qualifier("DataSource") DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }
}
