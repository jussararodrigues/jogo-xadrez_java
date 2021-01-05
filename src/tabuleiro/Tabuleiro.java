package tabuleiro;

public class Tabuleiro {
	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro na cria��o do tabuleiro: � necess�rio que haja ao menos uma linha e uma coluna");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		this.pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Posi��o n�o existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Posi��o n�o existe no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void localPeca(Peca peca, Posicao posicao) {
		if (existePeca(posicao)) {
			throw new TabuleiroException("H� uma pe�a na posi��o " + posicao);
		}
		this.pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private boolean existePosicao(int linha, int coluna) {
		return (linha >= 0 &&  linha < getLinhas()) && (coluna >= 0 && coluna < getColunas());
	}
	
	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean existePeca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Posi��o n�o existe no tabuleiro");
		}
		return peca(posicao) != null;
	}
}
