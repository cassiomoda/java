package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private Integer numero;
	private Date inicio;
	private Double valorTotal;
	
	private List<Parcela> parcelas = new ArrayList<Parcela>();
	
	public Contrato() {
		super();
	}

	public Contrato(Integer numero, Date inicio, Double valorTotal) {
		super();
		this.numero = numero;
		this.inicio = inicio;
		this.valorTotal = valorTotal;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}
	
	public void addParcela(Parcela parcela) {
		this.parcelas.add(parcela);
	}
	
	public void removeParcela(Parcela parcela) {
		this.parcelas.remove(parcela);
	}
}
