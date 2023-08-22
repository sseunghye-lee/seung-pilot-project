package com.sseung.pilot.seungpilotproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SeungPilotProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeungPilotProjectApplication.class, args);
	}

}
