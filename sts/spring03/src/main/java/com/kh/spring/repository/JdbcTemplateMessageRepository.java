package com.kh.spring.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.dto.Message;

@Repository
public class JdbcTemplateMessageRepository implements MessageRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplateMessageRepository(JdbcTemplate jdbctemplate) {
		this.jdbcTemplate = jdbctemplate;
	}

	// Spring JDBC
	// select				-> 단일 값 select 는 queryForObject / 대량 값 select 는 query
	// insert update delete -> 이런 쿼리들은 모두 update method 사용
	
	@Override
	public List<Message> findAll() throws SQLException {
		String sql = "select * from message";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Message>(Message.class));
	}

	@Override
	public void save(Message message) throws SQLException {
		String sql = "insert into message values(message_seq.nextval, ?, ?)";
		jdbcTemplate.update(sql, message.getWriter(), message.getMessage());
	}

	@Override
	public Message modify(Message message) throws SQLException {
		String sql = "update message set writer = ?, message = ? where id = ?";
		jdbcTemplate.update(sql, message.getWriter(), message.getMessage(), message.getId());
		return message;
	}

	@Override
	public void delete(Message message) throws SQLException {
		String sql = "delete from message where id = ?";
		jdbcTemplate.update(sql, message.getId());
	}
	
	public Message findById(Message message) throws SQLException {
		String sql = "select * from message where id =?";
		return jdbcTemplate.queryForObject(sql, Message.class, message.getId());
	}
	
	public int selectCount() {
		String sql = "select count(*) from message";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
