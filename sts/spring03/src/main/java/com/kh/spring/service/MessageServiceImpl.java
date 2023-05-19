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
	
	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	@Override
	public List<Message> findAll() throws SQLException {
		List<Message> messages = messageRepository.findAll();
		return messages;
	}

	@Override
	public void save(Message message) throws SQLException {
		try {
			messageRepository.save(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Message modify(Message message) throws SQLException {
		Message modifiedmessage = new Message();
		try {
			modifiedmessage = messageRepository.modify(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modifiedmessage;
	}

	@Override
	public void delete(Message message) throws SQLException {
		try {
			messageRepository.delete(message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
