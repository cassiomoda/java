package entidades;

public class Quarto {
	private int numero;
	private String nome;
	private String email;
	
	public Quarto(int numero, String nome, String email) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.email = email;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return numero + ": " +
				nome + ", " +
				email;
	}	
}
