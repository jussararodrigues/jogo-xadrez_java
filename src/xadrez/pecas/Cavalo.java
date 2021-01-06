package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaXadrez;

public class Cavalo extends PecaXadrez {

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
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
		
		// 
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}

		// 
		auxiliar.setValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
		if (getTabuleiro().existePosicao(auxiliar) && podeMover(auxiliar)) {
			matriz[auxiliar.getLinha()][auxiliar.getColuna()] = true;
		}


		return matriz;
	}
	
	@Override
	public String toString() {
		return "C";
	}

}
