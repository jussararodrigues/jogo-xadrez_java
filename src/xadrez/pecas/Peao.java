package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao auxiliar = new Posicao(0, 0);

		if (getCor() == Cor.BRANCO) {
			// Acima
			auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			auxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao auxiliar2 = new Posicao(auxiliar.getLinha() - 1, auxiliar.getColuna());
			if (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar) && getTabuleiro().existePosicao(auxiliar2) && !getTabuleiro().existePeca(auxiliar2) && getContagemMovimento() == 0) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			// Diagonal Esquerda
			auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			// Diagonal Direita
			auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

		} else {
			// Acima
			auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			auxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao auxiliar2 = new Posicao(auxiliar.getLinha() + 1, auxiliar.getColuna());
			if (getTabuleiro().existePosicao(auxiliar) && !getTabuleiro().existePeca(auxiliar) && getTabuleiro().existePosicao(auxiliar2) && !getTabuleiro().existePeca(auxiliar2) && getContagemMovimento() == 0) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			// Diagonal Esquerda
			auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}

			// Diagonal Direita
			auxiliar.setValores(posicao.getLinha() +  1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(auxiliar) && existePecaAdversaria(auxiliar)) {
				matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
			}
		}

		return matriz;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
