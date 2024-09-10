package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My Workout Gym API", version = "1.0", description = "Documentation for My Workout Gym API"))
public class MyWorkoutGymApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWorkoutGymApplication.class, args);
	}

}
