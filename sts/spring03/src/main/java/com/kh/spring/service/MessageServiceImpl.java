package com.kh.spring.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dto.Message;
import com.kh.spring.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	private MessageRepository messageRepository;
	private DataSource dataSource;
	
	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository, DataSource dataSource) {
		this.messageRepository = messageRepository;
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Message> findAll() throws SQLException {
		List<Message> messages = messageRepository.findAll();
		return messages;
	}

	@Override
	public void save(Message message) throws SQLException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			messageRepository.save(message, connection);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
	}

	@Override
	public Message modify(Message message) throws SQLException {
		Connection connection = null;
		Message modifiedmessage = new Message();
		try {
			connection = dataSource.getConnection();
			modifiedmessage = messageRepository.modify(message, connection);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
		return modifiedmessage;
	}

	@Override
	public void delete(Message message) throws SQLException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			messageRepository.delete(message, connection);
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		} finally {
			connection.close();
		}
	}
	
}
