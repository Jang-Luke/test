package com.kh.spring;

import java.sql.Connection;
import java.sql.SQLException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.spring.repository.JdbcTemplateMessageRepository;
import com.kh.spring.repository.MessageRepository;

public class JdbcTemplateTest {

	@Test
	@DisplayName("JdbcTemplate 테스트")
	void jdbcTemplate() throws SQLException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate jdbcTemplate = ac.getBean(JdbcTemplate.class);
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		Assertions.assertThat(jdbcTemplate).isNotNull();
		Assertions.assertThat(connection).isNotNull();
	}
	
	@Test
	@DisplayName("getBean 테스트")
	void getJdbcTemplate() throws SQLException{
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageRepository bean = ac.getBean(MessageRepository.class);
		Assertions.assertThat(bean.getClass()).isSameAs(JdbcTemplateMessageRepository.class);
	}
}
