package io.spring.practice1.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class JoinRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String zipcode;
    @NotBlank
    private String address;
    private LocalDateTime registerDate;
}
