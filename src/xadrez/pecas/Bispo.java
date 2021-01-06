package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Bispo extends PecaXadrez {

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao auxiliar = new Posicao(0, 0);

		// Diagonal Esquerda Acima (Noroeste)
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setValores(auxiliar.getLinha() - 1, auxiliar.getColuna() - 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Direita Acima (Nordeste)
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setValores(auxiliar.getLinha() - 1, auxiliar.getColuna() + 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Direita Abaixo (Sudeste)
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setValores(auxiliar.getLinha() + 1, auxiliar.getColuna() + 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Esquerda Abaixo (Sudoeste)
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setValores(auxiliar.getLinha() + 1, auxiliar.getColuna() - 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		return matriz;
	}
	
	@Override
	public String toString() {
		return "B";
	}

}
