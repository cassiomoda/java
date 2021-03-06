package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		System.out.println("Informe o numero de contibuintes: ");
		Integer numCont = sc.nextInt();
		
		for (int index = 1; index <= numCont; index++) {
			System.out.print("Dados do contribuinte #" + index);
			System.out.print("Pessoa fisica ou juridica (f/j)?");
			Character ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			Double renda = sc.nextDouble();
			
			if (ch == 'f') {
				System.out.print("Despesas com saude: ");
				Double despSaude = sc.nextDouble();
				pessoas.add(new PessoaFisica(nome, renda, despSaude));
			}
			else if (ch == 'j') {
				System.out.print("Numero de funcionarios: ");
				Integer numFunc = sc.nextInt();
				pessoas.add(new PessoaJuridica(nome, renda, numFunc));
			}
		}
		
		System.out.println("");
		System.out.println("Impostos pagos: ");
		
		Double totImpostos = 0.0;
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome() + ": $" + 
							   String.format("%.2f", pessoa.totalImpostos())
			);
			
			totImpostos += pessoa.totalImpostos();
		}
		
		System.out.println("");
		System.out.println("Total de impostos: $" + String.format("%.2f", totImpostos));
		
		sc.close();
	}

}
