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

public class App {
    public static void main(String[] args) throws Exception {
		lerEntradaTxt("entrada.txt");
	}

	public static float[][] lerEntradaTxt(String nomeArquivo) throws Exception {
        //Declaração de variaveis
		FileReader arquivo = new FileReader(nomeArquivo);
		BufferedReader leitorArq = new BufferedReader(arquivo);
		String linhaArquivo = "";
		String[] palavrasArquivo = new String[1000];
		int posicaoPalavrasArq = 0;
		

		//Leitura do tamanho da matriz
		do {
			linhaArquivo = leitorArq.readLine();
			if (linhaArquivo != null) {
				String[] aux = new String[1000];
				aux = linhaArquivo.split(" ");

				if (aux != null) {
					int i = 0;
					if (aux.length > 1) {
						while(i < aux.length) {
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


		for (int j = 0; j < palavrasArquivo.length; j++) {
			if (palavrasArquivo[j] != null) {
				System.out.println("TESTE: " + palavrasArquivo[j]);
			}
		}
		System.out.println("Tamanho Vetor: " + posicaoPalavrasArq);

		return null;
	}
}
