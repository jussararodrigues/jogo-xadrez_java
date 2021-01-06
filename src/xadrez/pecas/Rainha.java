package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rainha extends PecaXadrez {

	public Rainha(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao auxiliar = new Posicao(0, 0);

		// Acima
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setLinha(auxiliar.getLinha() - 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Esquerda
		auxiliar.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setColuna(auxiliar.getColuna() - 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Direta
		auxiliar.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setColuna(auxiliar.getColuna() + 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Abaixo
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			auxiliar.setLinha(auxiliar.getLinha() + 1);
		}
		if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

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
		return "Q";
	}

}
