package com.example.zomentum;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
public class ZomentumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZomentumApplication.class, args);
	}

	//@Scheduled(cron = "0 0 12 * * ?")

}
//
//
//@Configuration
//@EnableScheduling
//class SchedulingConfig {
//
//}