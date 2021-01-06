package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PartidaXadrez partidaXadrez = new PartidaXadrez();
		List<PecaXadrez> pecasCapturadas = new ArrayList<>();

		while (true) {
			try {
//				UI.limpaTela();
				UI.printPartida(partidaXadrez, pecasCapturadas);
				System.out.println();

				System.out.print("Origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

				boolean[][] movimentosPossiveis = partidaXadrez.movimentosPossiveis(origem);
				UI.printTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);
				
				System.out.print("Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);

				PecaXadrez pecaCapturada = partidaXadrez.executaMovimentoPeca(origem, destino);
				
				if (pecaCapturada != null) {
					pecasCapturadas.add(pecaCapturada);
				}
			}
			catch (XadrezException e) {
				System.out.println(e.getMessage());
				System.out.println("Pressione Enter para continuar");
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				System.out.println("Pressione Enter para continuar");
				sc.nextLine();
			}
		}

	}

}
