package kh.exam.sevlet.sevletpractice;

import kh.exam.sevlet.sevletpractice.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan
@SpringBootApplication
public class SevletpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevletpracticeApplication.class, args);
    }
}
