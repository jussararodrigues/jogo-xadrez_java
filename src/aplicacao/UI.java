package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

public class UI {

	public static PosicaoXadrez lerPosicaoXadrez(Scanner sc) {
		try {
			String posicao = sc.nextLine();

			char coluna = posicao.charAt(0);
			int linha = Integer.parseInt(posicao.substring(1));

			return new PosicaoXadrez(coluna, linha);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Erro ao ler a posição de xadres. Valores válidos são de a1 até h8.");
		}
	}

	public static void printTabuleiro(PecaXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				printPeca(pecas[i][j]);
			}
			System.out.println();
		}

		System.out.println("  a b c d e f g h");
	}

	private static void printPeca(PecaXadrez peca) {
		if (peca == null) {
			System.out.print("-");
		} else {
			System.out.print(peca);
		}

		System.out.print(" ");
	}

}
