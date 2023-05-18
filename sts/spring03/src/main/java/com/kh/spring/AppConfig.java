package com.kh.spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan
public class AppConfig {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    hikariConfig.setUsername("kh");
	    hikariConfig.setPassword("kh");
	    hikariConfig.setMaximumPoolSize(10);
	    hikariConfig.setAutoCommit(false);
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	 
	    return dataSource;
	}
}
