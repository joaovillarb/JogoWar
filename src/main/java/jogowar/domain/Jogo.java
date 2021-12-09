package jogowar.domain;

import jogowar.domain.jogador.Jogador;
import jogowar.exceptions.QuantidadeJogadoresException;

import java.util.List;

public class Jogo {

	private final Dado dado;
	private final List<Jogador> jogadores;
	private int jogadorAtual;

	public Jogo(Dado dado, List<Jogador> jogadores) {
		this.dado = dado;
		this.jogadores = jogadores;
		this.jogadorAtual = 0;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public boolean inicializaRodada() {
		if (dado != null && jogadores.size() >= 3)
			return true;
		throw new QuantidadeJogadoresException();
	}

	public void terminarRodada() {
		if (jogadorAtual == this.jogadores.size() - 1) {
			this.jogadorAtual = 0;
		} else {
			this.jogadorAtual += 1;
		}
	}

	public Jogador pegarJogadorAtual() {
		return this.jogadores.get(this.jogadorAtual);
	}
}
