package kh.spring.studyjpa8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class StudyJpa8Application {

    public static void main(String[] args) {
        SpringApplication.run(StudyJpa8Application.class, args);
    }

}
