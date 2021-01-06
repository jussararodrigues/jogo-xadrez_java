package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
	private Cor cor;
	private int contagemMovimento;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	public int getContagemMovimento() {
		return this.contagemMovimento;
	}
	
	public void incrementaContagemMovimento() {
		contagemMovimento++;
	}
	
	public void decrementaContagemMovimento() {
		contagemMovimento--;
	}
	
	public PosicaoXadrez getPosicaoXadrez() {
		return PosicaoXadrez.dePosicao(posicao);
	}
	
	protected boolean existePecaAdversaria(Posicao posicao) {
		PecaXadrez peca = (PecaXadrez) getTabuleiro().peca(posicao);
	
		return peca != null && peca.getCor() != cor;
	}
	
}
