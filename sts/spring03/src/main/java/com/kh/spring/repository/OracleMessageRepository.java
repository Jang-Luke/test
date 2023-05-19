package com.kh.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.dto.Message;


public class OracleMessageRepository implements MessageRepository {
	
	private DataSource dataSource;
	
	
	public OracleMessageRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Message> findAll() throws SQLException {
		String sql = "select * from message";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareCall(sql);
			ResultSet resultSet = preparedStatement.executeQuery()){
			List<Message> messages = new ArrayList<>(); 
			while(resultSet.next()) {
				messages.add(mapRow(resultSet));
			}
			return messages;
		}
	}

	@Override
	public void save(Message message) throws SQLException {
		String sql = "insert into message values(message_seq.nextval, ?, ?)";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, message.getWriter());
			preparedStatement.setString(2, message.getMessage());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("입력 값을 다시 확인해주세요.");
			}
		}
	}

	@Override
	public Message modify(Message message) throws SQLException {
		String sql = "update message set writer = ?, message = ? where id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setString(1, message.getWriter());
			preparedStatement.setString(2, message.getMessage());
			preparedStatement.setLong(3, message.getId());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("입력 값을 다시 확인해주세요.");
			}
			return message;
		}
	}
	
	@Override
	public void delete(Message message) throws SQLException {
		String sql = "delete from message where id = ?";
		try(Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql)){
			preparedStatement.setLong(1, message.getId());
			if (preparedStatement.executeUpdate() == 0) {
				throw new SQLException("존재하지 않는 글입니다.");
			}
		}
	}

	private Message mapRow(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong(1);
		String writer = resultSet.getString(2);
		String message = resultSet.getString(3);
		return new Message(id, writer, message);
	}
	
	
}
