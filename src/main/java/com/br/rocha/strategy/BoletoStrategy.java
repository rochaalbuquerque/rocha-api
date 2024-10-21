package com.br.rocha.strategy;

public class BoletoStrategy implements PaymentStrategy {

	@Override
	public String process() {
		return "Processando pagamento com Boleto";
	}

	/*
	 * @Override public String typePayment() { return "BOLETO"; }
	 */

}
