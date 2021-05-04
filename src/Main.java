/*
Entrega do Trabalho 2- Algoritmos e Programação II
Nós,
Fabricio Viana Belomo
Felype Carvalho de Oliveira
declaramos que
todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou
prejudicar outros.
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception {
		String palavrasEntrada[] = lerEntradaTxt("entrada.txt");
		String dicionarioFinal[] = adicionarPalavrasDicionario(palavrasEntrada);
	}

	public static String[] lerEntradaTxt(String nomeArquivo) throws Exception {
		// Declaração de variaveis
		FileReader arquivo = new FileReader(nomeArquivo);
		BufferedReader leitorArq = new BufferedReader(arquivo);
		String linhaArquivo = "";
		String palavrasArquivo[] = new String[1000];
		int posicaoPalavrasArq = 0;

		// Leitura do tamanho da matriz
		do {
			linhaArquivo = leitorArq.readLine();
			if (linhaArquivo != null) {
				String[] aux = new String[1000];
				aux = linhaArquivo.split(" ");

				if (aux != null) {
					int i = 0;
					if (aux.length > 1) {
						while (i < aux.length) {
							palavrasArquivo[posicaoPalavrasArq] = aux[i].toLowerCase().trim();
							i++;
							posicaoPalavrasArq++;
						}
					} else {
						palavrasArquivo[posicaoPalavrasArq] = aux[0].toLowerCase().trim();
						posicaoPalavrasArq++;
					}
				}
			}
		} while (linhaArquivo != null);

		String palavrasArquivoFormatado[] = new String[posicaoPalavrasArq];

		for (int j = 0; j < palavrasArquivoFormatado.length; j++) {
			palavrasArquivoFormatado[j] = palavrasArquivo[j];
			System.out.println("TESTE: " + palavrasArquivoFormatado[j]);
		}
		leitorArq.close();
		return palavrasArquivoFormatado;
	}

	public static String[] adicionarPalavrasDicionario(String vetor[]) {
		String dicionario[] = new String[1000];
		int cont = 0;
		String aux = "";

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != null) {
				if (cont >= 2) {
					int retornoBusca = buscaBinariaDicionario(dicionario, vetor[i]);

					if (retornoBusca < 0) {
						for (int j = 0; j < dicionario.length; j++) {
							if (dicionario[j] != null) {
								int verificacaoComparacao = dicionario[j].compareTo(vetor[i]);

								if (verificacaoComparacao < 0) {
									aux = dicionario[j];
									dicionario[j] = vetor[j+1];
									vetor[j+1] = aux;
								}
							} else {
								dicionario[j] = vetor[i];
							}
						}
					}
					cont++;
				} else {
					dicionario[cont] = vetor[i];
					cont++;
				}
			}
		}
		return dicionario;
	}

	public static int buscaBinariaDicionario(String dicionario[], String valorBuscado) {
		int inicio = 0;
		int meio = 0;
		int fim = 0;

		for (int i = 0; i < dicionario.length; i++) {
			if (dicionario[i] == null) {
				fim = i - 1;
			}
		}

		while (inicio <= fim) {
			meio = (inicio + fim) / 2;

		 	if (dicionario[meio].equals(valorBuscado)) {
				return 0;
			}

			int verificacao = valorBuscado.compareTo(dicionario[meio]);

			if (verificacao < 0) { // esquerda
				fim = meio - 1;
			} else { // x > v[m] - direita
				inicio = meio + 1;
			}
		}
		return -1;
	}

	// public static String[] ordemAlfabetica(String vetor[]) {
	// 	String aux = "";
	// 	// Fase de Ordenação
	// 	for (int i = 0; i < vetor.length - 1; i++) {
	// 		for (int j = 0; j < vetor.length - i - 1; j++) {
	// 			// if (vetor[j].compareTo(vetor[j+1]) == 0) {
	// 			// 	vetor[j] = null;
	// 			// } else {
	// 				int tamanhoPalavraAtual = vetor[j].length();
	// 				int tamanhoPalavraSeguinte = vetor[j+1].length();

	// 				if (tamanhoPalavraAtual > tamanhoPalavraSeguinte) {
	// 					//for (int k = 0; k <= tamanhoPalavraSeguinte; k++) {
	// 						// Troca dos Elementos
	// 						if (vetor[j].codePointAt(0) > vetor[j+1].codePointAt(0)) {
	// 							aux = vetor[j];
	// 							vetor[j] = vetor[j+1];
	// 							vetor[j+1] = aux;
	// 						}
	// 					//}
	// 				} else {
	// 					//for (int k = 0; k <= tamanhoPalavraAtual; k++) {
	// 						// Troca dos Elementos
	// 						if (vetor[j].codePointAt(0) > vetor[j+1].codePointAt(0)) {
	// 							aux = vetor[j];
	// 							vetor[j] = vetor[j+1];
	// 							vetor[j+1] = aux;
	// 						}
	// 					//}
	// 				}
	// 			//}
	// 		}
	// 	}

	// 	return vetor;
	// }
}
