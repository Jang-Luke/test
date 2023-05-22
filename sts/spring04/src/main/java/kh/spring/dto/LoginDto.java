package kh.spring.dto;

import java.util.Optional;

public class LoginDto implements Encryptable{
	private String username;
	private String password;
	private Boolean rememberUsername;
	
	public LoginDto() {}
	
	public LoginDto(String username, String password, Boolean rememberUsername) {
		this.username = username;
		this.password = password;
		this.rememberUsername = Optional.ofNullable(rememberUsername)
										.orElseGet(() -> false);
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
	public Boolean getRememberUsername() {
		return rememberUsername;
	}
	public void setRememberUsername(Boolean rememberUsername) {
		this.rememberUsername = Optional.ofNullable(rememberUsername)
										.orElseGet(() -> false);
	}
	
}
