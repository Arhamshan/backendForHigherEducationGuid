package com.higherEducationGuid.restful;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class HigherEducationGuidApplication {

	//public final static Logger logger =  LoggerFactory.getLogger(HigherEducationGuidApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HigherEducationGuidApplication.class, args);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

}
