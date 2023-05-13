package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@ToString
public class User {

    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email) {
        this.id = Optional.ofNullable(id)
                .orElse(0L);
        this.name = name;
        this.email = email;
    }

    public static User sample() {
        return new User("joe", "joe@namoosori.io");
    }

}
