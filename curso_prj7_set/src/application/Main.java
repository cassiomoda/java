package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {
			List<Integer> alunosCursoA = new ArrayList<Integer>();
			lerAlunosCurso(sc, "A", alunosCursoA);

			List<Integer> alunosCursoB = new ArrayList<Integer>();
			lerAlunosCurso(sc, "B", alunosCursoB);

			List<Integer> alunosCursoC = new ArrayList<Integer>();
			lerAlunosCurso(sc, "C", alunosCursoC);

			Set<Integer> totalAlunos = new HashSet<Integer>();

			somarAlunos(alunosCursoA, totalAlunos);
			somarAlunos(alunosCursoB, totalAlunos);
			somarAlunos(alunosCursoC, totalAlunos);

			System.out.println();
			System.out.print("Total de alunos: " + totalAlunos.size());
		}
		catch(RuntimeException exception) {
			System.out.println();
			System.out.println("Erro inesperado: " + exception.getMessage());
		}
	}

	private static void lerAlunosCurso(Scanner sc, String curso, List<Integer> alunos) {
		System.out.print("Quantidade de alunos do curso " + curso + ":");
		Integer qtdAlunos = sc.nextInt();

		for (int indice = 1; indice <= qtdAlunos; indice++) {
			System.out.print("Código aluno " + indice + ": ");
			alunos.add(sc.nextInt());
		}
	}

	private static void somarAlunos(List<Integer> alunosCurso, Set<Integer> totalAlunos) {
		for (Integer codAluno : alunosCurso) {
			totalAlunos.add(codAluno);
		}
	}
}
