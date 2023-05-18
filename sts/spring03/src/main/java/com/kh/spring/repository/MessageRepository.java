package com.kh.spring.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.spring.dto.Message;

public interface MessageRepository {
	List<Message> findAll() throws SQLException;

	void save(Message message, Connection connection) throws SQLException;

	Message modify(Message message, Connection connection) throws SQLException;

	void delete(Message message, Connection connection) throws SQLException;
}
