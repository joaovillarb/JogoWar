package jogowar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class JogoTest {

    private Dado dado;
    private List<Jogador> jogadores;

    @BeforeEach
    void setup() {
        dado = Dado.obtemInstancia();
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
        return List.of(new Jogador("Almir", Cor.sortear()),
                new Jogador("Ana Eliza", Cor.sortear()),
                new Jogador("Madeiro", Cor.sortear()),
                new Jogador("Giba", Cor.sortear()));
    }
}