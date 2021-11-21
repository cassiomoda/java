package model.services;

public class PayPallServico implements ServicoPagamento {
	private static final Double PERC_TAXA_PAGAMENTO = 2.0;
	private static final Double PERC_JUROS_MES = 1.0;
	
	@Override
	public Double taxaPagamento(Double valor) {
		return valor * PERC_TAXA_PAGAMENTO / 100;
	}
	
	@Override
	public Double calculaJurosParcela(Double valor, Integer mes) {
		return valor * (PERC_JUROS_MES / 100) * mes;
	}
}
