package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	private boolean podeMover(Posicao posicao) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
		return peca == null || peca.getCor() != getCor();
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao auxiliar = new Posicao(0, 0);
		
		// Acima
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Abaixo
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Esquerda
		auxiliar.setValores(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Direita
		auxiliar.setValores(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Esquerda Acima (Noroeste)
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Direita Acima (Nordeste)
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Esquerda Abaixo (Sudoeste)
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// Diagonal Direita Abaixo (Sudeste)
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}


		return matriz;
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
