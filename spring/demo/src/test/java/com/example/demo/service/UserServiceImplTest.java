package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.store.UserStore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
//    @Autowired
//    private UserStore userStore;

//    @DisplayName("사용자 생성")
//    @ParameterizedTest(name = "{index} : {arguments}")
//    @CsvSource({
//            "kim, kim@namoosori.io",
//            "jung, jung1@namoosori.io"
//    })
//    void register(String name, String email) {
//        User sample = User.sample();
//        User sample2 = new User(name, email);
//        User sample3 = new User(name, email);
//        assertThat(userService.register(sample)).isNotNull();
//        assertThat(userService.register(sample2)).isNotNull();
//        assertThat(userService.register(sample3)).isNotNull();
//        System.out.println(1);
//        System.out.println(sample.getId());
//        System.out.println(sample2.getId());
//        System.out.println(sample3.getId());
//    }

    @Test
    @DisplayName("생성 테스트")
    public void registerTest() {
        User sample = User.sample();
        assertThat(userService.register(sample)).isEqualTo(sample.getId());
        assertThat(userService.findAll().size()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("사용자 수정")
//    @ParameterizedTest(name = "{index} : {argument}")
//    @CsvSource({
//            "1"
//    })
//    void modify(String id) {
//
//    }
//
//    @Test
//    @DisplayName("사용자 삭제")
//    void remove() {
//    }
//
//    @Test
//    @DisplayName("사용자 조회")
//    void find() {
//    }
//
//    @Test
//    @AfterAll
//    @DisplayName("사용자 전부 조회")
//    void findAll() {
//        List<User> all = userService.findAll();
//        all.stream().forEach(System.out::println);
//    }
}