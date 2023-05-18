package com.kh.spring.dto;

public class Message {
	private Long id;
	private String writer;
	private String message;

	public Message() {}

	public Message(Long id, String writer, String message) {
		this.id = id;
		this.writer = writer;
		this.message = message;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
