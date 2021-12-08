package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o caminho do arquivo CSV: ");
		String path = sc.next();
		
		try (BufferedReader buffer = new BufferedReader(new FileReader(path))){
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				String campos[] = linha.split(",");
				funcionarios.add(new Funcionario(campos[0], campos[1], Double.parseDouble(campos[2])));
				linha = buffer.readLine();
			}
			
			System.out.println("Informe o valor minimo de salario: ");
			Double valMinSalario = sc.nextDouble();
			
			List<String> emailsSalarioMior = funcionarios.stream()
					.filter(f -> f.getSalario() > valMinSalario)
					.map(f -> f.getEmail())
					.sorted()
					.collect(Collectors.toList());
			
			System.out.println();
			emailsSalarioMior.forEach(System.out::println);
			
			Double sum = funcionarios.stream()
					.filter(f -> f.getNome().charAt(0) == 'M')
					.map(f -> f.getSalario())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println();
			System.out.println("Soma dos salarios: " + String.format("%.2f", sum));
		}
		catch(IOException exp) {
			System.out.println("Erro inesperado: " + exp.getMessage());
		}
		catch(RuntimeException exp) {
			System.out.println("Erro inesperado: " + exp.getMessage());
		}
		
		sc.close();
	}

}
