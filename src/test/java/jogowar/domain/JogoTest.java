package jogowar.domain;

import jogowar.domain.Cor;
import jogowar.domain.Dado;
import jogowar.domain.Jogador;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JogoTest {

    private Dado dado;
    private List<Jogador> jogadores;

    @BeforeEach
    void setup() {
        dado = new Dado();
        jogadores = inicializaJogadores();
    }

    @Test
    void Deve_gerar_um_numero_entre_1_e_6() {
        final int maior = 6;
        final int menor = 1;
        int random = dado.rodar();
        assertTrue(maior >= random);
        assertTrue(menor <= random);
    }



    private List<Jogador> inicializaJogadores() {
        List<Jogador> jogadores = List.of(new Jogador("Almir", Cor.sortear()),
                                          new Jogador("Ana Eliza", Cor.sortear()),
                                          new Jogador("Madeiro", Cor.sortear()),
                                          new Jogador("Giba", Cor.sortear()));

        return jogadores;
    }
}