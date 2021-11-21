package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.PayPallServico;
import model.services.ServicoContrato;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Entre com os dados do contrato: ");
			System.out.print("Numero: ");
			Integer numero = sc.nextInt();
			System.out.print("Inicio: ");
			Date inicio = sdf.parse(sc.next());
			System.out.print("Valor: ");
			Double valor = sc.nextDouble();
			System.out.print("Numero de parcelas: ");
			Integer numParcs = sc.nextInt();
			
			Contrato contrato = new Contrato(numero, inicio, valor);
			ServicoContrato servicoContrato = new ServicoContrato(new PayPallServico());
			servicoContrato.processaContrato(contrato, numParcs);
			
			System.out.println();
			System.out.println("Parcelas: ");
			
			for (Parcela parcela : contrato.getParcelas()) {
				System.out.println(sdf.format(parcela.getVencimento()) + " - " + String.format("%.2f", parcela.getValor()));
			}
		}
		catch(ParseException e) {
			System.out.println();
			System.out.println("Erro: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println();
			System.out.println("Erro Inesperado: " + e.getMessage());
		}
	}

}
