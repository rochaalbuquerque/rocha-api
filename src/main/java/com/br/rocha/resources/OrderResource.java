package com.br.rocha.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.rocha.dto.NewOrderDTO;
import com.br.rocha.services.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ordes")
@Tag(name = "Ordes", description = "Resource of Ordes in MYSQL and Strategy Pattern")
public class OrderResource {

	@Autowired
	private OrderService service;

	@PostMapping("/process")
	public ResponseEntity<String> processarPagamento(@RequestBody NewOrderDTO orderDTO) {
		String resultado = service.processPayment(orderDTO);
		return ResponseEntity.ok(resultado);
	}

	@PostMapping("/processStrategy")
	public ResponseEntity<String> processPayment(@RequestBody NewOrderDTO orderDTO) {
		String resultado = service.processPaymentStrategy(orderDTO);
		return ResponseEntity.ok(resultado);
	}

}
