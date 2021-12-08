package jogowar.domain;

import org.junit.jupiter.api.*;

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
    void deveGerarUmNumeroEntre1e6() {
        final int maior = 6;
        final int menor = 1;
        int random = dado.rodar();
        assertTrue(maior >= random);
        assertTrue(menor <= random);
    }

    @Test
    void deveAutorizarInicializacaoRodada(){
        jogo = new Jogo(this.dado, this.jogadores);

        assertTrue(jogo.inicializaRodada());
    }

    @Test
    void deveInvalidarInicializacaoRodada(){
        jogo = new Jogo(this.dado, List.of(new Jogador("Almir", Cor.sortear())));

        assertThrows(IllegalArgumentException.class, () -> jogo.inicializaRodada());
    }



    private List<Jogador> inicializaJogadores() {
        List<Jogador> jogadores = List.of(new Jogador("Almir", Cor.sortear()),
                                          new Jogador("Ana Eliza", Cor.sortear()),
                                          new Jogador("Madeiro", Cor.sortear()),
                                          new Jogador("Giba", Cor.sortear()));

        return jogadores;
    }
}