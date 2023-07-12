package kh.spring.dto;

import java.time.LocalDateTime;

public class Member implements Encryptable {
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

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public LocalDateTime getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}
}
