package model.services;

public interface ServicoPagamento {	
	public Double taxaPagamento(Double valor);
	public Double calculaJurosParcela(Double valor, Integer mes);
}
