package entidades;

public class Produto {
	private String nome;
	private int qtd;
	private double preco;
	
	public Produto() {
		
	}
	
	public Produto(String nome, int qtd, double preco) {
		this.nome = nome;
		this.qtd = qtd;
		this.preco = preco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public double getValorTotal() {
		return (qtd * preco);
	}
	
	public String toString() {
		return "Produto: " + nome + 
				"; Qtd: " + qtd + 
				"; Preco: " + String.format("%.2f", preco) +
				"; Total: " + String.format("%.2f", getValorTotal());
	}
	
	public void addQtd(int qtd) {
		this.qtd += qtd;
	}
	
	public void subQtd(int qtd) {
		this.qtd -= qtd;
	}
}
