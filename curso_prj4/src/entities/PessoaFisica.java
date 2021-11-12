package entities;

public class PessoaFisica extends Pessoa {
	private Double gastosSaude;
	
	public PessoaFisica() {
		super();
	}	
	
	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double totalImpostos() {
		Double totImp = 0.0;
		
		if (super.getRendaAnual() < 20000) {
			totImp = super.getRendaAnual() * 0.15;
		}
		else {
			totImp = super.getRendaAnual() * 0.25;
		}
		
		if (gastosSaude > 0) {
			totImp -= gastosSaude * 0.5;
		}
		
		return totImp;
	}

}
