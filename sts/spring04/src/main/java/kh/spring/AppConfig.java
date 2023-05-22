package kh.spring;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan
public class AppConfig {
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
	    hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    hikariConfig.setUsername("kh");
	    hikariConfig.setPassword("kh");
	    hikariConfig.setMaximumPoolSize(10);
	    hikariConfig.setAutoCommit(true);
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	    return dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate; 
	}
	
	@Bean
	public PasswordEncryptor passwordEncryptor() {
		return new BasicPasswordEncryptor();
	}
	
}
