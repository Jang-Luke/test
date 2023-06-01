package io.spring.practice1.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Getter
@Setter
public class JoinRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @Length(min = 11)
    private String phone;
    @Email
    private String email;
    @NotBlank
    private String address;
    @PastOrPresent
    private LocalDateTime registerDate = LocalDateTime.now();
}
