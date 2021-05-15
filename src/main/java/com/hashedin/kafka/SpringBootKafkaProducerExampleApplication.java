package com.hashedin.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
/***
 * scans all the packages for classes and beans
 */
@ComponentScan(basePackages = {
		"com.hashedin.controller",
		"com.hashedin.service",
		"com.hashedin.config",
		})
@EnableSwagger2
public class SpringBootKafkaProducerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducerExampleApplication.class, args);
	}

}
