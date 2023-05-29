package kh.study.khspring.repository;

import kh.study.khspring.AppConfig;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class MysqlBoardRepositoryTest {

    private JdbcTemplate jdbcTemplate;
    void insert(String writer, String title, String content, JdbcTemplate jdbcTemplate) {
        String sql = "insert into boards values(0, ?, ?, ?, default, default, default)";
        jdbcTemplate.update(sql, writer, title, content);
    }

    @Test
    void save() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        jdbcTemplate = ac.getBean(JdbcTemplate.class);
        for (int i = 0; i < 200; i++) {
            insert("newuser1", String.valueOf(i), String.valueOf(i), jdbcTemplate);
        }
    }

}