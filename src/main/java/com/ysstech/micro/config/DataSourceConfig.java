package com.ysstech.micro.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class DataSourceConfig {
	
	@Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="oracle.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    
	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
}
