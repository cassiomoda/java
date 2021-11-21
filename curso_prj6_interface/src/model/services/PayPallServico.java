package model.services;

public class PayPallServico implements ServicoPagamento {
	private static Double percTaxaPagamento = 2.0;
	private static Double percJurosMes = 1.0;
	
	public Double taxaPagamento(Double valor) {
		return valor * percTaxaPagamento / 100;
	}
	
	public Double calculaJurosParcela(Double valor, Integer mes) {
		return valor * (percJurosMes / 100) * mes;
	}
}
