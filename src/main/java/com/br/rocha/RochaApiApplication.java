package com.br.rocha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Rocha API", version = "2.0", description = "Employees Information"))
public class RochaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RochaApiApplication.class, args);
	}

}
