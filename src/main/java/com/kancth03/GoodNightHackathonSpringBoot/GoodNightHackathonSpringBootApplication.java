package com.kancth03.GoodNightHackathonSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GoodNightHackathonSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodNightHackathonSpringBootApplication.class, args);
	}

}
