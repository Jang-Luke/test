package kh.study.khspring.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
