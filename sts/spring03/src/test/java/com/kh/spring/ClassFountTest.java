package com.kh.spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kh.spring.service.MessageService;


public class ClassFountTest {
	
	@Test
	@DisplayName("클래스 알아보기")
	void 클래스뭐임() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageService bean2 = ac.getBean(MessageService.class);
		System.out.println(bean2.getClass());
		
		Assertions.assertThat(bean2).isNotNull();
	}
}
