package jogowar.domain.batalha;

import jogowar.domain.Dado;
import jogowar.domain.Jogo;
import jogowar.domain.Territorio;
import jogowar.domain.jogador.Jogador;
import jogowar.exceptions.JogadorNaoEDonoDoTerrritorioException;
import jogowar.exceptions.JogadorNaoEOJogadorDaVezException;
import jogowar.exceptions.MesmoJogadorException;
import jogowar.exceptions.MesmoTerritorioException;
import jogowar.exceptions.QuantidadeJogadoresException;
import jogowar.exceptions.TerritoriosNaoAdjacentesException;

import java.util.Arrays;

public class BatalhaServiceImpl implements BatalhaService {
	@Override
	public Jogador atacar(Jogo jogo, Territorio tAtacante, Territorio tDefensor, Dado dado, Jogador atacante,
			Jogador defensor) {
		this.validarJogadores(jogo, atacante, defensor);
		this.validarTerritorios(tAtacante, tDefensor, atacante, defensor);

		int[] resultadosAtacante = this.rodarDados(dado);
		int[] resultadosDefensor = this.rodarDados(dado);

		Jogador jogadorGanhador = this.checarQuemGanhou(resultadosAtacante, resultadosDefensor, atacante, defensor);
		
		System.out.println("Jogador ganhador e: " + jogadorGanhador.getNome());

		return jogadorGanhador;
	}

	private int[] rodarDados(Dado dado) {
		int[] resultados = new int[3];
		for (int i = 0; i < 3; i++) {
			resultados[i] = dado.rodar();
		}
		Arrays.sort(resultados);
		return resultados;
	}

	private Jogador checarQuemGanhou(int[] resultadosAtacante, int[] resultadosDefensor, Jogador atacante,
			Jogador defensor) {
		int atacanteVitorias = 0;
		int defensorVitorias = 0;

		for (int i = 0; i < 3; i++) {
			if (resultadosAtacante[i] > resultadosDefensor[i]) {
				atacanteVitorias = atacanteVitorias + 1;
			} else {
				defensorVitorias = defensorVitorias + 1;
			}
		}

		return atacanteVitorias > defensorVitorias ? atacante : defensor;
	}

	private void validarJogadores(Jogo jogo, Jogador atacante, Jogador defensor) {
		if (atacante.equals(defensor)) {
			throw new MesmoJogadorException();
		} else if (!jogo.pegarJogadorAtual().equals(atacante)) {
			throw new JogadorNaoEOJogadorDaVezException();
		}
	}

	private void validarTerritorios(Territorio atacante, Territorio defensor, Jogador jAtacante, Jogador jDefensor) {
		if (atacante.equals(defensor)) {
			throw new MesmoTerritorioException();
		}
		boolean eAdjacente = false;
		for (Territorio territorio : atacante.getAdjacentes()) {
			if (territorio.getNome().equalsIgnoreCase(defensor.getNome())) {
				eAdjacente = true;
			}
		}
		if (!eAdjacente) {
			throw new TerritoriosNaoAdjacentesException();
		}
		checkDono(atacante, jAtacante);
		checkDono(defensor, jDefensor);
	}

	private void checkDono(Territorio territorioG, Jogador jogador) {
		boolean eDono = false;
		for (Territorio territorio : jogador.getTerritorios()) {
			if(territorio.getNome().equalsIgnoreCase(territorioG.getNome())) {
				eDono = true;
			}
		}
		if(!eDono) {
			throw new JogadorNaoEDonoDoTerrritorioException(territorioG, jogador);
		}
	}

}
