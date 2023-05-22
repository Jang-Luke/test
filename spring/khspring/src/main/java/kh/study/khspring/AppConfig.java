package kh.study.khspring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/luke_db");
        hikariConfig.setUsername("luke");
        hikariConfig.setPassword("vtrol!Q2w3e");
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
