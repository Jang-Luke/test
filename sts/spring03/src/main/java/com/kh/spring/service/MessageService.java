package com.kh.spring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.spring.dto.Message;

public interface MessageService {
	List<Message> findAll() throws SQLException;

	void save(Message message) throws SQLException;

	Message modify(Message message) throws SQLException;

	void delete(Message message) throws SQLException;
}