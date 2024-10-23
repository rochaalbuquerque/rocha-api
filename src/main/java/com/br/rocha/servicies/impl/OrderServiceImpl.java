package com.br.rocha.servicies.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.br.rocha.dto.NewOrderDTO;
import com.br.rocha.enu.PaymentType;
import com.br.rocha.services.OrderService;
import com.br.rocha.services.exceptions.ObjectNotFoundException;
import com.br.rocha.strategy.BoletoStrategy;
import com.br.rocha.strategy.CartaoStrategy;
import com.br.rocha.strategy.PaymentStrategy;
import com.br.rocha.strategy.PixStrategy;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public String processPaymentStrategy(NewOrderDTO orderDTO) {

		HashMap<PaymentType, PaymentStrategy> payments = new HashMap<>();
		payments.put(PaymentType.BOLETO, new BoletoStrategy());
		payments.put(PaymentType.PIX, new PixStrategy());
		payments.put(PaymentType.CARTAO, new CartaoStrategy());

		try {
			PaymentStrategy strategy = payments.get(PaymentType.valueOf(orderDTO.getTypePayment().toUpperCase()));
			return strategy.process();
		} catch (IllegalArgumentException e) {
			throw new ObjectNotFoundException("Tipo de pagamento inválido: " + orderDTO.getTypePayment(), e);
		}

	}

	@Override
	public String processPayment(NewOrderDTO orderDTO) {

		if (orderDTO.getTypePayment().equalsIgnoreCase("CARTAO")) {
			return "Processando pagamento com Cartão";
		} else if (orderDTO.getTypePayment().equalsIgnoreCase("BOLETO")) {
			return "Processando pagamento com Boleto";
		} else if (orderDTO.getTypePayment().equalsIgnoreCase("PIX")) {
			return "Processando pagamento com Pix";
		} else {
			return "Tipo de pagamento inválido";
		}
	}

}
