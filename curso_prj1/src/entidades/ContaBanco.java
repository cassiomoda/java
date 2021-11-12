package entidades;

public class ContaBanco {
	private final double TAXA = 5.00; 
	
	private int numero;
	private String nomeTitular;
	private double saldo;
	
	public ContaBanco(int numero) {
		this.numero = numero;
	}
	
	public ContaBanco(int numero, String nomeTitular) {
		this.numero = numero;
		this.nomeTitular = nomeTitular;
	}
	
	public ContaBanco(int numero, String nomeTitular, double valorInicial) {
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		depositar(valorInicial);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}
	
	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			cobrarTaxa();
		}
	}
	
	public void cobrarTaxa() {
		saldo -= TAXA;
	}
	
	public String toString() {
		return "Conta: " + numero + "; " +
				"Titular: " + nomeTitular + "; " +
				"Saldo: " + String.format("%.2f", saldo);
	}
}
