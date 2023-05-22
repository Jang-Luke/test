package kh.study.khspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@NoArgsConstructor
@Getter
@Setter
public class LoginDto implements Encryptable {
    private String username;
    private String password;
    private Boolean rememberUsername;

    public LoginDto(String username, String password, Boolean rememberUsername) {
        this.username = username;
        this.password = password;
        this.rememberUsername = Optional.ofNullable(rememberUsername)
                                        .orElse(false);
    }
    public void setRememberUsername(Boolean rememberUsername) {
        this.rememberUsername = Optional.ofNullable(rememberUsername)
                                        .orElse(false);
    }
}
