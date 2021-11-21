package model.services;

import java.util.Calendar;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContrato {
	private ServicoPagamento servicoPagamento;
	
	public ServicoContrato() {
		super();
	}
	
	public ServicoContrato(ServicoPagamento servicoPagamento) {
		super();
		this.servicoPagamento = servicoPagamento;
	}
	
	public void processaContrato(Contrato contrato, Integer qtdMeses) {
		Double valorBaseParcela = contrato.getValorTotal() / qtdMeses;
		
		for (int mes = 1; mes <= qtdMeses; mes++) {
			Calendar vencimento = Calendar.getInstance();
			vencimento.setTime(contrato.getInicio());
			vencimento.add(Calendar.MONTH, mes);
			
			Double totParcela = valorBaseParcela + servicoPagamento.calculaJurosParcela(valorBaseParcela, mes);
			totParcela += servicoPagamento.taxaPagamento(totParcela);
			
			contrato.addParcela(new Parcela(vencimento.getTime(), totParcela));
		}
	}
}
