package kh.spring.controllers;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kh.spring.interfaces.TV;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("context.xml");
		// Spring -> Spring Container, Bean -> IOC : Inversion Of Control (제어의 역전)
		
		TV samsungtv = ctx.getBean("samsung", TV.class); // DL : Dependency Lookup, DI : Dependency Injection
		samsungtv.powerOn();
		samsungtv.volumnDown();
		TV lgtv = ctx.getBean("lg", TV.class);
		lgtv.volumnUp();
		lgtv.powerOff();
		// Spring Container 가 관리하는 인스턴스들은 기본적으로 singleton 패턴이 적용되어 있음.
		// xml(설정) 파일에서 Bean 설정 시, scope="prototype" 속성을 세팅하면 필요할 때 마다 인스턴스를 다시 생성함
	}
}
