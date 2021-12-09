package jogowar.domain;

import jogowar.domain.batalha.BatalhaServiceImpl;
import jogowar.domain.jogador.Jogador;
import jogowar.domain.jogador.JogadorFactoryMethod;
import jogowar.exceptions.JogadorNaoEDonoDoTerrritorioException;
import jogowar.exceptions.JogadorNaoEOJogadorDaVezException;
import jogowar.exceptions.MesmoJogadorException;
import jogowar.exceptions.MesmoTerritorioException;
import jogowar.exceptions.QuantidadeJogadoresException;
import jogowar.exceptions.TerritoriosNaoAdjacentesException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JogoTest {

	private Dado dado;
	private List<Jogador> jogadores;
	private List<Territorio> territorios;
	private Jogo jogo;

	@BeforeEach
	void setup() {
		this.dado = Dado.obtemInstancia();
		this.territorios = inicializaTerritorios();
		this.jogadores = inicializaJogadores();
		distribuirTerritorios();
	}

	@Test
	void deveVerificarSeExisteInstanciaDeSingletons() {
		assertNotNull(dado);
	}

	@Test
	void deveGerarUmaMesmaInstanciaDeDado() {
		Dado newDado = Dado.obtemInstancia();
		assertTrue(dado.equals(newDado));
	}

	@Test
	void deveGerarUmNumeroEntre1e6() {
		final int maior = 6;
		final int menor = 1;
		int random = dado.rodar();
		assertTrue(maior >= random);
		assertTrue(menor <= random);
	}

	@Test
	void deveFabricarUmJogador() {
		var nome = "Diego";
		var cor = Cor.AZUL;
		JogadorFactoryMethod jogadorFactory = new JogadorFactoryMethod();
		Jogador jogador = jogadorFactory.fabricarJogador(nome, cor);
		assertEquals(nome, jogador.getNome());
		assertEquals(cor, jogador.getCor());
		assertNull(jogador.getObjetivo());
		assertNull(jogador.getCartas());
		assertNull(jogador.getTerritorios());
	}

	@Test
	void deveAutorizarInicializacaoRodada() {
		jogo = new Jogo(this.dado, this.jogadores);

		assertTrue(jogo.inicializaRodada());
	}

	@Test
	void deveInvalidarInicializacaoRodada() {
		JogadorFactoryMethod jogadorFactory = new JogadorFactoryMethod();
		jogo = new Jogo(this.dado, List.of(jogadorFactory.fabricarJogador("Almir", Cor.sortear())));

		assertThrows(QuantidadeJogadoresException.class, () -> jogo.inicializaRodada());
	}

	@Test
	void deveReclamarDeMesmoJogador() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();

		assertThrows(MesmoJogadorException.class, () -> batalha.atacar(jogo, this.territorios.get(0),
				this.territorios.get(1), this.dado, this.jogadores.get(0), this.jogadores.get(0)));
	}

	@Test
	void deveReclamarDeMesmoTerritorio() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();

		assertThrows(MesmoTerritorioException.class, () -> batalha.atacar(jogo, this.territorios.get(0),
				this.territorios.get(0), this.dado, this.jogadores.get(0), this.jogadores.get(1)));
	}

	@Test
	void deveReclamarDeTerritoriosNaoAdjacentes() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();

		assertThrows(TerritoriosNaoAdjacentesException.class, () -> batalha.atacar(jogo, this.territorios.get(0),
				this.territorios.get(3), this.dado, this.jogadores.get(0), this.jogadores.get(1)));
	}

	@Test
	void deveReclamarDeNaoEOJogadorDaVez() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();

		assertThrows(JogadorNaoEOJogadorDaVezException.class, () -> batalha.atacar(jogo, this.territorios.get(0),
				this.territorios.get(3), this.dado, this.jogadores.get(2), this.jogadores.get(1)));
	}

	@Test
	void deveReclamarDeNaoEODonoDoTerritorio() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();
		Territorio territorio = new Territorio("Uruguai");
		territorio.setAdjacentes(List.of(this.territorios.get(1)));

		assertThrows(JogadorNaoEDonoDoTerrritorioException.class, () -> batalha.atacar(jogo, territorio,
				this.territorios.get(1), this.dado, this.jogadores.get(0), this.jogadores.get(1)));
	}

	@Test
	void realizarBatalha() {
		jogo = new Jogo(this.dado, this.jogadores);
		BatalhaServiceImpl batalha = new BatalhaServiceImpl();
		Jogador ganhador = batalha.atacar(jogo, this.territorios.get(0), this.territorios.get(1), this.dado,
				this.jogadores.get(0), this.jogadores.get(1));
		assertTrue(ganhador.equals(this.jogadores.get(0)) || ganhador.equals(this.jogadores.get(1)));
	}

	@Test
	void deveTrocarOJogadorAtual() {
		jogo = new Jogo(this.dado, this.jogadores);
		jogo.terminarRodada();
		assertTrue(this.jogadores.get(1).equals(jogo.pegarJogadorAtual()));
	}

	@Test
	void deveVoltarParaOPrimeiroJogador() {
		jogo = new Jogo(this.dado, this.jogadores);
		jogo.terminarRodada();
		jogo.terminarRodada();
		jogo.terminarRodada();
		jogo.terminarRodada();
		assertTrue(this.jogadores.get(0).equals(jogo.pegarJogadorAtual()));
	}

	private List<Jogador> inicializaJogadores() {
		JogadorFactoryMethod jogadorFactory = new JogadorFactoryMethod();
		return List.of(jogadorFactory.fabricarJogador("Almir", Cor.AMARELO),
				jogadorFactory.fabricarJogador("Ana Eliza", Cor.AZUL),
				jogadorFactory.fabricarJogador("Madeiro", Cor.PRETO),
				jogadorFactory.fabricarJogador("Giba", Cor.VERDE));
	}

	private List<Territorio> inicializaTerritorios() {
		Territorio territorio1 = new Territorio("Brasil");
		Territorio territorio2 = new Territorio("Argentina");
		Territorio territorio3 = new Territorio("Espanha");
		Territorio territorio4 = new Territorio("Portugal");
		territorio1.setAdjacentes(List.of(territorio2));
		territorio2.setAdjacentes(List.of(territorio1));
		territorio3.setAdjacentes(List.of(territorio4));
		territorio4.setAdjacentes(List.of(territorio3));

		return List.of(territorio1, territorio2, territorio3, territorio4);
	}

	private void distribuirTerritorios() {
		for (int i = 0; i < 4; i++) {
			this.jogadores.get(i).setTerritorios(List.of(this.territorios.get(i)));
		}
	}

}