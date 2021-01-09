package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;

public class Peao extends PecaXadrez {

	private PartidaXadrez partida;

	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaXadrez partida) {
		super(tabuleiro, cor);
		this.partida = partida;
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

			// Movimento Especial En Passant BRANCO
			if (posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().existePosicao(esquerda) && existePecaAdversaria(esquerda) && getTabuleiro().peca(esquerda) == partida.getEnPassantVulneravel()) {
					matriz[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}

				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().existePosicao(direita) && existePecaAdversaria(direita) && getTabuleiro().peca(direita) == partida.getEnPassantVulneravel()) {
					matriz[direita.getLinha() - 1][direita.getColuna()] = true;
				}
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

			// Movimento Especial En Passant PRETO
			if (posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().existePosicao(esquerda) && existePecaAdversaria(esquerda) && getTabuleiro().peca(esquerda) == partida.getEnPassantVulneravel()) {
					matriz[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}

				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().existePosicao(direita) && existePecaAdversaria(direita) && getTabuleiro().peca(direita) == partida.getEnPassantVulneravel()) {
					matriz[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}

		return matriz;
	}

	@Override
	public String toString() {
		return "P";
	}

}
