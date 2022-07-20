package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EntityScan(basePackages = {"com.spring.boot.entity"})
@ComponentScan(basePackages = {"com.spring.boot.*"})
@EnableJpaRepositories(basePackages = {"com.spring.boot.repository"})
@EnableTransactionManagement
//@EnableWebMvc  -- se eu habilitar isso, dá erro no bootstrap e jquery
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
