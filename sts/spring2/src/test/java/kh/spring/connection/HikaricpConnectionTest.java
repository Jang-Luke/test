//package kh.spring.connection;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.BeansException;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.zaxxer.hikari.HikariDataSource;
//
//import kh.spring.configurations.AnnotationConfiguration;
//
//public class HikaricpConnectionTest {
//
//	@Test
//	@DisplayName("Hikari Connection Test")
//	void connect() {
//		//when
//		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
//		//given
//		Connection connection = null;
//		try {
//			connection = ac.getBean("dataSource", HikariDataSource.class).getConnection();
//		} catch (BeansException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}			
//		//then
//		Assertions.assertThat(connection).isNotNull();
//	}
//	
//}
