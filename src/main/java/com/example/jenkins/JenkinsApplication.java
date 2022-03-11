package com.example.jenkins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
	}

	@Bean
	public UserBean getVal(@Value("${app.user.name}") String name,@Value("${app.user.email}") String email){
		UserBean userBean=new UserBean();
		userBean.setName(name);
		userBean.setEmail(email);
		return userBean;

	}

}
