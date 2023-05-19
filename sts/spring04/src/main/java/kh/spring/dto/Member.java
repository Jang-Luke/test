package kh.spring.dto;

import java.time.LocalDateTime;

public class Member {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String zipcode;
	private String address1;
	private String address2;
	private LocalDateTime registerDate;
	
	public Member() {}
	
	public Member(Long id, String username, String password, String name, String phone, String email, String zipcode,
			String address1, String address2, LocalDateTime registerDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
		this.registerDate = registerDate;
	}

	Long getId() {
		return id;
	}
	void setId(Long id) {
		this.id = id;
	}
	String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}
	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getPhone() {
		return phone;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	String getZipcode() {
		return zipcode;
	}
	void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	String getAddress1() {
		return address1;
	}
	void setAddress1(String address1) {
		this.address1 = address1;
	}
	String getAddress2() {
		return address2;
	}
	void setAddress2(String address2) {
		this.address2 = address2;
	}
	LocalDateTime getRegisterDate() {
		return registerDate;
	}
	void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
}
