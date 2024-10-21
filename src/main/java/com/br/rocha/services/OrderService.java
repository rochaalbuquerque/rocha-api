package com.br.rocha.services;

import com.br.rocha.dto.NewOrderDTO;

public interface OrderService {

	String processPayment(NewOrderDTO orderDTO);

	String processPaymentStrategy(NewOrderDTO orderDTO);

}
