package com.br.rocha.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorld {

	@GetMapping
	@Operation(summary = "Bem vindos!")
	public String helloWorld() {
		return "Hello World! This is the Rocha base project";
	}

}
