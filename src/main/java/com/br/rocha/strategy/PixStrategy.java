package com.br.rocha.strategy;

public class PixStrategy implements PaymentStrategy {

	@Override
	public String process() {
		return "Processando pagamento com Pix";
	}

	/*
	 * @Override public String typePayment() { return "PIX"; }
	 */
}
