package dataTransferObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MessagesDTO {
	private int id;
	private String writer;
	private String message;
	private Timestamp write_date;

	public MessagesDTO() {
	}

	public MessagesDTO(int id, String writer, String message, Timestamp write_date) {
		this.id = id;
		this.writer = writer;
		this.message = message;
		this.write_date = write_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		long checkTime = (System.currentTimeMillis() - this.getWrite_date().getTime()) / 1000;
		if (checkTime < 60) {
			return "방금 전";
		} else if (checkTime < 60 * 5) {
			return "5분 이내";
		} else if (checkTime < 60 * 60) {
			return "1시간 이내";
		} else if (checkTime < 60 * 60 * 24) {
			return "오늘";
		} else {
			return sdf.format(this.getWrite_date());
		}
	}

}
