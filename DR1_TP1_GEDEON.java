package br.edu.infnet.fundamentosjava;

import java.util.Scanner;

public class DR1_TP1_GEDEON {

	private static final int limitePos = 3; 		
	private static String[] nomeAluno;
	private static float[] notaAV1;
	private static float[] notaAV2;

	private static void imprimir() {		
		for (int i = 0; i < limitePos; i++) {
			if(nomeAluno[i] != null) {
				imprimir(i);
			}
		}
	}

	private static void imprimir(int indice) {
		float notaMedia = calcularMedia(indice);
		
		System.out.println("");
		System.out.println("Nome do Aluno: " + nomeAluno[indice]);
		System.out.println("Nota da AV1: " + notaAV1[indice]);
		System.out.println("Nota da AV2: " + notaAV2[indice]);
		System.out.println("Média final" + notaMedia);
		System.out.println("Situação: " + obterSituacao(notaMedia));
		System.out.println("");
	}
	
	private static float calcularMedia(int indice){
		return ((notaAV1[indice] + notaAV2[indice]) / 2);
	}
	
	private static String obterSituacao(float notaMed){		
		if(notaMed < 7) {
			if(notaMed < 4) {
				return "Reprovado";
			}
			return "Prova final";
		}		
		return "Aprovado";
	}

	public static void main(String[] args) {
		nomeAluno = new String[limitePos];
		notaAV1 = new float[limitePos];
		notaAV2 = new float[limitePos];
		Scanner in = new Scanner(System.in);
		String opcaoMenu;
		int posicao = 0;

		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair");
			System.out.println("...................................");
			System.out.print("Informe o número da opção desejada: ");						
			opcaoMenu = in.next();
			
			switch (opcaoMenu) {
			case "1":
				if(posicao < limitePos) {
					System.out.print("Informe o nome do aluno: ");	
					nomeAluno[posicao] = in.next();
	
					System.out.print("Informe a nota da AV1: ");	
					notaAV1[posicao] = in.nextFloat();
					
					System.out.print("Informe a nota da AV2: ");	
					notaAV2[posicao] = in.nextFloat();
					
					System.out.println("***** Aluno cadastrado na posição  < " + posicao + " > *****");
					System.out.println("");

					posicao++;
				} else {
					System.out.println("***** Impossível inserir novo registro, limite atingido! *****");
					System.out.println("");
				}
				break;

			case "2":
				System.out.print("Informe o código de registro do aluno: ");						
				int id = in.nextInt();

				if(id >= 0 && id < posicao) {
					imprimir(id);
				} else {
					System.out.println("***** O código ["+id+"] não existe! *****");
					System.out.println("");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Saída");
				break;

			default:
				System.out.println("***** A opção ["+opcaoMenu+"] é inválida *****");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcaoMenu));
				
		System.out.println("***** Fim do processamento! *****");
		
		in.close();
	}
}