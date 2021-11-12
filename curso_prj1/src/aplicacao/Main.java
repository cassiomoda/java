package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContaBanco;
import entidades.Funcionario;
import entidades.Produto;
import entidades.Quarto;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		;
		Scanner sc = new Scanner(System.in);

		System.out.println("Qual a operacao desejada?");
		System.out.println("1 - Produto");
		System.out.println("2 - Conta Banco");
		System.out.println("3 - Alugar quarto");
		System.out.println("4 - Funcionarios");

		switch (sc.nextInt()) {
		case 1:// Protudos
			Produto prod = new Produto();

			System.out.print("Informe o nome do produto: ");
			prod.setNome(sc.nextLine());

			System.out.print("Informe a quantidade em estoque: ");
			prod.addQtd(sc.nextInt());

			System.out.print("Informe o preço: ");
			prod.setPreco(sc.nextDouble());

			System.out.println(prod);
			break;
		case 2:// Conta Banco
			int numero;
			String nome;

			System.out.print("Informe o número da conta:");
			numero = sc.nextInt();

			System.out.print("Informe o nome do titular:");
			sc.nextLine();
			nome = sc.nextLine();

			if (numero != 0 && !nome.isEmpty()) {
				ContaBanco conta;

				System.out.println("Deseja informar o saldo inicial? S/N");
				char resposta = sc.next().charAt(0);

				if (resposta == 'S' || resposta == 's') {
					double saldo;
					System.out.print("Saldo inicial: ");
					saldo = sc.nextDouble();
					conta = new ContaBanco(numero, nome, saldo);
				} else {
					conta = new ContaBanco(numero, nome);
				}

				System.out.println(conta);

				System.out.print("Informe o valor para deposito: ");
				conta.depositar(sc.nextDouble());
				System.out.println(conta);

				System.out.print("Informe o valor do saque: ");
				conta.sacar(sc.nextDouble());
				System.out.println(conta);
			}

			break;
		case 3:
			Quarto[] vtQuartos = new Quarto[10];

			System.out.println("Informe a quantidade de alugueis (1-10): ");
			int nalugueis = sc.nextInt();

			for (int index = 0; index < nalugueis; index++) {
				System.out.println("Informe o número do quarto (0-9): ");
				int numQuarto = sc.nextInt();

				if (numQuarto <= 9) {
					System.out.println("Informe o nome: ");
					sc.nextLine();
					String nomeLocador = sc.nextLine();
					System.out.println("Informe o email: ");
					String emailLocador = sc.nextLine();

					vtQuartos[numQuarto] = new Quarto(numQuarto, nomeLocador, emailLocador);
				} else {
					System.out.println("Número de quarto inválido.");
				}
			}

			for (int index = 0; index < vtQuartos.length; index++) {
				if (vtQuartos[index] != null) {
					System.out.println(vtQuartos[index]);
				}
			}

			break;
		case 4:
			List<Funcionario> listFuncs = new ArrayList<Funcionario>();

			System.out.print("Informe quantos funcionarios serao inseridos: ");
			int numFunc = sc.nextInt();

			for (int index = 0; index < numFunc; index++) {
				System.out.println();
				System.out.print("Informe o id: ");
				int id = sc.nextInt();

				while (hasId(listFuncs, id)) {
					System.out.print("Id ja utilizado. Tente novamente: ");
					id = sc.nextInt();
				}
				
				System.out.print("Informe o nome: ");
				sc.nextLine();
				String nomeFuncionario = sc.nextLine();

				System.out.print("Informe o salario: ");
				double salario = sc.nextDouble();

				Funcionario func = new Funcionario(id, nomeFuncionario, salario);
				listFuncs.add(func);
			}

			System.out.println();
			System.out.print("Informe o Id de quem receberá o aumento:");
			int id = sc.nextInt();

			int pos = posId(listFuncs, id);

			if (pos < 0) {
				System.out.println();
				System.out.println("O id informado nao foi localizado.");
				System.out.println();
			} else {
				System.out.print("Informe o percentual de aumento: ");
				double perc = sc.nextDouble();

				listFuncs.get(pos).increaseSalario(perc);
			}

			System.out.println();
			System.out.println("Funcionarios inseridos: ");

			for (Funcionario f : listFuncs) {
				System.out.println(f);
			}

			break;
		default:
			System.out.print("Opcao invalida.");
		}

		sc.close();
	}

	public static Integer posId(List<Funcionario> list, int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}

		return -1;
	}

	public static Boolean hasId(List<Funcionario> list, int id) {
		Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}

}
