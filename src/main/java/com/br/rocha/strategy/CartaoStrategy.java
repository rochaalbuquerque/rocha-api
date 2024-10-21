package com.br.rocha.strategy;

public class CartaoStrategy implements PaymentStrategy {

	@Override
	public String process() {
		return "Processando pagamento com Cartão";
	}

	/*
	 * @Override public String typePayment() { return "CARTÃO"; }
	 */
}
