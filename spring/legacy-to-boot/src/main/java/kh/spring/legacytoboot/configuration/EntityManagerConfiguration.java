package kh.spring.legacytoboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class EntityManagerConfiguration {
    @Bean
    public EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory()
}
