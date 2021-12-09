package jogowar.domain;

import jogowar.domain.jogador.Jogador;
import jogowar.domain.jogador.JogadorFactoryMethod;
import jogowar.exceptions.QuantidadeJogadoresException;
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
    private Jogo jogo;

    @BeforeEach
    void setup() {
        dado = Dado.obtemInstancia();
        jogadores = inicializaJogadores();
    }

    @Test
    void deveVerificarSeExisteInstanciaDeSingletons() {
        assertNotNull(dado);
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


    private List<Jogador> inicializaJogadores() {
        JogadorFactoryMethod jogadorFactory = new JogadorFactoryMethod();
        return List.of(jogadorFactory.fabricarJogador("Almir", Cor.AMARELO),
                jogadorFactory.fabricarJogador("Ana Eliza", Cor.AZUL),
                jogadorFactory.fabricarJogador("Madeiro", Cor.PRETO),
                jogadorFactory.fabricarJogador("Giba", Cor.VERDE));
    }
}