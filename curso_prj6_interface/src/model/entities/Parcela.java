package model.entities;

import java.util.Date;

public class Parcela {
	private Date vencimento;
	private Double valor;
	
	public Parcela() {
		super();
	}
	
	public Parcela(Date vencimento, Double valor) {
		super();
		this.vencimento = vencimento;
		this.valor = valor;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
