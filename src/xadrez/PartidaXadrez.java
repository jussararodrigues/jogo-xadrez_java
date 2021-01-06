package xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {
	private int turno;
	private Cor jogadorAtual;
	private Tabuleiro tabuleiro;
	private boolean check;
	
	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	
	public PartidaXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		this.turno = 1;
		this.jogadorAtual = Cor.BRANCO;
		this.check = false;
		iniciaPartida();
	}
	
	public int getTurno() {
		return this.turno;
	}
	
	public Cor getJogadorAtual() {
		return this.jogadorAtual;
	}
	
	public boolean getCheck() {
		return this.check;
	}
	
	public PecaXadrez[][] getPecas() {
		PecaXadrez[][] matriz = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
	
		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
			}
		}
		
		return matriz;
	}
	
	public boolean[][] movimentosPossiveis(PosicaoXadrez posicaoOrigem) {
		Posicao posicao =  posicaoOrigem.paraPosicao();
		validaPosicaoOrigem(posicao);
		
		return tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	public PecaXadrez executaMovimentoPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao origem = posicaoOrigem.paraPosicao();
		Posicao destino = posicaoDestino.paraPosicao();
		
		validaPosicaoOrigem(origem);
		validaPosicaoDestino(origem, destino);
		Peca pecaCapturada = realizaMovimento(origem, destino);
		
		if (testeCheck(jogadorAtual)) {
			desfazMovimento(origem, destino, pecaCapturada);
			throw new XadrezException("Você não pode se colocar em check");
		}
		
		check = (testeCheck(adversario(jogadorAtual))) ? true : false;

		proximoTurno();
		
		return (PecaXadrez) pecaCapturada;
	}
	
	private Peca realizaMovimento(Posicao origem, Posicao destino) {
		Peca peca = tabuleiro.removePeca(origem);
		Peca pecaCapturada = tabuleiro.removePeca(destino);
		
		tabuleiro.localPeca(peca, destino);
		
		if (pecaCapturada != null) {
			pecasNoTabuleiro.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}
	
	private void desfazMovimento(Posicao origem, Posicao destino, Peca pecaCapturada) {
		Peca peca = tabuleiro.removePeca(destino);
		tabuleiro.localPeca(peca, origem);
		
		if (pecaCapturada != null) {
			tabuleiro.localPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasNoTabuleiro.add(pecaCapturada);
		}
	}
	
	private void validaPosicaoOrigem(Posicao posicao) {
		if (!tabuleiro.existePeca(posicao)) {
			throw new XadrezException("Não existe peça na posição de origem");
		}
		
		if (jogadorAtual != ((PecaXadrez) tabuleiro.peca(posicao)).getCor()) {
			throw new XadrezException("A peça escolhida não é sua");
		}
		
		if (!tabuleiro.peca(posicao).existeMovimentoPossivel()) {
			throw new XadrezException("Não existe movimento possível para a peça escolhida");
		}
	}
	
	private void validaPosicaoDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException("A peça escolhida não pode ser movida para a posição de destino");
		}
	}
	
	private void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private Cor adversario(Cor cor) {
		return (cor == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	private PecaXadrez rei(Cor cor) {
		List<Peca> listaPecas = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == cor).collect(Collectors.toList());
		
		for (Peca peca : listaPecas) {
			if (peca instanceof Rei) {
				return (PecaXadrez) peca;
			}
		}
		
		throw new IllegalStateException("Não existe o rei " + cor + " no tabuleiro");
	}
	
	private boolean testeCheck(Cor cor) {
		Posicao posicaoRei = rei(cor).getPosicaoXadrez().paraPosicao();
		List<Peca> pecasAdversario = pecasNoTabuleiro.stream().filter(x -> ((PecaXadrez) x).getCor() == adversario(cor)).collect(Collectors.toList());
		
		for (Peca peca : pecasAdversario) {
			boolean[][] matriz = peca.movimentosPossiveis();
			if (matriz[posicaoRei.getLinha()][posicaoRei.getColuna()]) {
				return true;
			}
		}
		
		return false;
	}
	
	private void localNovaPeca(char coluna, int linha, PecaXadrez peca) {
		tabuleiro.localPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
		pecasNoTabuleiro.add(peca);
	}
	
	private void iniciaPartida() {
		localNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        localNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        localNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        localNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        localNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        localNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        localNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        localNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        localNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        localNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        localNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        localNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
	
}
