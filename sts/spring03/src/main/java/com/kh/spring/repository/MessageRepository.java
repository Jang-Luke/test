package com.kh.spring.repository;

import java.sql.SQLException;
import java.util.List;

import com.kh.spring.dto.Message;

public interface MessageRepository {
	List<Message> findAll() throws SQLException;

	void save(Message message) throws SQLException;

	Message modify(Message message) throws SQLException;

	void delete(Message message) throws SQLException;
}
