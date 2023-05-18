package kh.spring.configurations;

import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(
		basePackages = "kh.spring.configuration",
		excludeFilters = @Filter(type = FilterType.ANNOTATION,
		classes = ExcludedComponent.class)
)
public class AnnotationConfiguration {
	
	@Bean
	public AtomicInteger atomicInteger() {
		return new AtomicInteger();
	}
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
	    hikariConfig.setUsername("kh");
	    hikariConfig.setPassword("kh");
	    hikariConfig.setMaximumPoolSize(10);
	 
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);
	 
	    return dataSource;
	}
}
