package dataTransferObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MembersDTO {
	private String id;
	private String pw;
	private String name;
	private String contact;
	private Timestamp reg_date;

	public MembersDTO() {}

	public MembersDTO(String id, String pw, String name, String contact, Timestamp reg_date) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.contact = contact;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��");
		return sdf.format(this.getReg_date());
	}
}
